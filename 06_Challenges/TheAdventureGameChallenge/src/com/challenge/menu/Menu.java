package com.challenge.menu;

import com.challenge.data.Location;
import com.challenge.utils.Utils;
import jdk.jshell.execution.Util;

public class Menu {

    public static String showMenu(Location playerLocation) {
        System.out.println(playerLocation);
        System.out.println("Select Your Compass Direction (Q to quit)");
        return Utils.inputResponse(playerLocation.getDirectionsAsKey());
    }
}
