public class Product {
    private String model;
    private String manufactures;
    private int width;
    private int height;
    private int depth;

    public Product(String manufactures, String model) {
        this.manufactures = manufactures;
        this.model = model;
    }
}

class Monitor extends Product {

    private int size;
    private String resolution;

    public Monitor(String manufactures, String model) {
        super(manufactures, model);
    }

    public Monitor(String manufactures, String model, int size, String resolution) {
        super(manufactures, model);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelArt(int x, int y, String color){
        System.out.println(String.format(
                "Drawing pixel at %d,%d in color %s", x, y, color
        ));
    }
}

class Motherboard extends Product {

    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String manufactures, String model) {
        super(manufactures, model);
    }

    public Motherboard(String manufactures, String model, int ramSlots, int cardSlots, String bios) {
        super(manufactures, model);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }
}

class ComputerCase extends Product {

    private String powerSuply;
    public ComputerCase(String manufactures, String model) {
        super(manufactures, model);
    }

    public ComputerCase(String manufactures, String model, String powerSuply) {
        super(manufactures, model);
        this.powerSuply = powerSuply;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}


