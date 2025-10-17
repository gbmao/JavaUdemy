package com.library;


public abstract class ItemLibrary implements Borrowable , Matchable{

    private String title;
    private boolean borrowed;
    protected int itemID;

    private static int nextID = 0;

    public ItemLibrary(String title) {
        this.title = title;
        this.borrowed = false;
        itemID = nextID++;
    }

    public int getItemID() {
        return itemID;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
