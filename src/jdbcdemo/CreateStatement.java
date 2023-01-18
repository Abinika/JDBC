package jdbcdemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
		// TODO Auto-generated method stub


		    private static final String createTableSQL = "create table Users1(\r\n" + "  id  int(3) primary key,\r\n" +
		        "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
		        "  password varchar(20)\r\n" + "  );";

		    public static void main(String[] argv) throws SQLException {
		        CreateStatement createTable = new CreateStatement();
		        createTable.createTable();
		    }

		    public void createTable() throws SQLException {

		        System.out.println(createTableSQL);
		        // Step 1: Establishing a Connection
		        try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false", "c2f", "c2fdbAdmin");

		            // Step 2:Create a statement using connection object
		            Statement statement = connection.createStatement();) {

		            // Step 3: Execute the query or update query
		            statement.execute(createTableSQL);
		        } catch (SQLException e) {

		            // print SQL exception information
		            printSQLException(e);
		        }

		        // Step 4: try-with-resource statement will auto close the connection.
		    }
// Exception occurs then this method will be called
		    
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
	


