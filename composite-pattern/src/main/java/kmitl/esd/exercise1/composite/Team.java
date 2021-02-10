package kmitl.esd.exercise1.composite;

import java.util.logging.Logger;

public class Team implements BusinessUnit {
    private static Logger logger = Logger.getLogger("composite.Team");
    private String name;
    private String managerName;

    public Team(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    @Override
    public void displayUnitDescription() {
        logger.info("Team Description: " + name + " with Manager: " + managerName);
    }
}
