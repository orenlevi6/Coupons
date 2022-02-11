package db.db_manager;

public class DBManagerCompanies {

    //Table
    public static final String CREATE_COMPANIES_TABLE = "CREATE TABLE IF NOT EXISTS `coupons`.`companies` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NULL," +
            "  `email` VARCHAR(45) NULL," +
            "  `password` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`))";

}
