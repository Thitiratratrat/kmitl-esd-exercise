package kmitl.esd.exercise1.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private static final String POSITION = "Manager";
    private List<Employee> subordinates = new ArrayList<Employee>();


    public Manager(String firstName, String surname, int salary) {
        super(firstName, surname, POSITION, salary);
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public void displayEmployeeInformation() {
        super.displayEmployeeInformation();

        System.out.println("\nSubordinates: ");

        for (Employee employee : subordinates) {
            employee.displayEmployeeInformation();

            System.out.println("\n");
        }
    }
}
