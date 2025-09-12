package dev.lpa.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }

    public class StoreComparator<T extends StoreEmployee>
            implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee storeEmployee, StoreEmployee t1) {
            int result = storeEmployee.store.compareTo(t1.store);
            if (result == 0) {
                return new Employee.EmployeeComparator<>(
                        "yearStarted").compare(storeEmployee, t1);
            }
            return result;
        }
    }
}
