package cartControl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Orders;
import model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import context.DBContext;
import dao.OrdersDao;

/**
 * Servlet implementation class PayController
 */
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	Cart cart =(Cart)session.getAttribute("cart");
	String userEmail= (String) session.getAttribute("userEmail");
	String nameOrder=request.getParameter("customerName");
	String addOrder=request.getParameter("customerAdd");
	String phoneOrder=request.getParameter("customerPhone");
	String discountOrder=request.getParameter("discountCode");
	
	if(cart==null || cart.getItems().size()==0) {//Giỏ hàng trống ; 
		request.setAttribute("addingProduct","* Please add goods to your Cart !");
		request.getRequestDispatcher("/Cart.jsp").forward(request, response);
	}else {
		request.setAttribute("addingProduct","");
		Date orderDate = new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(orderDate); 
		cal.add(Calendar.DATE, 5);
		Date receiveDate = cal.getTime();
		
		Orders order = new Orders();
		order.setPrice(cart.getAmount());
		order.setStatus(1);
		order.setOrderdate(orderDate);
		order.setAddress(addOrder);
		order.setPhoneNumber(phoneOrder);
		order.setReceiveDate(receiveDate);
		order.setDiscount(discountOrder);
		if(session.getAttribute("user")!=null && !session.getAttribute("user").equals("")) {
			order.setUserMail((String) session.getAttribute("userEmail"));
		}
		OrdersDao orderDao = new OrdersDao();
		try {
			orderDao.insertOrder(order, cart);
			request.getRequestDispatcher("/ListServlet").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	}

}
