package examples.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class _01_Jdbc_Statement {

    // Запрос к базе хранится в String.
    public static final String SELECT_ALL = "Select * from users";

    public static void main(String[] args) {

        // 1. Создается Connection
        Connection connection = JdbcUtils.getConnection();
        // 2. Создается Statement
        Statement statement = null;
        // 3. Создается ResultSet
        ResultSet rs = null;

        try {

            // настройка уровня транзакций
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            // отключаем автокоммит.
            connection.setAutoCommit(false);

            // получаем Statement из Connection
            statement = connection.createStatement();
            // получаем ResultSet из Statement.
            rs = statement.executeQuery(SELECT_ALL);

            List<User> result = new ArrayList<>();

            // разбираем ResultSet на объекты.
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
            System.out.println("commit");
            connection.commit();
            System.out.println(result.toString());
         /*   for (User user: result) {
                user.toString();
            }*/


        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(connection);
            e.printStackTrace();
        } finally {
            // обязательно нужно закрывать все открытые объекты
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(connection);
        }

    }

}

