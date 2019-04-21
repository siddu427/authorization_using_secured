<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0">
<%
	String contextPath = (String) request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/style/logoutPopup.css" />
</head>
<body>
	<div id="welcome" class="overlay">
	    <div class="popup">
	    	<div class="content">
	    		<span class="welcome_text">Your session is about to expire</span>
	    	</div>
	    	<progress id="logoutProgress" value="0" max="60" class="progress_bar"></progress>
	        <button type="submit" class="btn btn-default extend_button" onclick="javascript:extendSession();">Extend Session</button>
	        <button type="submit" class="btn btn-default logout_button" onclick="javascript:logOut();">Log Out</button>
	    </div>
	</div>
</body>
</html>