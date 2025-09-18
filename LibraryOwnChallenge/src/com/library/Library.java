package com.library;

import java.sql.Array;
import java.util.*;

public class Library<T extends Borrowable & Matchable >  {

    private List<T> library = new ArrayList<T>();

    public static class BookComparator implements Comparator<ItemLibrary> {

        private String sortType;

        public BookComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(ItemLibrary book, ItemLibrary t1) {



            return switch (sortType.toLowerCase()) {
                case "author" -> book.byAuthor().compareTo(t1.byAuthor());
                case "genre" ->
                        book.byGenre().name().compareTo(t1.byGenre().name()); // without .name() genre uses the order it was created
                case "totalpages" -> book.byPages() - t1.byPages();
                default -> book.byName().compareTo(t1.byName());
            };


        }


    }

    public Library(){}

    public Library(T item) {
        addElements(item);
    }

    public void removeElement(String title){
        List<T> toRemove = new ArrayList<>();
        for (T t : library) {
            if(t.byName().equalsIgnoreCase(title)){
                System.out.println(t + " foi removido");

                toRemove.add(t);
            }
        }
        library.remove(toRemove.get(0));

    }


    @SafeVarargs
    public final void addElements(T... elements) {

        for (T newItem : elements) {
            boolean exist = false;
            for (T t : library) {
                if(newItem.byName().equalsIgnoreCase(t.byName())){
                    exist = true;
                }
            }
            if(exist) {
                System.out.println(newItem.byName() + " ja esta na lista");
            }
            if(!exist) {
                library.add(newItem);
            }
        }

    }

    public final void addElements(ArrayList<T> elements) {
        library.addAll(elements);

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-5s %-35s %-25s %-12s %-6s\n","ID", "Title", "Author", "Genre", "Pages"));
        sb.append("-".repeat(80)); // linha separadora
        sb.append("\n");

        for (T t : library) {
            if (t instanceof Book book) { // cast seguro
                sb.append(String.format("%-5s %-35s %-25s %-12s %-6d\n",
                        book.getItemID(),
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







