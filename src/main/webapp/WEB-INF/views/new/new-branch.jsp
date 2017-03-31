<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Branch</h2>

<form:form method="POST" class="form-vertical" modelAttribute="branch">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/branch' />">
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
			<div class="col-md-2">
				<label for="name">Name:</label>
				<form:input type="text" path="name" class="form-control" id="name"
					autocomplete="off" required="" />
				<form:errors path="name" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="branchType">Branch Type:</label>
				<form:input type="text" path="branchType" class="form-control"
					id="branchType" autocomplete="off" required="" />
				<form:errors path="branchType" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="establishedDate">Established Date:</label>
				<form:input type="text" path="establishedDate" class="form-control"
					id="establishedDate" autocomplete="off" required="" />
				<form:errors path="establishedDate" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="addressLine1">Address Line1:</label>
				<form:input type="text" path="addressLine1" class="form-control"
					id="addressLine1" autocomplete="off" required="" />
				<form:errors path="addressLine1" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="addressLine2">Address Line2:</label>
				<form:input type="text" path="addressLine2" class="form-control"
					id="addressLine2" autocomplete="off" required="" />
				<form:errors path="addressLine2" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="city">City:</label>
				<form:input type="text" path="city" class="form-control" id="city"
					autocomplete="off" required="" />
				<form:errors path="city" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="state">State:</label>
				<form:input type="text" path="state" class="form-control" id="state"
					autocomplete="off" required="" />
				<form:errors path="state" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="country">Country:</label>
				<form:input type="text" path="country" class="form-control"
					id="country" autocomplete="off" required="" />
				<form:errors path="country" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="zipCode">Zip Code:</label>
				<form:input type="text" path="zipCode" class="form-control"
					id="zipCode" autocomplete="off" required="" />
				<form:errors path="zipCode" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="stdCode">STD Code:</label>
				<form:input type="text" path="stdCode" class="form-control"
					id="stdCode" autocomplete="off" required="" />
				<form:errors path="stdCode" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="contactNo1">Contact No1:</label>
				<form:input type="text" path="contactNo1" class="form-control"
					id="contactNo1" autocomplete="off" required="" />
				<form:errors path="contactNo1" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="contactNo2">Contact No2:</label>
				<form:input type="text" path="contactNo2" class="form-control"
					id="contactNo2" autocomplete="off" required="" />
				<form:errors path="contactNo2" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="fax">FAX:</label>
				<form:input type="text" path="fax" class="form-control" id="fax"
					autocomplete="off" required="" />
				<form:errors path="fax" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="url">URL:</label>
				<form:input type="text" path="url" class="form-control" id="url"
					autocomplete="off" required="" />
				<form:errors path="url" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="emailId">Email Id:</label>
				<form:input type="text" path="emailId" class="form-control" id="emailId"
					autocomplete="off" required="" />
				<form:errors path="emailId" cssClass="error" />
			</div>
		</div>
	</div>
</form:form>

