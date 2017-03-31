<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Associate</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="associate">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/associate' />">
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
				<label for="number">Number:</label>
				<form:input type="text" path="number" class="form-control"
					id="number" autocomplete="off" required="" />
				<form:errors path="number" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="firstName">FirstName:</label>
				<form:input type="text" path="firstName" class="form-control"
					id="firstName" autocomplete="off" required="" />
				<form:errors path="firstName" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="lastName">LastName:</label>
				<form:input type="text" path="lastName" class="form-control"
					id="lastName" autocomplete="off" required="" />
				<form:errors path="lastName" cssClass="error" />
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
				<label for="email">Email:</label>
				<form:input type="text" path="email" class="form-control"
					autocomplete="off" id="email" required="" />
				<form:errors path="email" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="dob">DOB:</label>
				<form:input type="text" path="dob" class="form-control"
					autocomplete="off" id="dob" required="" />
				<form:errors path="dob" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="licenceNo">Licence No:</label>
				<form:input type="text" path="licenceNo" class="form-control"
					autocomplete="off" id="licenceNo" required="" />
				<form:errors path="licenceNo" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="licenceValidUpto">Licence Valid Upto:</label>
				<form:input type="text" path="licenceValidUpto" class="form-control"
					autocomplete="off" id="licenceValidUpto" required="" />
				<form:errors path="licenceValidUpto" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="address">Address:</label>
				<form:textarea class="form-control" path="address"
					autocomplete="off" />
				<form:errors path="address" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="notes">Notes:</label>
				<form:textarea class="form-control" path="notes" autocomplete="off" />
				<form:errors path="notes" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="status">Status:</label> <select class="form-control"
					name="status" id="status">
					<option>Active</option>
					<option>Inactive</option>
				</select>
			</div>
		</div>
	</div>
</form:form>