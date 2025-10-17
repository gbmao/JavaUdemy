package dev.lpa;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return rightLink;
    }


    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return leftLink;
    }

    @Override
    int compareTo(ListItem nextItem) {
        if (nextItem.getValue() == null ) return 1;
        if (nextItem.getValue().equals(this.value)) return 0;
        if (((Comparable)nextItem.getValue()).compareTo(this.value) > 0) {
            return 1;
        } else {
            return -1;

        }
    }


}
