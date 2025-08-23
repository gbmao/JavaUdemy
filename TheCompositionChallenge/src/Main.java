public class Main {
    public static void main(String[] args){

    SmartKitchen kitchen = new SmartKitchen();

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
