package com.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library <T extends Borrowable>  {

    private List<T> library = new ArrayList<T>();

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

        for (T t : library){
           sb.append(t);
           sb.append("\n");
        }
        return sb.toString();
    }

    public void sortBy(Comparator<T> comparator) {
        library.sort(comparator);
    }




}

class AuthorComparator implements Comparator<Book> {


    @Override
    public int compare(Book book, Book t1) {
        return book.author.compareTo(t1.author);
    }
}


