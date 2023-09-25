$(document).ready(function(){

	getPosts();
});

//Client side API call using AJAX
function getPosts(){
	
	$.ajax({
		url: "./webapi/post/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<tr><td>"+value.id+"</td><td>"+value.userId+"</td><td>"+value.title+"</td><td>"+value.body+"</td></tr>";
       		
    		document.getElementById('postBody').innerHTML += lstResults;
    	});
	});
}