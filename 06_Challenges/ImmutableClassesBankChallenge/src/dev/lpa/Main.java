package dev.lpa;

import dev.lpa.bank.Bank;
import dev.lpa.bank.BankCustomer;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        dev.lpa.bank.BankCustomer joe = new BankCustomer("Joe", 500.00,
//                10000.00);
//        System.out.println(joe);
//
//        List<BankAccount> accounts = joe.getAccounts();
//        accounts.clear();
//        System.out.println(joe);

        Bank itau = new Bank();
        itau.addCustomer("Joe", 500, 1000);
        itau.addCustomer("Jorge", 500, 1000);
        itau.printClient();

        System.out.println(itau.getCustomers("10000000"));
        System.out.println(itau.getCustomers("10000001"));

        System.out.println("-------------------");

        itau.doTransaction("10000000", itau.getAccountType("CHECKING"), -500);
        itau.doTransaction("10000000", itau.getAccountType("CHECKING"), -500);


        itau.printTransactions("10000000", itau.getAccountType("CHECKING"));

        System.out.println("---------------");
        System.out.println(itau.getCustomers("10000000"));

        System.out.println("------------------------");
    }


}
