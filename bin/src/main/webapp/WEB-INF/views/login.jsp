<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/bootstrap/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/bootstrap/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
		<script src='https://www.google.com/recaptcha/api.js'></script>
	</head>

	<body>
	
		<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">
						<c:url var="loginUrl" value="/login"/>
						<form action="${loginUrl} " class="form-horizontal" id="recaptcha-demo-form" method="POST">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
							</div>
							

							<div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
							
							<div id="recaptcha-demo" class="g-recaptcha" data-sitekey="6LchXxMUAAAAABMgib58BQvWwIxaUUxAEFrurcAz" data-callback="onSuccess"></div>
<br>
						<div class="form-actions">
								<input id="recaptcha-demo-submit" type="submit"
									class="btn btn-block btn-primary btn-default" value="login">
									</div>
								</form>
							</div>
							</div>
								
					</div>		
				</div>
		
			
		
		</body>
</html>




