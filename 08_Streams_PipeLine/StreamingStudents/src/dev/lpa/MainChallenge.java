package dev.lpa;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass", 50);
        Course jmc = new Course("JMC", "Java MasterClass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        var students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(5000)
                .toList();

        var percentCompJMC = students.stream()
//                .filter(s -> s.getEngagementMap().containsKey("JMC"))
                .map(s -> s.getPercentComplete("JMC"))
//                .peek(s -> System.out.println(s))
                .reduce(Double::sum)
                .orElse(0.0);
        percentCompJMC = percentCompJMC / students.size();
        percentCompJMC = percentCompJMC * 1.25;


        // Solucao do chat

//        double avgJMC = students.stream()
//                .map(s -> s.getPercentComplete("JMC"))
//                .reduce(0.0, Double::sum) / students.size();
//
//        double threshold = avgJMC * 1.25;



        // collect the students with more percentCompJMC
        Double finalPercentCompJMC = percentCompJMC;
        var suitableStudents = students.stream()
                .filter(s -> s.getPercentComplete("JMC") > finalPercentCompJMC)
                .filter(s -> s.getMonthsSinceActive() < 12) // filter active students
//                .collect(Collectors.toSet(Comparator.comparing(Student::getYearsSinceEnrolled)))
                .sorted(Comparator.comparing(Student::getYearsSinceEnrolled).reversed()
                        .thenComparing(s -> s.getPercentComplete("JMC")).reversed())
                .limit(10)
                .peek(s-> s.addCourse(cgj));
//                .peek(s -> System.out.println(s.getYea/rsSinceEnrolled()));


        System.out.println("result = " + percentCompJMC);
//        System.out.println(suitableStudents);
        suitableStudents.forEach(s -> System.out.println( s.getPercentComplete("JMC") + " " + s.getEngagementMap()));

    }
}
