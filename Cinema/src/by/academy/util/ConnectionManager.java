package by.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private final static String URL = "db.url";

    private final static String USERNAME = "db.username";

    private final static String PASSWORD = "db.password";

    static {
        loadDriver();
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertyUtil.get(URL),
                    PropertyUtil.get(USERNAME),
                    PropertyUtil.get(PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionManager() {
    }
}
