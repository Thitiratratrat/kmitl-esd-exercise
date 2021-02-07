package kmitl.esd.exercise1.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyOrganizationTest {
    private static CompanyOrganization companyOrganization =
            new CompanyOrganization("A");

    @Test
    void addDepartment() {
        Manager manager = new Manager("John", "Doe", 100);
        Department department = new Department("Engineering", manager);

        companyOrganization.addDepartment(department);
    }

    @Test
    void displayEmployeeInformation() {
        Manager manager = new Manager("John", "Doe", 100);
        Department department = new Department("Engineering", manager);

        companyOrganization.addDepartment(department);
        companyOrganization.displayEmployeeInformation();
    }
}