//JQuery
$(document).ready(function(){
	chainMultipleCalls();
});

function chainMultipleCalls() {
	
	//From: http://www.lampdev.org/programming/jquery/jquery-deferred-chained-ajax-calls.html
	for(var i=1; i < 11; i++){
		//console.log(i);
	var chainedPromise = $.when(
			getPosts(i*10),getUserName(i),getPostImage(i))

		// execute this when all three calls are done
		chainedPromise.done(function(post,username,image) {
			
    		var blogPosts = "<div class='card mb-4'>" +
            "<img class='card-img-top' src='"+image+"' alt='Card image cap'>" +
            "<div class='card-body'>" +
              "<h2 class='card-title'>" + post[0] + "</h2>" +
              "<p class='card-text'>" + post[1] + "</p>" +
              "<a href='#' class='btn btn-primary'>Read More &rarr;</a>" +
            "</div>" +
            "<div class='card-footer text-muted'>" +
              "Posted on January 1, 2017 by " +
              "<a href='#'>"+username+"</a><img class='avatar' src='https://robohash.org/"+post[2]+"?set=set2&size=180x180'>" +
            "</div>" +
          "</div>";
    	
    		$("#blogBody").append(blogPosts);

		});
	}
}

function getPosts(id){
	
	var deferred = $.Deferred();
	
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/posts/"+id+"",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	deferred.resolve(response.title,response.body,response.userId);
	});
	
	return deferred.promise();
}


function getUserName(userId){
	var deferred = $.Deferred();
	
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/users/"+userId+"",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	deferred.resolve(response.username);
	});
	return deferred.promise();
}

function getPostImage(photoId){
	
	var deferred = $.Deferred();
	
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/photos/"+photoId+"",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {	

    }).done(function(response) {
			deferred.resolve(response.url);
	});
	
	return deferred.promise();
}
