package com.library.util;

import com.library.Book;
import com.library.Borrowable;
import com.library.Library;
import com.library.Matchable;

import java.util.ArrayList;
import java.util.List;

public class Util<T extends Borrowable & Matchable> extends Library<T> {

    private ArrayList<T> searchList = new ArrayList<>();
    private Library<T> library;

    public Util(Library<T> library) {
        this.library = library;
    }

    public ArrayList<T> addToSearch(String type, String name) {

         searchList.addAll(library.findMatch(type,name));
         return searchList;
    }

    public ArrayList<T> addToSearch(String type, String name, Util<T> search){


        return searchList;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-35s %-25s %-12s %-6s\n", "Title", "Author", "Genre", "Pages"));
        sb.append("-".repeat(80)); // linha separadora
        sb.append("\n");

        for (T t : searchList) {
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
}
