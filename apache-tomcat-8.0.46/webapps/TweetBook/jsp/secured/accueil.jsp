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
	<script src="${pageContext.request.contextPath}/js/accueil.js"></script>
</head>
<body>

	<jsp:useBean id="user" scope="session" class="beans.User"/>
	<jsp:useBean id="sql_list" scope="page" class="beans.Sql_list"/>
	<%---user.init(request.getRemoteUser()); --%>
	<%user.init("toto"); %>
	<%sql_list.init("prenom,nom","comptes",2); %>
	
	<div class="header">
		<a href="" class="logo"><img
			src="${pageContext.request.contextPath}/img/logo.png" /></a>
		<div class="search">
			<a href=""><i class="material-icons">search</i></a><input list="name_firstname" onclick="show_login()" onfocusout="hide_login()" placeholder="Rechercher" type="text" /><div id="list_login"><datalist id="name_firstname">${sql_list.get_list_to_datalist()}</datalist></div>
		</div>
		<a href="" class="profil"><span><p><img alt="" src="${user.getPhoto()}"/><%--=request.getRemoteUser()--%>toto</p></span></a>
	</div>
	
	<div class="content">
		<p></p>
	</div>
	
	<div class="footer"></div>
	
	<%
		
	%>
</body>
</html>