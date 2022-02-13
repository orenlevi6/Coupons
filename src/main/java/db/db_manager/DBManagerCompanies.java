package db.db_manager;

public class DBManagerCompanies {

    //Tables
    public static final String CREATE_COMPANIES_TABLE = "CREATE TABLE IF NOT EXISTS `coupons`.`companies` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NULL," +
            "  `email` VARCHAR(45) NULL," +
            "  `password` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`))";

    public static final String ADD_COMPANY = " INSERT INTO `coupons`.`companies` " +
            " (`name`,`email`,`password` ) " +
            " VALUES (?,?,?) ";

    public static final String UPDATE_COMPANY = " UPDATE `coupons`.`companies` " +
            " SET name=?,email=?,password=? " + " WHERE id=? ";

    public static final String DELETE_COMPANY = " DELETE FROM `coupons`.`companies` WHERE id=? ";

    public static final String GET_ALL_COMPANIES = " SELECT * FROM `coupons`.`companies` ";

    public static final String GET_A_COMPANY = " SELECT * FROM `coupons`.`companies` WHERE id=? ";

}
