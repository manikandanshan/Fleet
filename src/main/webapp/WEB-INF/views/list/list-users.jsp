<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>


<%-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/app.css"
	rel="stylesheet"></link>

</head> --%>



<form name="fUserList"
	action="${pageContext.request.contextPath}/delete-all/user/${fn:length(users)}">
	<div class="row">
		<div class="col-md-8">

			<h2>List of Users</h2>
		</div>
		<div class="col-md-4">
			<br>
			<div class="pull-right">
				<sec:authorize access="hasRole('ADMIN')">
					<a class="btn btn-primary" href="<c:url value='/new/user' />">Add</a>
					<button type="submit" class="btn btn-danger"
						onclick="return ConfirmDelete('deleteAll()')">Delete</button>
				</sec:authorize>
			</div>
		</div>
		<div class="alert-success">
			<strong>${success}</strong>

		</div>
		<table class="table table-hover table-striped table-bordered">

			<thead class="thead-inverse">

				<tr>
					<th width="2%"><input type="checkbox" id="checkAll" /></th>
					<th width="4%">S.No</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>User Name</th>
					<!-- <th>Number</th> -->
					<!-- <th>Phone Number</th> -->
					<th>Mobile Number</th>
					<!-- <th>Dob</th> -->
					<!-- <th>License Number</th>
					<th>License Valid Upto</th>
					<th>Address</th>
					<th>Notes</th> -->
					<th>Status</th>
					<th>Role</th>
					
				</tr>
			</thead>

			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="userId${status.count}" value="${user.id}" /></td>
					<td>${status.count}</td>
					<%-- <td>${user.firstName}</td> --%>
					<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
						<td><a href="<c:url value='/edit/user/${user.ssoId}'/>">${user.firstName}</a></td>
					</sec:authorize>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.ssoId}</td>
					<%-- <td>${user.number}</td>
					<td>${user.phoneNo}</td> --%>
					<td>${user.mobileNo}</td>
					<%-- <td>${user.dob}</td>
					<td>${user.licenceNo}</td>
					<td>${user.licenceValidUpto}</td>
					<td>${user.address}</td>
					<td>${user.notes}</td> --%>
					<td>${user.status}</td>
					<%-- <td>${user.getSsoId}</td> --%>


				</tr>
			</c:forEach>

		</table>
	</div>

</form>


<script type="text/javascript">
	function deleteAll() {
		window.document.fUserList.submit();
	}
	function ConfirmDelete() {
		var x = confirm("Are you sure you want to delete?");
		if (x)
			return true;
		else
			return false;
	}
</script>