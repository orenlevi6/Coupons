package dao;

import beans.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponDAO {

    boolean addCoupon(Coupon coupon);

    boolean updateCoupon(Coupon coupon);

    boolean deleteCoupon(int id);

    List<Coupon> getAllCoupon(String sql, Map<Integer, Object> value);

    Coupon getOneCoupon(int couponId);

    boolean addCouponPurchase(int customerId, int couponId);

    boolean deleteCouponPurchase(int customerId, int couponId);

}
