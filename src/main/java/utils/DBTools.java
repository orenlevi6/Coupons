package utils;

import db.ConnectionPool;

import java.sql.*;
import java.util.Map;

public class DBTools {
    /**
     * runQuery method return boolean to know if client succeeded or not, used to create tables
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

    // Tal - Method Overloading
    public static boolean runQuery(String sql, Map<Integer, Object> parameters) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            parameters.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }
            });
            preparedStatement.execute();
            return true;

        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());
            return false;

        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    public static ResultSet runQueryForResult(String sql, Map<Integer, Object> parameters) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            parameters.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    } else if (value instanceof Enum) {
                        preparedStatement.setString(key, String.valueOf(value));
                    }

                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }
            });
            return preparedStatement.executeQuery();

        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());
            return null;
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }

    }

    public static ResultSet runQueryForResult(String sql, int id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeQuery();

        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());
            return null;
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

}
