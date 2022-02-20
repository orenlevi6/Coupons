package facades;

import beans.Coupon;
import db.db_manager.DBManagerCoupons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyFacade extends ClientFacade {
    private int companyID;

    public CompanyFacade(int companyID) {
        this.companyID = companyID;
    }

    @Override
    public boolean login(String email, String password) {
        return super.login(email, password);
    }

    public boolean addCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getCompanyId());
        values.put(2, coupon.getTitle());
        if (couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_COMPANY_ID_AND_TITLE, values)) {
            System.out.println("Coupon already exists");
            return false;
        }
        return couponsDAO.addCoupon(coupon);
    }

    public boolean updateCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getId());
        if (couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_ID, values)) {
            return couponsDAO.updateCoupon(coupon);
        }
        System.out.println("Coupon ID not found");
        return false;
    }

    public boolean deleteCoupon(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        if (couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_ID, values)) {
            return couponsDAO.deleteCoupon(id);
        }
        System.out.println("Coupon ID not found");
        return false;
    }

    public List<Coupon> getAllCoupons(String sql, Map<Integer, Object> value) {
        return couponsDAO.getAllCoupons(sql, value);
    }

    public List<Coupon> getAllCoupons() {
        return couponsDAO.getAllCoupons();
    }

}
