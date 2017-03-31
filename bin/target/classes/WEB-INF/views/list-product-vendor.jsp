<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<form name="fProductVendorList"
	action="${pageContext.request.contextPath}/delete-all/productVendor/${fn:length(productVendors)}">

	<h2>List of ProductVendors</h2>
	<div class="row">
		<div class="col-md-12">
			<div class="pull-right">
				<a class="btn btn-primary"
					href="<c:url value='/new/product-vendor' />">Add</a>
				<button type="submit" class="btn btn-danger" onclick="return ConfirmDelete('deleteAll()')">delete</button>
			</div>
			<div class="alert-success">
				<strong>${success}</strong>
			</div>
		</div>
	</div>



	<table class="table table-hover table-striped table-bordered">

		<thead class="thead-inverse">

			<tr>

				<th width="2%"><input type="checkbox" id="checkAll" /></th>
				<th width="4%">S.No</th>
				<th>Delivery Date</th>
				<th>Price</th>
				<th>Last Receipt Cost</th>
				<th>Last Receipt Date</th>
				<th>Min Order Qty</th>
				<th>Max Order Qty</th>
				<th>On Order Quantity</th>
				<th>Unit Measure Code</th>
			</tr>

			<c:forEach items="${productVendors}" var="data" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="productVendorId${status.count}" value="${data.id}" /></td>
					<td>${status.count}</td>
					<td><a href="<c:url value='/edit/product-vendor/${data.id}'/>"
						title="EDIT ME!">${data.averageLeadTime}</a></td>
					<td>${data.standardPrice}</td>
					<td>${data.lastReceiptCost}</td>
					<td>${data.lastReceiptDate}</td>
					<td>${data.minOrderQty}</td>
					<td>${data.maxOrderQty}</td>
					<td>${data.onOrderQty}</td>
					<td>${data.unitMeasureCode}</td>

				</tr>
			</c:forEach>
	</table>
</form>
<script type="text/javascript">
	function deleteAll() {
		window.document.fProductVendorList.submit();
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

