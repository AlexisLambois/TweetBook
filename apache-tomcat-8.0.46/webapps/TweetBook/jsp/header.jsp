<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:useBean id="sql_list" scope="page" class="beans.Sql_list" />
<%---user.init(request.getRemoteUser()); --%>
<%
	user.init("toto");
%>
<%
	sql_list.init("prenom,nom", "comptes", 2);
%>

<div class="header">
	<a href="" class="logo"><img
		src="${pageContext.request.contextPath}/img/logo.png" /></a>
	<div class="search">
		<a href=""><i class="material-icons">search</i></a><input
			list="name_firstname" onclick="show_login()"
			onfocusout="hide_login()" placeholder="Rechercher" type="text" />
		<div id="list_login">
			<datalist id="name_firstname">${sql_list.get_list_to_datalist()}</datalist>
		</div>
	</div>
	<a href="" class="profil"><span><p>
				<img alt="" src="${user.getPhoto()}" />
				<%--=request.getRemoteUser()--%>
				toto
			</p></span></a>
</div>