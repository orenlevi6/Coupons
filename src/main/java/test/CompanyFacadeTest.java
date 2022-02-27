package test;

import beans.Category;
import beans.Coupon;
import facades.CompanyFacade;
import login.ClientType;
import login.LoginManager;

import java.sql.Date;
import java.time.LocalDate;

public class CompanyFacadeTest {
    public static void testCompanyFacade1() {
        CompanyFacade company = (CompanyFacade) LoginManager.getInstance().login("no-reply@oreninc.com", "OrenInc", ClientType.COMPANY);

        Coupon coupon1 = new Coupon(1, 1, 1, "Title1", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 9.90, "Image");
        Coupon coupon2 = new Coupon(2, 1, 2, "Title2", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 19.90, "Image");
        Coupon coupon3 = new Coupon(3, 1, 3, "Title3", "Desc", Date.valueOf(LocalDate.now().minusDays(8)),
                Date.valueOf(LocalDate.now().minusDays(1)), 10, 29.90, "Image");
        Coupon coupon4 = new Coupon(4, 1, 4, "Title4", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 39.90, "Image");

        System.out.println(company.addCoupon(coupon1));
        System.out.println(company.addCoupon(coupon2));
        System.out.println(company.addCoupon(coupon3));
        System.out.println(company.addCoupon(coupon4));

        coupon3.setImage("Blowfish");
        System.out.println(company.updateCoupon(coupon3));

        System.out.println(company.deleteCoupon(2));

        company.getCompanyCoupons().forEach(System.out::println);

        System.out.println();
        company.getCompanyCouponsByCategory(Category.VACATION).forEach(System.out::println);

        System.out.println();
        company.getCompanyCouponsByMaxPrice(30).forEach(System.out::println);

        System.out.println();
        System.out.println(company.getCompanyDetails());

        System.out.println();

    }

    public static void testCompanyFacade2() {
        CompanyFacade company = (CompanyFacade) LoginManager.getInstance().login("lea@lea.inc", "LeaInc", ClientType.COMPANY);

        Coupon coupon5 = new Coupon(5, 3, 1, "Title1", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 9.90, "Image");
        Coupon coupon6 = new Coupon(6, 3, 2, "Title2", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 19.90, "Image");
        Coupon coupon7 = new Coupon(7, 3, 3, "Title3", "Desc", Date.valueOf(LocalDate.now().minusDays(8)),
                Date.valueOf(LocalDate.now().minusDays(1)), 10, 29.90, "Image");
        Coupon coupon8 = new Coupon(8, 3, 4, "Title4", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 39.90, "Image");
        Coupon coupon9 = new Coupon(9, 3, 2, "Title5", "Desc", Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusDays(14)), 10, 49.90, "Image");

        System.out.println(company.addCoupon(coupon5));
        System.out.println(company.addCoupon(coupon6));
        System.out.println(company.addCoupon(coupon7));
        System.out.println(company.addCoupon(coupon8));
        System.out.println(company.addCoupon(coupon9));

        coupon7.setImage("Blowfish");
        System.out.println(company.updateCoupon(coupon7));

        System.out.println(company.deleteCoupon(3));
        System.out.println(company.deleteCoupon(8));

        company.getCompanyCoupons().forEach(System.out::println);

        System.out.println();
        company.getCompanyCouponsByCategory(Category.ELECTRICITY).forEach(System.out::println);

        System.out.println();
        company.getCompanyCouponsByMaxPrice(40).forEach(System.out::println);

        System.out.println();
        System.out.println(company.getCompanyDetails());

    }

}
