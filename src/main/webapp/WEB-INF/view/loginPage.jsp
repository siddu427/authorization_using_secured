<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	String contextPath = (String) request.getContextPath();

%>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=contextPath%>/style/application.css"
	rel="stylesheet">	

</head>
<body class="container">
	<label for="login" class="login_text">Enter you credentials</label>
	<div class="login_container">
		<form action="<%=contextPath%>/login" method="post">
			<c:if test="${loginFailed == true}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${logoutSuccess == true}">
				<div class="alert alert-info">
					<p>You have successfully logged out.</p>
				</div>
			</c:if>
			<div class="form-group">
				<label for="userLabel">User name</label> 
				<input type="text" class="form-control" id="userName" name="userName" placeholder="User name">
			</div>
			<div class="form-group">
				<label for="passwordLabel">Password</label> 
				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default">Log In</button>
		</form>
	</div>
	
</body>
</html>