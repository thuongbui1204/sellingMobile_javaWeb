<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ attribute name="products" required="true" type="java.util.ArrayList" description="The product List" %>
<%@ attribute name="param1" required="false" type="java.lang.Integer" description="The first product" %>
<%@ attribute name="param2" required="false" type="java.lang.Integer" description="The last product" %>
        <c:set var="products" value="${products}"/>
	    <div class="container-fluid">
	    <div class="row">
	        <c:forEach var="row" items="${products}" varStatus="No" begin="${param1}" end="${param2}">
		        <div class="col-sm-4 p-4">
		        <a class="aDecor" href="/PRJ321x_A3/productInfor?id=${row.getId()}">
		        <div class="card p-1 mt-3">
		        <img class="py-3"style="width:95%" src="${row.getSrc()}"/>
		        <div class="card-body">
		        <h5 class="card-title">${row.getType()}</h5>
		        <p class="card-text">${row.getName()}</p>
		        <p class="btn btn-primary">${row.getPrice()}$</p>
		        </div>
		        </div>
		        </a>
		        </div>
		       
	        </c:forEach>
        </div>
        </div>