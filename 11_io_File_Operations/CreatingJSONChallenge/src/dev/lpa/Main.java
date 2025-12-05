package dev.lpa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        String students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5)
                .map(Student::toJSON)
                .collect(Collectors.joining(",","[","]"));

//        System.out.println(writeJSON(students.get(0)));


        try {

                Files.writeString(Path.of("students.json"),students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
