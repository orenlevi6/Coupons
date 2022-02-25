package dbdao;

import beans.Customer;
import dao.CustomersDAO;
import db.db_manager.DBManagerCustomers;
import utils.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersDBDAO implements CustomersDAO {

    @Override
    public boolean isCustomerExists(String email, String password) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, email);
        values.put(2, password);
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCustomers.FIND_CUSTOMER_BY_EMAIL_AND_PASSWORD, values);
        try {
            assert resultSet != null;
            resultSet.next();
            return (resultSet.getInt("counter") > 0);
        } catch (SQLException err) {
            System.out.println(err.getMessage());

        }
        return false;
    }

    @Override
    public boolean isExists(String sql, Map<Integer, Object> values) {
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        try {
            assert resultSet != null;
            resultSet.next();
            return (resultSet.getInt("counter") > 0);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }
    }

    @Override
    public boolean addCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getFirstName());
        values.put(2, customer.getLastName());
        values.put(3, customer.getEmail());
        values.put(4, customer.getPassword());
        return DBTools.runQuery(DBManagerCustomers.ADD_CUSTOMER, values);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getFirstName());
        values.put(2, customer.getLastName());
        values.put(3, customer.getEmail());
        values.put(4, customer.getPassword());
        values.put(5, customer.getId());
        return DBTools.runQuery(DBManagerCustomers.UPDATE_CUSTOMER, values);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customerId);
        return DBTools.runQuery(DBManagerCustomers.DELETE_CUSTOMER, values);
    }

    //Generic
    @Override
    public List<Customer> getAllCustomers(String sql, Map<Integer, Object> values) {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        Customer customer;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return customers;
    }

    @Override
    public List<Customer> getAllCustomers() {
        Map<Integer, Object> values = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCustomers.GET_ALL_CUSTOMERS, values);
        Customer customer;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return customers;
    }

    //Generic
    public Customer getOneCustomer(int customerId) {
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCustomers.GET_CUSTOMER_BY_ID, customerId);
        Customer customer = null;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return customer;

    }

    //Second way
    public Customer getOneCustomerFromArraylist(int customerId) {
        ArrayList<Customer> allCustomers = (ArrayList<Customer>) getAllCustomers();
        for (Customer item : allCustomers) {
            if (item.getId() == customerId) {
                return item;
            }
        }
        return null;
    }

}
