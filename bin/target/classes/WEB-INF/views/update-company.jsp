<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Company Updated</title>
</head>
<body>
	message : ${success}
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list/company' />">List of All Companys</a>
	Go back to<a href="<c:url value='/list/branch' />">list of Branches</a>
	
</body>

</html>
