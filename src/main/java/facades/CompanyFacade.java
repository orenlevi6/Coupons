package facades;

import beans.Category;
import beans.Company;
import beans.Coupon;
import dao.CompaniesDAO;
import dao.CouponsDAO;
import db.db_manager.DBManagerCoupons;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyFacade extends ClientFacade {
    private int companyId;

    private static CompaniesDAO companiesDAO = new CompaniesDBDAO();
    private static CouponsDAO couponsDAO = new CouponsDBDAO();
    private static int company;

    public CompanyFacade(int companyID) {
        company = companyID;
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
        System.out.println("Coupon has been added");
        return couponsDAO.addCoupon(coupon);
    }

    public boolean updateCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getId());
        values.put(2, coupon.getCompanyId());
        if (couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_ID_AND_COMPANY_ID, values)) {
            System.out.println("Coupon has been updated");
            return couponsDAO.updateCoupon(coupon);
        }
        System.out.println("Coupon ID doesn't match the records");
        return false;
    }

    public boolean deleteCoupon(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        if (couponsDAO.isExists(DBManagerCoupons.FIND_COUPON_BY_ID, values)) {
            System.out.println("Coupon has been deleted");
            return couponsDAO.deleteCoupon(id);
        }
        System.out.println("Coupon ID not found");
        return false;
    }

    public List<Coupon> getAllCoupons(String sql, Map<Integer, Object> value) {
        return couponsDAO.getAllCoupons(sql, value);
    }

    public List<Coupon> getCompanyCoupons() {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_COUPON_BY_COMPANY_ID, values);
    }

    public List<Coupon> getCompanyCouponsByCategory(int categoryId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1,company);
        values.put(2,categoryId);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_COUPONS_BY_COMPANY_ID_AND_CATEGORY_ID,values);
    }

    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company);
        values.put(2, 0);
        values.put(3, maxPrice);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_PRICE_RANGE, values);
    }

    public Company getCompanyDetails() {
        return companiesDAO.getOneCompany(company);
    }

}
