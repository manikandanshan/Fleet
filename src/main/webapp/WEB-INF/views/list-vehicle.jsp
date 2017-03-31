
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fVehicleList"
	action="${pageContext.request.contextPath}/delete-all/vehicle/${fn:length(vehicles)}">

	<h2>List of Vehicles</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<security:authorize access="hasAnyRole('ADMIN','DBA','MANAGER')">
				<a class="btn btn-primary" href="<c:url value='/new/vehicle' />">Add</a>
				</security:authorize>
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
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>Colour</th>
			<th>VIN</th>
			<th>Fuel Capacity</th>
			<th>Engine No</th>
			<th>Odometer Type</th>
			<th>Department Id</th>
			<th>Note</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${vehicles}" var="data" varStatus="status" >
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="vehicleId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td>${data.make}</td>
			<td>${data.model}</td>
			<td>${data.year}</td>
			<td>${data.color}</td>
			<td><a href="<c:url value='/edit/vehicle/${data.id}' />" title="EDIT ME!">${data.vin}</a></td>
			<td>${data.fuelCapacity}</td>
			<td>${data.engineNo}</td>
			<td>${data.odometerType}</td>
			<td>${data.departmentId}</td>
			<td>${data.note}</td>
			<td>${data.status}</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
		</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fVehicleList.submit();
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
