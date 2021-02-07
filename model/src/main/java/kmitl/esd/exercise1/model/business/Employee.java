package kmitl.esd.exercise1.model.business;

/**
 * Encapsulation example: package privacy
 */
public class Employee {

    protected String firstName;
    protected String surname;

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
}
