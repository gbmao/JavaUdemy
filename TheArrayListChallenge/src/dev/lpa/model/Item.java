package dev.lpa.model;

public class Item {
    private String name;
    private String type;
    private int count;


    public Item(String name) {
        this.name = name;
        type = "Default";
        count = 1;
    };

    public Item(String name, String type, int count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

    public void addCount(int n) {
        count += n;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return " Nome = " + name +
                " tipo = " + type +
                " quantidade = " + count + "\n";
    }
}
