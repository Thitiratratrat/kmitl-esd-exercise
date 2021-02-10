import kmitl.esd.exercise1.composite.Department;
import kmitl.esd.exercise1.composite.Team;

public class Main {

    public static void main(String[] args) {
        Department technicalDepartment = new Department("Technical");
        Department humanResourcesDepartment = new Department("Human Resources");

        Team developerTeam = new Team("Developer", "Eren");
        Team systemTeam = new Team("System", "Armin");
        Team recruitingTeam = new Team("Recruiting", "Jean");
        Team internManagementTeam = new Team("Intern Management", "Connie");

        technicalDepartment.addTeam(developerTeam);
        technicalDepartment.addTeam(systemTeam);
        humanResourcesDepartment.addTeam(recruitingTeam);
        humanResourcesDepartment.addTeam(internManagementTeam);

        technicalDepartment.displayUnitDescription();
        humanResourcesDepartment.displayUnitDescription();
    }
}
