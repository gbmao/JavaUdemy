package com.lpa;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;

        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact name) {

        if(findContact(name) >= 0) {
            return false;
        } else {
            myContacts.add(name);
            return true;
        }
    }

    public boolean updateContact(Contact old, Contact newContact) {

        if(findContact(old) < 0) {
            return false;
        } else {
            myContacts.set(myContacts.indexOf(old),newContact );
            return true;
        }
    }

    public boolean removeContact(Contact name) {

        if(!myContacts.contains(name)) {
            return false;
        } else  {
            myContacts.remove(name);
            return true;
        }
    }

    private int findContact(Contact name) {
        return myContacts.indexOf(name);
    }

    public int findContact(String name) {

        for (Contact i : myContacts) {

            if(i.getName().equals(name)) {
                return myContacts.indexOf(i);
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {

        for ( Contact i : myContacts) {

            if(i.getName().equals(name)) {
                return i;
            }
        }

        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        int count = 1;
        for (Contact i : myContacts) {
            System.out.println(count + ". " + i.getName() + " -> " + i.getPhoneNumber());
            count++;
        }
    }

}
