package kmitl.esd.registration;

import kmitl.esd.exercise1.singleton.business.Company;

import java.util.ArrayList;
import java.util.List;

class CompanyManager implements ICompanyManager {
    private List<Company> companyList = new ArrayList<>();

    @Override
    public List<Company> getCompanyList() {
        return companyList;
    }

    @Override
    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }
}
