package kmitl.esd;

import kmitl.esd.exercise1.singleton.business.Company;
import kmitl.esd.exercise1.singleton.business.CompanyType;
import kmitl.esd.registration.CompanyManagerRegistry;
import kmitl.esd.registration.ICompanyManager;
import kmitl.esd.simple.CompanyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RegistrationMain {
    private static Logger logger = Logger.getLogger(RegistrationMain.class.getName());

    public static void main(String[] args) {
        CompanyManagerRegistry companyManagerRegistry = new CompanyManagerRegistry();

        companyManagerRegistry.register(CompanyManagerRegistry.getInstance().createCompanyManager());

        ICompanyManager companyManager = companyManagerRegistry.getCompanyManager();
        List<Company> companyList = new ArrayList<>();
        Company localCompany = Company.create(CompanyType.LOCAL);
        Company foreignCompany = Company.create(CompanyType.FOREIGN);

        localCompany.setName("A");
        foreignCompany.setName("B");
        companyList.add(localCompany);
        companyList.add(foreignCompany);

        companyManager.setCompanyList(companyList);
        companyList = companyManager.getCompanyList();

        companyList.forEach(company -> logger.info(company.getName()));
    }
}
