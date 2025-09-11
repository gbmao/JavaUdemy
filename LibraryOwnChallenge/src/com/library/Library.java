package com.library;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Library<T extends Borrowable & Matchable >  {

    private List<T> library = new ArrayList<T>();

    static class BookComparator implements Comparator<Book> {

        private String sortType;

        public BookComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Book book, Book t1) {

            return switch (sortType.toLowerCase()) {
                case "author" -> book.author.compareTo(t1.author);
                case "genre" ->
                        book.genre.name().compareTo(t1.genre.name()); // without .name() genre uses the order it was created
                case "totalpages" -> book.totalPages - t1.totalPages;
                default -> book.getTitle().compareTo(t1.getTitle());
            };
        }
    }

    public Library(){}

    public Library(T item) {
        addElements(item);
    }



    @SafeVarargs
    public final void addElements(T... elements) {
        library.addAll(List.of(elements));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-35s %-25s %-12s %-6s\n", "Title", "Author", "Genre", "Pages"));
        sb.append("-".repeat(80)); // linha separadora
        sb.append("\n");

        for (T t : library) {
            if (t instanceof Book book) { // cast seguro
                sb.append(String.format("%-35s %-25s %-12s %-6d\n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre().name(),
                        book.getTotalPages()));
            } else {
                sb.append(t).append("\n"); // fallback
            }
        }
        return sb.toString();
    }

    public void sortBy(Comparator<T> comparator) {
        library.sort(comparator);
    }

    //TODO a switch to search by type
    // expand findMatch to receive all possible Matchs
    public ArrayList<T> findMatch(String type, String name) {

        ArrayList<T> library = new ArrayList<>(this.library);

        ArrayList<T> searchList = new ArrayList<>();
        for (T t : library) {

            switch (type.toLowerCase()){
                case "title" -> {
                    if(t.byName().equalsIgnoreCase(name)){
                        searchList.add(t);

                    }
                }
                case "author" -> {
                    if(t.byAuthor().equalsIgnoreCase(name)) {
                        searchList.add(t);

                    }
                }
                case "pages" -> {
                    if(t.byPages().equals(Integer.parseInt(name))) {
                       //TODO change this to  list items with higher or lower pages count
                    }
                }
                case "genre" -> {
                    if (t.byGenre().name().equalsIgnoreCase(name)) {
                        searchList.add(t);

                    }

                }
                default -> {
                    searchList.add(t);

                }
            }

        }
        return searchList;

    }
    //TODO a search list
    // should receive one or more parameters
    // and list all items with those parameters

    //TODO method for removing items from library

    /**
     *
     * @return all books with !isBorrowed() as String
     */
    public String isAvailable() {

        StringBuilder sb = new StringBuilder();

        for (T t : library) {
            if (!t.isBorrowed()) { //if isBorrowed is false print results
                sb.append(t);
                sb.append("\n");
            }

        }
        return sb.toString();
    }
}







