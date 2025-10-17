package com.lpa.utils;

import com.lpa.Itinerary;
import com.lpa.Places;

import java.util.ListIterator;

public class IteratorTools {
    private Itinerary itinerary;
    private ListIterator<Places> iterator;

    public IteratorTools(Itinerary itinerary) {
        this.itinerary = itinerary;
        this.iterator =  itinerary.getList().listIterator(1);
    }


    public void forward() {
        String town = "";
        if (iterator.hasNext()) {
            town = iterator.next().getTown();
            System.out.println("You are in " + town);


//            System.out.println(iterator.next().getTown());

        } else if (!iterator.hasNext()){
            iterator.previous();
            System.out.println("You are in " + iterator.next().getTown() +  " the end of the line");

        }
    }

    public void backward() {

        if (iterator.hasPrevious()) {
            System.out.println("You are in " + iterator.previous().getTown());
        }else if (!iterator.hasPrevious()){
            iterator.next();
            System.out.println("You are in " + iterator.previous().getTown() +  " the end of the line");

        }
    }

}
