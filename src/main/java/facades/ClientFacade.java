package facades;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import dbdao.CustomersDBDAO;

public abstract class ClientFacade {
    protected CompaniesDAO companiesDAO;
    protected CustomersDAO customersDAO;
    protected CouponsDAO couponsDAO;

    public ClientFacade() {
        this.companiesDAO = new CompaniesDBDAO();
        this.customersDAO = new CustomersDBDAO();
        this.couponsDAO = new CouponsDBDAO();
    }

    public boolean login(String email, String password) {
        return false;
    }

}
