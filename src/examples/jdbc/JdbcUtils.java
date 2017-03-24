package examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by apomazkin on 24.03.2017.
 */
public class JdbcUtils {
    public static final String SELECT_ALL = "Select * from users";

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\examples\\jdbc\\testdb.db");
            return c;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if (c != null) {
            return c;
        } else {
            System.out.println("Not found.");
            return null;
        }
    }

    public static void rollbackQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                //NOP
            }
        }
    }

    public static void closeQuietly(Connection connection) {
    }
}
