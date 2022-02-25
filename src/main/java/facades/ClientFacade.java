package facades;

import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;

public abstract class ClientFacade {
    protected CompaniesDAO companiesDAO;
    protected CustomersDAO customersDAO;
    protected CouponsDAO couponsDAO;

    public boolean login(String email, String password) {
        return false;
    }

}
