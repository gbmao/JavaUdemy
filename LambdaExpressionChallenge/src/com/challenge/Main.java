package com.challenge;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Joanna");
        names.add("Bob");
        names.add("Anna");
        System.out.println(names);
        UnaryOperator<String> toUpper = (source) ->source.toUpperCase();

        List<String> test = new ArrayList<>();
//        names.replaceAll(toUpper);



        System.out.println(names);
        Random random = new Random();
//        char a = (char) random.nextInt(65,91);
//        System.out.println(a);

        UnaryOperator<String> middleLetter = (source) -> source + " " + (char) random.nextInt(65,91) + ".";

        names.replaceAll(middleLetter);
        System.out.println(names);

        ArrayList<String> novo = new ArrayList<>();

        UnaryOperator<String> lastName = (source  ) -> {
            String[] firstName =  source.split(" ");

            StringBuilder sb = new StringBuilder(firstName[0]).reverse();

            return source.concat(" " + sb);
        };

//        names.forEach(s -> {
//
//            String[] firstName =  s.split(" ");
//
//            StringBuilder sb = new StringBuilder(firstName[0]).reverse();
//            novo.add(s.concat(" " + sb));
//        });

        names.replaceAll(lastName);

        System.out.println(names);

        ArrayList<String> nova = new ArrayList<>();

        names.forEach(s -> {
            String[] separated =  s.split(" ");
            if(!separated[0].equalsIgnoreCase(separated[separated.length - 1])) {
                nova.add(s);
            }
        } );

        System.out.println(nova);

        names.forEach(s -> System.out.println(s));
//
//        UnaryOperator<String> removeDuplicate = (source) -> {
//
//            String[] name = source.split(" ");
////            name = source.split(" ");
//
//            if(name[0].equals(name[2])) {
//                source = null;
//            }
//
//        };



    }


}
