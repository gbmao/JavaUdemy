package com.abc.first;

import java.util.List;

public class Item {
    private String type;

    private List<String> list;

    public Item(String type){
        this.type = type;
    }

    public List<String> getList() {

        return list;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                '}';
    }
}
