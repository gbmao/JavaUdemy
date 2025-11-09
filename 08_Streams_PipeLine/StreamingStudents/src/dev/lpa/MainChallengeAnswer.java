//package dev.lpa;
//
//import java.rmi.Naming;
//import java.util.Comparator;
//import java.util.stream.Collectors;
//
//public class MainChallengeAnswer {
//
//
//    Edwin Einsen — Instrutor
//            Resposta
//0 voto a favor
//1 dia atrás
//    Hi Gabriel, good work! Your pipeline is clear, and the idea (pick top candidates above an adjusted JMC average, active in last year) makes sense. A few sharp fixes to make it robust and idiomatic:
//
//
//
//            1) Don't hardcode 5000 for the average
//
//    Use mapToDouble(...).average() (or averagingDouble) so it works for any list size.
//
//
//
//    double avgJmc = students.stream()
//            .mapToDouble(s -> s.getPercentComplete("JMC"))
//            .average()
//            .orElse(0.0);
//
//    double cutoff = Math.min(100.0, avgJmc * 1.25); // cap at 100 if you like
//
//
//2) Comparator: avoid the double .reversed() trap
//
//    Your chain reverses twice and can flip the whole order. Make each key explicit:
//
//
//
//    var suitable = students.stream()
//            .filter(s -> s.getPercentComplete("JMC") > cutoff)
//            .filter(s -> s.getMonthsSinceActive() < 12)
//            .sorted(
//                    Comparator.comparingInt(Student::getYearsSinceEnrolled).reversed()
//                            .thenComparing(Comparator.comparingDouble(
//                                    s -> s.getPercentComplete("JMC")).reversed())
//            )
//            .limit(10)
//            .collect(Collectors.toList());
//
//
//3) Don't use peek for side-effects
//
//    peek(s -> s.addCourse(cgj)) works only because there's a terminal op later, but peek is for debugging. Prefer:
//
//
//
//            suitable.forEach(s -> s.addCourse(cgj));
//    Then print:
//
//
//
//            suitable.forEach(s ->
//            System.out.println(s.getPercentComplete("JMC") + " " + s.getEngagementMap()));
//
//
//4) Naming: make intent obvious
//
//    percentCompJMC is an average, so avgJmc / cutoff reads better.
//
//
//
//5) .toList() returns unmodifiable (JDK 16+)
//
//    That's fine since you don't mutate students, just good to be aware.
//
//
//
//    About your getRandomStudent changes
//
//
//
//    int lecture = random.nextInt((c.lectureCount() > 30 ? 30 : 1), c.lectureCount());
//-- This biases selection (e.g., for 31 lectures, you only ever get 30).
//
//            -- If you wanted 1..lectureCount inclusive, use:
//
//
//
//    int lecture = 1 + random.nextInt(c.lectureCount()); // [1..count]
//-- If you wanted to start around lecture 30 when available, use:
//
//
//
//    int start = (c.lectureCount() > 30) ? 30 : 1;          // inclusive
//    int bound = c.lectureCount() + 1;                      // make upper inclusive
//    int lecture = start + random.nextInt(bound - start);   // [start..count]
//    Your month clamp is sensible, so you can also bound the random date to now up front to avoid the corrective if.
//
//
//
//    Happy coding!
//}
