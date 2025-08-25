public class Car {
    private String Description;

    public Car(String description) {
        Description = description;
    }

    public void starEngine(){
        System.out.println("Start engine");
    }

    protected  void runEngine(){
        System.out.println("Engine is running...");
    }

    public void drive(){
        System.out.println("Car is driving...  type is : " + getClass().getSimpleName());
        runEngine();
    }
}

class GasPoweredCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void starEngine() {
        System.out.printf("gas -> All %d cylinders are fired up, ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {

        System.out.printf("gas -> usage exceeds the average: %.2f %n", avgKmPerLitre);
    }
}

class EletricCar extends Car {
    private double avgKimPerCharge;
    private int battery;

    public EletricCar(String description) {
        super(description);
    }

    public EletricCar(String description, double avgKimPerCharge, int battery) {
        super(description);
        this.avgKimPerCharge = avgKimPerCharge;
        this.battery = battery;
    }

    @Override
    public void starEngine() {
        System.out.printf("BEV -> switch %d battery on, ready!%n", battery);
    }

    @Override
    protected void runEngine() {

        System.out.printf("BEV -> under the  average: %.2f %n", avgKimPerCharge);
    }
}

class HybridCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    private int batterySize;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLitre, int cylinders, int batterySize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    @Override
    public void starEngine() {
        System.out.printf("hybrid -> All %d cylinders are fired up, ready!%n", cylinders);
        System.out.printf("hybrid -> All %d battery are on, ready!%n", batterySize);
    }

    @Override
    protected void runEngine() {

        System.out.printf("gas -> usage exceeds the average: %.2f %n", avgKmPerLitre);
    }
}