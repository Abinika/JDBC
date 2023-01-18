package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateRecord {

    private static final String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
    	UpdateRecord update = new UpdateRecord();
        update.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false", "c2f", "c2fdbAdmin");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2, 1);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }

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
