<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.nagarro.models.User"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Product Search</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<%
				if (session.getAttribute("user") == null) {
					response.sendRedirect("index.jsp");
				%>
				<jsp:forward page="index.jsp">
					<jsp:param name="tutorialname" value="jsp forward action" />
				</jsp:forward>
				<%
				}
				String fullName = "";
				User user = (User) session.getAttribute("user");
				try {
				fullName = user.getFullName();
				} catch (Exception e) {
				response.sendRedirect("index.jsp");
				}
				%>
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"><%=fullName%></span> Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<form action="ProductSearch" method="get"
			enctype="multipart/form-data">
			<input type="text" name="color" placeholder="Color" required><br />
			<input type="text" name="size" placeholder="Size" required><br />
			<input type="text" name="gender" placeholder="Gender" required>
			<br /> Output Preference 
			<select name="output">
            <option value="1">Price</option>
            <option value="2">Rating</option>
            <option value="3">Both</option>
          </select>
			<br/>
			<input type="submit" value="Search"> <br />
		</form>

		<%
		if (session.getAttribute("message") != null) {
			String message = session.getAttribute("message").toString();
		%>
		<p>
			<%=message%>
		</p>
		<%
		}
		%>
		<h3>Output:</h3>
		<%=request.getAttribute("result")%>
		
<%-- 		<c:forEach items= "$result" var="t"> --%>
<!-- 		<div class="card"> -->
<!-- 		<div class="card-body"> -->
<%-- 		<h4><c:out value="${t.id}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.name}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.color}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.gender}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.size}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.price}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.rating}"></c:out></h4> --%>
<%-- 		<h4><c:out value="${t.availability}"></c:out></h4> --%>
<!-- 		</div> -->
<!-- 		</div> -->
<%-- 		</c:forEach> --%>
		
	</div>
</body>
</html>