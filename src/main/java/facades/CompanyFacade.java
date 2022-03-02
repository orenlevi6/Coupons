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

    public CompanyFacade() {

    }

    @Override
    public boolean login(String email, String password) {
        if (companiesDAO.isCompanyExists(email, password)) {
            this.companyId = companiesDAO.getOneCompany(email, password).getId();
            return true;
        }
        return false;
    }

    public boolean addCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.companyId);
        values.put(2, coupon.getTitle());
        if (couponsDAO.isExists(DBManagerCoupons.COUNT_COUPON_BY_COMPANY_ID_AND_TITLE, values)) {
            System.out.println("Coupon already exists");
            return false;
        }
        System.out.println("Coupon has been added");
        return couponsDAO.addCoupon(coupon);
    }

    public boolean updateCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getId());
        values.put(2, this.companyId);
        if (couponsDAO.isExists(DBManagerCoupons.COUNT_COUPON_BY_ID_AND_COMPANY_ID, values)) {
            System.out.println("Coupon has been updated");
            return couponsDAO.updateCoupon(coupon);
        }
        System.out.println("Coupon ID doesn't match the records");
        return false;
    }

    public boolean deleteCoupon(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        values.put(2, this.companyId);
        if (couponsDAO.isExists(DBManagerCoupons.COUNT_COUPON_BY_ID_AND_COMPANY_ID, values)) {
            System.out.println("Coupon has been deleted");
            return couponsDAO.deleteCoupon(id);
        }
        System.out.println("Coupon not found");
        return false;
    }

    public List<Coupon> getCompanyCoupons() {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.companyId);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_COUPON_BY_COMPANY_ID, values);
    }

    public List<Coupon> getCompanyCouponsByCategory(Category category) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.companyId);
        values.put(2, category.VALUE);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_COUPONS_BY_COMPANY_ID_AND_CATEGORY_ID, values);
    }

    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, this.companyId);
        values.put(2, 0);
        values.put(3, maxPrice);
        return couponsDAO.getAllCoupons(DBManagerCoupons.GET_PRICE_RANGE, values);
    }

    public Company getCompanyDetails() {
        return companiesDAO.getOneCompany(this.companyId);
    }

}
