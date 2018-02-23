

<%@ include file="../header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/accueil.css">
	
<div class="content">
	<form action="${pageContext.request.contextPath}/servlet/insert_event">
		<input type="text" placeholder="Ecrirez a vos amis !!" name="commentaire" required/>
		<input type="submit" value="Envoyer !"/>
	</form>
	${user.afficheActualite()}
</div>

<%@ include file="../footer.jsp"%>
