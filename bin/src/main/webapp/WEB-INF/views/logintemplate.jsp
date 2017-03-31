<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
table{
background-color: #7FFFD4;
table-align: middle;
text-align: middle;
}
tr:first-child{
			font-weight: bold;
			
			
			text-align: middle;
		}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>

<div class="container">
	<tiles:insertAttribute name="header" /> 
	<article>
	<table >
		<tr><tiles:insertAttribute name="body" />	</tr>
	</table>
	</article>
	<tiles:insertAttribute name="footer" />


</div>
</body>
</html>