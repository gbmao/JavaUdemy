public class Appliances {
    private boolean hasWorkToDo;
    private String name;

    public Appliances(String name) {

        this.name = name;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;

    }

    public boolean getHasWorkToDo() {
        return hasWorkToDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

 class Refrigerator extends  Appliances {

    public Refrigerator(String name) {
        super( name);
    }


    public void orderFood(){
        if(getHasWorkToDo()){
            System.out.println("Refrigerator is making milk...");
        }
    }

}

class Dishwasher extends Appliances {

    public Dishwasher(String name) {
        super(name);
    }

    public void doDishes(){
        if(getHasWorkToDo()){
            System.out.println("Dishwasher is doing dishes...");
        }
    }
}

class  CoffeeMaker extends Appliances {

    public CoffeeMaker(String name){
        super(name);
    }

    public void brewCoffee(){
        if (getHasWorkToDo()){
            System.out.println("Brewing coffee...");
        }
    }

}
