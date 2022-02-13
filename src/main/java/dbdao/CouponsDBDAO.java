package dbdao;

import utils.DBTools;
import beans.Coupon;
import dao.CouponDAO;
import db.db_manager.DBManagerCoupon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsDBDAO implements CouponDAO {
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
        return DBTools.runQuery(DBManagerCoupon.CREATE_NEW_COUPON, values);
    }

    @Override
    public boolean updateCoupon(Coupon coupon) {
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
        values.put(10, coupon.getId());
        return DBTools.runQuery(DBManagerCoupon.UPDATE_COUPON, values);
    }

    @Override
    public boolean deleteCoupon(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        return DBTools.runQuery(DBManagerCoupon.DELETE_COUPON, values);
    }

    @Override
    public List<Coupon> getAllCoupons(String sql, Map<Integer, Object> value) {
        List<Coupon> coupons = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, value);
        try {
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
                        resultSet.getInt("price"),
                        resultSet.getString("image")
                );
                coupons.add(coupon);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return coupons;
    }

    // you also can get coupon id by getAllCoupon method
    // TODO:: Turn this method to a generic method that return one coupon of any sql script,
    //  currently it's like project request
    @Override
    public Coupon getOneCoupon(int couponId) {
        ResultSet resultSet = DBTools.runQueryForResult(DBManagerCoupon.GET_COUPON_BY_ID, couponId);
        Coupon coupon = null;
        try {
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
                        resultSet.getInt("price"),
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
        return false;
    }

    @Override
    public boolean deleteCouponPurchase(int customerId, int couponId) {
        return false;
    }

}
