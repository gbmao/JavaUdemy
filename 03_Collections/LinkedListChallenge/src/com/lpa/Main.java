package com.lpa;

import com.lpa.menu.Menu;
import com.lpa.utils.IteratorTools;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        Itinerary itinerary = new Itinerary();

        itinerary.addTown("Sydney", 0);
        itinerary.addTown("Sydney", 0);
        itinerary.addTown("Adelaide",1374 );
        itinerary.addTown("Alice Springs",2771 );
        itinerary.addTown("Brisbane",917 );
        itinerary.addTown("Darwin",3972 );
        itinerary.addTown("Melbourne",877 );
        itinerary.addTown("Perth",3923 );

        System.out.println(itinerary);

       itinerary.setItinerary(itinerary.sortByKmSydney());
        System.out.println(itinerary);

        IteratorTools iterator = new IteratorTools(itinerary);

        Menu menu = new Menu();

        menu.startingMenu(itinerary, iterator);

//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.forward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
//        iterator.backward();
    }
}
