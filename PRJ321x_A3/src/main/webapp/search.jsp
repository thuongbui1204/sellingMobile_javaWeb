<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>  
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
<jsp:include page="header.jsp"></jsp:include>


<div class="container-fluid">
<div class="row clearfix pb-3">
	<div class="col-md-9">
	
       <c:if test='${param.page== null}'>
	    	<t:hometable products='${session.getAttribute("products")}' param1="0" param2="5"/>
	   </c:if>
       
       <c:if test='${param.page!= null}'>
	    	<t:hometable products='${session.getAttribute("products")}' param1="${param.page*6-6}" param2="${param.page*6-1}"/>
	   </c:if>


	<ul class="pagination d-flex justify-content-center flex-wrap pagination-rounded-flat pagination-success">
					<li class="page-item">
						<a class="page-link disabled" href="#" data-abc="true"> <i class="fa fa-angle-left"></i></a>
					</li>
					<li class="page-item">
						<a class="page-link" id="page-num" href="search.jsp?page=1" data-abc="true">1</a>
					</li>
					<li class="page-item">
						<a class="page-link" id="page-num"href="search.jsp?page=2" data-abc="true">2</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link disabled" id="btn-next" data-abc="true"><i class="fa fa-angle-right"></i></a>
					</li>
				</ul>
	
		
	</div>

        <div class="col-md-3">
        </div>


    </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>