<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<script
	src="${pageContext.request.contextPath}/static/js/controller/associateTypeController.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/service/associateTypeService.js"></script>
<div ng-controller="associateTypeController">
<form name="fAssociateTypeList"
	action="${pageContext.request.contextPath}/delete-all/associateType/${fn:length(associateTypes)}">
	<div class="row">
		<div class="col-md-8">

			<h2>List of AssociateTypes</h2>
		</div>
		<div class="col-md-4">
			<br>
			<div class="pull-right">
				<a class="btn btn-primary"
					href="<c:url value='/new/associate-type' />">Add</a>
				<button type="submit" class="btn btn-danger"
					onclick="return ConfirmDelete('deleteAll()')">Delete</button>
			</div>
		</div>
	</div>
	<div class="alert-success">
		<strong>${success}</strong>
	</div>
	<br>
	<table class="table table-hover table-striped table-bordered">

		<thead class="thead-inverse">
			<tr>
				<th width="2%"><input type="checkbox" id="checkAll" class="selectall" /></th>
				<th width="4%">S.No</th>
				<th>Name</th>
				<th>Code</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${associateTypes}" var="data" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkbox${status.count}"
						class="checkthis" /> <input type="hidden"
						name="associateTypeId${status.count}" value="${data.id}" /></td>
					<td>${status.count}</td>
					<td><a href="<c:url value='/edit/associate-type/${data.id}'/>">${data.name}</a></td>
					<td>${data.code}</td>
					<td>${data.status}</td>
				</tr>
			</c:forEach>
	</table>
</form>
</div>
<script type="text/javascript">
	function deleteAll() {
		window.document.fAssociateTypeList.submit();
	}
	function ConfirmDelete() {
		var x = confirm("Are you sure you want to delete?");
		if (x)
			return true;
		else
			return false;
	}
	
	$('.selectall').click(function() {
	    if ($(this).is(':checked')) {
	        $('div input').attr('checked', true);
	    } else {
	        $('div input').attr('checked', false);
	    }
	});

</script>
