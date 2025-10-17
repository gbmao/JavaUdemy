package dev.lpa;

import java.util.List;

public class SearchTree implements NodeList {

    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {

        ListItem currentItem = getRoot();

        if (currentItem == null) {
            this.root = item;
            return true;
        }

        while (true) {
            int compareResponse = currentItem.compareTo(item);

            if (compareResponse == 0) {
                System.out.println("Item already on list");
                return false;
            }

            if (compareResponse == 1) { // item > currentItem

                if (currentItem.next() == null) {
                    currentItem.setNext(item);
                    return true;
                }
                currentItem = currentItem.next(); // moves to right
            }

            if (compareResponse == -1) { // item < currentItem

                if (currentItem.previous() == null) {
                    currentItem.setPrevious(item);
                    return true;
                }
                currentItem = currentItem.previous(); // moves to left
            }
        }


    }

    @Override
    public boolean removeItem(ListItem item) {


        try {
            //search for it
            if (getRoot() == null) return  false;
            ListItem currentItem = getRoot();

            int value = currentItem.compareTo(item);

            //search


            while (true) {
                value = currentItem.compareTo(item);

                switch (value) {
                    case 1 -> {
                        // to the right
                        //ListItem right = currentItem.next();
                        if(currentItem.next() == null) {
                            return false;
                        }

                        if (currentItem.next().compareTo(item) == 0) {

                            performRemoval(currentItem.next(), currentItem);
                            return true;
                        }
                        currentItem = currentItem.next();
                    }

                    case -1 -> {
                        // to the left
                       // ListItem left = currentItem.previous();
                        if (currentItem.previous() == null) {
                            return false;
                        }

                        if (currentItem.previous().compareTo(item) == 0) {

                            performRemoval(currentItem.previous(), currentItem);
                            return true;
                        }
                        currentItem = currentItem.previous();
                    }
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous()); // to the left of root
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }

    private void performRemoval(ListItem itemTobeRemoved, ListItem parentItem) {

        switch (itemTobeRemoved.compareTo(itemTobeRemoved)) {
            case 1 -> { // item to be removed is at right
                // both null
                if (itemTobeRemoved.next() == null && itemTobeRemoved.previous() == null) {
                    parentItem.setNext(null);

                }
                // only left
                if (itemTobeRemoved.next() == null && itemTobeRemoved.previous() != null) {
                    parentItem.setNext(itemTobeRemoved.previous());
                }

                //only right
                if (itemTobeRemoved.next() != null && itemTobeRemoved.previous() == null) {
                    parentItem.setNext(itemTobeRemoved.next());
                }
                // both
                if (itemTobeRemoved.next() != null && itemTobeRemoved.previous() != null) {
                    parentItem.setNext(itemTobeRemoved.previous());
                    addItem(itemTobeRemoved.next());
                }
            }
            case -1 -> { // itemToBeRemoved at left
                // both null
                if (itemTobeRemoved.next() == null && itemTobeRemoved.previous() == null) {
                    parentItem.setPrevious(null);

                }
                // only left
                if (itemTobeRemoved.next() == null && itemTobeRemoved.previous() != null) {
                    parentItem.setPrevious(itemTobeRemoved.previous());
                }

                //only right
                if (itemTobeRemoved.next() != null && itemTobeRemoved.previous() == null) {
                    parentItem.setPrevious(itemTobeRemoved.next());
                }
                // both
                if (itemTobeRemoved.next() != null && itemTobeRemoved.previous() != null) {
                    parentItem.setPrevious(itemTobeRemoved.previous());
                    addItem(itemTobeRemoved.next());
                }
            }
            default -> {

            }

        }


    }


}
