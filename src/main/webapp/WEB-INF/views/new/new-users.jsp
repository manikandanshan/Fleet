<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/bootstrap/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">

		<div class="well lead">User Registration Form</div>
	 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First Name</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">User ID</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="number">Number</label>
					<div class="col-md-7">
						<form:input type="text" path="number" id="number" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="number" class="help-inline"/>
						</div>
					</div>
				</div>
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
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
					<div class="col-md-7">
						<form:select path="roles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="roles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> 
							<a class="btn btn-primary" href="<c:url value='/list/user' />">Close</a> 
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> 
							<a class="btn btn-primary" href="<c:url value='/list/user' />">Close</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>