//JQuery
$(document).ready(function(){

  $("#turnTextGreen").click(function(){
	  	$("#assignmentText").attr("style", "color: green");
	  });

});

//Javascript
//From Button
function turnTextRed(){
	document.getElementById('assignmentText').setAttribute("style", "color: red");
}

//Listening for ID
document.getElementById('turnTextBlue').onclick = function(){
	document.getElementById('assignmentText').setAttribute("style", "color: blue");
};