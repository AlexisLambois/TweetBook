function show_form(){
	document.getElementsByClassName("modification")[0].style.visibility="visible";
}

$(function() {
	$( "#datepicker" ).datepicker({
		monthNames: ['Janvier','Février','Mars','Avril','Mai','Juin','Juillet','Août','Septembre','Octobre','Novembre','Décembre'],
		monthNamesShort: ['Jan','Fév','Mar','Avr','Mai','Jun','Jul','Aoû','Sep','Oct','Nov','Déc'],
		dayNames: ['Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi','Dimanche'],
		dayNamesShort: ['Lun','Mar','Mer','Jeu','Ven','Sam','Dim'],
		dayNamesMin: ['Lu','Ma','Me','Je','Ve','Sa','Di'],
		dateFormat: 'dd-mm-yy', 
		firstDay: 0,
		maxDate: 0  
	});
});

function modif_user(){
	$.ajax({
        type: 'POST',
        url: '/TweetBook/servlet/update_user',
        data: 'naissance=' + document.getElementById("datepicker").value + '&email=' + document.getElementById("email").value + '&photo=' + document.getElementById("photo").value,
        error: function(response) {
        },
        success: function(response) {
        	location.reload();
        }
    });
}