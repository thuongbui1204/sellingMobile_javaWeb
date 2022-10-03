<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>

<div class="container-fluid bg-white border border-left-0 border-right-0">

	<div class="row border border-left-0 border-right-0 mx-4 py-3" >
	<h5>${product.name}</h5>
	</div>

	<div class="row clearfix py-3">
	
	<div class="col-sm-4 py-3">
	<img src="${product.src}" style="width:90%" class="mx-auto d-block"></img>
	</div>
	
	<div class="col-sm-6 py-3">
	<h4 class="text-danger"><fmt:formatNumber type="number" maxFractionDigits = "3" value="${product.price*23000}"/> VND</h4>
	<p>${product.description}</p>
	<a href="/PRJ321x_A3/AddtoCartController?id=${product.id}&action=add "><button class="btn btn-warning">Add to cart</button></a>
	</div>
	
    </div>


</div>

<c:import url="footer.jsp"></c:import>

</body>
</html>