package test;

import beans.Category;
import db.db_manager.*;
import utils.DBTools;

import java.util.HashMap;
import java.util.Map;

public class SchemaTest {
    public static void createSchema() {
        System.out.println(DBTools.runQuery(DBManager.CREATE_DB));
        createCategoriesTable();
        System.out.println(DBTools.runQuery(DBManagerCompanies.CREATE_COMPANIES_TABLE));
        System.out.println(DBTools.runQuery(DBManagerCustomers.CREATE_CUSTOMERS_TABLE));
        System.out.println(DBTools.runQuery(DBManagerCoupons.CREATE_COUPONS_TABLE));
        System.out.println(DBTools.runQuery(DBManagerCustomersVsCoupons.CREATE_CUSTOMERS_VS_COUPONS_TABLE));

    }

    public static void createCategoriesTable() {
        DBTools.runQuery(DBManagerCategories.CREATE_CATEGORIES_TABLE);

        Map<Integer, Object> values = new HashMap<>();
        values.put(1, Category.FOOD.toString());
        System.out.println(DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values));
        values.clear();

        values.put(1, Category.ELECTRICITY.toString());
        System.out.println(DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values));
        values.clear();

        values.put(1, Category.RESTAURANT.toString());
        System.out.println(DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values));
        values.clear();

        values.put(1, Category.VACATION.toString());
        System.out.println(DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values));

    }

}
