package test;

import beans.Category;
import db.db_manager.*;
import exceptions.SQLTables;
import exceptions.TableNotCreatedException;
import utils.DBTools;

import java.util.HashMap;
import java.util.Map;

public class SchemaTest {
    public static void createSchema() throws TableNotCreatedException {
        if (!DBTools.runQuery(DBManager.CREATE_DB)) {
            throw new TableNotCreatedException(SQLTables.SCHEMA);
        }
        createCategoriesTable();
        if (!DBTools.runQuery(DBManagerCompanies.CREATE_COMPANIES_TABLE)) {
            throw new TableNotCreatedException(SQLTables.COMPANIES);
        }
        if (!DBTools.runQuery(DBManagerCustomers.CREATE_CUSTOMERS_TABLE)) {
            throw new TableNotCreatedException(SQLTables.CUSTOMERS);
        }
        if (!DBTools.runQuery(DBManagerCoupons.CREATE_COUPONS_TABLE)) {
            throw new TableNotCreatedException(SQLTables.COUPONS);
        }
        if (!DBTools.runQuery(DBManagerCustomersVsCoupons.CREATE_CUSTOMERS_VS_COUPONS_TABLE)) {
            throw new TableNotCreatedException(SQLTables.CUSTOMERS_VS_COUPONS);
        }
    }

    public static void createCategoriesTable() throws TableNotCreatedException {
        if (!DBTools.runQuery(DBManagerCategories.CREATE_CATEGORIES_TABLE)) {
            throw new TableNotCreatedException(SQLTables.CATEGORIES);
        }

        Map<Integer, Object> values = new HashMap<>();
        values.put(1, Category.FOOD.toString());

        if (!DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values)) {
            throw new TableNotCreatedException(SQLTables.CATEGORY_VALUE);
        }
        values.clear();
        values.put(1, Category.ELECTRICITY.toString());

        if (!DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values)) {
            throw new TableNotCreatedException(SQLTables.CATEGORY_VALUE);
        }

        values.clear();
        values.put(1, Category.RESTAURANT.toString());

        if (!DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values)) {
            throw new TableNotCreatedException(SQLTables.CATEGORY_VALUE);
        }

        values.put(1, Category.VACATION.toString());
        if (!DBTools.runQuery(DBManagerCategories.ADD_CATEGORY, values)) {
            throw new TableNotCreatedException(SQLTables.CATEGORY_VALUE);
        }
    }

}
