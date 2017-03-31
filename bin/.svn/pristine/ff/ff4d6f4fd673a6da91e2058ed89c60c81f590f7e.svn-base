<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<script
	src="${pageContext.request.contextPath}/static/js/controller/associateTypeController.js"></script>
<div ng-controller="associateTypeController"
	id="associateTypeController">
	<form:form method="POST" name="myForm" modelAttribute="associateType">
		<form:input data-ng-model="ctrl.associateType.id" type="hidden"
			path="id" id="id" />
{{sample}}
<div class="row">
			<div class="col-md-8">

				<h2>Create Associate Type</h2>
			</div>
			<div class="col-md-4">
				<div class="pull-right">
					<c:choose>
						<c:when test="${edit}">
							<button type="submit" class="btn btn-primary" value="Update">Update</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-primary" value="Register">Add</button>
						</c:otherwise>
					</c:choose>
					<a href="<c:url value='/list/associate-type'/>">
						<button type="button" class="btn btn-default">Close</button>
					</a>
				</div>
			</div>
		</div>

		<div class="alert-success">
			<strong>${success}</strong>
		</div>
		<div>
			<div class="row">
				<div class=" col-md-2">
					<label for="code">Code:</label>
					<form:input type="text" path="code" class="form-control" />
					<form:errors path="code" cssClass="error" />
					<!-- 			<div class="has-error" data-ng-show="myForm.$dirty">
				  <span data-ng-show="myForm.name.$error.required">This is a required field</span>
				  <span data-ng-show="myForm.code.$invalid">This field is invalid </span>
	            </div> -->
				</div>
			</div>

			<div class="row">
				<div class=" col-md-6">
					<label for="name">Name:</label>
					<form:input type="text" path="name" class="form-control" />
					<form:errors path="name" cssClass="error" />
					<!-- 			<div class="has-error" data-ng-show="myForm.$dirty" >
		               <span data-ng-show="myForm.name.$error.required">This is a required field</span>
		               <span data-ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
		               <span data-ng-show="myForm.name.$invalid">This field is invalid </span>
		            </div> -->
				</div>
			</div>

			<div class="row">
				<div class=" col-md-2">
					<label for="status">Status:</label> <select class="form-control"
						name="status" id="status">
						<option>Active</option>
						<option>Inactive</option>
					</select>
					<form:errors path="status" cssClass="error" />
				</div>
			</div>
		</div>

	</form:form>
</div>
<!-- controller -->
