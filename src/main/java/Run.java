import beans.Category;
import beans.Customer;
import dao.CustomersDAO;
import db.db_manager.*;
import dbdao.customersDBDAO;
import utils.DBTools;

import java.util.HashMap;
import java.util.Map;

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
//        CREATE_CUSTOMERS_VS_COUPONS_TABLE check = true;
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
//        CustomersDAO customers = new customersDBDAO();
//        customers.addCustomer(new Customer("Oren", "Levi", "orenlevi6@gmail.com", "12345678"));
//        UPDATE_CUSTOMER check = true (Requires customer `id`)
//        System.out.println(customers.updateCustomer(new Customer(1,"Oren","Levi","orenlevi6@gmail.com", "12345678")));
//        DELETE_CUSTOMER check = true
//        System.out.println(customers.deleteCustomer(1));

    }

}
