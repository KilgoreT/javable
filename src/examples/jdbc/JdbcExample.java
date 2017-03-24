package examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apomazkin on 23.03.2017.
 */
public class JdbcExample {
    public static final String SELECT_ALL = "Select * from users";

    private static Connection getConnection() {
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

    public static void main(String[] args) {

        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_ALL);

            List<User> result = new ArrayList<>();
            while (rs.next()) {

                int id = rs.getInt("id");
                String login = rs.getString("name");
                int age = rs.getInt("age");

                User user = new User(id);
                user.setLogin(login);
                user.setAge(age);

                result.add(user);

                /*System.out.print(id);
                System.out.print(" - " + login);
                System.out.println(" - " + age);*/
            }
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

class User {
    int id;
    String login;
    int age;

    public User(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
