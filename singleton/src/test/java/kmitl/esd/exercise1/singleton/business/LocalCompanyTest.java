package kmitl.esd.exercise1.singleton.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalCompanyTest {
    @Test
    void shouldReturnLocalTypeCompany() {
        LocalCompany localCompany = new LocalCompany();

        assertEquals(CompanyType.LOCAL, localCompany.getCompanyType());
    }

    @Test
    void shouldReturnCompanyName() {
        LocalCompany localCompany = new LocalCompany();
        localCompany.setName("A");

        assertEquals( "Local Comp.A" , localCompany.getName());
    }

}