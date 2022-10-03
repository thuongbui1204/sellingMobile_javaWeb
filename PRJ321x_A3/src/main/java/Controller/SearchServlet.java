package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.DBContext;
import dao.ListProductDao;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String value=request.getParameter("searchValue");
		
		
		ArrayList<Product> products =new ArrayList<>();
		try {
			ListProductDao list= new ListProductDao();
			products=list.search(value);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("products", products);
		session.setAttribute("searchValue",value);
		request.getRequestDispatcher("/search.jsp").forward(request, response);
		
		
		/*
		Connection conn=null;
		try {
			conn = DBContext.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//tách lấy giá trị cần 
		String[]values=value.split(" ");
		ArrayList<Product> productList=new ArrayList<>();
		
		//đối chiếu giá trị cần search với dữ liệu 
		for(String item: values) {
			String sql="Select * from products";
			PreparedStatement stmt=null;
			try {
				stmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs=null;
			try {
				rs = stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rs.next()) {
				
					String name=rs.getString(2);
					response.getWriter().println(name);
					response.getWriter().println(name.toLowerCase().contains(item.toLowerCase()));
					if(name.contains(item)) {
						Product product=new Product(rs.getInt(1));
						product.setName(name);
						product.setDesciption(rs.getString(3));
						product.setPrice(rs.getDouble(4));
						product.setSrc(rs.getString(5));
						product.setType(rs.getString(6));
						product.setBrand(rs.getString(7));
						boolean add=true;
					for(Product productItem: productList) {
						response.getWriter().println(productItem.getId()==product.getId());
						if(productItem.getId()==product.getId()) {
						add=false;
						break;
					}
					if(add) {productList.add(product);}
					}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		*/
		
		
		
		
		
		
		
		
	}

}
