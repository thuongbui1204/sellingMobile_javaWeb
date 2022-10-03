package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ShoppingDB";
		String user="root";
		String pass="";
		Connection conn=DriverManager.getConnection(url,user,pass);
		return conn;
}

}
