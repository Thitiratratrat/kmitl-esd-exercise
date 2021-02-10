package kmitl.esd.exercise1.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    @Test
    void shouldDisplayUnitDescription() {
        Team teamA = new Team("A", "A");
        Team teamB = new Team("B", "B");
        Department departmentA = new Department("A");

        departmentA.addTeam(teamA);
        departmentA.addTeam(teamB);

        departmentA.displayUnitDescription();
    }

}