<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<nav class="navbar navbar-default" style="background-color: #1c66b5;">
	<div class="navbar-header">
		
					<a style="color: white;" class="navbar-brand">Asset Management
				Platform<small><em> --Designed to make your job
						easier..</em></small>
			</a>
			<a class="navbar-brand" style="color: white;" href="#"><strong>${companys.companyType}</strong></a>
		</div>
		<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
			<a  class="dropdown-toggle"
				data-toggle="dropdown" style="color: white;"><sec:authentication property="principal.Username" /><b class="caret"></b></a>
				
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/edit/user/${user.ssoId}">User Profile</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span
							class="glyphicon glyphicon-log-in"></span>  Logout</a></li>
				</ul>
			</li>
		</ul>
	</div>

</nav>


