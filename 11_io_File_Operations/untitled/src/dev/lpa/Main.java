package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("a","aaa");
    map.put("b","aaa");
    map.put("c","cake");

        System.out.println(mapAB2(map));

    }

    public static Map<String, String> mapAB2(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b")) {
            if(map.get("a") == map.get("b") ) {
                map.remove("a");
                map.remove("b");
                map.get("a").length();
            }
        }
        return map;
    }

    public static ListNode teste(ListNode head) {

    }
}
