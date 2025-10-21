package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        printMap(createMap(inputSentence()));
    }
    public static String inputSentence() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        return scanner.nextLine();
    }

    public static Map<String, Integer> createMap(String sentence) {
        String[] words = sentence.split(" ");
        NavigableMap<String, Integer> wordsMapped = new TreeMap<>();
//        Map<String, Integer> wordsMapped = new HashMap<>();
        for (String s : words) {
            if (!wordsMapped.containsKey(s)) {
                wordsMapped.put(s, 1);
            } else {
                wordsMapped.put(s, wordsMapped.get(s) +1);
            }
        }

        return wordsMapped;
    }

    public static void printMap(Map<String, Integer> words) {
        System.out.println("Word count:");

        words.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

}
