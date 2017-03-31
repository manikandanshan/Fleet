
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fCompanyList"
	action="${pageContext.request.contextPath}/delete-all/company/${fn:length(companys)}">

	<h2>List of Companies</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/company' />">Add</a>
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
			<th>Company Type</th>
			<th>Address Line</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>ZIP_Code</th>
			<th>Contact_No1</th>
			<th>Contact_No2</th>
			<th>URL</th>
			<th>Email_Id</th>
			
			

		</tr>
		</thead>
		<tbody>
		<c:forEach items="${companys}" var="data" varStatus="status">
			<tr>
		<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="companyId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td><a href="<c:url value='/edit/company/${data.id}'/>" title="EDIT ME!">${data.name}</a></td>
			<td>${data.companyType}</td>
			<td>${data.addressLine1}</td>
			<td>${data.city}</td>
			<td>${data.state}</td>
			<td>${data.country}</td>
			<td>${data.zipCode}</td>
			<td>${data.contactNo1}</td>
			<td>${data.contactNo2}</td>
			<td>${data.url}</td>
			<td>${data.emailId}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fCompanyList.submit();
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