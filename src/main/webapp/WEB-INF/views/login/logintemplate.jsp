<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	<tiles:insertAttribute name="header-login" /> 
	
	<!-- <div class="row"> -->
  <div class="col-md-6">
          <tiles:insertAttribute name="menu-login" />
  </div>
    <div class="col-md-6">
      <tiles:insertAttribute name="body-login" />

  <!-- </div> -->
  
  </div>
	<%-- <article>
	<table >
		<tr><tiles:insertAttribute name="body" />	</tr>
	</table>
	</article> --%>
	<tiles:insertAttribute name="footer-login" />

</body>
</html>