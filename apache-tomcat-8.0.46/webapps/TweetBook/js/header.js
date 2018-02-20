function show_login() { 
	document.getElementById("list_login").style.visibility = "visible";
}

function hide_login(){
	document.getElementById("list_login").style.visibility = "hidden";
}

function to_profil(){
	window.location = "profil.jsp?login_search="+document.getElementById("input_login").value;
}