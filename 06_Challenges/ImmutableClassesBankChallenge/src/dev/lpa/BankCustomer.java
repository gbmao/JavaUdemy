package dev.lpa;

import java.util.List;

public final class BankCustomer {
    private final String name;
    private final String customerId;
    private List<BankAccount> accounts;

    public BankCustomer(String name, String customerId, List<BankAccount> accounts) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = accounts;
    }


    public String getName() {
        return name;
    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public String getCustomerId() {
        return customerId;
    }


    @Override
    public String toString() {
        return "BankCustomer{" +
                "name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
