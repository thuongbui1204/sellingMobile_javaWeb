<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
</head>
<body>
<div class="row">

<div class="col-md-3 leftcolumn">
            <div class="clearfix d-flex my-3">
                <img id="logo" src="${pageContext.request.contextPath}/media/logo.png"/>
                <p class="greeting mt-4"> Welcome ! 
                <%-- Chèn tên admin  --%>
        		<% if(request.getAttribute("name")!=null){%> <strong id="adminName"><%=request.getAttribute("name")%></strong><%}%>
        		</p>
            </div>

            <div class="d-flex flex-column">
                <a href="#"><span class="material-symbols-outlined">dashboard</span><span>Dashboard</span></a>
                <a href="#"><span class="material-symbols-outlined">group</span><span>Staff Manager</span></a>
            </div>


</div>
<div class="col-md-9 mb-4">
            <div class="header clearfix container-fluid">
            <div class="row">
                
                <div class="col-md-7 py-3 d-flex align-items-md-start">
	                <a href="/PRJ321x_A3/LogoutServlet" class="logout align-self-md-start">
	                    <span class="material-symbols-outlined">logout</span><span>Log out</span>
	                </a>
	                <div class="align-self-md-end float-right">
	                    <h2>Administration homepage</h2>    
	                    <p>Enjoy fantastic teamworking environment</p> 
	                </div>
                
                </div>
                <img class="float-md-right col-md-5 rounded py-3" style="width:100%" src="${pageContext.request.contextPath}/media/index.jpg"/>
                
            </div>     
            </div> 

            <div class="container-fluid content pt-5">
            <div class="row">
            <div class="col-md-9">
                <p>Members of the team</p>
                <div>
                <table>
                	<tr>
                		<th>ID</th>
                		<th>Name</th>
                		<th>Student ID</th>
                		<th>Class</th>
                	</tr>
                	<tr>
                		<td>1</td>
                		<td>Member 1</td>
                		<td>Member Code 1</td>
                		<td>Class 1</td>
                	</tr>
                	<tr>
                		<td>2</td>
                		<td>Member 2</td>
                		<td>Member Code 2</td>
                		<td>Class 2</td>
                	</tr>
                </table>
                </div>
             </div>
             <div class="col-md-3"></div>   
            </div>
            </div>

</div>


</div>
</body>
</html>
