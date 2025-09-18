package dev.lpa;

import dev.lpa.domain.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Minnie", "Mouse", "01/02/2015");
        Employee e2 = new Employee("Mickie", "Mouse", "05/08/2000");
        Employee e3 = new Employee("Daffy", "Duck", "11/02/2011");
        Employee e4 = new Employee("Daisy", "Duck", "05/03/2013");
        Employee e5 = new Employee("Goofy", "Dog", "23/07/2020");

        List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderedList(list,"name");
        System.out.println();
        printOrderedList(list,"year");

    }

    public static void printOrderedList(List<Employee> eList, String sortField) {

        int currentYear = LocalDate.now().getYear();

        class MyEmployee {

            Employee cointainedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee cointainedEmployee) {
                this.cointainedEmployee = cointainedEmployee;
                yearsWorked = currentYear - Integer.parseInt(cointainedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ", cointainedEmployee.first(), cointainedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }


        }
        List<MyEmployee> list = new ArrayList<>();
        for (Employee employee : eList) {
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>() {
            @Override
            public int compare(MyEmployee myEmployee, MyEmployee t1) {

                if(sortField.equals("name")){
                    return myEmployee.fullName.compareTo(t1.fullName);
                }
                return myEmployee.yearsWorked - t1.yearsWorked;
            }
        };

        list.sort(comparator);

        for (MyEmployee myEmployee : list) {
            System.out.println(myEmployee);
        }
    }
}
