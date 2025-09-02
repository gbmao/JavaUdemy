package com.bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;


    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public void addCustomer(String name) {
        int index = clientExist(name);

        if(index != -1) {
            System.out.println("Client already exist! ");
            return;
        } else {
            Customer newCustomer = new Customer(name);
            customers.add(newCustomer);
            System.out.println(customers.get(clientExist(name)).name() +
                    " add to database!\nWelcome to our bank id: " +
                    clientExist(name));
        }

    }

    private int clientExist(String name) {
        int index = -1;
        for (Customer n : customers) {

            if(n.name().equalsIgnoreCase(name)) {
//                System.out.println(customers.indexOf(n));
                return customers.indexOf(n);
            }

        }
        return index;
    }

    public void addTransaction(String sender, String receiver, Double value) {
        int indexSender = clientExist(sender);
        int  indexReceiver = clientExist(receiver);
        if(indexReceiver != -1 && indexSender != -1) {
            addBalance(sender, - value);
            System.out.println(value + " debited from " + customers.get(indexSender).name());
            addBalance(receiver, value);
            System.out.println(customers.get(indexReceiver).name() + " received " + value);

        }
    }

    private void addBalance(String name, Double valor) {

        int index = clientExist(name);
        customers.get(index).addTransaction(valor);
    }

    public void showBalance(String name) {
        int index = clientExist(name);
        if(index == -1) {
            System.out.println("Client not found");
        } else {
            double total = 0.0;
            System.out.println("-".repeat(30));
            System.out.println(customers.get(index).name() + " Account balance: ");
            for (Double d : customers.get(index).transactions()) {
                System.out.println("Transaction: " + d);
                total += d;
            }
            System.out.println("Total value: " + total);
            System.out.println("-".repeat(30));
        }
    }
}
