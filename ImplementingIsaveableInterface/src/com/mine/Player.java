package com.mine;

import java.util.List;

public class Player implements ISaveable {
    // It has four fields. Two Strings called name and weapon. Two ints called hitPoints and strength.
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    // A constructor that accepts a String (name) and two ints (hitPoints and strength).

    public Player(String name, int hitPoints, int strength) {
        // It initialises name, hitPoints and strength with the newly passed in values.
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        // It initialises weapon with the default weapon "Sword".
        this.weapon = "Sword";
    }


    //Getters and setters for all four fields.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    //-  write(), same as interface. Return a List of the fields in the order they appear in toString().
    @Override
    public List<String> write() {
        return List.of();
    }

    //-  read(), same as interface. Store the values in the List, in the order they appear in toString().
    // Make sure the List is not null and the size() is greater than 0 before storing the values.
    @Override
    public void read(List<String> list) {

    }
    // -  toString(), Players overriding toString() method. It takes no arguments and returns a String in the following format:
    //Player{name='Tim', hitPoints=10, strength=15, weapon='Sword'}


    @Override
    public String toString() {
        return """
                %s{name='%s', hitPoints=%s, strength=%s, weapon='%s'}"""
                .formatted(getClass().getSimpleName(), getName(), getHitPoints(), getStrength(), getWeapon());
    }
}
