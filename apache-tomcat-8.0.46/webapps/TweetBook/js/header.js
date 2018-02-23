function show_login() { 
	document.getElementById("list_login").style.visibility = "visible";
}

function hide_login(){
	document.getElementById("list_login").style.visibility = "hidden";
}

function to_profil(){
	if(document.getElementById("input_login").value !== ""){
		window.location = "profil.jsp?login_search="+document.getElementById("input_login").value;
	}
}