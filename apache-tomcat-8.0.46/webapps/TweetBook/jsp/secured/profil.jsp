

<%@ include file="../header.jsp"%>

<jsp:useBean id="user_search" scope="page" class="beans.User" />

<%
	user_search.init(request.getParameter("login_search"));
%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="content">
	<p></p>
	${user_search.afficheVisiteur()}
	<c:if test="${!user.verifier_amitie(user_search)}">
		<form action="${pageContext.request.contextPath}/servlet/insert_amis">
			<input type="hidden" value="${user_search.getLogin()}" name="hidden"/>
			<input type="submit" value="Ajouter comme Amis !!!"/>
		</form>
	</c:if>
</div>

<%@ include file="../footer.jsp"%>
