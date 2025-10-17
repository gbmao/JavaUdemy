package com.lpa;

public class Main {
    public static void main(String[] args) {

        MobilePhone mobilePhone = new MobilePhone("985487918");
        Contact contact1 = new Contact("al", "87878");
        Contact contact2 = new Contact("bertie", "548578");
        Contact contact3 = new Contact("celia", "86668");



        System.out.println(mobilePhone.addNewContact(contact1));
        System.out.println(mobilePhone.addNewContact(contact1));
        mobilePhone.printContacts();



    }
}
