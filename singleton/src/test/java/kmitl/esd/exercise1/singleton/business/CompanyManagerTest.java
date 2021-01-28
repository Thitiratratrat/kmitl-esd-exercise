package kmitl.esd.exercise1.singleton.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyManagerTest {

    @Test
    void getInstance() {
        CompanyManager companyManager = CompanyManager.getInstance();
        CompanyManager companyManager2 = CompanyManager.getInstance();

        assertEquals(companyManager, companyManager2);
    }
}