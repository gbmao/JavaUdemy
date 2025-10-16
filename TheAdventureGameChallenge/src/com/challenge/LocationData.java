package com.challenge;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LocationData {
    private static final String locations = """
                road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    //creates an HashMap with locations
    public static HashMap<String, Location> getData() {
        Scanner scanner = new Scanner(locations);
        HashMap<String, Location> dataList = new HashMap<>();
        //scan each line and put it in array of strings
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",");

            //insert locations to into another array
            if(data.length > 2) {
                String[] data2 = new String[data.length - 2];
                System.arraycopy(data, 2, data2, 0, data.length - 2);

            dataList.put(data[0], new Location(data[0], data[1], data2));
            }

        }

        return dataList;
    }
}
