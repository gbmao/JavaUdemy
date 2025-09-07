package com.challenge;

public class Park extends Point{
    private String name;

    public Park(String name, Double latitude, Double longitude) {
        super(latitude, longitude);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.print(name + " as " + getClass().getSimpleName() + " ");
        super.render();
    }
}
