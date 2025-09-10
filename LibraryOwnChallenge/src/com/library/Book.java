package com.library;


public class Book extends ItemLibrary implements Borrowable {
    private String author;
    private int totalPages;
    private Genre genre;

    public enum Genre {
        ROMANCE, DIDACTIC, POETRY, DEFAULT;

        private static Genre fromString(String genre) {
            return switch (genre.toUpperCase()) {
                case "ROMANCE" -> Genre.ROMANCE;
                case "DIDACTIC" -> Genre.DIDACTIC;
                case "POETRY" -> Genre.POETRY;
                default -> Genre.DEFAULT;
            };
        }
    }

    public Book(String title, String author, int totalPages, String genre) {
        super(title);
        this.author = author;
        this.totalPages = totalPages;
        this.genre = Genre.fromString(genre);
    }

    @Override
    public String toString() {
        return getTitle() + " Author: " + author + isBorrowed();
    }


    @Override
    public void borrow() {
        if (isBorrowed()) {
            System.out.println("Item unavailable");
        } else {
            System.out.println("Borrowin...");
            setBorrowed(true);
        }
    }

    @Override
    public void returnDate() {
        System.out.println("Some date");
    }


}
