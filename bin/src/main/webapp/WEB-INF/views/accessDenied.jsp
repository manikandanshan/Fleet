<%@ include file="/WEB-INF/includes/taglibs.jsp"%> 
<%@ page isELIgnored="false" %>
	<title>AccessDenied page</title>
	<div class="generic-container">
		<div class="authbar">
			<span>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
		</div>
	</div>
