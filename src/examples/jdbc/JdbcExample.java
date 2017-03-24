package examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcExample {
    public static final String SELECT_ALL = "Select * from users";

    public static void main(String[] args) {

        Connection connection = JdbcUtils.getConnection();
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
            result.toString();


        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(connection);
            e.printStackTrace();
        } finally {
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(connection);
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
