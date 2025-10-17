package gabarito;

public class Main {
    public static void main(String[] args) {

//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();
//
//        Item avocado =  new Item("topping", "avocado", 2.0);
//        avocado.printItem();


//        Burger burger = new Burger("regular", 4.00);
//        burger.addToppings("BACON","CHEESE", "MAYO");
//        burger.printItem();

//        MealOrder regularMeal = new MealOrder();
//        regularMeal.addBurgertoppings("BACON","CHEESE", "MAYO");
//        regularMeal.setDrinkSize("LARGE");
//        regularMeal.printItemizedList();

//        MealOrder secondMeal = new MealOrder("Turkey", "pepsi",
//                "Chili");
//        secondMeal.addBurgertoppings("LETTUCE", "CHEESE", "MAYO");
//        secondMeal.setDrinkSize("SMALL");
//        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "coke", "chili");
        deluxeMeal.addBurgertoppings("AVOCADO", "BACON", "LETTUCE","CHEESE","MAYO");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();

    }
}
