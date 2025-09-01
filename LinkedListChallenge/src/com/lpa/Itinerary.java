package com.lpa;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Itinerary {
    //    private Places town;
    private LinkedList<Places> itinerary;


    public Itinerary() {
        itinerary = new LinkedList<>();
        itinerary.add(new Places("Sydney", 0));


    }

    public void setItinerary(LinkedList<Places> itinerary) {
        this.itinerary = itinerary;
    }

    public void addTown(String name, int km) {
        if (findCity(name)) {
            System.out.println("Essa Cidade ja existe ");
        } else {

            Places place = new Places(name, km);
            itinerary.add(place);
        }
    }

    private boolean findCity(String name) {


        for (Places i : itinerary) {
            if (i.getTown().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Places> getList() {
        return itinerary;
    }

    public LinkedList<Places> sortByKmSydney() {

        LinkedList<Places> sortedList = new LinkedList<>(itinerary);

        sortedList.sort(Comparator.comparing(Places::getKmFromSydney));



        return  sortedList;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sydney");
        for (Places i : itinerary) {

            sb.append("--> ").append(i.getTown()).append(" is ").append(i.getKmFromSydney()).append(" from sydney\n");
        }

        return sb.toString();
    }
}
