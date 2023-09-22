//JQuery
$(document).ready(function(){

	ajaxMethod();

});

//Client side API call using AJAX
function ajaxMethod(){
	
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/users",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
		
    	$.each(response, function(key, value) {
    		
    		var userResults = "<div class='col-lg-3 col-md-6 mb-4'>" +
    	        "<div class='card h-100'>" +
    	        "<img class='card-img-top' src='https://robohash.org/"+value.id+"?set=set1&size=180x180' alt=''>" +
    	          "<div class='card-body'>" +
    	            "<h4 class='card-title'>"+value.name+"</h4>" +
    	            "<p class='card-text'>"+value.company.name+"</p>" +
    	          "</div>" +
    	          "<div class='card-footer'>" +
    	            "<a href='#' class='btn btn-primary' data-toggle='modal' onclick=userModal('" + value.id + "')>Contact Details</a>" +
    	          "</div>" +
    	        "</div>" +
    	      "</div>";
    	        
    	      $("#userList").append(userResults);
       	});
	});
}

function userModal(id){
	
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/users/"+id+"",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
			
    	$("#detailsModal").modal('show');
    	
    	$("#userName").text(response.name);
			$("#userEmail").text(response.email);
			$("#userPhone").text(response.phone);
			$("#userWebsite").text(response.website);
			$("#userCity").text(response.address.city);
	});
}

