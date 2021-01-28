package kmitl.esd.exercise1.composite;

public class Department implements Employable {
    private String name;
    private Manager manager;

    public Department(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    @Override
    public void displayEmployeeInformation() {
        System.out.println("Department: ".concat(name));
        System.out.println("Manager:");

        manager.displayEmployeeInformation();
    }
}
