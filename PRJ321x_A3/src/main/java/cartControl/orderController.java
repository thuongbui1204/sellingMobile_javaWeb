package cartControl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Orders;
import model.Product;
import model.ProductOrder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import context.DBContext;

/**
 * Servlet implementation class orderController
 */
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email= (String)session.getAttribute("userEmail");
		Connection conn=null;
			try {
				response.getWriter().println("finish0");
				conn=DBContext.getConnection();
				String sql="select * from orders where user_mail='"+email+" ' order by order_id";
				PreparedStatement stmt=conn.prepareStatement(sql);
				ResultSet rs= stmt.executeQuery();
				ArrayList<Orders> orders= new ArrayList<>();
				while (rs.next()) {
					Orders order =new Orders();
					order.setOrderId(rs.getInt(2));
					order.setOrderdate(rs.getDate(4));
					order.setAddress(rs.getString(6));
					double orderAmount=0;
					String sql2="select * from Orders_detail WHERE order_id=?";
					PreparedStatement stmt2=conn.prepareStatement(sql2);
					stmt2.setInt(1, rs.getInt(2));
					ResultSet rs2 = stmt2.executeQuery();
					ArrayList<ProductOrder> products= new ArrayList<>();
					while(rs2.next()) {
						int ProductId =rs2.getInt(2);
						Double productAmount=rs2.getDouble(4);
						orderAmount=orderAmount+productAmount;
						int productQuantity=rs2.getInt(3);
						
						String sql3="select * from Products WHERE product_id=?";
						PreparedStatement stmt3=conn.prepareStatement(sql3);
						stmt3.setInt(1,ProductId);
						ResultSet rs3 = stmt3.executeQuery();
						if(rs3.next()) {
							String productName=rs3.getString(2);
							ProductOrder product =new ProductOrder(rs.getInt(2),ProductId,productQuantity,productAmount,productName);
							products.add(product);
						}
						
					}
					order.setLp(products);
					order.setPrice(orderAmount);
					orders.add(order);
				}
				session.setAttribute("orders", orders);
						
				request.getRequestDispatcher("/orderConfirm.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
