<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Fuel Station</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="fuelStation">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/fuel-Station' />">
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
		<div class="row">
			<div class="col-md-1">
				<label for="code">Code:</label>
				<form:input type="text" path="code" class="form-control" id="code"
					autocomplete="off" required="" />
				<form:errors path="code" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="name">Name:</label>
				<form:input type="text" path="name" class="form-control" id="name"
					autocomplete="off" required="" />
				<form:errors path="name" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="phoneNo">Phone No:</label>
				<form:input type="text" path="phoneNo" class="form-control"
					autocomplete="off" id="phoneNo" required="" />
				<form:errors path="phoneNo" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="mobileNo">Mobile No:</label>
				<form:input type="text" path="mobileNo" class="form-control"
					autocomplete="off" id="mobileNo" required="" />
				<form:errors path="mobileNo" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="address">Address:</label>
				<form:textarea class="form-control" path="address"
					autocomplete="off" />

				<form:errors path="address" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="status">Status:</label> <select class="form-control"
					name="status" id="status">
					<option>Active</option>
					<option>Inactive</option>
				</select>
			</div>

			<div class="col-md-2">
				<label for="typesOfFuel">TypesOfFuel:</label>
				<form:input type="text" class="form-control" path="typesOfFuel"
					autocomplete="off" id="typeOfFuel" required=""/>
				<form:errors path="typesOfFuel" cssClass="error" />
			</div>
		</div>
	</div>
</form:form>