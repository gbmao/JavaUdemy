package com.loja;

import java.util.ArrayList;



public class Store {

    private static ArrayList<OrderItem> orderList = new ArrayList<>();

    public static void main(String[] args) {
    Soda coca = new Soda("Coca", 1.50, "Taste good, bad for health");

//    coca.printPricedItem(2);



        orderList.add(new OrderItem(3, coca));
        orderList.add(new OrderItem(7, new Cigar("Cuban cigar", 5.20, "Comes with cancer")));


        printOrderItems(orderList);




    }

    private static void printOrderItems(ArrayList<OrderItem> orderList) {
        double total = 0.0;
        for (OrderItem item : orderList) {

            item.getProduct().printPricedItem(item.getQuantity());
            total += item.getProduct().getSalesPrice(item.getQuantity());

        }

        System.out.println("Total: " + total);
    }




}
