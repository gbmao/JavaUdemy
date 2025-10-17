package com.loja;

public class Soda extends ProductForSale{

    public Soda(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + ":  " + description + " Price: " + price);
    }
}
