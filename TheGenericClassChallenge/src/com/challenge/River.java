package com.challenge;

public class River extends Line {
    private String name;

    public River(String name, double... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.print(name + " as " + getClass().getSimpleName() + " ");
        super.render();
    }
}
