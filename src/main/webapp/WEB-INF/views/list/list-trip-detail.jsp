
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fTripDetailList"
	action="${pageContext.request.contextPath}/delete-all/tripDetail/${fn:length(tripDetails)}">

	<h2>List of TripDetails</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/trip-detail' />">Add</a>
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
			<th>From Address</th>
			<th>To Address</th>
			<th>Distance</th>
			<th>Type Of Good</th>
			<th>Odometer Start Reading</th>
			<th>Odometer End Reading</th>
			<th>Fuel Consumption</th>
			<th>Amount</th>
			<th>Status</th>
			</tr>
		</thead><tbody>
		
		<c:forEach items="${tripDetails}" var="data" varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="tripDetailId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			
			<td>${data.fromAddress}</td>
			<td>${data.toAddress}</td>
			<td><a href="<c:url value='/edit/trip-detail/${data.id}'/>"  title="EDIT ME!">${data.distance}</a></td>
			<td>${data.typeOfGood}</td>
			<td>${data.odometerStartReading}</td>
			<td>${data.odometerEndReading}</td>
			<td>${data.fuelConsumption}</td>
			<td>${data.amount}</td>
			<td>${data.status}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fTripDetailList.submit();
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
