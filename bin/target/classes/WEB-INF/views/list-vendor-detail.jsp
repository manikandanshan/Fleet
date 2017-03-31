
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<form name="fVendorDetailList"
	action="${pageContext.request.contextPath}/delete-all/vendorDetail/${fn:length(vendorDetails)}">

	<h2>List of VendorDetails</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary" href="<c:url value='/new/vendor-detail' />">Add</a>
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
			<th>Identification No</th>
			<th>Name</th>
			<th>Prefered Vendor Status</th>
			<th>Service Type</th>
			<th>Active Flag</th>
			<th>Contact Person Name</th>
			<th>Contact Type Id</th>
			<th>Address</th>
			<th>URL</th>
			<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${vendorDetails}" var="data" varStatus="status">
			<tr>
			<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="vendorDetailId${status.count}" value="${data.id}" /></td>
            <td>${status.count}</td>
			<td>${data.identificationNo}</td>
			<td><a href="<c:url value='/edit/vendor-detail/${data.id}'/>" title="EDIT ME!">${data.name}</a></td>
			<td>${data.preferedVendorStatus}</td>
			<td>${data.serviceType}</td>
			<td>${data.activeFlag}</td>
			<td>${data.contactPersonName}</td>
			<td>${data.contactTypeId}</td>
			<td>${data.url}</td>
			<td>${data.address}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fVendorDetailList.submit();
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