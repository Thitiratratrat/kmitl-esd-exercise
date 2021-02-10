package kmitl.esd.exercise1.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Department implements BusinessUnit {
    private static Logger logger = Logger.getLogger(Department.class.getName());
    private String name;
    private List<BusinessUnit> teams = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addTeam(BusinessUnit team) {
        teams.add(team);
    }

    @Override
    public void displayUnitDescription() {
        logger.info("Department name: " + name + " With Teams: ");

        teams.forEach(team -> team.displayUnitDescription());
    }
}
