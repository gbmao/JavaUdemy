package com.lpa;

import java.util.ArrayList;

public class Places {
    private String town;
    private int kmFromSydney;

    public Places(String town, int kmFromSydney) {
        this.town = town;
        this.kmFromSydney = kmFromSydney;
    }

    public String getTown() {
        return town;
    }

    public int getKmFromSydney() {
        return kmFromSydney;
    }


}
