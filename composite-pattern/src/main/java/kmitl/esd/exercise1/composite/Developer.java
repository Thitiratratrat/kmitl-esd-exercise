package kmitl.esd.exercise1.composite;

public class Developer extends Employee {
    private String specialization;
    private static final String POSITION = "Developer";


    public Developer(String firstName, String surname, int salary,
                     String specialization) {
        super(firstName, surname, POSITION, salary);

        this.specialization = specialization;
    }

    public void develop() {
        System.out.println("I can develop with a specialization in "
                .concat(specialization));
    }


    @Override
    public void displayEmployeeInformation() {
        super.displayEmployeeInformation();

        System.out.println("Specialization: ".concat(specialization));
    }
}
