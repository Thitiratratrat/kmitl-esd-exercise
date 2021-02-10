package kmitl.esd.exercise1.composite;

import org.junit.jupiter.api.Test;

class TeamTest {
    @Test
    void shouldDisplayUnitDescription() {
        Team teamA = new Team("A", "A");

        teamA.displayUnitDescription();
    }

}