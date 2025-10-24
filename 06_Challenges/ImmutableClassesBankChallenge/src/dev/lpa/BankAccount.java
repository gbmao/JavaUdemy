package dev.lpa;

public class BankAccount {
    private String type;
    private double balance;

    public BankAccount(String type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
