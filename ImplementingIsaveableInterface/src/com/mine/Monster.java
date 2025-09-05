package com.mine;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    // -  It has three fields. One String called name and Two ints called hitPoints and strength.
    private String name;
    private int hitPoints;
    private int strength;
    // -  A constructor that accepts a String (name) and two ints (hitPoints and strength).

    public Monster(String name,int hitPoints, int strength) {
    // It initialises name, hitPoints and strength with the newly passed in values.
        this.strength = strength;
        this.hitPoints = hitPoints;
        this.name = name;
    }



    // Only getters for the three fields.

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    // -  write(), same as interface. Return a List of the fields in the order they appear in toString().
    @Override
    public List<String> write() {
        List<String> list = new ArrayList<>();
        list.add(getName());
        list.add(String.valueOf(getHitPoints()));
        list.add(String.valueOf(getStrength()));
        return list;
    }
    //-  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.
    @Override
    public void read(List<String> list) {
        if(list == null || list.size() <= 0) {
            System.out.println("Not a valid list");
            return;
        }
        this.name = list.get(0);
        this.hitPoints = Integer.parseInt(list.get(1));
        this.strength = Integer.parseInt(list.get(2));
    }
    // -  toString(), Monsters overriding toString() method.
    // It takes no arguments and returns a String in the following format:
    //
    //Monster{name='Werewolf', hitPoints=20, strength=40}


    @Override
    public String toString() {
        return """
                %s{name='%s', hitPoints=%s, strength=%s}"""
                .formatted(getClass().getSimpleName(), getName(), getHitPoints(), getStrength());
    }
}
