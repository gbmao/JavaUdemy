package com.library;

enum Genre {ROMANCE, DIDACTIC, POETRY}

public class Book extends ItemLibrary implements Borrowable{
    private String author;
    private int totalPages;


    public Book(String title, String author, int totalPages) {
        super(title);
        this.author = author;
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return getTitle() + " Author: " + author + isBorrowed();
    }


    @Override
    public void borrow() {
        if(isBorrowed()) {
            System.out.println("Item unavailable");
        } else {
            System.out.println("Borrowin...");
            setBorrowed(true);
        }
    }

    @Override
    public void returnDate() {

    }
}
