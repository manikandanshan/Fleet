<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<br>

<form id="fClient" name="fClientList"
	action="${pageContext.request.contextPath}/delete-all/client/${fn:length(clients)}">

	<h2>List of Clients</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
			<security:authorize access="hasAnyRole('ADMIN','DBA','MANAGER')">
				<a class="btn btn-primary" href="<c:url value='/new/client' />">Add</a>
				<button type="submit" id="deleteId" class="btn btn-danger"  onclick="return ConfirmDelete('deleteAll()')">delete</button>
				</security:authorize>
			</div>
			<div class = "alert-success">
			<strong>${success}</strong>
			</div>
		</div>      
	</div>

	<%-- 	<input type="text" name="rowcount" value="${fn:length(clients)}">
	<a class="btn btn-danger" href="<c:url value='/delete/client/${fn:length(clients)}' />">sample link</a>
	 --%>
<div id="divpopup" class="table-responsive">

	<table id="tClient" class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th><div class="fieldwidth"><input type="checkbox" id="selectAll" /></div></th>
				<th><div class="fieldwidth">S.No</div></th>
				<th>Code</th>
				<th>Name</th>
				<th>Phone No</th>
				<th>Mobile No</th>
				<th>Address</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${clients}" var="data" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden" class="checkthis"
						name="clientId${status.count}" value="${data.id}" /></td>
					<td class="checkthis">${status.count}</td>
					<td class="checkthis">${data.code}</td> 
					<td class="checkthis"><a href="<c:url value='/edit/client/${data.id}'/>">${data.name}</a></td> 
					<td class="checkthis">${data.phoneNo}</td>
					<td class="checkthis">${data.mobileNo}</td>
					<td class="checkthis">${data.address}</td>
					<td class="checkthis">${data.status}</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
	</div>
</form>

<script type="text/javascript">

function deleteAll() {
	window.document.fClientList.submit();
}
function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x)
      return true;
  else
    return false;
}
</script>
	