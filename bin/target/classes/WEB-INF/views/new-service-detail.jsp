<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Service Detail</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="serviceDetail">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/service-detail' />">
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
			<label for="activity">Activity:</label>
			<form:input type="text" path="activity" class="form-control"
				id="activity" autocomplete="off" required="" />
			<form:errors path="activity" cssClass="error" />
		</div>

		<div class="col-md-2">
			<label for="amount">Amount:</label>
			<form:input type="text" path="amount" class="form-control"
				id="amount" autocomplete="off" required="" />
			<form:errors path="amount" cssClass="error" />
		</div>

		<div class="col-md-2">
			<label for="vat">VAT:</label>
			<form:input type="text" path="vat" class="form-control" id="vat"
				autocomplete="off" required="" />
			<form:errors path="vat" cssClass="error" />
		</div>

		<div class="col-md-2">
			<label for="tax">TAX:</label>
			<form:input type="text" path="tax" class="form-control" id="tax"
				autocomplete="off" required="" />
			<form:errors path="tax" cssClass="error" />
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