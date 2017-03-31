<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="assertManagement">
<head>

<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/angularjs/angular.js"></script>
<script src="${pageContext.request.contextPath}/static/js/app.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>


<body>


	<tiles:insertAttribute name="header" /> 
 
 <div class="row">
  <div class="col-md-2">
          <tiles:insertAttribute name="menu" />
    </div>
    <div class="col-md-10">
      <tiles:insertAttribute name="body" />
    </div>
  </div>
 
 <tiles:insertAttribute name="footer" />
</body>
</html>