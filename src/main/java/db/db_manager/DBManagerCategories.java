package db.db_manager;

public class DBManagerCategories {

    //Tables
    public static final String CREATE_CATEGORIES_TABLE = "CREATE TABLE IF NOT EXISTS `coupons`.`categories` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`))";

    //Create
    public static final String ADD_CATEGORY = "INSERT INTO `coupons`.`categories` (`name`) VALUES ( ?);";
    //Update
    public static final String UPDATE_CATEGORY = " UPDATE `coupons`.`categories` SET name=? WHERE id=? ";
    //Delete
    public static final String DELETE_CATEGORY = " DELETE FROM `coupons`.`categories` WHERE id=? ";
    //Read all
    public static final String GET_ALL_CATEGORIES = " SELECT * FROM `coupons`.`categories` ";
    //Read by filter
    public static final String GET_CATEGORY_BY_ID = " SELECT * FROM  `coupons`.`categories` WHERE id=? ";

}
