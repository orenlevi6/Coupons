package dao;

import beans.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponsDAO {

    boolean addCoupon(Coupon coupon);

    boolean updateCoupon(Coupon coupon);

    boolean deleteCoupon(int id);

    List<Coupon> getAllCoupons(String sql, Map<Integer, Object> value);

    List<Coupon> getAllCoupons();

    Coupon getOneCoupon(int couponId);

    boolean addCouponPurchase(int customerId, int couponId);

    boolean updateCouponAmount(int couponId);

    boolean deleteCouponPurchase(int customerId, int couponId);

}
