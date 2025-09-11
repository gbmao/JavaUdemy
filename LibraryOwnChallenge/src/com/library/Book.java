package com.library;


public class Book extends ItemLibrary implements Borrowable, Comparable<Book> {
    protected String author;
    protected int totalPages;
    protected Genre genre;

    @Override
    public String byName() {
        return getTitle();
    }

    @Override
    public String byAuthor() {
        return author;
    }

    @Override
    public Integer byPages() {
        return totalPages;
    }


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

    //TODO better output
    @Override
    public String toString() {
        return getTitle() + "\tAuthor: " + author + "\tgenre: " + genre+ "\tTotalPages: " +totalPages + "\t borrow: " + this.isBorrowed();
    }


    @Override
    public void borrow() {
        if (isBorrowed()) {
            System.out.println("Item unavailable");
        } else {
            System.out.println("Borrowin...");
            this.setBorrowed(true);
        }
    }

    @Override
    public void returnDate() {
        System.out.println("Some date");
    }

    @Override
    public int compareTo(Book book) {
//        System.out.println(book.author + " is " +book.author.compareTo(this.author) + " to " + this.author );
        return this.getTitle().compareTo(book.getTitle());
    }




}
