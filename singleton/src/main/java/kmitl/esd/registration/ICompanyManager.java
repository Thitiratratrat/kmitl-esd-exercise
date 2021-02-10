package kmitl.esd.registration;

import kmitl.esd.exercise1.singleton.business.Company;

import java.util.List;

public interface ICompanyManager {
    List<Company> getCompanyList();

    void setCompanyList(List<Company> companyList);
}
