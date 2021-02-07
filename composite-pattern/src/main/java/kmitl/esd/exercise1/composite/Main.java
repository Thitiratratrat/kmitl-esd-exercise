package kmitl.esd.exercise1.composite;

public class Main {
    public static void main(String[] args) {
        CompanyOrganization shopee = new CompanyOrganization("Shopee");
        Designer designer1 = new Designer("Tom", "Cat", 20000, "Branding");
        Designer designer2 = new Designer("Jane", "Ng", 20000, "UX/UI");
        Manager designManager = new Manager("John", "Doe", 300000);

        designManager.addSubordinate(designer1);
        designManager.addSubordinate(designer2);

        Developer developer1 = new Developer("June", "May", 20000, "Backend");
        Developer developer2 = new Developer("Jim", "Cook", 20000, "Frontend");
        Manager developerManager = new Manager("Star", "Bucks", 300000);

        developerManager.addSubordinate(developer1);
        developerManager.addSubordinate(developer2);

        Department designDepartment = new Department("Design", designManager);
        Department itDepartment = new Department("IT", developerManager);

        shopee.addDepartment(designDepartment);
        shopee.addDepartment(itDepartment);

        shopee.displayEmployeeInformation();
    }
}
