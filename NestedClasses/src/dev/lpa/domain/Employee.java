package dev.lpa.domain;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator <T extends Employee>
            implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee employee, Employee t1) {
            if(sortType.equalsIgnoreCase("yearstarted")){
                return employee.yearStarted - t1.yearStarted;
            }
            return employee.name.compareTo(t1.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
