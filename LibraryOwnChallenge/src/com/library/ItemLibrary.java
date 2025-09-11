package com.library;


abstract class ItemLibrary implements Borrowable , Matchable{

    private String title;
    private boolean borrowed;

    public ItemLibrary(String title) {
        this.title = title;
        this.borrowed = false;
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
