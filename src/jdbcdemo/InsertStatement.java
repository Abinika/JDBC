package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertStatement{
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
        "  (id, name, email, country, password) VALUES " +
        " (?, ?, ?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        InsertStatement createTable = new InsertStatement();
        createTable.insertRecord();
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false", "c2f", "c2fdbAdmin");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Madhu");
            preparedStatement.setString(3, "madhu@gmail.com");
            preparedStatement.setString(4, "India");
            preparedStatement.setString(5, "Abi");

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
