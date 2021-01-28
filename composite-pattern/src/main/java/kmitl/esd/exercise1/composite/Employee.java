package kmitl.esd.exercise1.composite;

public abstract class Employee implements Employable {
    protected String firstName;
    protected String surname;
    protected String position;
    protected int salary;

    public Employee(String firstName, String surname, String position,
                    int salary) {
        this.firstName = firstName;
        this.surname = surname;
        this.position =  position;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void displayEmployeeInformation() {
        System.out.println("First Name: ".concat(firstName)
                .concat("\nSurname: ").concat(surname).concat("\nPosition: ")
                .concat(position).concat("\nSalary: ")
                .concat(String.valueOf(salary)));
    }
}