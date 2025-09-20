package dev.lpa;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

//        Consumer<String> printTheParts = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                String[] parts = s.split(" ");
//                for (String part : parts) {
//                    System.out.println(part);
//                }
//            }
//        };
//
//        printTheParts.accept("testando tudo aqui");

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printWordsLambda.accept("testandp tudo aqui");
//        printAqui("Testando tudo aqui");
        Consumer<String> passandoRaiva = s -> {
            System.out.println(s + " ESTOU PASSANDO RAIVA");
        };
        passandoRaiva.accept("aqui...");


        Function<String, String> secondCharLambda = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }

            }
            return returnVal.toString();
        };
        UnaryOperator<String> secondCharUnary = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }

            }
            return  returnVal.toString();
        };

        System.out.println("Unary: " + secondCharUnary.apply("Testando"));
        System.out.println("A Stringbuild ta aqui : " + secondCharLambda.apply("Testando"));

    Consumer<String> everySecondCharLambda = source -> {

        for (int i = 0; i < source.length(); i++) {
            if(i % 2 == 1) {
                System.out.print("" + source.charAt(i));
            }

        }
    };



    everySecondCharLambda.accept("testando");

    }
    public static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }

        }
        return returnVal.toString();
    }




}
