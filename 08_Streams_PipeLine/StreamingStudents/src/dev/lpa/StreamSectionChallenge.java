package dev.lpa;

import java.util.stream.Stream;

public class StreamSectionChallenge {
    public static void main(String[] args) {

    Course pymc = new Course("PYMC", "Python MasterClass", 50);
    Course jmc = new Course("JMC", "Java MasterClass", 100);
    Course cgj = new Course("CGJ", "Creating Games in Java",40);

    var students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc, cgj))
            .filter(s->s.getYearsSinceEnrolled() > 4)
            .limit(10000)
            .toList();

    var pymcEnrolled = students.stream()
            .filter(s -> s.getEngagementMap().containsKey(pymc.courseCode()))
            .count();
        var java = students.stream()
                .filter(s -> s.getEngagementMap().containsKey(jmc.courseCode()))
                .count();
        var cgjEnrolled = students.stream()
                .filter(s -> s.getEngagementMap().containsKey(cgj.courseCode()))
                .count();

        System.out.println("# of students in Python:" + pymcEnrolled);
        System.out.println("# of students in java:" + java  );
        System.out.println("# of students in Creating java games:" + cgjEnrolled);

    }
}
