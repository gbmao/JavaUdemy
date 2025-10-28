package dev.lpa.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final int routingNumber;
    private static  long lastTransaction = 0;
    private long transactionId;
    private final Map<String,BankCustomer> customers;

    public Bank() {
        this.routingNumber = 1;
        this.customers = new HashMap<>();
    }

    public dev.lpa.bank.BankCustomer getCustomers(String id) {
        return customers.get(id);
    }

    public void addCustomer(String name, double checkingInitialDeposit,
                            double savingInitialDeposit) {
        BankCustomer bc = new BankCustomer(name,checkingInitialDeposit,savingInitialDeposit);
        customers.put(bc.getCustomerId(),bc);
    }

    public void doTransaction(String id, BankAccount.AccountType type, double amount) {
        BankCustomer bc = customers.get(id);
        transactionId = lastTransaction++;
        bc.getAccount(type).commitTransaction(routingNumber,Integer.parseInt(id),transactionId,amount);
    }

    public void printClient(){
        customers.forEach((k,v) -> System.out.println("ID: " +k + " client: " + v.getName()));
    }

    public void printTransactions(String id, BankAccount.AccountType type) {
        getCustomers(id).printTransactions(type);
    }

    public BankAccount.AccountType getAccountType(String type){
        return BankAccount.AccountType.valueOf(type.toUpperCase());
    }
}
