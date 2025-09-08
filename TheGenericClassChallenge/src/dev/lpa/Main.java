package dev.lpa;

public class Main {

    public static void main(String[] args) {

        var nationalUSParks = new Park[] {
                new Park("YellowStone", "4545454, -4654654564"),
                new Park("Grand Canyon", "65456456465,65465465"),
                new Park("Yosemite", "54654564,4564654")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();
    }
}
