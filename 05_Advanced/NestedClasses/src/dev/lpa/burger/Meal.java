package dev.lpa.burger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meal {

    private double price = 5.0;
    //    private Burger burger;
    private BurgerTemplate burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

//    public void addToppings(String... toppings){
//        burger.addToppings(toppings);
//    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
//        burger = new Burger("regular", "burger");
        burger = new BurgerTemplate("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total due: ", getTotal());
    }

    public void addToppings(String... selectedToppings) {
        burger.addToppings(selectedToppings);
    }

    private class Burger {

        private ArrayList<Toppings> toppings = new ArrayList<>();

        private String name;
        private String type;
        private double price;

        private enum Toppings {
            TOMATO,
            ONION,
            BACON,
            CHEDDAR,
            EGG;


            static Toppings fromString(String topping) {
                return switch (topping.toUpperCase()) {
                    case "TOMATO" -> TOMATO;
                    case "ONION" -> ONION;
                    case "BACON" -> BACON;
                    case "CHEDDAR" -> CHEDDAR;
                    case "EGG" -> EGG;
                    default -> TOMATO;
                };
            }

            public double price() {
                return switch (this) {
                    case TOMATO, ONION -> 0.0;
                    case BACON -> 1.0;
                    case CHEDDAR -> 0.5;
                    case EGG -> 0.5;

                };
            }


            @Override
            public String toString() {
                return switch (this) {
                    case TOMATO -> "Tomato";
                    case BACON -> "Bacon";
                    case CHEDDAR -> "Cheddar";
                    case EGG -> "Egg";
                    case ONION -> "Onion";

                };
            }
        }

        public Burger(String name, String type) {

            this.name = name;
            this.type = type;
            this.price = 5.0;

        }

        private void addToppings(String... toppings) {

            for (String t : toppings) {
                this.toppings.add(Toppings.fromString(t));
            }

        }


        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate)) + (toppings.isEmpty() ? "" : toppingsToString());
        }


        private String toppingsToString() {
            toppings.sort(Comparator.naturalOrder());
            StringBuilder sb = new StringBuilder();
            double totalPrice = price;
            for (Toppings t : toppings) {
                sb.append("%n%10s%15s $%.2f".formatted("plus", t.toString(), getPrice(t.price(), conversionRate)));
                totalPrice += t.price();
            }
            sb.append("\n").append("-".repeat(30));
            sb.append("%n%26s $%.2f".formatted("Total burger: ", getPrice(totalPrice, conversionRate)));
            return sb.toString();
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }

    }

    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0); // call new Burger here
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }


        private static double getPrice(double price, double rate) {
            return price * rate;
        }


    }

    private class BurgerTemplate extends Item {

        private enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice(){
                return switch (this){
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }
        }

        private List<Item> toppings = new ArrayList<>();

        public BurgerTemplate(String name) {
            super(name, "Burger", 5.0);
        }

        public double getPrice() {
            double total = super.price;
            for (Item topping : toppings) {
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... selectedToppings) {

            for (String selectedTopping : selectedToppings) {
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "TOPPING",
                            topping.getPrice()));
                } catch (IllegalArgumentException e) {
                    System.out.println(selectedTopping + " Not a valid topping ");
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings){
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }

}
