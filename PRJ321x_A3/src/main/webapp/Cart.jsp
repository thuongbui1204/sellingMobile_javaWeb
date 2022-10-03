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
<div class="container-fluid py-4">
<table class="table table-bordered">
<thead style="background-color:#29afb3">
	<tr>
	<th>Products in cart: ${cart.getItems().size()}</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Amount</th>
	<th>Delete</th>
	</tr>
</thead>
<tbody class="bg-white">
	
	<c:forEach var="product" items="${cart.getItems()}">
	<tr>
	<td><p>${product.name}</p>
	    <p>ID: ${product.id}</p></td>
	<td><fmt:formatNumber type="number" value="${product.price}"></fmt:formatNumber>$</td>
	<td>${product.number}</td>
	<td><fmt:formatNumber type="number" value="${product.price*product.number}"></fmt:formatNumber>$</td>
	<td> <a href="/PRJ321x_A3/AddtoCartController?action=remove&id=${product.id}"><button class="btn btn-danger"> Delete </button></a></td>
	</tr>
	</c:forEach>
</tbody>	

	<tr class="bg-light"><td class="text-right" colspan="4">Total: <fmt:formatNumber type="number" value="${cart.getAmount()}" maxFractionDigits="2"></fmt:formatNumber>$</td></tr>

</table>

<form action="/PRJ321x_A3/PayController" onsubmit="return loginRecommend()" method="post" >
<div class="row">
<div class="col-md-9">
<div class="row pb-3 pr-3">
<span class="col-4">Customer Name:</span>
<input class="col-8" name="customerName" type="text" value="${user}" required>
</div>
<div class="row pb-3 pr-3">
<span class="col-4">Customer Address:</span>
<input class="col-8" name="customerAdd" type="text" value="${address}" required>
</div>
<div class="row pb-3 pr-3">
<span class="col-4">Phone number:</span>
<input class="col-8" name="customerPhone" type="text" value="${phone}" required>
</div>
<div class="row pb-3 pr-3">
<span class="col-4">Discount code(if any):</span>
<input class="col-8" name="discountCode" type="text">
</div>
</div>

<div>
<div class="col-md-3"></div>
</div>

</div>
<button class="btn btn-warning mx-auto d-block" type="submit">Submit</button>
</form>
<p class="confirm1 pt-3"> Please login to tracking and follow your order history. Or <a href="#" id="process">click here</a> to order without
login!<p>
<p class="text-danger pt-3">${addingProduct}<p>
</div>

<c:import url="footer.jsp"></c:import>
<script>
function loginRecommend(){
	if(document.querySelector(".confirm1").innerHTML== "No login required, please re-submit !"){
		return true;
	}else{
		if(document.querySelector(".login").innerHTML=="Log in"){
		document.querySelector(".confirm1").style.display = 'block';
		return false;
		}
		return true;
	}
}
document.querySelector('#process').addEventListener('click',function(){
    document.querySelector(".confirm1").innerHTML = 'No login required, please re-submit !';
    document.querySelector(".confirm1").style.color="green";
})
</script>
</body>

</html>