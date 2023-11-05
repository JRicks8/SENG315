$(document).ready(function(){

	getAllArticles();
	
	view = getQueryStringVariable('view');
	
	if (view == 'articleedit') {
		articleID = getQueryStringVariable('edit');
		getArticle(articleID);
	}
});

var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
};

//Client side API call using AJAX
function getAllArticles(){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/list/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<tr><td><a href ='./index.jsp?view=articleedit&edit="+value.articleID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a></td>" +
	            "<td>"+value.articleID+"</td><td>"+value.articleTitle+"</td><td>"+value.categoryID+"</td>"+
	    		"<td>"+value.articleAuthorID+"</td><td>"+value.articleCreateDate+"</td><td></td><td>"+value.articleContent+"</td></tr>";
       		
    		document.getElementById('postBody').innerHTML += lstResults;
    	});
	});
}

function addArticle(){

	var articleTitle = $("#articleTitle").val();
	var categoryID = $("#categoryID").val();
	var articleAuthorID = $("#articleAuthorID").val();
	var articleContent = $("#articleContent").val();
	
	var parms = { articleTitle:articleTitle, categoryID:categoryID, articleAuthorID:articleAuthorID, articleContent:articleContent };
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/add/",
		type: 'POST',
		dataType : "json",
    contentType: "application/json",
    data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
	}).done(function(response){

    	alert(response.message);
    	
	});
}

function updateArticle(){

	var articleTitle = $("#articleTitle").val();
	var categoryID = $("#categoryID").val();
	var articleContent = $("#articleContent").val();
	
	var parms = { articleID:articleID, articleTitle:articleTitle, categoryID:categoryID, articleContent:articleContent };
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/update",
		type: 'POST',
		dataType : "json",
    contentType: "application/json",
    data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
	}).done(function(response){

    	alert(response.message);
    	
	});
}

function getArticle(articleID){
		
		$.ajax({
			url: "../SENG315FinalProjectAPIs/rest/articles/"+articleID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#articleTitle").val(response.articleTitle);
	    	$("#categoryID").val(response.categoryID);
	    	$("#articleAuthorID").val(response.articleAuthorID);
	    	$("#articleContent").val(response.articleContent);
	    	$("#articleImage").val(response.articleImage);

		});
	}