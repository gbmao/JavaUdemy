package com.library;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("Lotr", "Jrr.Tolkien", 666, "Romance");
        Book b1 = new Book("Dom Casmurro", "Machado de Assis", 320, "romance");
        Book b2 = new Book("A Brief History of Time", "Stephen Hawking", 212, "didactic");
        Book b3 = new Book("The Iliad", "Homer", 560, "poetry");
        Book b4 = new Book("Clean Code", "Robert C. Martin", 464, "didactic");
        Book b5 = new Book("Unknown Title", "Anonymous", 100, "fantasy");

//        System.out.println(b5.compareTo(b4));
//        System.out.println(b4);
//        book.borrow();
//        book.borrow();

        Library<Book> library = new Library<>(book);
        library.addElements(b1);
        library.addElements(b2);
        library.addElements(b3);
        library.addElements(b4);
        library.addElements(b5);
//        Collections.sort(library);
//        Comparator<Book> teste = new BookAuthorComparator();

//        System.out.println(library);
//        library.sortBy(Comparator.naturalOrder());
        System.out.println(library);
        Comparator<Book> aq = new Library.AuthorComparator("author");
        library.sortBy(aq);
        System.out.println(library);
        aq = new Library.AuthorComparator("genre");
        library.sortBy(aq);
        System.out.println(library);
        aq = new Library.AuthorComparator("totalPages");
        library.sortBy(aq);
        System.out.println(library);
        aq = new Library.AuthorComparator("");
        library.sortBy(aq);
        System.out.println(library);



////
//        Book[] a = {b1,b2,b3};
//
//        System.out.println(Arrays.deepToString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.deepToString(a));


//        Arrays.sort(library, teste);




    }
}
