package kmitl.esd.exercise1.singleton.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    @Test
    void shouldCreateCorrectCompanyType() {
        Company foreignCompany = Company.create(CompanyType.FOREIGN);
        Company localCompany = Company.create(CompanyType.LOCAL);

        assertEquals(CompanyType.FOREIGN, foreignCompany.getCompanyType());
        assertEquals(CompanyType.LOCAL, localCompany.getCompanyType());
    }
}