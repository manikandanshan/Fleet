<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Trip Detail</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="tripDetail">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/trip-detail' />">
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
			<label for="fromAddress">From Address:</label>
			<form:input type="text" path="fromAddress" class="form-control"
				id="fromAddress" autocomplete="off" required="" />
			<form:errors path="fromAddress" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="toAddress">To Address:</label>
			<form:input type="text" path="toAddress" class="form-control"
				id="toAddress" autocomplete="off" required="" />
			<form:errors path="toAddress" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="distance">Distance:</label>
			<form:input type="text" path="distance" class="form-control"
				id="distance" autocomplete="off" required="" />
			<form:errors path="distance" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="typeOfGood">Type Of Good:</label>
			<form:input type="text" path="typeOfGood" class="form-control"
				id="typeOfGood" autocomplete="off" required="" />
			<form:errors path="typeOfGood" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="odometerStartReading">Odometer Start Reading:</label>
			<form:input type="text" path="odometerStartReading"
				class="form-control" id="odometerStartReading" autocomplete="off"
				required="" />
			<form:errors path="odometerStartReading" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="odometerEndReading">Odometer End Reading:</label>
			<form:input type="text" path="odometerEndReading"
				class="form-control" id="odometerEndReading" autocomplete="off"
				required="" />
			<form:errors path="odometerEndReading" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="fuelConsumption">Fuel Consumption:</label>
			<form:input type="text" path="fuelConsumption" class="form-control"
				id="fuelConsumption" autocomplete="off" required="" />
			<form:errors path="fuelConsumption" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="amount">Amount:</label>
			<form:input type="text" path="amount" class="form-control"
				id="amount" autocomplete="off" required="" />
			<form:errors path="amount" cssClass="error" />
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
