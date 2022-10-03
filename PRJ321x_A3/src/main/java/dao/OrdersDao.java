package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao {
	public void insertOrder(Orders o, Cart c) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		conn=DBContext.getConnection();
		
		String sql="Insert into Orders (user_mail, order_status,order_date,order_discount_code,order_address) VALUES (?,?,CURDATE(),?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, o.getUserMail());
		stmt.setInt(2, o.getStatus());
		stmt.setString(3, o.getDiscount());
		stmt.setString(4, o.getAddress());
		stmt.executeUpdate();
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		if(generatedKeys.next()) {
			int orderId=generatedKeys.getInt(1);
			o.setOrderId(orderId);
			ArrayList<Product> products =c.getItems();
			for(Product product: products) {
			String sql2="Insert into Orders_detail values (?,?,?,?,?)";
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.setInt(1, orderId);
			stmt2.setInt(2, product.getId());
			stmt2.setInt(3, product.getNumber());
			stmt2.setDouble(4, product.getNumber()*product.getPrice());
			stmt2.setDouble(5,product.getPrice());
			stmt2.executeUpdate();
			}
			
		}
		conn.close();
	}

}
