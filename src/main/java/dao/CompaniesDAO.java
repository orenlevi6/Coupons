package dao;

import beans.Company;

import java.util.List;
import java.util.Map;

public interface CompaniesDAO {

    boolean isCompanyExists(String email, String password);

    boolean isExists(String sql, Company company);

    boolean addCompany(Company company);

    boolean updateCompany(Company company);

    boolean deleteCompany(int companyID);

    List<Company> getAllCompanies(String sql, Map<Integer, Object> value);

    Company getOneCompany(int companyID);

}
