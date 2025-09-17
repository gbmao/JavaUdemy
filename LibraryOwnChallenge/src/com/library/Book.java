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

    @Override
    public Genre byGenre() {
        return genre;
    }

    @Override
    public int byID() {
        return itemID;
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
        return getTitle()  ;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public void borrow() {
        if (isBorrowed()) {
            System.out.println("Item indisponivel");
        } else {
            System.out.println("Alugando...");
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
