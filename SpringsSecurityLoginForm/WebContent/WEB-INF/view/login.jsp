<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title>Home Appliances Shop</title>
<spring:url value="/resources/css/core.css" var="coreCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<jsp:include page="loginHeader.jsp" />

<body>
	<form action="<c:url value='j_spring_security_check'/>" method="POST"
		class="loginForm">
		<div class="container">
			<div class="top150">
				<div class="row justify-content-around">

					<div class="col-sm-4">

						<div class="login-margin">
							<input type="text" class="form-control" name="j_username"
								placeholder="Username">
						</div>

						<div class="login-margin">
							<input type="password" class="form-control" name="j_password"
								placeholder="Password">
						</div>

						<div class="login-margin">
							<button type="submit" class="btn btn-info btn-block">Submit</button>
						</div>

					</div>

					<div class="col-sm-4">
						<p class="lead">
							Register now for <span class="text-success">FREE</span>
						</p>
						<ul class="list-unstyled" style="line-height: 2">
							<li><span class="fa fa-check text-success"></span> See all
								new appliances</li>
							<li><span class="fa fa-check text-success"></span> See all
								your orders</li>
							<li><span class="fa fa-check text-success"></span> Save your
								favorites</li>
						</ul>
						<p>
							<a href="/SpringsSecurityLoginForm/newcustomer" class="btn btn-info btn-block">Register
								now!</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</form>


	<jsp:include page="footer.jsp" />

</body>
</html>