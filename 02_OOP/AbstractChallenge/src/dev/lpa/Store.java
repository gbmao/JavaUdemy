package dev.lpa;

import java.util.ArrayList;

record Orderitem(int qty, ProductForSale product) {}


public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {




        storeProducts.add(new ArtObject("Oil painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeProducts.add(new ArtObject("Sculpture", 2000,
                "Bronze work by jfk in 1950"));

        storeProducts.add(new Furniture("Desk", 500, "Mahogany Desk"));
        storeProducts.add(new Furniture("Lamp", 200, "Tiffany lamp "));


        listProducts();

        System.out.printf("\nOrder 1\n");
        var order1 = new ArrayList<Orderitem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.printf("\nOrder 2\n");
        var order2 = new ArrayList<Orderitem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
//        addItemToOrder(order1, 0, 1);
        printOrder(order2);


    }

    public static void listProducts() {

        for(var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<Orderitem> order, int orderIndex,
                                      int qty) {
        order.add(new Orderitem(qty, storeProducts.get(orderIndex)));
    }
    public static void printOrder(ArrayList<Orderitem> order) {

        double salesTotal = 0;
        for(var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales total = $%6.2f %n", salesTotal);
    }

}
