package com.challenge;


import java.util.Arrays;


abstract class  Line implements Mappable{

    private double[][] locations;

    protected Line(double... locations) {
        this.locations = new double[locations.length/2][2];

        int index = 0;
        for (int i = 0; i < locations.length/2; i++) {

            for (int j = 0; j < 2; j++) {

                this.locations[i][j] = locations[index];
                index++;

            }

        }


    }


    private String location(){
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println(location());
    }
}
