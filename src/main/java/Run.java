import dao.CompaniesDAO;
import dao.CouponsDAO;
import dao.CustomersDAO;
import dbdao.CouponsDBDAO;
import dbdao.CompaniesDBDAO;
import dbdao.CustomersDBDAO;

public class Run {

    //Single line comment

    /*
    Multi line comment
     */

    //   Javadoc Example -

    /**
     * Run Class -
     * The run Class is used in order to instantiate
     * the Program of coupons
     */

    public static void main(String[] args) {
//        DB Check
//        CREATE_DB check = true
//        System.out.println(DBTools.runQuery(DBManager.CREATE_DB));
//        DROP_DB check = true
//        System.out.println(DBTools.runQuery(DBManager.DROP_DB));

//        Create Tables Check
//        CREATE_CATEGORIES_TABLE check = true
//        System.out.println(DBTools.runQuery(DBManagerCategories.CREATE_CATEGORIES_TABLE));
//        CREATE_COMPANIES_TABLE check = true
//        System.out.println(DBTools.runQuery(DBManagerCompanies.CREATE_COMPANIES_TABLE));
//        CREATE_CUSTOMERS_TABLE check = true
//        System.out.println(DBTools.runQuery(DBManagerCustomers.CREATE_CUSTOMERS_TABLE));
//        CREATE_COUPONS_TABLE check = true
//        System.out.println(DBTools.runQuery(DBManagerCoupon.CREATE_COUPONS_TABLE));
//        CREATE_CUSTOMERS_VS_COUPONS_TABLE check = true
//        System.out.println(DBTools.runQuery(DBManagerCustomersVsCoupons.CREATE_CUSTOMERS_VS_COUPONS_TABLE));

//        Table checks
//        Category Table
//        ADD_CATEGORY check = true
//        Map<Integer, Object> categoryValues = new HashMap<>();
//        categoryValues.put(1, Category.FOOD.toString());
//        categoryValues.put(1,Category.ELECTRICITY.toString());
//        categoryValues.put(1,Category.RESTAURANT.toString());
//        categoryValues.put(1,Category.VACATION.toString());
//        System.out.println(DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, categoryValues));

//        Customer Table
//        ADD_CUSTOMER check = true
        CustomersDAO customers = new CustomersDBDAO();
//        customers.addCustomer(new Customer("Oren", "Levi", "orenlevi6@gmail.com", "12345678"));
//        UPDATE_CUSTOMER check = true (Requires customer `id`)
//        System.out.println(customers.updateCustomer(new Customer(1,"Oren","Levi","orenlevi6@gmail.com", "12345678")));
//        DELETE_CUSTOMER check = true
//        System.out.println(customers.deleteCustomer(1));
//        GET_ALL_CUSTOMERS check = true
//        Map<Integer, Object> values = new HashMap<>();
//        customers.getAllCustomers(DBManagerCustomers.GET_ALL_CUSTOMERS,values).forEach(System.out::println);
//        GET_ALL_CUSTOMERS check #2 = true
//        customers.getAllCustomers().forEach(System.out::println);
//        GET_ONE_CUSTOMER check = true
//        System.out.println(customers.getOneCustomer(3));

//        Companies Table
        CompaniesDAO companies = new CompaniesDBDAO();
//        ADD_COMPANY check = true
//        System.out.println(companies.addCompany(new Company(1,"Oren LLC", "oren@llc.co.il","12345678")));
//        UPDATE_COMPANY check = true
//        System.out.println(companies.updateCompany(new Company(2,"Lea INC", "lea@leainc.co.il","1234567")));
//        DELETE_COMPANY check = true
//        System.out.println(companies.deleteCompany(1));
//        GET_ALL_COMPANIES check = true
//        Map<Integer,Object> values = new HashMap<>();
//        companies.getAllCompanies(DBManagerCompanies.GET_ALL_COMPANIES,values).forEach(System.out::println);
//        GET_ALL_COMPANIES #2 check //TODO
//        companies.getAllCompanies();
//        GET_ONE_COMPANY check = true
//        System.out.println(companies.getOneCompany(2));
//        IS_COMPANY_EXISTS check = true
//        System.out.println(companies.isCompanyExists("oren@oren.com", "oren"));

//        Coupons Table
        CouponsDAO couponsDAO = new CouponsDBDAO();
//        ADD_COUPON check = true;
//        System.out.println(couponDAO.addCoupon(new Coupon(2, 3, 2,"BLAbla",
//                "blabla", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(12)),
//                10,49.99,"image")));
//        UPDATE_COUPON check = true;
//        System.out.println(couponDAO.updateCoupon(new Coupon(2, 3, 2,"some title",
//                "something", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(12)),
//                10,49.99,"image")));
//        DELETE_COUPON check = true
//        couponDAO.deleteCoupon(3);
//        GET_ALL_COUPONS check = //TODO
//        Map<Integer,Object> values = new HashMap<>();
//        couponDAO.getAllCoupons(DBManagerCoupon.GET_ALL_COUPONS, values).forEach(System.out::println);

    }

}
