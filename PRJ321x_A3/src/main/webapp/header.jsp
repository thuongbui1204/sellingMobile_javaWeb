<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://kit.fontawesome.com/05fa1eb772.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid quickInfor header">
    <div class="row clearfix">
        <div class="col-6 d-flex">
        <img class="align-self-start pt-2" id="logo" src="media/logo.png"></img>
        <div class="align-self-start pt-2 pl-3">
        	<h4>PhoneAd</h4>
        	<p>Mobine Phone and accessories</p>
        </div>
        </div>
        
        <div class="col-6 d-flex flex-column">
        <div class="float-right" >
        <a href="/PRJ321x_A3/ListServlet" class="pt-2 px-3 float-right"><i class="fa-solid fa-house"></i></a>
        <a href="#" class="pt-2 px-3 float-right"><i class="fa-solid fa-gear"></i></a>
        <a href="/PRJ321x_A3/AddtoCartController" class="pt-2 px-3 float-right"><i class="fa-solid fa-cart-arrow-down"></i></a>
        </div>
        <div class="float-right">
        <c:if test='${user!=null && user!="" }'>
        <a href="${pageContext.request.contextPath}/orderController" class="p-3 float-md-right aDecor"><button class="btn btn-outline-warning">Order tracking</button></a>
        </c:if> 
        </div>
        </div>
       
   	
   	</div>     
    

	<div class="pt-3 pb-5">
        <form class="input-group" action="/PRJ321x_A3/SearchServlet" method="post">
        	<span class="input-group-text" style="background:none; border-color:gray">Categories: </span>
          	<input class=" form-control" placeholder="What are you looking for ?" name="searchValue"type="text"/>
          	<span class="input-group-text" style="background:none; border-color:gray"><i class="fa-solid fa-magnifying-glass"></i></span>
        </form>
        
    </div>
</div>
    <nav class = "navbar p-0">
    <ul class="navbar-nav flex-row">
        <li class="nav-item px-3"><a class="nav-link" href="/PRJ321x_A3/ListServlet">Home</a></li>
       <li class="nav-item px-3"><a class="nav-link" href="#">Products</a></li>
        <li class="nav-item px-3"><a class="nav-link" href="#">About us</a></li>
    </ul>
    <ul class="navbar-nav flex-row pr-3">   
        <%-- Thay login bằng tên user --%>
        <c:if test='${user==null || user==""}'>
        <li class="nav-item px-3 float-right"><a class="nav-link login" href="/PRJ321x_A3/LoginServlet?action=login" style="float:right">Log in</a></li>
        <li class="nav-item px-3 float-right"><a class="nav-link register" href="register.jsp">Register</a></li>
        </c:if>

        <c:if test='${user!=null && user!=""}'>
        <li class="nav-item px-3 float-right"><a class="nav-link login" href="#">Welcome ${user} !</a></li>
        <li class="nav-item px-3 float-right"><a class="nav-link login" href="/PRJ321x_A3/LogoutServlet">Log out</a></li>
        </c:if>

    </ul></nav>
    
</body>
</html>