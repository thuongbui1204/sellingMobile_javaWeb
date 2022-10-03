package cartControl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import context.DBContext;
import dao.ListProductDao;

/**
 * Servlet implementation class AddtoCartController
 */
public class AddtoCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id= request.getParameter("id");
		String action= request.getParameter("action");
		String user= (String)session.getAttribute("user");
		int idInt;
		Cart cart= null;
		Product product=null;
		ListProductDao list = new ListProductDao();
		
		if(session.getAttribute("cart")==null) {
			cart=new Cart();
			session.setAttribute("cart", cart);
		}else {
			cart=(Cart)session.getAttribute("cart");
		}
		
		if(id!=null) {
		try {
			idInt=Integer.parseInt(id);
			product= list.getProduct(idInt);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		if(action!=null && action.equals("add")) {
			cart.add(product);
		}
		if(action!=null && action.equals("remove")) {
			cart.remove(Integer.parseInt(id));
		}
		session.setAttribute("cart",cart);
		
		request.getRequestDispatcher("/Cart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
