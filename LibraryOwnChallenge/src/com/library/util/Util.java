package com.library.util;

import com.library.Book;
import com.library.Borrowable;
import com.library.Library;
import com.library.Matchable;

import java.util.ArrayList;
import java.util.List;

public class Util<T extends Borrowable & Matchable> {

    private ArrayList<T> searchList = new ArrayList<>();
    private Library<T> library;

    public Util(Library<T> library) {
        this.library = library;
    }

    public ArrayList<T> addToSearch(String type, String name) {
        if (searchList.isEmpty()) {
            searchList = library.findMatch(type, name);
        } else {
            Library<T> library1 = new Library<>();
            library1.addElements(searchList);
            searchList = library1.findMatch(type,name);
        }
        return searchList;
    }

    public void clearSearch(){
        searchList.clear();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-35s %-25s %-12s %-6s\n", "Title", "Author", "Genre", "Pages"));
        sb.append("-".repeat(80));
        sb.append("\n");
        if(searchList.isEmpty()) return "Not results";

        for (T t : searchList) {
            if (t instanceof Book book) {
                sb.append(String.format("%-35s %-25s %-12s %-6d\n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre().name(),
                        book.getTotalPages()));
            } else {
                sb.append(t).append("\n");
            }
        }
        return sb.toString();
    }
}
