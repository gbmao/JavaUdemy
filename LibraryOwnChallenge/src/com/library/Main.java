package com.library;

import com.library.menu.Menu;

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
        library.addElements(new Book("Dom Casmurro 2", "Machado de Assis", 280, "didactic"));
        library.addElements(new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 300, "poetry"));
        library.addElements(new Book("A Briefer History of Time", "Stephen Hawking", 198, "poetry"));
        library.addElements(new Book("The Universe in a Nutshell", "Stephen Hawking", 224, "romance"));
        library.addElements(new Book("The Odyssey", "Homer", 600, "didactic"));
        library.addElements(new Book("Iliad: Modern Retelling", "Homer", 540, "romance"));
        library.addElements(new Book("Clean Architecture", "Robert C. Martin", 432, "poetry"));
        library.addElements(new Book("The Clean Coder", "Robert C. Martin", 350, "romance"));
        library.addElements(new Book("Unknown Secrets", "Anonymous", 150, "didactic"));
        library.addElements(new Book("Anonymous Tales", "Anonymous", 120, "poetry"));

//        Collections.sort(library);
//        Comparator<Book> teste = new BookAuthorComparator();

//        System.out.println(library);
//        library.sortBy(Comparator.naturalOrder());
//        System.out.println(library);
//        Comparator<Book> aq = new Library.BookComparator("author");
//        library.sortBy(aq);
//        System.out.println(library);
//        aq = new Library.BookComparator("genre");
//        library.sortBy(aq);
//        System.out.println(library);
//        aq = new Library.BookComparator("totalPages");
//        library.sortBy(aq);
//        System.out.println(library);

//        b1.borrow();
//        b2.borrow();
//        b1.borrow();
//        aq = new Library.BookComparator("");
//        library.sortBy(aq);
//        System.out.println(library);
//
//        System.out.println(library.isAvailable());



//        System.out.println("aq");
//        System.out.println(search.addToSearch("genre", "romance" ));
//        System.out.println(search);
////
//        Book[] a = {b1,b2,b3};
//
//        System.out.println(Arrays.deepToString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.deepToString(a));


//        Arrays.sort(library, teste);
        System.out.println(library);
        Menu menu = new Menu(library);
        menu.menuStart();
//        search.addToSearch("Genre", "romance");
//        System.out.println(search);
//        search.addToSearch("author", "Homer");
//        System.out.println(search);
//        search.addToSearch("author", "Machado de Assis");
//        System.out.println(search);




    }
}
