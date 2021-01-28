package kmitl.esd.exercise1.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void displayEmployeeInformation() {
        Manager manager = new Manager("John", "Doe", 100);
        Department department = new Department("Engineering", manager);

        department.displayEmployeeInformation();
    }
}