package dev.lpa;

public class Test {
    public static void main(String[] args) {


//        inFlight(new Jet());
//
////        OrbitEarth.log("Testing" + new Satellite());
//
//
//        orbit(new Satellite());
//        fly(new DragonFly("Borboleta", "Inseto", FlightStages.GROUNDED));

        getToship(new TransportHelicopter());

    }

    private static void inFlight(FlightEnabled flier) {

        flier.takeOff();

        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {

        flier.takeOff();
        flier.fly();
        flier.land();
    }

    private static void fly(FlightEnabled i) {

        i.takeOff();
        i.land();
        i.fly();
    }

    private static void getToship(FlyingToShip chopper) {
        chopper.takeOff();
        chopper.fly();
        chopper.land();
    }
}
