package examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by apomazkin on 27.04.2017.
 */
public class _02_Jdbc_PreparedStatement {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            //ps.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
