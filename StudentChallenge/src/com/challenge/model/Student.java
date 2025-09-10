package com.challenge.model;

import com.challenge.util.QueryItem;

import java.util.Comparator;
import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private static int LAST_ID = 10_000;

    private String name;
    private String course;
    private int yearStarted;
    private int studentID;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};

    private static String[] courses = {"C++", "Java", "Python"};

    public Integer getStudentID() {
        return studentID;
    }

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
        studentID = LAST_ID++;
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentID, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fname = fieldName.toUpperCase();
        return switch (fname) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }


    @Override
    public int compareTo(Student student) {
        return Integer.valueOf(studentID).compareTo(student.studentID);
    }
}