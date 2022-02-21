package facades;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import db.db_manager.DBManagerCompanies;
import db.db_manager.DBManagerCustomers;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import dbdao.CustomersDBDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminFacade extends ClientFacade {
    private static CompaniesDAO companiesDAO = new CompaniesDBDAO();
    private static CustomersDAO customersDAO = new CustomersDBDAO();

    public AdminFacade() {
    }

    @Override
    public boolean login(String email, String password) {
        return super.login("admin@admin.com", "admin");
    }

    public boolean addCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        if (companiesDAO.isExists(DBManagerCompanies.FIND_COMPANY_BY_NAME_OR_EMAIL, values)) {
            System.out.println("Company already exists");
            return false;
        }
        return companiesDAO.addCompany(company);
    }

    public boolean updateCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getId());
        if (customersDAO.isExists(DBManagerCompanies.FIND_COMPANY_BY_ID, values)) {
            return companiesDAO.updateCompany(company);
        }
        System.out.println("Company ID not found");
        return false;
    }

    public boolean deleteCompany(int companyID) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, companyID);
        if (customersDAO.isExists(DBManagerCompanies.FIND_COMPANY_BY_ID, values)) {
            return companiesDAO.deleteCompany(companyID);
        }
        System.out.println("Company ID not found");
        return false;
    }

    public List<Company> getAllCompanies(String sql, Map<Integer, Object> value) {
        return companiesDAO.getAllCompanies(sql, value);
    }

    public List<Company> getAllCompanies() {
        return companiesDAO.getAllCompanies();
    }

    public Company getOneCompany(int companyID) {
        return companiesDAO.getOneCompany(companyID);
    }


    public boolean addCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getEmail());
        if (customersDAO.isExists(DBManagerCustomers.FIND_CUSTOMER_BY_EMAIL, values)) {
            System.out.println("Customer already exists");
            return false;
        }
        return customersDAO.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getId());
        if (customersDAO.isExists(DBManagerCustomers.FIND_CUSTOMER_BY_ID, values)) {
            return customersDAO.updateCustomer(customer);
        }
        System.out.println("Customer ID not found");
        return false;
    }

    public boolean deleteCustomer(int customerId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customerId);
        if (customersDAO.isExists(DBManagerCustomers.FIND_CUSTOMER_BY_ID, values)) {
            return customersDAO.deleteCustomer(customerId);
        }
        System.out.println("Customer ID not found");
        return false;
    }

    public List<Customer> getAllCustomers(String sql, Map<Integer, Object> values) {
        return customersDAO.getAllCustomers(sql, values);
    }

    public List<Customer> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    public Customer getOneCustomer(int customerId) {
        return customersDAO.getOneCustomer(customerId);
    }

}
