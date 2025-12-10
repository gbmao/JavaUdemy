package dev.lpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Warehouse {

    public static LinkedList<String> products = new LinkedList<>(List.of(
            "Tênis", "Sapato", "Sandalia"));

    private Queue<Order> orders = new LinkedList<>();
    private Random random;

    public Warehouse() {

    }

    public void receiveOrder(){
         while (orders.size() < 10){
            orders.add()
         }

        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }

    public void fulfillOrder(){

        while (orders.isEmpty()){

        }

        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }
}
