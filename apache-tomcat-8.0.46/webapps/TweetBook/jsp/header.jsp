<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TweetBook</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/header.js"></script>
</head>
<body>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:useBean id="sql_list_user" scope="page" class="beans.Sql_list_User" />
<%---user.init(request.getRemoteUser()); --%>
<%user.init("toto");%>
<%sql_list_user.init("login,prenom,nom", "comptes", 3);%>

<div class="header">
	<a href="${pageContext.request.contextPath}/jsp/secured/accueil.jsp" class="logo"><img src="${pageContext.request.contextPath}/img/logo.png" /></a>
	<div class="search">
		<a onclick="to_profil()"><i class="material-icons">search</i></a>
		<input id="input_login" list="name_firstname" onclick="show_login()" onfocusout="hide_login()" placeholder="Rechercher" type="text" />
		<div id="list_login">
			<datalist id="name_firstname">${sql_list_user.list_to_user_datalist()}</datalist>
		</div>
	</div>
	<a href="" class="profil">
		<span>
			<p>
				<img alt="" src="${user.getPhoto()}" /><%--=request.getRemoteUser()--%>toto
			</p>
		</span>
	</a>
</div>