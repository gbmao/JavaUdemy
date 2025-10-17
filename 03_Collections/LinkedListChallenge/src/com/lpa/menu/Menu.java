package com.lpa.menu;

import com.lpa.Itinerary;
import com.lpa.utils.Input;
import com.lpa.utils.IteratorTools;

public class Menu {

    Input input = new Input();

    public Menu() {
    }



    public void startingMenu(Itinerary itinerary, IteratorTools iterator) {
        boolean flag = true;
            printOptions();

        while (flag) {
        char a = input.userInputToChar('f', 'b', 'l', 'm', 'q');

        switch (a) {
           case 'f' -> iterator.forward();
           case 'b' -> iterator.backward();
           case 'l' -> System.out.println(itinerary);
           case 'm' -> printOptions();
           case 'q' -> {
               System.out.println("Finishing application...");
               flag =false;
           }
        }

        }
    }

    public void printOptions() {
        System.out.println("""
                available actions:
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");


    }





}
