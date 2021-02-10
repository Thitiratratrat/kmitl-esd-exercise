package kmitl.esd.simple;

import kmitl.esd.exercise1.singleton.business.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyManager {
    private static CompanyManager companyManager;
    private List<Company> companyList = new ArrayList<>();

    private CompanyManager() {
    }

    public static CompanyManager getInstance() {
        if (companyManager != null) {
            return companyManager;
        }

        companyManager = new CompanyManager();

        return companyManager;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }


}
