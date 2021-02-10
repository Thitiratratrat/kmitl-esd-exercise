package kmitl.esd.exercise1.singleton.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForeignCompanyTest {
    @Test
    void shouldReturnForeignTypeCompany() {
        ForeignCompany foreignCompany = new ForeignCompany();

        assertEquals(CompanyType.FOREIGN, foreignCompany.getCompanyType());
    }

    @Test
    void shouldReturnCompanyName() {
        ForeignCompany foreignCompany = new ForeignCompany();
        foreignCompany.setName("A");

        assertEquals( "Foreign Comp.A" , foreignCompany.getName());
    }

}