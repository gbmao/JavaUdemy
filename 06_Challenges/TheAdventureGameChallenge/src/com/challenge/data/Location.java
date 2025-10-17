package com.challenge.data;

import java.util.HashMap;
import java.util.Set;

public class Location {
    private String name;
    private String description;
    private HashMap<String, String> connections;

    public Location(String name, String description, String[] locations) {
        this.name = name;
        this.description = description;
        this.connections = createMap(locations);
    }

    public Location(String name) {
        this.name = name;
    }

    public Set<String> getDirectionsAsKey(){
        return connections.keySet();
    }


    private static HashMap<String, String> createMap(String[] locations) {
        HashMap<String, String> maps = new HashMap<>();
        for (String s : locations) {
            String[] data = s.split(":");
            maps.put(data[0],data[1]);
        }
        return maps;
    }

    public String returnValue(String key) {
        return connections.get(key);
    }

    private StringBuilder getDirections(){
        StringBuilder sb = new StringBuilder();
        connections.forEach((k, v) -> sb.append("    ● A road to the %s (%s) %n".formatted(v,k.toUpperCase())) );
        return sb;
    }

    @Override
    public String toString() {

        return "*** You're standing  " + description + "  ***\n    From Here, you can see:\n" + getDirections() ;
    }
}
