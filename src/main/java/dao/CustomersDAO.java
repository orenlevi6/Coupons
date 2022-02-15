package dao;

import beans.Customer;

import java.util.List;

public interface CustomersDAO {

    boolean isCustomerExists(String email, String password);

    boolean addCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int customerId);

    List<Customer> getAllCustomers();

    Customer getOneCustomer(int customerId);

}
