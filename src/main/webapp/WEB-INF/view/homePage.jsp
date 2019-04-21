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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/script/app.js"></script>	

</head>
<body class="container">
	
	<label for="login" class="login_text">Welcome to home page</label>
	<div class="login_container">
		<c:if test="${userName != null}">
			<label>User Name: ${userName}</label>
		</c:if>
		<c:if test="${msg != null}">
			<label>${msg}</label>
		</c:if>
		<div class="button_padding">
			<button type="button" class="btn btn-default" onclick="javascript:callUserController()">User Role Controller</button>
		</div>
		<div class="button_padding">
			<button type="button" class="btn btn-default" onclick="javascript:callAdminController()">Admin Role Controller</button>
		</div>
		<div class="button_padding">
			<button type="button" class="btn btn-default" onclick="javascript:callUserService()">User Role Service</button>
		</div>
		<div class="button_padding">
			<button type="button" class="btn btn-default" onclick="javascript:callAdminService()">Admin Role Service</button>
		</div>
		<form action="<%=contextPath%>/logout" method="post">
			<button type="submit" class="btn btn-default">Log Out</button>
		</form>
	</div>
	
</body>
</html>