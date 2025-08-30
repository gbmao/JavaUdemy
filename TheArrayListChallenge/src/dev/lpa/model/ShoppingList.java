package dev.lpa.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingList {


    public List<Item> shoppingList = new ArrayList<>();

    public void addItem(Item item) {

        if (isOnList(item.getName())) {
            System.out.println("A lista ja possui : " + item.getName());
        } else {
            shoppingList.add(item);
        System.out.println(item.getName()+ " Adiciona a lista ");
        }

    }

    public boolean isOnList(String name) {
        for (Item item : shoppingList) {
            if (item.getName().equals(name)) {

                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        int i =1;
        for (Item item : shoppingList  ){
            System.out.println(i + item.toString() );
            i++;
        }
        return "-".repeat(30);
    }

    public void addItem(String... array) {

        for (String item : array) {
            Item novoItem = new Item(item.trim());
            addItem(novoItem);
        }
        shoppingList.sort(Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println(this);
    }

    public void contain(String name) {

        for (Item item : shoppingList) {

            if (item.getName().equals(name)){
                System.out.printf("%s Arroz esta na lista no numero : %s%n", name, shoppingList.indexOf(item) + 1);
            }
        }
    }

    public void removeFromList(String... array) {


        for (String nome : array) {

            for (int i = 0; i < shoppingList.size(); i++) {
                Item item = shoppingList.get(i);

                if (item.getName().equals(nome)) {
                    shoppingList.remove(i);
                    i--;
                }
            }
        }
        shoppingList.sort(Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println(this);

    }

}

