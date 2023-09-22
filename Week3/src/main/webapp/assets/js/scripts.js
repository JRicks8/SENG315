
$(document).ready(function() {
	GetCatFact();
	GetCatPicture();
});

function GetCatFact() {
	
	var deferred = $.Deferred();
	
	$.ajax({
		url: "https://catfact.ninja/fact?max_length=1000",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(response);
    }).done(function(response) {
    	console.log(response);
    	$("#factZone").text(response.fact);
    	deferred.resolve(response.title,response.body,response.userId);
	});
	
	return deferred.promise();
}

function GetCatPicture() {
	
	var deferred = $.Deferred();
	
	$.ajax({
		url: "https://api.thecatapi.com/v1/images/search",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(response);
    }).done(function(response) {
    	console.log(response[0]);
    	$(".masthead").css("background-image", "url("+response[0].url+")");
    	deferred.resolve(response.title,response.body,response.userId);
	});
	
	return deferred.promise();
}

$("#factButton").on("click", function() {
	GetCatPicture();
	GetCatFact();
});