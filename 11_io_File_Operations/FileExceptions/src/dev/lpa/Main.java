package dev.lpa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String fileName = "testing.csv";

        testFile2(null);

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
        FileReader reader = null;
        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }


    private static void testFile2(String fileName) {

        try (FileReader reader = new FileReader(fileName)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + fileName + "' does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data " + badData.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        }
        finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
