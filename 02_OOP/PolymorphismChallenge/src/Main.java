public class Main {
    public static void main(String[] args) {



        Car ferrari = new GasPoweredCar("Ferrari GTS", 15.4, 6);
        runRace(ferrari);



        Car tesla = new EletricCar("tesla", 568, 75);
        runRace(tesla);

        Car ferrariHybrid = new HybridCar("Ferrari", 16, 8 ,8);
        runRace(ferrariHybrid);
    }

    public static void runRace(Car car){

        car.starEngine();
        car.drive();
    }
}

