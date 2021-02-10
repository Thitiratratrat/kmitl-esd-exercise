package kmitl.esd.registration;

public class CompanyManagerRegistry {
    private static CompanyManagerRegistry instance = null;
    private ICompanyManager companyManager = null;

    public static CompanyManagerRegistry getInstance() {
        if (instance == null) {
            synchronized (CompanyManagerRegistry.class) {
                if (instance == null) {
                    instance = new CompanyManagerRegistry();
                }
            }
        }

        return instance;

    }

    public Boolean register(ICompanyManager companyManager) {
        if (companyManager != null && this.companyManager == null) {
            this.companyManager = companyManager;

            return true;
        }

        return false;
    }

    public Boolean unregister() {
        if (companyManager != null) {
            companyManager = null;

            return true;
        }

        return false;
    }

    public ICompanyManager getCompanyManager() {
        return companyManager;
    }

    public ICompanyManager createCompanyManager() {
        CompanyManager newCompanyManager = new CompanyManager();

        if (register(newCompanyManager)) {
            unregister();

            return newCompanyManager;
        }

        return companyManager;
    }
}
