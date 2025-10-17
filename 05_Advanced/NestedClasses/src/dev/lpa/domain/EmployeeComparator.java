package dev.lpa.domain;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getName().compareTo(t1.getName());
    }
}
