$(document).ready(function(){

	listArticles();
	listNavigations();
	listCategories();
	listUsers();
	
	view = getQueryStringVariable('view');
	
	if (view == 'articleedit') {
		articleID = getQueryStringVariable('edit');
		getArticle(articleID);
	} else if (view == 'navedit') {
		navigationID = getQueryStringVariable('edit');
		getNavigation(navigationID);
	} else if (view == 'catedit') {
		categoryID = getQueryStringVariable('edit');
		getCategory(categoryID);
	} else if (view == 'useredit') {
		userID = getQueryStringVariable('edit');
		getUser(userID);
	}
});

var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
};