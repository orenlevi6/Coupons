package dbdao;

import utils.DBTools;
import beans.Company;
import dao.CompaniesDAO;
import db.db_manager.DBManagerCompanies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class companiesDBDAO implements CompaniesDAO {

    @Override
    public boolean isCompanyExists(String email, String password) {
        return false;
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
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        values.put(3, company.getPassword());
        values.put(4, company.getId());
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
        //TODO : Null pointer exception problem if no companies exist
        List<Company> companies = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, value);
        try {
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
    public Company getOneCompany(int companyID) { //TODO : Null pointer exception problem if id doesn't exist
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCompanies.GET_A_COMPANY, companyID);
        Company company = null;
        try {
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

}
