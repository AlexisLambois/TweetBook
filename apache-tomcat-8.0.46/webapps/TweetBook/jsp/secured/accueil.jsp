

<%@ include file="../header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/accueil.css">
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">

<div class="content">
	<form action="${pageContext.request.contextPath}/servlet/insert_event">
		<input type="text" placeholder="Ecrirez à vos amis !!" name="commentaire" required/>
		<input type="submit" value="Envoyer !"/>
	</form>
	${user.afficheActualite(pageContext.request.contextPath)}
</div>

<%@ include file="../footer.jsp"%>
