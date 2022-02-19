package facades;

import beans.Company;
import beans.Customer;

import java.util.List;
import java.util.Map;

public class AdminFacade extends ClientTFacade {

    public AdminFacade() {
    }

    @Override
    public boolean login(String email, String password) {
        return super.login("admin@admin.com", "admin");
    }

    public static boolean addCompany(Company company) {
        return companiesDAO.addCompany(company);
    }

    public static boolean updateCompany(Company company) {
        return companiesDAO.updateCompany(company);
    }

    public static boolean deleteCompany(int companyID) {
        return companiesDAO.deleteCompany(companyID);
    }

    public static List<Company> getAllCompanies(String sql, Map<Integer, Object> value) {
        return companiesDAO.getAllCompanies(sql, value);
    }

    public static Company getOneCompany(int companyID) {
        return companiesDAO.getOneCompany(companyID);
    }

    public static boolean addCustomer(Customer customer) {
        return customersDAO.addCustomer(customer);
    }

    public static boolean updateCustomer(Customer customer) {
        return customersDAO.updateCustomer(customer);
    }

    public static boolean deleteCustomer(int customerId) {
        return customersDAO.deleteCustomer(customerId);
    }

    public static List<Customer> getAllCustomers(String sql, Map<Integer, Object> values) {
        return customersDAO.getAllCustomers(sql, values);
    }

    public static Customer getOneCustomer(int customerId) {
        return customersDAO.getOneCustomer(customerId);
    }

}
