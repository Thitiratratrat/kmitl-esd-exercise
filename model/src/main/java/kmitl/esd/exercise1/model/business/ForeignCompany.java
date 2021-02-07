package kmitl.esd.exercise1.model.business;

public class ForeignCompany extends Company {
    public CompanyType getCompanyType() {
        return CompanyType.FOREIGN;
    }

    public String getName() {
        return "Foreign Comp." + name;
    }
}
