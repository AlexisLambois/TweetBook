<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TweetBook</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/accueil.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>

	<jsp:useBean id="user" scope="session" class="beans.User"/>
	<%---user.init(request.getRemoteUser()); --%>
	<%user.init("toto"); %>
	
	<div class="header">
		<a href="" class="logo"><img
			src="${pageContext.request.contextPath}/img/logo.png" /></a>
		<div class="search">
			<a href=""><i class="material-icons">search</i></a><input
				placeholder="Rechercher" type="text" />
		</div>
		<a href="" class="profil"><span><p><img alt="" src="${user.getPhoto()}"/><%--=request.getRemoteUser()--%>toto</p></span></a>
	</div>
	
	<div class="content">
		<p>${user.getPassword()}</p>
	</div>
	
	<div class="footer"></div>
	
</body>
</html>