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
import java.util.List;
import java.util.Map;

public class CustomerFacade extends ClientFacade {
    private int customerID;

    private static CouponsDAO couponsDAO = new CouponsDBDAO();
    private static CustomersDAO customersDAO = new CustomersDBDAO();

    public CustomerFacade() {

    }

    @Override
    public boolean login(String email, String password) {
        if (customersDAO.isCustomerExists(email, password)) {
            this.customerID = customersDAO.getOneCustomer(email, password).getId();
            return true;
        }
        return false;
    }

    public boolean purchaseCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.customerID);
        values.put(2, coupon.getId());
        if (customersDAO.isExists(DBManagerCustomers.COUNT_COUPON_PURCHASE, values)) {
            System.out.println("Customer already has this coupon");
            return false;
        }
        values.clear();
        values.put(1, coupon.getId());
        if (!couponsDAO.isExists(DBManagerCoupons.COUNT_COUPON_BY_ID, values)) {
            System.out.println("Coupon ID not found");
            return false;
        }
        if (!couponsDAO.isExists(DBManagerCoupons.COUNT_COUPON_AMOUNT_BY_ID, values)) {
            System.out.println("This coupon is no longer available");
            return false;
        }
        if (couponsDAO.isExists(DBManagerCoupons.CHECK_COUPON_EXPIRATION_BY_ID, values)) {
            System.out.println("Coupon has expired");
            return false;
        }
        if (!couponsDAO.addCouponPurchase(this.customerID, coupon.getId())) {
            System.out.println("Coupon purchase went wrong");
            return false;
        }
        return couponsDAO.updateCouponAmount(coupon.getId());
    }

    public List<Coupon> getCustomerCoupons() {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.customerID);
        return couponsDAO.getAllCoupons(DBManagerCustomers.FIND_CUSTOMER_COUPONS, values);
    }

    public List<Coupon> getCustomerCouponsByCategory(int categoryId) { //TODO
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.customerID);
        values.put(2, categoryId);
        return couponsDAO.getAllCoupons(DBManagerCustomers.FIND_CUSTOMER_COUPONS_BY_CATEGORY, values);
    }

    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.customerID);
        values.put(2, maxPrice);
        return couponsDAO.getAllCoupons(DBManagerCustomers.FIND_CUSTOMER_COUPONS_BY_MAX_PRICE, values);
    }

    public Customer getOneCustomer() {
        return customersDAO.getOneCustomer(this.customerID);
    }

}
