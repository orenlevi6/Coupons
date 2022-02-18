package dao;

import beans.Customer;

import java.util.List;
import java.util.Map;

public interface CustomersDAO {

    boolean isCustomerExists(String email, String password);

    boolean addCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int customerId);

    List<Customer> getAllCustomers(String sql, Map<Integer, Object> values);

    Customer getOneCustomer(int customerId);

}
