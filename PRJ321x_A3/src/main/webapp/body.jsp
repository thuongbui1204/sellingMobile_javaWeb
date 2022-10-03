<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid bg-white border border-left-0 border-right-0 border-top-0">
<div class="row clearfix pb-3">
	<div class="col-md-2 d-flex flex-column px-0">
	    <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Iphone</a>
	    <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Samsung</a>
        <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Oppo</a>
        <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Vivo</a>
        <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Motorola</a>
        <a href="#" class="p-3 aDecor leftbar border border-left-0 border-right-0 border-top-0">Other</a>
    </div>
	
	<div class="col-md-10 px-0">
	
		<div>
		<t:hometable products='${productsList}' param1="${homePage*6-6}" param2="${homePage*6-1}"/>       
		</div>
	
		<ul class="pagination d-flex justify-content-center flex-wrap pagination-rounded-flat pagination-success mt-4">
					<li class="page-item">
						<a class="page-link disabled" href="#" data-abc="true"> <i class="fa fa-angle-left"></i></a>
					</li>
					<li class="page-item">
						<a class="page-link" id="page-num" href="/PRJ321x_A3/ListServlet?page=1" data-abc="true">1</a>
					</li>
					<li class="page-item">
						<a class="page-link" id="page-num"href="/PRJ321x_A3/ListServlet?page=2" data-abc="true">2</a>
					</li>
					<li class="page-item">
						<a href="#" class="page-link disabled" id="btn-next" data-abc="true"><i class="fa fa-angle-right"></i></a>
					</li>
				</ul>
		
		
	</div>

    </div>
    </div>
</body>
</html>