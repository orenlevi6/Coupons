package facades;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import dbdao.CustomersDBDAO;

public abstract class ClientTFacade {
    protected static CompaniesDAO companiesDAO = new CompaniesDBDAO();
    protected static CustomersDAO customersDAO = new CustomersDBDAO();
    protected static CouponsDAO couponsDAO = new CouponsDBDAO();

    public boolean login(String email, String password) {
        return false;
    }
}
