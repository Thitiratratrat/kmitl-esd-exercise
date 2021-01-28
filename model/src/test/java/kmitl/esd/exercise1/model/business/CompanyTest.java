package kmitl.esd.exercise1.model.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    @Test
    void create() {
        Company foreignCompany = Company.create(CompanyType.FOREIGN);

        foreignCompany.setName("A");

        Company localCompany = Company.create(CompanyType.LOCAL);

        localCompany.setName("A");

        assertTrue(foreignCompany instanceof ForeignCompany);
        assertEquals("Foreign Comp.A", foreignCompany.getName());

        assertTrue(localCompany instanceof LocalCompany);
        assertEquals("Local Comp.A", localCompany.getName());
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void testSetName() {
    }

    @Test
    void getTaxId() {
    }
}