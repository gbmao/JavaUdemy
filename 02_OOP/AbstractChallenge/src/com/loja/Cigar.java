package com.loja;

public class Cigar extends  ProductForSale{
    public Cigar(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + ":  " + description + " Price: " + price);
    }
}
