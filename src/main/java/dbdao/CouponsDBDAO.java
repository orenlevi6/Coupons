package dbdao;

import beans.Coupon;
import dao.CouponsDAO;
import db.db_manager.DBManagerCoupons;
import utils.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsDBDAO implements CouponsDAO {
    @Override
    public boolean isExists(String sql, Map<Integer, Object> values) {
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        try {
            assert resultSet != null;
            resultSet.next();
            return (resultSet.getInt("counter") > 0);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return false;
        }

    }

    @Override
    public boolean addCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getCompanyId());
        values.put(2, coupon.getCategory().VALUE);
        values.put(3, coupon.getTitle());
        values.put(4, coupon.getDescription());
        values.put(5, coupon.getStartDate());
        values.put(6, coupon.getEndDate());
        values.put(7, coupon.getAmount());
        values.put(8, coupon.getPrice());
        values.put(9, coupon.getImage());
        return DBTools.runQuery(DBManagerCoupons.ADD_COUPON, values);
    }

    @Override
    public boolean updateCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getCategory().VALUE);
        values.put(2, coupon.getTitle());
        values.put(3, coupon.getDescription());
        values.put(4, coupon.getStartDate());
        values.put(5, coupon.getEndDate());
        values.put(6, coupon.getAmount());
        values.put(7, coupon.getPrice());
        values.put(8, coupon.getImage());
        values.put(9, coupon.getId());
        return DBTools.runQuery(DBManagerCoupons.UPDATE_COUPON, values);
    }

    @Override
    public boolean deleteCoupon(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        return DBTools.runQuery(DBManagerCoupons.DELETE_COUPON, values);
    }

    @Override
    public List<Coupon> getAllCoupons(String sql, Map<Integer, Object> value) {
        List<Coupon> Coupons = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, value);
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                Coupon coupon = new Coupon(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getInt("category_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("amount"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image")
                );
                Coupons.add(coupon);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return Coupons;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        Map<Integer, Object> values = new HashMap<>();
        List<Coupon> coupons = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCoupons.GET_ALL_COUPONS, values);
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                Coupon coupon = new Coupon(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getInt("category_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("amount"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image")
                );
                coupons.add(coupon);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int couponId) {
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCoupons.GET_COUPON_BY_ID, couponId);
        Coupon coupon = null;
        try {
            assert resultSet != null;
            if (resultSet.next()) {
                coupon = new Coupon(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getInt("category_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("amount"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image")
                );

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
        return coupon;

    }

    @Override
    public boolean addCouponPurchase(int customerId, int couponId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customerId);
        values.put(2, couponId);
        return DBTools.runQuery(DBManagerCoupons.ADD_COUPON_PURCHASE, values);
    }

    @Override
    public boolean updateCouponAmount(int couponId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, couponId);
        return DBTools.runQuery(DBManagerCoupons.UPDATE_COUPON_TABLE_AMOUNT, values);
    }

    @Override
    public boolean deleteCouponPurchase(int customerId, int couponId) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customerId);
        values.put(2, couponId);
        return DBTools.runQuery(DBManagerCoupons.DELETE_COUPON_PURCHASE, values);
    }

}
