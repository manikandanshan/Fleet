<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Vehicle</h2>

<form:form method="POST" class="form-vertical" modelAttribute="vehicle">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/vehicle' />">
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
			<label for="make">Make:</label>
			<form:input type="text" path="make" class="form-control" id="make"
				autocomplete="off" required="" />
			<form:errors path="make" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="model">Model:</label>
			<form:input type="text" path="model" class="form-control" id="model"
				autocomplete="off" required="" />
			<form:errors path="model" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="year">Year:</label>
			<form:input type="text" path="year" class="form-control" id="year"
				autocomplete="off" required="" />
			<form:errors path="year" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="color">Color:</label>
			<form:input type="text" path="color" class="form-control" id="color"
				autocomplete="off" required="" />
			<form:errors path="color" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="vin">VIN:</label>
			<form:input type="text" path="vin" class="form-control" id="vin"
				autocomplete="off" required="" />
			<form:errors path="vin" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="fuelCapacity">Fuel Capacity:</label>
			<form:input type="text" path="fuelCapacity" class="form-control"
				id="fuelCapacity" autocomplete="off" required="" />
			<form:errors path="fuelCapacity" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="engineNo">Engine No:</label>
			<form:input type="text" path="engineNo" class="form-control"
				id="engineNo" autocomplete="off" required="" />
			<form:errors path="engineNo" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="odometerType">Odometer Type:</label>
			<form:input type="text" path="odometerType" class="form-control"
				id="odometerType" autocomplete="off" required="" />
			<form:errors path="odometerType" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="departmentId">Department Id:</label>
			<form:input type="text" path="departmentId" class="form-control"
				id="departmentId" autocomplete="off" required="" />
			<form:errors path="departmentId" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="note">Note:</label>
			<form:input type="text" path="note" class="form-control" id="note"
				autocomplete="off" required="" />
			<form:errors path="note" cssClass="error" />
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