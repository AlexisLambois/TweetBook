function change(object) {
	var text = object.value;
	document.getElementById("list_login")
	console.log(text);
}

function show_login() { 
	document.getElementById("list_login").style.visibility = "visible";
}

function hide_login(){
	document.getElementById("list_login").style.visibility = "hidden";
}