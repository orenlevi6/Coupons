package facades;

import beans.Coupon;
import beans.Customer;
import dao.CouponsDAO;
import dao.CustomersDAO;
import db.db_manager.DBManagerCoupons;
import db.db_manager.DBManagerCustomers;
import dbdao.CouponsDBDAO;
import dbdao.CustomersDBDAO;

import java.util.HashMap;
import java.util.Map;

public class CustomerFacade extends ClientFacade {
    private int customerId;

    private static CouponsDAO couponsDAO = new CouponsDBDAO();
    private static CustomersDAO customersDAO = new CustomersDBDAO();
    private static int customer;

    public CustomerFacade(int customerID) {
        customer = customerID;
    }

    @Override
    public boolean login(String email, String password) {
        return super.login(email, password);
    }

    public boolean purchaseCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getId());
        if (!couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_ID, values)) {
            System.out.println("Coupon ID not found");
            return false;
        }
        values.clear();
        values.put(1, customer);
        values.put(2, coupon.getId());
        if (customersDAO.isExists(DBManagerCustomers.FIND_COUPON_PURCHASE, values)) {
            System.out.println("Customer already has this coupon");
            return false;
        }
        values.clear();
        values.put(1, coupon.getId());
        if (!couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_AMOUNT_BY_ID, values)) {
            System.out.println("This coupon is no longer available");
            return false;
        }
        if (!couponsDAO.isExists(DBManagerCoupons.CHECK_COUPON_EXPIRATION_BY_ID, values)) {
            System.out.println("Coupon has expired");
            return false;
        }
        if (!couponsDAO.addCouponPurchase(customer, coupon.getId())) {
            System.out.println("Coupon purchase went wrong");
            return false;
        }
        return couponsDAO.updateCouponAmount(coupon.getId());
    }

    public Customer getOneCustomer() {
        return customersDAO.getOneCustomer(customer);
    }
}
