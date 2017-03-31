<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

	<h2>New product vendor</h2>
 
 <form:form method="POST" class="form-vertical" modelAttribute="productVendor">
	<form:input type="hidden" path="id" id="id" />
	<div class="form-group">
		<div>
			<br> <a href="<c:url value='/list/product-vendor' />">
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
			<label for="averageLeadTime">Average Lead Time:</label>
			<form:input type="text" path="averageLeadTime" class="form-control" id="averageLeadTime"
				autocomplete="off" required="" />
			<form:errors path="averageLeadTime" cssClass="error" />
		</div>
	
		<div class="col-md-2">
			<label for="standardPrice">Standard Price:</label>
			<form:input type="text" path="standardPrice" class="form-control" id="standardPrice"
				autocomplete="off" required="" />
			<form:errors path="standardPrice" cssClass="error" />
		</div>
		
		<div class="col-md-2">
			<label for="lastReceiptCost">Last Receipt Cost:</label>
			<form:input type="text" path="lastReceiptCost" class="form-control" id="lastReceiptCost"
				autocomplete="off" required="" />
			<form:errors path="lastReceiptCost" cssClass="error" />
		</div>
		    
		<div class="col-md-2">
			<label for="lastReceiptDate">Last Receipt Date:</label>
			<form:input type="text" path="lastReceiptDate" class="form-control" id="lastReceiptDate"
				autocomplete="off" required="" />
			<form:errors path="lastReceiptDate" cssClass="error" />
		</div>
			
		<div class="col-md-2">
			<label for="minOrderQty">Min Order Qty:</label>
			<form:input type="text" path="minOrderQty" class="form-control" id="minOrderQty"
				autocomplete="off" required="" />
			<form:errors path="minOrderQty" cssClass="error" />
		</div>
		    
		<div class="col-md-2">
			<label for="maxOrderQty">Max Order Qty:</label>
			<form:input type="text" path="maxOrderQty" class="form-control" id="maxOrderQty"
				autocomplete="off" required="" />
			<form:errors path="maxOrderQty" cssClass="error" />
		</div>
		    
		<div class="col-md-2">
			<label for="onOrderQty">On Order Qty:</label>
			<form:input type="text" path="onOrderQty" class="form-control" id="onOrderQty"
				autocomplete="off" required="" />
			<form:errors path="onOrderQty" cssClass="error" />
		</div>
		
		<div class="col-md-2">
			<label for="unitMeasureCode">Unit Measure Code:</label>
			<form:input type="text" path="unitMeasureCode" class="form-control" id="unitMeasureCode"
				autocomplete="off" required="" />
			<form:errors path="unitMeasureCode" cssClass="error" />
		</div>
		</div>
	</form:form>				