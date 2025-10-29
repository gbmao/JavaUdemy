package dev.gab;

import dev.dto.Transaction;
import dev.lpa.bank.Bank;
import dev.lpa.bank.BankAccount;
import dev.lpa.bank.BankCustomer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

//        BankCustomer joe = new BankCustomer("Joe", 500.00,
//                10000.00);
//        System.out.println(joe);

        Bank bank = new Bank(321325);
        bank.addCustomer("Joe", 500.00, 10000.00);
        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, 35)) {
            System.out.println(joe);
        }
//            System.out.println(joe);
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, -535)) {
            System.out.println(joe);
        }
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, -1)) {
            System.out.println(joe);
        }
        BankAccount checking = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransaction();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

//        transactions.put(3L, new Transaction(1,1,
//                Integer.parseInt(joe.getCustomerId()), 500));

//        System.out.println("----------------------");
//        for(var tx : transactions.values()) {
//            tx.setCustomerId(2);
//            tx.setAmount(10000.00);
//        }
//        transactions.forEach((k,v) -> System.out.println(k + ": " + v));

        joe.getAccount(BankAccount.AccountType.CHECKING).getTransaction().clear();
        System.out.println("--------------------------------");

        joe.getAccount(BankAccount.AccountType.CHECKING).getTransaction()
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
