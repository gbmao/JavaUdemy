package com.challenge;

import java.util.Arrays;

abstract class Point implements Mappable{

    private Double latitude;
    private Double longitude;

    protected Point(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude =  longitude;
    }

    private String location() {
        return "([" + latitude + "," + longitude + "])";
    }

    @Override
    public void render() {
        System.out.println(location());
    }
}
