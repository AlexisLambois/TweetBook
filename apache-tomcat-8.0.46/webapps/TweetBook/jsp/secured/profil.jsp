<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TweetBook</title>
</head>
<body>
	
	<%@ include file="../header.jsp" %>
	
	<jsp:useBean id="user_search" scope="page" class="beans.User" />
	<%
		user.init(request.getParameter("login_search"));
		if( user_search.getLogin().equals(user.getLogin()) ){
			user_search.afficheTotal();
		}else{
			user_search.afficheVisiteur();
		}
	%>
	
	<%@ include file="../footer.jsp" %>

</body>
</html>