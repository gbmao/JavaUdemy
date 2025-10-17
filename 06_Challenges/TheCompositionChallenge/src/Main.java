public class Main {
    public static void main(String[] args){

    SmartKitchen kitchen = new SmartKitchen(new CoffeeMaker("coffe"), new Dishwasher("ae"), new Refrigerator("aae") );

    kitchen.doKitchenWork();
    kitchen.addWater();
    kitchen.doKitchenWork();
//    kitchen.setKitchenState(true, true, true);
//    kitchen.doKitchenWork();
//    kitchen.setKitchenState(false,true,false);
//    kitchen.doKitchenWork();

        System.out.println(kitchen);
    }
}
