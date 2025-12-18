package dev.lpa;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        System.out.println(countYZ("!!day--yaz!!"));
    }

    public static int countYZ(String str) {
        int count = 0;
        var teste = str.split("[^a-zA-Z]+");
        for (int i = 0; i < teste.length; i++) {

           if (teste[i].toLowerCase().charAt(teste[i].length() - 1) == 'z'  ||
                   teste[i].toLowerCase().charAt(teste[i].length() - 1) == 'y') {
               count++;
           }
        }
        return count;
    }

    public static void nhamain(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("a","aaa");
    map.put("b","aaa");




//        System.out.println(mapAB2(map));

//        var  = LocalDate.of(2024,9,10);
        var birthDate = LocalDate.of(2023,10,15);




            var today = LocalDate.of(2025,11,15);
            var age = today.getYear() - birthDate.getYear();
            int months = 0;

            if (today.getMonthValue() < birthDate.getMonthValue() ||
                    (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
                age--;
                months = today.getMonthValue() - birthDate.getMonthValue();
                months = 12 + months;
            } else {
               months =  birthDate.getMonthValue() - today.getMonthValue();
                months = 12 + months;
            }

            var p = Period.between(birthDate, today);


        System.out.printf("age : " + p.getYears() + " months " + p.getMonths());

    }

    public static int age(int age){
        return age / 12;
    }
    public static int month(int age) {
        return age % 12;
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


}
