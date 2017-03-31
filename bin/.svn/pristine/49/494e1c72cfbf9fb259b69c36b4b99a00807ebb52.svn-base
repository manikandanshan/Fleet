
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fVehicleInsuranceList"
	action="${pageContext.request.contextPath}/delete-all/vehicleInsurance/${fn:length(vehicleInsurances)}">

	<h2>List of VehicleInsurances</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/vehicle-insurance' />">Add</a>
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
			<th>Insurance Policy No</th>
			<th>Valid From</th>
			<th>Valid Upto</th>
			<th>Amount</th>
			<th>Status</th>
			<th>Action</th>
			
		</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${vehicleInsurances}" var="data"  varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="vehicleInsuranceId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td><a href="<c:url value='/edit/vehicle-insurance/${data.id}'/>" title="EDIT ME!">${data.insurancePolicyNo}</a></td>
			<td>${data.validFrom}</td>
			<td>${data.validUpto}</td>
			<td>${data.amount}</td>
			<td>${data.status}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fVehicleInsuranceList.submit();
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
	

