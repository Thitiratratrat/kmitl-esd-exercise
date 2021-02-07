package kmitl.esd.exercise1.composite;

import java.util.ArrayList;
import java.util.List;

public class CompanyOrganization implements Employable {
    private String companyName;
    private List<Department> departments = new ArrayList<>();

    public CompanyOrganization(String companyName) {
        this.companyName = companyName;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public void displayEmployeeInformation() {
        System.out.println("Company Organization of ".concat(companyName));

        for (Department department : departments) {
            department.displayEmployeeInformation();

            System.out.println("\n");
        }
    }
}
