<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
	header {
    padding: 1em;
    color: black;
    background-color: lightblue;
    clear: left;
    
}
</style>
</head>
<body>
<header>
  
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  
     &nbsp;
     <a class="btn btn-info pull-right" href="${pageContext.request.contextPath}/logout">Logout</a>
     
  </c:if>

<h1 style="text-align: center;">Asset Management Platform</h1>								
<h3 style="text-align: right;">-Designed to make your job easier..</h3>		
</header>
</body>
</html>