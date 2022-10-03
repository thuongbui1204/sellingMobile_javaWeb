package Controller;

import jakarta.servlet.ServletException;
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

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 String action = request.getParameter("action");
		 HttpSession session=request.getSession();
		if(action!=null&& action.equals("login")) {
			session.setAttribute("errorName1","");
			session.setAttribute("errorPwd1", "");
			Cookie[] cookies = request.getCookies();
			if (cookies.length>=2) {
				for(Cookie cookie:cookies) {
				if(cookie.getName().equals("email")) {request.setAttribute("email",cookie.getValue());}
				if(cookie.getName().equals("password")) {request.setAttribute("pass",cookie.getValue());}
				}
			}
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session=request.getSession();
		session.setAttribute("errorName1","");
		session.setAttribute("errorPwd1", "");
		String email=request.getParameter("user");
		String pass=request.getParameter("pass");
		request.setAttribute("email", email);
		request.setAttribute("pass", pass);
		
		//Kiểm tra tài khoản trong Database 
		Connection conn;
		conn=DBContext.getConnection();
			//Kiem tra email
		String sql="Select * from Account where user_mail=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs=stmt.executeQuery();
		if (rs.next()) {
			Account account =new Account(email,rs.getString(2));
			int role=rs.getInt(3);
			String name=rs.getString(4);
			String address=rs.getString(5);
			String phone=rs.getString(6);
			//Check password
			if(!pass.equals(account.getPwd())){
				session.setAttribute("errorPwd1","* Invalid Password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				//Thiết lập lưu cookie tên đã đăng nhập 
				String remember=request.getParameter("remember");
				if(remember!=null&&remember.equals("true")) {
					Cookie cookie1 =new Cookie("email",email);
					response.addCookie(cookie1);
					Cookie cookie2 =new Cookie("password",pass);
					response.addCookie(cookie2);
				}
				if(role==2) {
					session.setAttribute("user", name);
					session.setAttribute("userEmail", email);
					session.setAttribute("address", address);
					session.setAttribute("phone", phone);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else {
					request.setAttribute("name", name);
					request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
				}
			}
			
		}else {
			session.setAttribute("errorName1","* Invalid Email");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		}catch (Exception ex) {
			response.getWriter().println(ex);
		}
			
	}
	


}
