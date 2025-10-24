package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<BankAccount> list = new ArrayList<>();
        list.add(new BankAccount("Online", 500.00));

        BankCustomer c1 = new BankCustomer("Ann", "1", list);



        System.out.println(c1);

        String name = c1.getName();



        System.out.println(c1);

    }


}
