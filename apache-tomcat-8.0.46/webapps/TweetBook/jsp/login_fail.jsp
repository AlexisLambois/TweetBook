<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TweetBook</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
	<div class="content">
		<h1>Erreur Identifiants !!!!</h1>
		<button type="button" onclick="redirec()">Comme Back !!!</button>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		function redirec(){
			window.location.href = "/TweetBook/jsp/secured/accueil.jsp";
		}
	</script>