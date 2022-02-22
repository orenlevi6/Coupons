package facades;

import beans.Coupon;
import dao.CouponsDAO;
import db.db_manager.DBManagerCustomers;
import dbdao.CouponsDBDAO;

import java.util.HashMap;
import java.util.Map;

public class CustomerFacade extends ClientFacade {
    private static CouponsDAO couponsDAO = new CouponsDBDAO();
    private static int customer;

    public CustomerFacade(int customerID) {
        customer = customerID;
    }

    @Override
    public boolean login(String email, String password) {
        return super.login(email, password);
    }

    public boolean purchaseCoupon(Coupon coupon) {
        boolean allOk;
        Map<Integer,Object> values = new HashMap<>();
        values.put(1, customer);
        values.put(2, coupon.getId());
//        if (customersDAO.isExists(DBManagerCustomers.))
        return false;
    }
}
