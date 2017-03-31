<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Feature</h2>

<form:form method="POST" class="form-vertical" modelAttribute="feature">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/feature' />">
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
				<label for="id">Id:</label>
				<form:input type="text" path="id" class="form-control" id="id"
					autocomplete="off" required="" />
				<form:errors path="id" cssClass="error" />
			</div>

			<div class="col-md-2">
				<label for="name">Name:</label>
				<form:input type="text" path="name" class="form-control" id="name"
					autocomplete="off" required="" />
				<form:errors path="name" cssClass="error" />
			</div>
		</div>
	</div>
</form:form>
