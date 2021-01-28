package kmitl.esd.exercise1.singleton.business;

public class ForeignCompany extends Company{
    public CompanyType getCompanyType() {
        return CompanyType.FOREIGN;
    }

    public String getName() {
        return "Foreign Comp." + name;
    }
}