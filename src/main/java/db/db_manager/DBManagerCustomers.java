package db.db_manager;

public class DBManagerCustomers {

    //Tables
    public static final String CREATE_CUSTOMERS_TABLE = "CREATE TABLE IF NOT EXISTS `coupons`.`customers` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `first_name` VARCHAR(45) NULL," +
            "  `last_name` VARCHAR(45) NULL," +
            "  `email` VARCHAR(45) NULL," +
            "  `password` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`))";
    //Create
    public static final String ADD_CUSTOMER = " INSERT INTO  `coupons`.`customers` " +
            " (`first_name`,`last_name`,`email`,`password`) "
            + " VALUES ( ?, ?, ?, ?) ";
    //Update
    public static final String UPDATE_CUSTOMER = "UPDATE `coupons`.`customers` " +
            "SET  first_name = ?, last_name = ?, email = ?, password = ? "
            + " WHERE id = ?";
    //Delete
    public static final String DELETE_CUSTOMER = " DELETE FROM `coupons`.`customers` WHERE id=? ";

    //Read all
    public static final String GET_ALL_CUSTOMERS = " SELECT * FROM  `coupons`.`customers` ";
    //Read by filter
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM `coupons`.`customers` WHERE id=?";
    public static final String GET_CUSTOMERS_BY_FIRST_NAME = " SELECT * FROM `coupons`.`customers` WHERE first_name=? ";
    public static final String GET_CUSTOMERS_BY_LAST_NAME = " SELECT * FROM `coupons`.`customers` WHERE last_name=? ";
    public static final String GET_CUSTOMERS_BY_FULL_NAME = " SELECT * FROM `coupons`.`customers` WHERE first_name=? AND last_name=? ";
    public static final String GET_ALL_CUSTOMER_BY_EMAIL = " SELECT * FROM `coupons`.`customers` WHERE email=? ";
    //Find Customer
    public static final String FIND_CUSTOMER = " SELECT count(*) AS counter FROM `coupons`.`customers` WHERE email=? AND password=? ";

}
