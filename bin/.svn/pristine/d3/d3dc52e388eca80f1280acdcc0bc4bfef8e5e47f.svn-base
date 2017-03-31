
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fInsuranceProviderList"
	action="${pageContext.request.contextPath}/delete-all/insuranceProvider/${fn:length(insuranceProviders)}">

	<h2>List of InsuranceProviders</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/insurance-provider' />">Add</a>
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
			<th>Name</th>
			<th>Code</th>
			<th>Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${insuranceProviders}" var="data" varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="insuranceProviderId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td><a href="<c:url value='/edit/insurance-provider/${data.id}'/>"title="EDIT ME!">${data.name}</a></td>
			<td>${data.code}</td>
			<td>${data.status}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
		</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fInsuranceProviderList.submit();
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