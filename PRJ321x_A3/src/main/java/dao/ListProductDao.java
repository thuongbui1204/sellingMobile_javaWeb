package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.DBContext;
import model.Product;


public class ListProductDao {
	public ArrayList<Product> search(String value) throws ClassNotFoundException, SQLException{
		//Kết nối dữ 
		Connection conn=null;
		try {
			conn = DBContext.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//tách lấy giá trị cần search
		String[]values=value.split(" ");
		ArrayList<Product> productList=new ArrayList<>();
		
		//đối chiếu giá trị cần search với dữ liệu 
		for(String item: values) {
			String sql="Select * from products";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString(2).toLowerCase();
				if(name.contains(item.toLowerCase())) {
					Product product=new Product(rs.getInt(1));
					product.setName(name);
					product.setDesciption(rs.getString(3));
					product.setPrice(rs.getDouble(4));
					product.setSrc(rs.getString(5));
					product.setType(rs.getString(6));
					product.setBrand(rs.getString(7));
					boolean add=true;
					for(Product productItem: productList) {
						if(productItem.getId()==product.getId()) {
						add=false;
						break;}
					
					}
				if(add) {productList.add(product);}
				}
			}
		}
		try {
		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;	
		}
	public ArrayList<Product> getProducts() throws ClassNotFoundException, SQLException{
		//Kết nối dữ liêu 
		Connection conn=null;
		try {
			conn = DBContext.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql="Select * from products";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		ArrayList<Product> products=new ArrayList<>();
		while(rs.next()) {
			Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7));
			products.add(product);
		}
		try {
			conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return  products;
		}
	public Product getProduct(int id) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		Product product=null;
			conn=DBContext.getConnection();
			String sql="Select * from products where product_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ""+id);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
			product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}

		return product;
	}
	
	}
