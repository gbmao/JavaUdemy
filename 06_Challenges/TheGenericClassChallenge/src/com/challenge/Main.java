package com.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Layer<T extends Mappable>  {
    private List<T> elements = new ArrayList<>();

    public Layer(List<T> elements) {
        this.elements = elements;
    }

    public void add(T elements) {
        this.elements.add(elements);
    }



    public Layer(){}

    public void renderLayer() {

        for (T t : elements) {
            t.render();
        }
    }
}

public class Main {
    public static void main(String[] args) {

//        River rio = new River("Macae", "teste");

        Park parque = new Park("pracinha da Trindade", 15454545.0,65546.0);

        Layer<Park> parques = new Layer<>();
        parques.add(parque);
        parques.add(new Park("Cramunho", 5145.5, -45682.5));

        parques.renderLayer();

        River river = new River("Arg", 15.6,656546.6, -45154, 6565);

        Layer<River> rios = new Layer<>();

        rios.add(river);

        rios.renderLayer();

        Layer<Mappable> tudo = new Layer<>();

        tudo.add(river);
        tudo.add(parque);

        tudo.renderLayer();


    }
}
