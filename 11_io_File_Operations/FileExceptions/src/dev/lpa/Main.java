package dev.lpa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String fileName = "testing.csv";

        testFile(fileName);

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("I can't run unless this file exists");
            System.out.println("Quitting application, go figure it out");
            return;
        }
        System.out.println("I'm good to go.");
    }

    private static void testFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
