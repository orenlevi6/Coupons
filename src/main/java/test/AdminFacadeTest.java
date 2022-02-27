package test;

import beans.Company;
import beans.Customer;
import facades.AdminFacade;
import login.ClientType;
import login.LoginManager;

public class AdminFacadeTest {
    public static void testAdminFacade() {
        AdminFacade admin = (AdminFacade) LoginManager.getInstance().login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);

        Company company1 = new Company(1, "Oren INC", "email@oreninc.com", "OrenInc");
        Company company2 = new Company(2, "Oren LTD", "email@orenltd.com", "OrenLtd");
        Company company3 = new Company(3, "Lea INC", "lea@lea.inc", "LeaInc");

        System.out.println(admin.addCompany(company1));
        System.out.println(admin.addCompany(company2));
        System.out.println(admin.addCompany(company3));

        company1.setEmail("no-reply@oreninc.com");
        System.out.println(admin.updateCompany(company1));

        System.out.println(admin.deleteCompany(2));

        admin.getAllCompanies().forEach(System.out::println);

        System.out.println();
        System.out.println(admin.getOneCompany(1));

        Customer customer1 = new Customer(1, "Oren", "Levi", "orenlevi6@gmail.com", "orenL");
        Customer customer2 = new Customer(2, "Lea", "Sad", "leasad@gmail.com", "leaS");
        Customer customer3 = new Customer(3, "Tal", "Bechor", "talbe@gmail.com", "talB");

        System.out.println();
        System.out.println(admin.addCustomer(customer1));
        System.out.println(admin.addCustomer(customer2));
        System.out.println(admin.addCustomer(customer3));

        customer1.setEmail("orenlevi@gmail.com");
        System.out.println(admin.updateCustomer(customer1));

        System.out.println(admin.deleteCustomer(2));

        admin.getAllCustomers().forEach(System.out::println);

        System.out.println();
        System.out.println(admin.getOneCustomer(1));

    }

}
