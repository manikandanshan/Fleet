
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fAssociateList"
	action="${pageContext.request.contextPath}/delete-all/associate/${fn:length(associates)}">

	<h2>List of Associates</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/associate' />">Add</a>
				<button type="submit" class="btn btn-danger" onclick="return ConfirmDelete('deleteAll()')">delete</button>
			</div>
			<div class = "alert-success">
			<strong>${success}</strong></div>
		</div>
	</div>

	
	
	<table class="table table-hover table-striped table-bordered">
	     
	   <thead class="thead-inverse">

		<tr>
		
		     <th width="2%"><input type="checkbox" id="checkAll" /></th>
			<th width="4%">S.No</th><th>Number</th><th>First Name</th><th>last Name</th><th>Phone Number</th><th>Mobile Number</th><th>E-Mail</th><th>Dob</th><th>License Number</th><th>License Valid Upto</th><th>Address</th><th>Notes</th><th>Status</th><th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${associates}" var="associate" varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="associateId${status.count}" value="${associate.id}" /></td>
					<td>${status.count}</td>
			<td>${associate.number}</td>
			<td><a href="<c:url value='/edit/associate/${associate.id}'/>" title="EDIT ME!">${associate.firstName}</a></td>
			<td>${associate.lastName}</td>
			<td>${associate.phoneNo}</td>
			<td>${associate.mobileNo}</td>
			<td>${associate.email}</td>
			<td>${associate.dob}</td>
			<td>${associate.licenceNo}</td>
			<td>${associate.licenceValidUpto}</td>
			<td>${associate.address}</td>
			<td>${associate.notes}</td>
			<td>${associate.status}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
	<script type="text/javascript">
	function deleteAll() {
		window.document.fAssociateList.submit();
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
