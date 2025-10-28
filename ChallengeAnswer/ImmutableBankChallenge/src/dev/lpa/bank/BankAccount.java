package dev.lpa.bank;

import dev.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {

    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType accountType;

    private  double balance;

    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();


    BankAccount(AccountType accountType, double balance) { //VIP
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Long, Transaction> getTransaction() {
        return Map.copyOf(transactions);
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    void commitTransaction(int routingNumber, long transactionId,
                           String customerId, double amount) {
        balance += amount;
        transactions.put(transactionId,
                new Transaction(routingNumber, transactionId,
                        Integer.parseInt(customerId), amount));
    }
}
