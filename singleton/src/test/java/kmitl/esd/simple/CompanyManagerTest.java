package kmitl.esd.simple;

import kmitl.esd.exercise1.singleton.business.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyManagerTest {
    @Test
    void shouldReturnSameInstanceOfCompanyManager() {
        CompanyManager companyManager = CompanyManager.getInstance();
        CompanyManager companyManager2 = CompanyManager.getInstance();

        assertEquals(companyManager, companyManager2);
    }

}