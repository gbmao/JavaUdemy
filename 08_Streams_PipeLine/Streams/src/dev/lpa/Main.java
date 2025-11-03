package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> bingoPool = new ArrayList<>(70);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
//            System.out.println();
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("----------------------------------");

//        List<String> firstOnes = bingoPool.subList(0,15);
        List<String> firstOnes = new ArrayList<>( bingoPool.subList(0,15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n---------------------------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("----------------------------------");

//        bingoPool.stream() // source
//                .limit(15) //intermediario
//                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0) //intermediario
//                .map(s -> s.charAt(0) + "-" +s.substring(1)) // intermediario
//                .sorted() //intermediario
//                .forEach(s-> System.out.print(s + " ")); //terminal

        // intermediario não são necessarios
        //intermediario pega os elementos da stream, manipula, e retorna uma stream


        var tempStream = bingoPool.stream() // source
                .limit(15) //intermediario
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0) //intermediario
                .map(s -> s.charAt(0) + "-" +s.substring(1)) // intermediario
                .sorted(); //intermediario
//                .forEach(s-> System.out.print(s + " ")); //terminal

        tempStream.forEach(s-> System.out.print( s + " "));

        System.out.println("\n---------------------------------");

        //uma vez consumida, a stream nao pode mais ser usada!!!!!!
//        tempStream.forEach(s-> System.out.print( s.toLowerCase() + " "));

//        for (int i = 0; i < 15; i++) {
//            System.out.println(bingoPool.get(i));
//        }
    }
}
