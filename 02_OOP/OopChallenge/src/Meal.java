public class Meal {
    private String type;
    protected double price;

    public Meal() {
    }

    public Meal(String type) {
        this.type = type;
    }

    public Meal(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    protected String formatPrice(double price){
        return String.format("%.2f%n", price);
    }

    @Override
    public String toString() {
        return type + " Price : " + formatPrice(price);
    }
}


class Drink extends Meal {
    private String size;

    public Drink(String type, String size) {
        super(type);
        setSize(size);
    }

    public void setSize(String size) {
        this.size = size;
        switch (size.toLowerCase().charAt(0)) {
            case 'p' -> price = 5.5;
            case 'm' -> price = 7.9;
            case 'g' -> price = 9.9;
        }
    }

    @Override
    public String toString() {
        return size + " " + super.toString();
    }
}

class FrenchFries extends Meal {
    public FrenchFries(String type) {
        super(type);
        price = 7.99;
    }

    public FrenchFries(String type, double price) {
        super(type, price);
    }

}

class Burgers extends Meal {
    private boolean tomato;
    private boolean bacon;
    private boolean onions;
    private int toppingCount;
    private double totalPrice;

    public Burgers(String type, double price) {
        super(type, price);
        setBacon(false);
        setOnions(false);
        setTomato(false);

    }


    public void setTomato(boolean tomato) {
        if (this.tomato && tomato) {
            System.out.println("You can't add more tomato");
        } else if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else if (tomato) {
            this.tomato = tomato;
            totalPrice += 0.99;
            toppingCount++;
        } else if (!tomato) {
            if (this.tomato) {
                System.out.println("Removing extra tomato");
                this.tomato = tomato;
                toppingCount--;
                totalPrice -= 0.99;
            }
        }
    }

    public void setBacon(boolean bacon) {
        if (this.bacon && bacon) {
            System.out.println("You can't add more bacon");
        } else if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else if (!bacon) {
            if (this.bacon) {
                System.out.println("Removing extra bacon");
                this.bacon = bacon;
                toppingCount--;
                totalPrice -= 0.99;
            }
        }
    }

    public void setOnions(boolean onions) {
        if (this.onions && onions) {
            System.out.println("You can't add more onions");
        } else if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else if (!onions) {
            if (this.onions) {
                System.out.println("Removing extra onions");
                this.onions = onions;
                toppingCount--;
                totalPrice -= 0.99;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        if (tomato) {
            response.append(" -> extra Tomato : 0.99\n");
        }
        if (bacon) {
            response.append(" -> extra Bacon : 2.99\n");
        }
        if (onions) {
            response.append(" -> extra Onions : 0.99\n");
        }

        return super.toString() + response ;
    }

    @Override
    public double getPrice() {
        return (totalPrice + price);
    }


}

class DeluxeBurger extends Meal {
    private boolean tomato;
    private boolean bacon;
    private boolean onions;
    private boolean lettuce;
    private boolean ketchup;
    private int toppingCount;

    public DeluxeBurger(String type) {
        super(type, 49.90);
    }


    public void setTomato(boolean tomato) {
        if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else {
            this.tomato = tomato;
            price += 0.99;
            toppingCount++;
        }
    }

    public void setBacon(boolean bacon) {
        if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else {
            this.bacon = bacon;
            price += 2.99;
            toppingCount++;
        }
    }

    public void setOnions(boolean onions) {
        if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else {
            this.onions = onions;
            price += 0.99;
            toppingCount++;
        }
    }

    public void setLettuce(boolean Lettuce) {
        if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else {
            this.lettuce = Lettuce;
            price += 0.99;
            toppingCount++;
        }
    }

    public void setKetchup(boolean ketchup) {
        if (toppingCount >= 3) {
            System.out.println("You can't add more toppings");
        } else {
            this.ketchup = ketchup;
            price += 0.99;
            toppingCount++;
        }
    }

    @Override
    public String toString() {


        return "49.90";
    }
}
