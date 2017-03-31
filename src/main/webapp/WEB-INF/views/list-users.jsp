<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"
	rel="stylesheet"></link>
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/app.css"
	rel="stylesheet"></link>

<form name="fUserList">
	<div class="row">
		<div class="col-md-8">
			<h2>List of Users</h2>
		</div>
		<div class="col-md-4">
			<br>
			<div class="pull-right">
				<security:authorize access="hasAnyRole('ADMIN','DBA')">
				<a class="btn btn-primary btn-space"
					href="<c:url value='/new/user' />">Add</a>
					</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
				<button type="submit" id="deleteId" class="btn btn-danger"
					onclick="return ConfirmDelete('deleteAll()')">delete</button>
					</security:authorize>
			</div>
			<div class="alert-success">
				<strong>${success}</strong>
			</div>
		</div>
	</div>
	<table class="table table-hover table-striped table-bordered">

		<thead class="thead-inverse">

			<tr>
			</tr>
			<%-- <%@include file="authheader.jsp"%> --%>
		<thead>
			<tr>
				<th width="2%"><input type="checkbox" id="checkAll" /></th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Email</th>
				<th>User Name</th>
				<th>Number</th>
				<th>Phone Number</th>
				<th>Mobile Number</th>
				<th>Dob</th>
				<th>License Number</th>
				<th>License Valid Upto</th>
				<th>Address</th>
				<th>Notes</th>
				<th>Status</th>

			</tr>
		</thead>

		<c:forEach items="${users}" var="data">
			<tr>
				<td><input type="checkbox" name="checkbox${status.count}"
					class="checkthis" /></td>
				<td>${data.firstName}</td>
				<td>${data.lastName}</td>
				<td>${data.email}</td>
				<td><a href="<c:url value='/edit/user/${data.ssoId}'/>" title="EDIT ME!">${data.ssoId}</a></td>
				<td>${data.associate.number}</td>
				<td>${data.associate.phoneNo}</td>
				<td>${data.associate.mobileNo}</td>
				<td>${data.associate.dob}</td>
				<td>${data.associate.licenceNo}</td>
				<td>${data.associate.licenceValidUpto}</td>
				<td>${data.associate.address}</td>
				<td>${data.associate.notes}</td>
				<td>${data.associate.status}</td>
				</tr>
		</c:forEach>
	</table>
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