//JQuery
$(document).ready(function(){

	helloWorld();
	helloName();
	helloId();
	plainText();
	XML();
	JSON();
	HTML();
	postName();

});


function helloWorld(){
	
	$.ajax({
		url: "./rest/hello/world",
		type: 'GET',
		dataType : "html",
        contentType: "text/html",
	}).fail(function(response) {	

    }).done(function(response) {
    	
    	$("#helloWorld").append(response);

	});
}

function postName(){
	
	var name = "John";
	
	$.ajax({
		url: "./rest/hello/user?name="+name+"",
		type: 'POST',
		dataType : "html",
        contentType: "text/html",
	}).fail(function(response) {	

    }).done(function(response) {
    	
    	$("#postName").append(response);

	});
}

function helloName(){
	
	var name = "Jim";
	
	$.ajax({
		url: "./rest/hello/user?name="+name+"",
		type: 'GET',
		dataType : "html",
        contentType: "text/html",
	}).fail(function(response) {	

    }).done(function(response) {
    	
    	$("#helloName").append(response);

	});
}

function helloId(){
	
	var id = "2";
	
	$.ajax({
		url: "./rest/hello/user/"+id+"",
		type: 'GET',
		dataType : "html",
        contentType: "text/html",
	}).fail(function(response) {
		

    }).done(function(response) {
    	console.log(response);
    	
    	$("#helloId").append(response);

	});
}

function plainText(){
	
	$.ajax({
		url: "./rest/type/",
		type: 'GET',
		dataType : "text",
        contentType: "text/plain",
	}).fail(function(response) {
		

    }).done(function(response) {
    	
    	$("#plainText").append(response);

	});
}

function XML(){
	
	$.ajax({
		url: "./rest/type/",
		type: 'GET',
		dataType : "xml",
        contentType: "application/xml",
	}).fail(function(response) {
		console.log(response);

    }).done(function(response){
    	
    	var value = $(response).find('value');
    	
    	$("#xml").append(value);

	});
}

function JSON(){
	
	$.ajax({
		url: "./rest/type/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(response);

    }).done(function(response){
    	
    	var value = response.value;
    	
    	$("#json").append(value);

	});
}

function HTML(){
	
	$.ajax({
		url: "./rest/type/",
		type: 'GET',
		dataType : "html",
        contentType: "text/html",
	}).fail(function(response) {
		console.log(response);

    }).done(function(response){
    	
    	$("#html").append(response);

	});
}
