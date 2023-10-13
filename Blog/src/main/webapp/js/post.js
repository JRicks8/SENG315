$(document).ready(function() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	displayPost(urlParams.get('id'));
});

function displayPost(id) {
	$.ajax({
		url: "./webapi/posts/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
  }).done(function(response){
		console.log($("#postMeta").text());
		$("#postTitle").text(response.title);
		$("#postMeta").text("Posted by "+response.author+" on "+response.date);
		$("#postContent").text(response.content);
	});
}