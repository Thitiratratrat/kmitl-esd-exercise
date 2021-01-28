package kmitl.esd.exercise1.model.business;

public abstract class Company implements ICompany {
    private String taxId;
    protected long id;
    protected String name;

    public static Company create(CompanyType companyType) {
        switch (companyType) {
            case LOCAL:
                return new LocalCompany();
            case FOREIGN:
                return new ForeignCompany();
        };
        return null;
    }


    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return this.taxId;
    }
}
