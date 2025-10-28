package dev.lpa.bank;

import dev.dto.Transaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

 class BankAccount {

    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType accountType;

    private double balance;

    private final Map<Long, Transaction> transactions;


    //getter/access method for the transaction data
    protected Map<Long, Transaction> getTransactions() {
        return transactions;
    }

    //adjust balance / add transaction data

    protected boolean commitTransaction(int routingNumber, int customerId, long transactionId, double transactionAmount) {
        if ((balance + transactionAmount) < 0) {
            System.out.println("Not enough money! pobre miseravi");
            transactions.put(transactionId, new Transaction(routingNumber, customerId, transactionId, transactionAmount, false));
            return false;
        } else {
            balance += transactionAmount;
            transactions.put(transactionId, new Transaction(routingNumber, customerId, transactionId, transactionAmount, true));
            return true;
        }
    }

    BankAccount(AccountType accountType, double balance) { //VIP
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = new LinkedHashMap<>(); // LinkedHashMap para manter a ordem de inserção
    }


    protected AccountType getAccountType() {
        return accountType;
    }

    protected double getBalance() {
        return balance;
    }

    protected void printTransactions(){
        System.out.println("Transactions: ");
        transactions.forEach((k,v)-> System.out.println(v));
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }
}
