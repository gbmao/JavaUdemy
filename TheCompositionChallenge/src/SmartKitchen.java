public class SmartKitchen {
    private  CoffeeMaker coffeeMaker;
    private Dishwasher dishwasher;
    private Refrigerator refrigerator;

    public SmartKitchen(CoffeeMaker coffeeMaker, Dishwasher dishwasher, Refrigerator refrigerator) {
        this.coffeeMaker = coffeeMaker;
        this.dishwasher = dishwasher;
        this.refrigerator = refrigerator;
    }

    public SmartKitchen(){
        coffeeMaker = new CoffeeMaker("Cafeteira");
        dishwasher = new Dishwasher("Lava-loucas");
        refrigerator = new Refrigerator("Geladeira");
    }

    @Override
    public String toString() {
        return "SmartKitchen{" +
                "coffeeMaker=" + coffeeMaker.getName() +
                ", dishwasher=" + dishwasher.getName() +
                ", refrigerator=" + refrigerator.getName() +
                '}';
    }

    public void addWater(){
        coffeeMaker.setHasWorkToDo(true);
    }

    public void pourMilk(){
        refrigerator.setHasWorkToDo(true);
    }

    public void loadDishwasher(){
        dishwasher.setHasWorkToDo(true);
    }
    public void setKitchenState(boolean addWater, boolean pourMilk,
                                boolean loadDishwasher){
        coffeeMaker.setHasWorkToDo(addWater);
        refrigerator.setHasWorkToDo(pourMilk);
        dishwasher.setHasWorkToDo(loadDishwasher);
    }

    public void doKitchenWork(){
        coffeeMaker.brewCoffee();
        refrigerator.orderFood();
        dishwasher.doDishes();
    }
//    public CoffeeMaker getCoffeeMaker() {
//        return coffeeMaker;
//    }
}
