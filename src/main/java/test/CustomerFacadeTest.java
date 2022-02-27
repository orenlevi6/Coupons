package test;

import beans.Coupon;
import facades.CustomerFacade;
import login.ClientType;
import login.LoginManager;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerFacadeTest {
    public static void testCustomerFacade() {
        CustomerFacade customer = (CustomerFacade) LoginManager.getInstance().login("orenlevi@gmail.com", "orenL", ClientType.CUSTOMER);

        Coupon coupon1 = new Coupon(1, 1, 1, "Title1", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 9.90, "Image");

        Coupon coupon2 = new Coupon(5, 3, 1, "Title1", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 9.90, "Image");

        System.out.println(customer.purchaseCoupon(coupon1));
        System.out.println(customer.purchaseCoupon(coupon1));
        System.out.println(customer.purchaseCoupon(coupon2));


        System.out.println();
        customer.getCustomerCoupons().forEach(System.out::println);

        System.out.println();
        customer.getCustomerCouponsByCategory(1).forEach(System.out::println);

        System.out.println();
        customer.getCustomerCouponsByMaxPrice(10).forEach(System.out::println);

        System.out.println();
        System.out.println(customer.getOneCustomer());

    }

}
