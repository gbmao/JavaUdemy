package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
//        warehouse.receiveOrder();

        Thread buy = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
//                System.out.print("\n Buyer : ");
                warehouse.receiveOrder();
            }
        });
        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\nConsumer 1: ");
                    warehouse.fulfillOrder();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer2 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                System.out.print("\nConsumer 2: ");
                warehouse.fulfillOrder();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        buy.start();
        consumer2.start();
        consumer1.start();

        try {
            buy.join();
            consumer2.join();
            consumer1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(warehouse);
    }
}
