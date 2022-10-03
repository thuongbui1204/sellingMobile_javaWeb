<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<div class="container-fluid py-3">

<form action="/PRJ321x_A3/RegisterControll" method="post" onsubmit="return validateRepeatPass()" >
<div class="row">
<div class="col-md-9">

<div class="row pb-3 pr-3">
<span class="col-4">Customer Name:</span>
<input class="col-8" name="name" type="text" value="${name}" required>
</div>

<div class="row pr-3">
<div class="col-4"></div>
<div class="col-8">
<span class="wrongdata">${errorName}</span>          
</div>

</div>                
<div class="row pb-3 pr-3">
<span class="col-4">Customer Email:</span>
<input class="col-8" name="email" type="text" value="${email}" required>
</div>

<div class="row pb-3 pr-3">
<span class="col-4">Customer Address:</span>
<input class="col-8" name="address" type="text" value="${address}" required>
</div>

<div class="row pb-3 pr-3">
<span class="col-4">Phone number:</span>
<input class="col-8" name="phone" type="text" value="${phone}" required>
</div>

<div class="row pr-3">
<div class="col-4"></div>
<div class="col-8">
<span class="wrongdata">${errorPwd}</span>           
</div>
</div>

<div class="row pb-3 pr-3">
<span class="col-4">Password:</span>
<input class="col-8 pwd" name="pwd" type="password" required>
</div>

<div class="row pr-3">
<div class="col-4"></div>
<div class="col-8">
<span class="confirm1 wrongdata ">* Repeat password wrongly !</span>          
</div>
</div>


<div class="row pb-3 pr-3">
<span class="col-4">Retype Password:</span>
<input class="col-8 repeatpwd" name="rePwd" type="password" required>
</div>

</div>

<div>
<div class="col-md-3">
</div>
</div>
</div>

<button class="btn btn-warning mx-auto d-block" type="submit">Submit</button>
</form>


</div>


<c:import url="footer.jsp"></c:import>
<script>
function validateRepeatPass(){
	const pwd=document.querySelector(".pwd").value;
	const rePwd=document.querySelector(".repeatpwd").value
	if(pwd !== rePwd){
        document.querySelector(".confirm1").style.display = 'block'; 
        return false;
    }else{return true;}
	return false;
}
</script>
</body>
</html>