package kmitl.esd.registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyManagerRegistryTest {
    @Test
    void shouldGetSameInstanceOfCompanyManagerRegistry() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        CompanyManagerRegistry companyManagerRegistry2 = CompanyManagerRegistry.getInstance();

        assertEquals(companyManagerRegistry, companyManagerRegistry2);
    }

    @Test
    void shouldReturnTrueWhenFirstRegisterOfCompanyManager() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();

        assertTrue(companyManagerRegistry.register(companyManagerRegistry.createCompanyManager()));
    }

    @Test
    void shouldReturnFalseWhenRegisterOfCompanyManagerMultipleTimes() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        companyManagerRegistry.register(companyManagerRegistry.createCompanyManager());

        assertFalse(companyManagerRegistry.register(companyManagerRegistry.createCompanyManager()));
    }

    @Test
    void shouldReturnTrueWhenFirstUnregister() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        companyManagerRegistry.register(companyManagerRegistry.createCompanyManager());

        assertTrue(companyManagerRegistry.unregister());
    }

    @Test
    void shouldReturnFalseWhentUnregisterMultipleTimes() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        companyManagerRegistry.register(companyManagerRegistry.createCompanyManager());
        companyManagerRegistry.unregister();

        assertFalse(companyManagerRegistry.unregister());
    }

    @Test
    void shouldGetCompanyManager() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        companyManagerRegistry.register(companyManagerRegistry.createCompanyManager());

        assertNotNull(companyManagerRegistry.getCompanyManager());
    }

    @Test
    void shouldReturnCompanyManagerWhenCreateFirstTime() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();

        assertNotNull(companyManagerRegistry.createCompanyManager());
    }

    @Test
    void shouldReturnSameInstanceOfCompanyManagerWhenCreateMultipleTimes() {
        CompanyManagerRegistry companyManagerRegistry = CompanyManagerRegistry.getInstance();
        ICompanyManager companyManager = companyManagerRegistry.createCompanyManager();

        companyManagerRegistry.register(companyManager);
        ICompanyManager companyManager2 = companyManagerRegistry.createCompanyManager();

        assertEquals(companyManager, companyManager2);

    }

}