package utils;

import db.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTools {
    /**
     * runQuery method - returns boolean to know if client succeeded or not, used to create tables
     */
    public static boolean runQuery(String sql) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

}
 