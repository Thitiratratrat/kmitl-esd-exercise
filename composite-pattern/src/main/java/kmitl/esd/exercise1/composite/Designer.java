package kmitl.esd.exercise1.composite;

public class Designer extends Employee {
    private String specialization;
    private static final String POSITION = "Designer";


    public Designer(String firstName, String surname, int salary,
                    String specialization) {
        super(firstName, surname, POSITION, salary);

        this.specialization = specialization;
    }

    public void design() {
        System.out.println("I can design with a specialization in ".concat(specialization));
    }

    @Override
    public void displayEmployeeInformation() {
        super.displayEmployeeInformation();

        System.out.println("Specialization: ".concat(specialization));
    }
}
