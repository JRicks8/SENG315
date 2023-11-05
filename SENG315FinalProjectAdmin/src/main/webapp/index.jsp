<%@include file=".\includes\adminHeader.jsp" %>

<%@include file=".\includes\adminNavigation.jsp" %>

<div class="container-fluid">

<%
	if (view == null) {
		view = "";
	}

	if (view.equals("articlelist")) {%>
		<%@include file=".\includes\articleList.jsp" %>
	<%} else if (view.equals("articleadd")) {%>
		<%@include file=".\includes\articleAdd.jsp" %>
	<%} else if (view.equals("articleedit")) {%>
		<%@include file=".\includes\articleEdit.jsp" %>
	<%} else {%>
		<%@include file=".\includes\dashboard.jsp" %>
	<%}%>

</div>
<!-- /.container-fluid -->

<%@include file=".\includes\adminFooter.jsp" %>