package dev.lpa;

public class Dog extends Mammal{


    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if(speed.equals("Slow")) {
            System.out.print(type + " Walking");
        } else {
            System.out.print(getExplicitType() + " Running");
        }
    }

    @Override
    public void shedHair() {

        System.out.println(getExplicitType() + " shed hair all the time");
    }

    @Override
    public void makeNoise() {

        if(type == "wolf") {
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }
    }
}
