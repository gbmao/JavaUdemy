package dev.lpa.ui;

import dev.lpa.model.ShoppingList;
import dev.lpa.service.Service;
import dev.lpa.utils.InputHelper;

public class ConsoleUI {
    ShoppingList lista = new ShoppingList();
    InputHelper inputHelper = new InputHelper();

    public void startingMenu() {

        boolean turnOn = true;
        while(turnOn){

            Service.initialText();
            int response = inputHelper.intInput(1,4);
            switch (response) {
                case 1 :
                    turnOn = false;
                    break;
                case 2 : lista.addItem(inputHelper.separatedByCommaInput());
                break;

                case 3: lista.removeFromList(inputHelper.separatedByCommaInput());
                break;
                case 4:
                    System.out.println(lista);
                    break;
                default:
                    System.out.println("Como?");
                    break;

               }
            }


        }


}

