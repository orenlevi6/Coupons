package exceptions;

public enum SQLTables {
    SCHEMA("database"),
    CATEGORIES("`categories` table"),
    CATEGORY_VALUE("category value"),
    COMPANIES("`companies` table"),
    CUSTOMERS("`customers` table"),
    COUPONS("`coupons` table"),
    CUSTOMERS_VS_COUPONS("`customers_vs_coupons` table");

    public final String MESSAGE;

    SQLTables(String message) {
        this.MESSAGE = message;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

}
