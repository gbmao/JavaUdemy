package dev.lpa.burger;

public class Store {
    public static void main(String[] args) {

        Meal regularMeal = new Meal();
//        regularMeal.addToppings("tomato","bacon");

        regularMeal.addToppings("Ketchup","Mayo","Bacon","cheddar");
        System.out.println(regularMeal);

        Meal UsRegularMeal = new Meal(0.68);
        System.out.println(UsRegularMeal);
    }
}
