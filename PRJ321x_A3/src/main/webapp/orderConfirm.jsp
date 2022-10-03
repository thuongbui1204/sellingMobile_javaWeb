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
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container-fluid pt-3">
	<div class="row">
		<div class="col-md-9">
			<h4 class="text-center"> Order Confirmation</h4>
			<div class=row>
				<p class="col-3 font-weight-bold">Customer Name: <p><p class="col-9">${user}</p>
			</div>
			<div class="row">
				<p class="col-3 font-weight-bold">Customer Email: <p><p class="col-9">${userEmail}</p>
			</div>
			
				<c:forEach var="order" items="${orders}">
				<div class="bg-white p-3 mb-3">
					<div class="row">
						<p class="col-3 font-weight-bold">Order ID: <p><p class="col-9">${order.orderId}</p>
					</div>
					<div class="row">
						<p class="col-3 font-weight-bold">Order Date: <p><p class="col-9">${order.orderdate}</p>
					</div>
					<div class="row">
					<p class="col-3 font-weight-bold">Deliver Address: <p><p class="col-9">${order.address}</p>
					</div>
					<table class="table">
						<thead class="thead-light">
							<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Product Quantity</th>
							<th>Product Price</th>
							<th>Product Amount</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${order.lp}">
							<tr>
							<td>${product.productId}</td>
							<td>${product.nameProduct}</td>
							<td>${product.productQuantity}</td>
							<td>${product.amountProduct/product.productQuantity}$</td>
							<td>${product.amountProduct}$</td>
							</tr>
							</c:forEach>
						</tbody>
						<tr><td class="text-right"colspan="5"><strong>Total: </strong><fmt:formatNumber value="${order.price}" maxFractionDigits="2"/>$</td></tr>
					</table>
				</div>
				</c:forEach>
			
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>