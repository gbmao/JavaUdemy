package com.library;

abstract class ItemLibrary {

    private String title;
    private boolean isBorrowed = false;

    public ItemLibrary(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
