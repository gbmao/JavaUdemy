package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("aVidaComoElaE.txt");

        mostUsedWordsWithMinimalCharacter(path, 10, 5);

    }

    private static void mostUsedWordsWithMinimalCharacter(Path path, int maxDisplayWords, int minimumChar) {
        Pattern pattern = Pattern.compile("([a-zA-Z]{" + minimumChar + ",})");

        try {
            var teste = Files.lines(path);

            var result = teste
                    .flatMap(line -> Arrays.stream(line.split("\\W+")))
//                   .map(pattern::matcher)
                    .map(String::toLowerCase)
                    .filter(a -> pattern.matcher(a).matches())
                    .collect(Collectors.groupingBy(
                            word -> word,
                            Collectors.counting()));

            result.entrySet().stream()
//                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .limit(maxDisplayWords)
                    .forEach((s) -> {

                        System.out.print(s.getKey() + " = " + s.getValue() + " ");

                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
