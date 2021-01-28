package kmitl.esd.exercise1.model.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getFirstName() {
        Employee employee = new Employee();
        String firstName = "John";

        employee.setFirstName(firstName);
        assertEquals(firstName, employee.getFirstName());
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getSurname() {
        Employee employee = new Employee();
        String surname = "Doe";

        employee.setSurname(surname);
        assertEquals(surname, employee.getSurname());
    }

    @Test
    void setSurname() {
    }
}