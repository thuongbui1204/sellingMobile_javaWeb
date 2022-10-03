<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css"></link>
</head>
<body>
	<div class="login row">
		<div class="leftcolumn">
        <div class="fakeimg"><img src="media/icon_login.png"></img></div>
        <div>
        <% String action=request.getParameter("action");
        if(action!=null && action.equals("loginRequire")){%>
        <p class="loginRequire">Successfully register. Please login to continue! </p>
        <%} %>
        </div> 
        <div class="card1">
            <form action="/PRJ321x_A3/LoginServlet" method="post" name="loginForm">
            <%-- Thông tin usr  --%>
                <h4>User
                <%--Dòng hiển thị thông báo nhập sai --%>
                <%if(session.getAttribute("errorName1")!=null){%>
                <span class="wrongdata"><%=session.getAttribute("errorName1")%></span>
                <%} %>
                </h4>
                <input type="text" placeholder="Enter Username" name="user" 
                <%if(request.getAttribute("email")!=null){%> value="<%=request.getAttribute("email")%>"<%}%>/>
           <%-- Thông tin password   --%>     
                <h4>Password
                <%--Dòng hiển thị thông báo nhập sai --%>
                <%if(session.getAttribute("errorPwd1")!=null){%>
                <span class="wrongdata"><%=session.getAttribute("errorPwd1")%></span>
                <%}%>
                </h4>
                <input type="password" placeholder="Enter Password" name="pass" <%if(request.getAttribute("pass")!=null){%> value="<%=request.getAttribute("pass")%>"<%}%>/>
         
                <button id="submit" type="submit">Login</button>
          <%-- Thông tin remember   --%>     
                <label class="container">Remmember me
                    <input type="checkbox" value="true" name="remember"/>
                    <span class="checkmark"></span>
                </label>
        

            </form>
            <div><a href="register.jsp"><button id="register">Register ?</button></a></div>
        </div>   
        <div class="card2 row">
            <button id="cancel" style ="float:left">Cancel</button>
            <p style="float:right"> <a href="#">Forgot password ?</a></p>
        </div> 
   	 	</div>
    	<div class="rightcolumn">
            <div id="welcome">
            <h4>Welcome Back!</h4>
            <p>To keep connected with us please login with your personal infor</p>
            </div>
        </div>
    </div>
    
</body>
</html>