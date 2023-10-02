$(document).ready(function() {
	getContacts();
});

//Client side API call using AJAX
function getContacts(){
	
	$.ajax({
		url: "./webapi/contacts/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<tr><td>"+value.name+"</td><td>"+value.email+"</td><td>"+value.city+"</td>" + 
    		"<td><a href='#' onclick=editContact('"+value.id+"') data-toggle='tooltip' title='Edit'>Edit</a></td>" +
    		"<td><a href='#' onclick=deleteContact('"+value.id+"') data-toggle='tooltip' title='Delete'>Delete</a></td></tr>";
       	
       	if ($("#postBody").text()) {
					 document.getElementById('postBody').innerHTML += lstResults;
			 	}
    	});
	});
}

function addContact() {
	var contactName = $("#contactName").val();
	var contactEmail = $("#contactEmail").val();
	var contactCity = $("#contactCity").val();
	
	if (contactName == "") {
		alert("Contact Name cannot be blank");
		$("#contactName").focus();
		return;
	}
	
	if (contactEmail == "") {
		alert("Contact Email cannot be blank");
		$("#contactEmail").focus();
		return;
	}
	
	if (contactCity == "") {
		alert("Contact City cannot be blank");
		$("#contactCity").focus();
		return;
	}
	
	var parms = { name:contactName, email:contactEmail, city:contactCity };
	
	$.ajax({
		url: "./webapi/contacts/",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify)
	});
}

function deleteContact(id) {
	$.ajax({
		url: "./webapi/contacts/"+id,
		type: 'DELETE',
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}

function editContact(id) {
	
	$("#editModal").modal('show');
	
	$.ajax({
		url: "./webapi/contacts/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
  }).done(function(response){
		console.log(response);
		$("#contactID").val(response.id);
		$("#contactName").val(response.name);
		$("#contactEmail").val(response.email);
		$("#contactCity").val(response.city);
	});
}

function updateContact() {
	var contactID = $("#contactID").val();
	var contactName = $("#contactName").val();
	var contactEmail = $("#contactEmail").val();
	var contactCity = $("#contactCity").val();
	
	var parms = { id:contactID, name:contactName, email:contactEmail, city:contactCity };
	
	$.ajax({
		url: "./webapi/contacts/"+contactID,
		type: 'PUT',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}