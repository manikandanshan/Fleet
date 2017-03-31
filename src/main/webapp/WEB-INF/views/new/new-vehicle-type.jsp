<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Vehicle Type</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="vehicleType">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/vehicle-type' />">
				<button type="button" class="btn btn-default pull-right">Close
				</button>
			</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${edit}">
					<button type="submit" class="btn btn-primary pull-right"
						value="update">Update</button>

				</c:when>

				<c:otherwise>
					<div>
						<button type="submit" class="btn btn-primary pull-right"
							value="Register">Add</button>

					</div>
				</c:otherwise>
			</c:choose>
			<div class="alert-success">
				<strong>${success}</strong>
			</div>
		</div>
		<br> <br>
		<div class="col-md-2">
			<label for="name">Name:</label>
			<form:input type="text" path="name" class="form-control" id="name"
				autocomplete="off" required="" />
			<form:errors path="name" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="code">Code:</label>
			<form:input type="text" path="code" class="form-control" id="code"
				autocomplete="off" required="" />
			<form:errors path="code" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="weightRange">Weight Range:</label>
			<form:input type="text" path="weightRange" class="form-control" id="weightRange"
				autocomplete="off" required="" />
			<form:errors path="weightRange" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="purpose">Purpose:</label>
			<form:input type="text" path="purpose" class="form-control" id="purpose"
				autocomplete="off" required="" />
			<form:errors path="purpose" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="permitType">Permit Type:</label>
			<form:input type="text" path="permitType" class="form-control" id="permitType"
				autocomplete="off" required="" />
			<form:errors path="permitType" cssClass="error" />
		</div>
		<div class="col-md-2">
				<label for="status">Status:</label> <select class="form-control"
					name="status" id="status">
					<option>Active</option>
					<option>Inactive</option>
				</select>
			</div>
	</div>
</form:form>		