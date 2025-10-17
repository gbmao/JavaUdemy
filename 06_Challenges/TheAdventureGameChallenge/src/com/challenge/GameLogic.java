package com.challenge;

import com.challenge.data.Location;
import com.challenge.data.LocationData;
import com.challenge.menu.Menu;

import java.util.HashMap;

public class GameLogic {
    static GameMap map = new GameMap();

    public static void main(String[] args) {

    Player player = new Player("road");
//        System.out.println(player.location);
        boolean flag = true;
        while (flag) {
       String res = Menu.showMenu(player.getLocation());
            if(res.equals("Q")) {
                flag = false;
                System.out.println("Quiting...");
            } else {
             player.move(res);
            }

        }


//        System.out.println(player.location);
    }



    public static class Player {
        private Location location;

        public Player(String location) {
            this.location = map.getLocation(location);
        }

        public Location getLocation() {
            return location;
        }

        private void setLocation(Location location) {
            this.location = location;
        }

        public void move(String key) {
            String mapKey = location.returnValue(key);
            setLocation(map.getLocation(mapKey));
        }
    }

    public static class GameMap {
        private HashMap<String,Location> map = LocationData.getData();

        public GameMap() {

        }

        public Location getLocation(String key){
            return map.get(key);
        }



    }
}
