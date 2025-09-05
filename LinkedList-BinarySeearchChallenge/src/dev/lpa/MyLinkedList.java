package dev.lpa;


public class MyLinkedList implements NodeList {
    private ListItem root;


    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null) return false;
        ListItem currentItem = getRoot();
        // dealing with root null
        if (getRoot() == null) {
            this.root = item;
            return true;
        }

        // put a while here to repeat

        do {
            int compareValue = currentItem.compareTo(item);

            //change to switch
            if (compareValue == 0) {
                System.out.println("Item already on the list");
                return false;
            }

            if (compareValue == 1) { // item > current item

                if (currentItem.next() == null) {
                    ListItem itemAdded = currentItem.setNext(item);
                    item.setPrevious(currentItem);
                    System.out.println(itemAdded + " has been added to the list");
                    return true;
                } else {
                    currentItem = currentItem.next();
                }

            }

            if (compareValue == -1) { // currentItem > item

                if (currentItem == getRoot()) {
                    this.root = item;
                    root.setNext(currentItem);
                    currentItem.setPrevious(getRoot());
                    return true;
                }
//                ListItem before = currentItem.previous();


                currentItem.previous().setNext(item);
                item.setPrevious(currentItem.previous());
                item.setNext(currentItem);
                currentItem.setPrevious(item);

                return true;

            }


        } while (true);

    }

    @Override
    public boolean removeItem(ListItem item) {


        if (item== null) return false;
        if (getRoot() == null) return false;
        ListItem currentItem = getRoot();
        int valour = currentItem.compareTo(item);
        if (valour == 0) {

            //check next item exist
            if (currentItem.next() == null) {
                this.root = null;
                return true;
            } else {

                this.root = currentItem.next();
                this.root.setPrevious(null);
                return true;
            }


        }

        while (currentItem != null) {
            if(currentItem.next()== null) return false;
            if (currentItem == null) return false;
            currentItem = currentItem.next();

            valour = currentItem.compareTo(item);

            if (valour == 0) {

                if (currentItem.next() == null) {
                    ListItem previous = currentItem.previous();
                    previous.setNext(null);
                    return true;
                } else {

//                    ListItem previous = currentItem.previous();
//                    ListItem next = currentItem.next();
                    currentItem.previous().setNext(currentItem.next());
                    currentItem.next().setPrevious(currentItem.previous());
                    return true;
                }

            }

        }
        return false;

    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }

        }

    }

}
