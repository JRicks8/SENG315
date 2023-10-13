// Bootstrap template code block
window.addEventListener('DOMContentLoaded', () => {
    let scrollPos = 0;
    const mainNav = document.getElementById('mainNav');
    const headerHeight = mainNav.clientHeight;
    window.addEventListener('scroll', function() {
        const currentTop = document.body.getBoundingClientRect().top * -1;
        if ( currentTop < scrollPos) {
            // Scrolling Up
            if (currentTop > 0 && mainNav.classList.contains('is-fixed')) {
                mainNav.classList.add('is-visible');
            } else {
                console.log(123);
                mainNav.classList.remove('is-visible', 'is-fixed');
            }
        } else {
            // Scrolling Down
            mainNav.classList.remove(['is-visible']);
            if (currentTop > headerHeight && !mainNav.classList.contains('is-fixed')) {
                mainNav.classList.add('is-fixed');
            }
        }
        scrollPos = currentTop;
    });
});

$(document).ready(function() {
	getPosts();
});

//Client side API call using AJAX
function getPosts(){
	$.ajax({
		url: "./webapi/posts/",
		type: 'GET',
		dataType : "json",
    contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var firstResults = "<hr class=\"my-4\" /><div class=\"post-preview\"><a href='#' onclick=openPost("+value.id+")><h2 class=\"post-title\">"+
    		value.title+"</h2></a><p class=\"post-meta\">Posted by "+
    		value.author+" on "+
    		value.date+"</p><button class=\"btn btn-primary\" type=\"submit\" onclick=editPost('"+value.id+"') id=\"postEdit\" data-toggle=\"tooltip\" title=\"Edit Post\">Edit Post</button></div>" +
    		"<button class=\"btn btn-primary\" type=\"submit\" onclick=deletePost('"+value.id+"') id=\"postDelete\" data-toggle=\"tooltip\" title=\"Delete Post\">Delete Post</button></div>";
       	
       	if ($("#postBody").text()) {
					 document.getElementById('postBody').innerHTML += firstResults;
			 	}
    	});
	});
}

function openPost(id) {
	window.location="./post.html?id="+id;	
}

function addPost() {
	var postID = $("#postID").val();
	var postTitle = $("#postTitle").val();
	var postAuthor = $("#postAuthor").val();
	var postDate = $("#postDate").val();
	var postContent = $("#postContent").val();
	
	if (postTitle == "") {
		alert("Post Title cannot be blank");
		$("#postTitle").focus();
		return;
	}
	
	if (postAuthor == "") {
		alert("Post Author cannot be blank");
		$("#postAuthor").focus();
		return;
	}
	
	if (postDate == "") {
		alert("Post Date cannot be blank");
		$("#postDate").focus();
		return;
	}
	
	if (postContent == "") {
		alert("Post Content cannot be blank");
		$("#postContent").focus();
		return;
	}
	
	var parms = { id:postID, title:postTitle, author:postAuthor, date:postDate, content:postContent };
	
	$.ajax({
		url: "./webapi/posts/",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
	}).done(function(response){
		window.location="./index.html";
	});
}

function deletePost(id) {
	$.ajax({
		url: "./webapi/posts/"+id,
		type: 'DELETE',
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}

function editPost(id) {
	
	$("#editModal").modal('show');
	
	$.ajax({
		url: "./webapi/posts/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
  }).done(function(response){
		console.log(response);
		$("#postID").val(response.id);
		$("#postTitle").val(response.title);
		$("#postAuthor").val(response.author);
		$("#postDate").val(response.date);
		$("#postContent").val(response.content);
	});
}

function updatePost() {
	var postID = $("#postID").val();
	var postTitle = $("#postTitle").val();
	var postAuthor = $("#postAuthor").val();
	var postDate = $("#postDate").val();
	var postContent = $("#postContent").val();
	
	var parms = { id:postID, title:postTitle, author:postAuthor, date:postDate, content:postContent };
	
	$.ajax({
		url: "./webapi/posts/"+postID,
		type: 'PUT',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}