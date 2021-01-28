package kmitl.esd.exercise1.singleton.business;

public class CompanyManager {
    private static CompanyManager companyManager;

    private CompanyManager() {
    }

    public static CompanyManager getInstance() {
        if (companyManager != null) {
            return companyManager;
        }

        companyManager = new CompanyManager();

        return companyManager;
    }
}
