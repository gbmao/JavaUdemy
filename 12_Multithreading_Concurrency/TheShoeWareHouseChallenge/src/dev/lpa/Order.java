package dev.lpa;

public record Order(long id,String type, int quantity) {
    static long totalId = 1;
    public Order(String type, int quantity) {
        this(totalId++, type, quantity);
    }
}
