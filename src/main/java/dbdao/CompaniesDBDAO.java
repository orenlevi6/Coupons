package dbdao;

import beans.Company;
import dao.CompaniesDAO;
import db.db_manager.DBManagerCompanies;
import utils.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompaniesDBDAO implements CompaniesDAO {

    @Override
    public boolean isCompanyExists(String email, String password) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, email);
        values.put(2, password);
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCompanies.FIND_COMPANY_BY_EMAIL_AND_PASSWORD, values);
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
    public boolean isExists(String sql, Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
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
    public boolean addCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        values.put(3, company.getPassword());
        return DBTools.runQuery(DBManagerCompanies.ADD_COMPANY, values);
    }

    @Override
    public boolean updateCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getEmail());
        values.put(2, company.getPassword());
        values.put(3, company.getId());
        return DBTools.runQuery(DBManagerCompanies.UPDATE_COMPANY, values);
    }

    @Override
    public boolean deleteCompany(int companyID) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, companyID);
        return DBTools.runQuery(DBManagerCompanies.DELETE_COMPANY, values);
    }

    @Override
    public List<Company> getAllCompanies(String sql, Map<Integer, Object> value) {
        List<Company> companies = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, value);
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
                companies.add(company);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return companies;
    }

    @Override
    public List<Company> getAllCompanies() {
        Map<Integer, Object> values = new HashMap<>();
        List<Company> companies = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCompanies.GET_ALL_COMPANIES, values);
        Company company;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
                companies.add(company);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyID) {
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCompanies.GET_COMPANY_BY_ID, companyID);
        Company company = null;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return company;
    }

    @Override
    public Company getOneCompany(String email, String password) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, email);
        values.put(2, password);
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCompanies.GET_COMPANY_BY_EMAIL_AND_PASSWORD, values);
        Company company = null;
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return company;
    }

//    REDUNDANT
//     public Company getOneCompanyFromArraylist(int companyId) {
//        ArrayList<Company> allCompanies = (ArrayList<Company>) getAllCompanies();
//        for (Company item : allCompanies) {
//            if (item.getId() == companyId) {
//                return item;
//            }
//        }
//        return null;
//    }

}
