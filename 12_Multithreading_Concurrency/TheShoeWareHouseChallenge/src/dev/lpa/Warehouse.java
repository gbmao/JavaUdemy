package dev.lpa;

import java.util.*;

public class Warehouse {

    public static LinkedList<String> products = new LinkedList<>(List.of(
            "Tênis", "Sapato", "Sandalia"));

    private Queue<Order> orders = new LinkedList<>();
    private Random random = new Random();

    public Warehouse() {

    }

    public synchronized void receiveOrder() {
        while (orders.size() >= 10) {
            try {
                System.out.println("All slot orders are full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        orders.add(new Order(
                products.get(random.nextInt(0, 3)),
                random.nextInt(1, 10)
        ));
        System.out.println("Order received. Total: " + orders.size());
        notifyAll();
    }

    public synchronized void fulfillOrder() {

        while (orders.isEmpty()) {
            try {
                System.out.println("NO more orders");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Order removed = orders.remove();
        System.out.println("Delivered order: " + removed);
        notifyAll();

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("orders=" + orders)
                .toString();
    }
}
