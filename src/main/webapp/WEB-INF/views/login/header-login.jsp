<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>  
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>


	
<style>
	header {
    padding: 0.5em;
    color: black;
    background-color: lightblue;
    clear: left;
    
}
</style>

<header>
<h1 style="text-align: center;">Asset Management Platform	</h1>								
<h3 style="text-align: right;">-Designed to make your job easier..</h3>		
</header>



<%-- <hr style="margin-bottom: 50px; margin-top: 0px;">
<!-- /header container-->
   <div class="container">
    <div class="row">
        <div class="col-md-12">
        <img src="${pageContext.request.contextPath}/static/img/AMP.jpg" style="width: 100%;" alt="RAIN Logo">
        </div>
        </div>
        </div> --%>
        <!-- <div class="col-md-1"></div>
        <div class="col-md-3"><div> -->
        <!-- <div class="container"> -->
  <%-- <c:if test="${not empty error}">
   <div class="alert alert-danger" role="alert">${error}</div>
  </c:if> --%>
  
  
  <%-- <div class="jumbotron text-center">
    <div class="container">
      <div class="row">
        <div class="col col-lg-12 col-sm-12">
         <div><img src="${pageContext.request.contextPath}/static/img/watsinit_logo.jpg" height="5%" style="width: 100%;" alt="WatsInIt Logo"></div> 
          <div><img src="${pageContext.request.contextPath}/resources/img/Vel_Tech_Logo.png" style="width: 60%;" alt="WatsInIt Logo"></div> 
        </div>
      </div>
    </div> 
</div> --%>
<%-- <hr style="margin-bottom: 50px; margin-top: 0px;">
<!-- /header container-->
   <div class="container">
    <div class="row">
        <div class="col-md-8">
        <img src="${pageContext.request.contextPath}/static/img/rain_logo.jpg" style="width: 100%;" alt="RAIN Logo">
        </div></div>
        <div class="col-md-1"></div>
        <div class="col-md-3"><div>
        <!-- <div class="container"> -->
		
        <div class="col-md-4">
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
		  </div>
		  </div> --%>
  