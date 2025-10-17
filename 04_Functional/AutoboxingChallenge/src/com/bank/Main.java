package com.bank;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    public Customer (String name){
        this(name, new ArrayList<>());
    }
    public void addTransaction(Double valor) {
        transactions.add(valor);
    }

//private  ArrayList<Double> transactions = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {

        Bank bradesco = new Bank("Bradesco");
        bradesco.addCustomer("Alberto");
        bradesco.addCustomer("Abelardo");
        bradesco.addCustomer("Alberto");



        System.out.println(bradesco);
//        bradesco.addBalance("Alberto", 100.00);

        bradesco.addTransaction("Alberto", "abelardo", 10.0);

        bradesco.showBalance("Alberto");
        bradesco.showBalance("Abelardo");
        bradesco.showBalance("Abelardo");
    }
}
