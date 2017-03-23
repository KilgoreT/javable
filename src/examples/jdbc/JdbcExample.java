package examples.jdbc;

import java.sql.*;

/**
 * Created by apomazkin on 23.03.2017.
 */
public class JdbcExample {
    public static final String SELECT_ALL = "Select * from users";

    private static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\examples\\jdbc\\test.db");
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

    public static void main(String[] args) {

        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                System.out.print(rs.getInt("id"));
                System.out.print(" - " + rs.getString("name"));
                System.out.println(" - " + rs.getInt("age"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
