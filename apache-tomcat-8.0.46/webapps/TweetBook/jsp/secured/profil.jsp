

<%@ include file="../header.jsp"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profil.css">

<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/redmond/jquery-ui.min.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<jsp:useBean id="user_search" scope="page" class="beans.User" />

<%user_search.init(request.getParameter("login_search"));%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="content">
		<div class="profil">
		${user_search.afficheVisiteur()}
		<c:if test="${!user.verifier_amitie(user_search)}">
			<form action="${pageContext.request.contextPath}/servlet/insert_amis">
				<input type="hidden" value="${user_search.getLogin()}" name="hidden"/>
				<input type="submit" value="Ajouter comme Amis !!!"/>
			</form>
		</c:if>
		<div class="modification" hidden>
			<c:if test="${user.getLogin().equals(user_search.getLogin())}">
				<form action="${pageContext.request.contextPath}/servlet/update_profil">
					<input type="submit" value="Enregistrer les modifcations !!"/>
				</form>
			</c:if>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/profil.js"></script>
<%@ include file="../footer.jsp"%>
