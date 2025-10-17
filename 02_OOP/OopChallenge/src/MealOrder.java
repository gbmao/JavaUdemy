public class MealOrder extends Meal {
    private double dueAmount;

    private Burgers burgers;

    private Drink drink;

    private FrenchFries frenchfries;

    private DeluxeBurger deluxeBurger;

    private boolean isDeluxe;

    public MealOrder(){
        this.burgers = new Burgers("X-tudo", 19.80);
        this.drink = new Drink("Coca-cola", "Media");
        this.frenchfries = new FrenchFries("batata frita ");
    }

    public MealOrder(String type, Burgers burgers, Drink drink, FrenchFries frenchfries) {
        super(type);
        this.burgers = burgers;
        this.drink = drink;
        this.frenchfries = frenchfries;
        price = getPrice();
    }

    public MealOrder(DeluxeBurger deluxeBurger, FrenchFries frenchfries, Drink drink) {
        this.deluxeBurger = deluxeBurger;
        this.frenchfries = frenchfries;
        this.drink = drink;
        isDeluxe = true;
    }



    public double getPrice(){
        if(isDeluxe) return deluxeBurger.getPrice();
        return burgers.getPrice() + drink.getPrice() + frenchfries.getPrice();
    }

    @Override
    public String toString() {
        if(isDeluxe) return "X- sinistro  Price: " + deluxeBurger;
        return  drink + "" + frenchfries  + burgers  +"-".repeat(30) +"\n" + getType() +" price : " + formatPrice(getPrice());

    }
}
