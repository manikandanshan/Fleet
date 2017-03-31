<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fPrivilegeList"
	action="${pageContext.request.contextPath}/delete-all/privilege/${fn:length(privileges)}">

	<h2>List of Privileges</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/privilege' />">Add</a>
				<button type="submit" class="btn btn-danger" onclick="return ConfirmDelete('deleteAll()')">delete</button>
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
			<td>Name</td>
			
		</tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${privileges}" var="data" varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="privilegeId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td><a href="<c:url value='/edit/privilege/${data.id}'/>" title="EDIT ME!">${data.name}</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fPrivilegeList.submit();
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