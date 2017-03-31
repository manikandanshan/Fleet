
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fServiceDetailList"
	action="${pageContext.request.contextPath}/delete-all/serviceDetail/${fn:length(serviceDetails)}">

	<h2>List of ServiceDetails</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/service-detail' />">Add</a>
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
			<th>Activity</th>
			<th>Amount</th>
			<th>VAT</th>
			<th>Tax</th>
			<th>Status</th>	
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${serviceDetails}" var="data" varStatus="status">
			<tr>
			            <td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="serviceDetailId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td><a href="<c:url value='/edit/service-detail/${data.id}'/>"  title="EDIT ME!">${data.activity}</a></td>
			<td>${data.amount}</td>
			<td>${data.vat}</td>
			<td>${data.tax}</td>
			<td>${data.status}</td>
						
			</tr>
		</c:forEach>
		</tbody>
	</table>
</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fServiceDetailList.submit();
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


