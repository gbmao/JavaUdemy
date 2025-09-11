package com.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library<T extends Borrowable> {

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

        for (T t : library) {
            sb.append(t);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortBy(Comparator<T> comparator) {
        library.sort(comparator);
    }


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







