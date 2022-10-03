package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

/**
 * Servlet implementation class RegisterControll
 */
public class RegisterControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControll() {
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
		try {
			
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String pwd=request.getParameter("pwd");
			
			request.setAttribute("name",name);
			request.setAttribute("email",email);
			request.setAttribute("address",address);
			request.setAttribute("phone",phone);
			request.setAttribute("pwd",pwd);
			
			Account account= new Account(email, pwd, 2,
					name, address, phone);
			
			boolean validateUsr=account.validateUsr(email);
			boolean validePass=account.validatePwd(pwd);
			
			//Kiểm tra tài khoản có hợp lệ 
			if(!validateUsr||!validePass) {
				//Tài khoản không hợp lệ 
				request.setAttribute("errorName",account.getMessageUsr());
				request.setAttribute("errorPwd", account.getMessagePwd());
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else {//Tài khoản hợp lệ, 
				//thêm tài khoản vào database  
				Connection conn;
				conn=DBContext.getConnection();
				//Kiểm tra email đã tồn tại chưa 
				String sql1="Select * from Account where user_mail=?";
				PreparedStatement stmt1=conn.prepareStatement(sql1);
				stmt1.setString(1, email);
				ResultSet rs=stmt1.executeQuery();
				if(rs.next()) {
					request.setAttribute("errorName","* Email was registered already");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}else {
				String sql="Insert into Account values (?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,email);
				stmt.setString(2, pwd);
				stmt.setInt(3, 2);
				stmt.setString(4, name);
				stmt.setString(5, address);
				stmt.setString(6, phone);
				stmt.executeUpdate();
				conn.close();
				//Chuyển về trang chủ 
				request.setAttribute("user",name);
					request.getRequestDispatcher("/login.jsp?action=loginRequire").forward(request, response);
				}
			}
			}catch(Exception ex) {
				response.getWriter().println(ex);
			}
	}

}


