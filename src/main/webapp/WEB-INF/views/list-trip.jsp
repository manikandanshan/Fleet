
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fTripList"
	action="${pageContext.request.contextPath}/delete-all/trip/${fn:length(trips)}">

	<h2>List of Trips</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/trip' />">Add</a>
				<security:authorize access="hasAnyRole('ADMIN')">
				<button type="submit" class="btn btn-danger" onclick="return ConfirmDelete('deleteAll()')">delete</button>
				</security:authorize>
			</div>
			<div class = "alert-success">
			<strong>${success}</strong>
		</div>
	</div>
	</div>

	
	
	<table class="table table-hover table-striped table-bordered">
	     
	   <thead class="thead-inverse">

		<tr>
		
		     <th width="2%"><input type="checkbox" id="checkAll" /></th>
			<th width="4%">S.No</th>
			<th>Id</th>
			<th>Status</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${trips}" var="data"  varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="tripId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td>${data.id}</td>
			<td><a href="<c:url value='/edit/trip/${data.id}'/>" title="EDIT ME!">${data.status}</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fTripList.submit();
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
	
