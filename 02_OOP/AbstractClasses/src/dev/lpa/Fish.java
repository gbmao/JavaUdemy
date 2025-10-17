package dev.lpa;

public class Fish extends Animal{


    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if(speed.equals("Slow")) {
            System.out.print(getExplicitType() + " gliding throught water ");
        } else {
            System.out.print(getExplicitType()  +"following the currency");
        }
    }

    @Override
    public void makeNoise() {

        if(type == "GoldFish") {
            System.out.print("Splash! ");
        } else {
            System.out.print("Bubbles! ");
        }
    }
}
