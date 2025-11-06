package dev.lpa;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass");
        Course jmc = new Course("JMC", "Java MasterClass");
//        Student tim = new Student("AU", 2019, 30, "M", true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        var studentList = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        var maleStream = studentList.stream()
                .filter(s -> Objects.equals(s.getGender(), "M"))
                .count();

        var femaleStream = studentList.stream()
                .filter(s -> s.getGender().equals("F"))
                .count();
        var nonBStream = studentList.stream()
                .filter(s -> !s.getGender().equals("M") && !s.getGender().equals("F"))
                .count();

        var ageLessThan30 = studentList.stream()
                .filter(s -> s.getAge() < 30)
                .count();

        var ageBetween3060 = studentList.stream()
                .filter(s -> s.getAge() >= 30 && s.getAge() <= 60)
                .count();

        var ageMoreThan60 = studentList.stream()
                .filter(s -> s.getAge() > 60)
                .count();


        var studentByCountry = studentList.stream()
                .map(Student::getCountryCode)
                .distinct();
        var studentByCountrySize = studentList.stream()
                .map(Student::getCountryCode)
                .distinct()
                .count();

        var studentActive = studentList.stream()
//                .filter(s -> s.getMonthsSinceActive() <= 12)
//                .filter(student -> student.getYearsSinceEnrolled() > 7)
                        .anyMatch(s -> s.getMonthsSinceActive() <= 12 && s.getYearsSinceEnrolled() > 7);

        var studentActivePrint = studentList.stream()
                .filter(s -> s.getMonthsSinceActive() < 12)
//                .filter(s-> s.getAgeEnrolled() < 20)
                .filter(student -> student.getYearsSinceEnrolled() > 7)
//                .peek(s -> System.out.println(s.getStudentId() + " -> inactivity months: " + s.getMonthsSinceActive()))
                        .limit(5);




        System.out.println("Total male: " + maleStream);
        System.out.println("Total female: " + femaleStream);
        System.out.println("Total unknow: " + nonBStream);

        System.out.println("Total student less than 30: " + ageLessThan30);
        System.out.println("Total student between 30 and 60: " + ageBetween3060);
        System.out.println("Total student more than 60: " + ageMoreThan60);

        System.out.print("Total countries: " + studentByCountrySize + " they are: ");
        studentByCountry.forEach(s -> System.out.print(s + " "));
        System.out.println();


        System.out.println("There student active for more than 7 years? " + studentActive);

        studentActivePrint.forEach(System.out::println);


        System.out.println("-------------------------");


    }
}
