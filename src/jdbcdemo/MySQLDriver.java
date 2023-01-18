package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDriver {
	
	public static void main (String[]args) {
		// get database Connection

		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false", "c2f", "c2fdbAdmin");
				
				// Create statements

				Statement statement = connection.createStatement();
				
				//Execute statements

				ResultSet resultset = statement.executeQuery("Select * from users");){	
			
			//Process results

			  while (resultset.next()) {
	                int id = resultset.getInt("id");
	                String name = resultset.getString("name");
	                String email = resultset.getString("email");
	                String country = resultset.getString("country");
	                String password = resultset.getString("password");
	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			  }
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		
		
	}

}
