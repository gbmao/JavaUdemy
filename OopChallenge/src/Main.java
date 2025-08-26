public class Main {
    public static void main(String[] args) {
        Burgers burgao = new Burgers("X-salad", 13.99);
        Drink pepsi = new Drink("Pepsi", "Medio");
        FrenchFries bata = new FrenchFries("Batata Maluca", 25.90);
        DeluxeBurger xSinistro = new DeluxeBurger("X - Sinistro");

        MealOrder combo = new MealOrder("Combo Solteiro", burgao, pepsi, bata);

//        System.out.println(combo.toString());

        pepsi.setSize("Grande");
        burgao.setTomato(true);
        System.out.println(combo);


        System.out.println(combo);
        burgao.setTomato(true);
        System.out.println(combo);
        burgao.setTomato(false);
        System.out.println(combo);


        MealOrder sinistro = new MealOrder(xSinistro, bata, pepsi);
        System.out.println(sinistro);

    }

}
