<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<h2>New Vendor Detail</h2>

<form:form method="POST" class="form-vertical"
	modelAttribute="vendorDetail">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/vendor-detail' />">
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
			<label for="identificationNo">Identification No:</label>
			<form:input type="text" path="identificationNo" class="form-control"
				id="identificationNo" autocomplete="off" required="" />
			<form:errors path="identificationNo" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="name">Name:</label>
			<form:input type="text" path="name" class="form-control" id="name"
				autocomplete="off" required="" />
			<form:errors path="name" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="preferedVendorStatus">Prefered Vendor Status:</label>
			<form:input type="text" path="preferedVendorStatus"
				class="form-control" id="preferedVendorStatus" autocomplete="off"
				required="" />
			<form:errors path="preferedVendorStatus" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="serviceType">Service Type:</label>
			<form:input type="text" path="serviceType" class="form-control"
				id="serviceType" autocomplete="off" required="" />
			<form:errors path="serviceType" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="activeFlag">Active Flag:</label>
			<form:input type="text" path="activeFlag" class="form-control"
				id="activeFlag" autocomplete="off" required="" />
			<form:errors path="activeFlag" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="contactPersonName">Contact Person Name:</label>
			<form:input type="text" path="contactPersonName" class="form-control"
				id="contactPersonName" autocomplete="off" required="" />
			<form:errors path="contactPersonName" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="contactTypeId">Contact Type Id:</label>
			<form:input type="text" path="contactTypeId" class="form-control"
				id="contactTypeId" autocomplete="off" required="" />
			<form:errors path="contactTypeId" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="url">URL:</label>
			<form:input type="text" path="url" class="form-control" id="url"
				autocomplete="off" required="" />
			<form:errors path="url" cssClass="error" />
		</div>
		<div class="col-md-2">
			<label for="address">Address:</label>
			<form:input type="text" path="address" class="form-control"
				id="address" autocomplete="off" required="" />
			<form:errors path="address" cssClass="error" />
		</div>
	</div>
</form:form>
