package dev.lpa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class MainFinalChallenge {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass", 50);
        Course jmc = new Course("JMC", "Java MasterClass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java" );

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc, cgj))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        students.subList(0,10).forEach(System.out::println);
    }
}
