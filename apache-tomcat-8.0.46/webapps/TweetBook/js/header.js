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

function send(id_event){
	$.ajax({
        type: 'POST',
        url: '/TweetBook/servlet/like_event',
        data: 'id_event=' + id_event,
        error: function(response) {
        },
        success: function(response) {
        	location.reload();
        }
    });
}

function refreshPage () {
    var page_y = document.getElementsByTagName("body")[0].scrollTop;
    window.location.href = window.location.href.split('?')[0] + '?page_y=' + page_y;
}
window.onload = function () {
//    setTimeout(refreshPage, 35000);
    if ( window.location.href.indexOf('page_y') != -1 ) {
        var match = window.location.href.split('?')[1].split("&")[0].split("=");
        document.getElementsByTagName("body")[0].scrollTop = match[1];
    }
}