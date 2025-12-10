package dev.lpa;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
//        warehouse.receiveOrder();

        Thread buy = new Thread(() -> {
            warehouse.receiveOrder();
        });
    }
}
