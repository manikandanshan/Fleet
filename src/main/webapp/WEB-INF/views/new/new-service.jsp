<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Service</h2>

<form:form method="POST" class="form-vertical" modelAttribute="service">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/service' />">
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
			<label for="entryDate">Entry Date:</label>
			<form:input type="text" path="entryDate" class="form-control"
				id="entryDate" autocomplete="off" required="" />
			<form:errors path="entryDate" cssClass="error" />
		</div>

		<div class="col-md-2">
			<label for="releaseDate">Release Date:</label>
			<form:input type="text" path="releaseDate" class="form-control"
				id="releaseDate" autocomplete="off" required="" />
			<form:errors path="releaseDate" cssClass="error" />
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
