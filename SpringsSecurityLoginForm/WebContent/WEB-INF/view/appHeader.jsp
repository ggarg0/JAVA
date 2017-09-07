<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Home Appliances Shop</title>

<spring:url value="/resources/css/core.css" var="coreCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/logout" var="logout" />

<nav class="navbar navbar-light" style="background-color: #5bc0de;">
	<div class="row">
	
	<div class="col-4">
			<a class="navbar-brand" href="/../SpringsSecurityLoginForm/getAllProducts"> <img
				src="/../SpringsSecurityLoginForm/resources/images/icon.jpg"
				width="120" height="90" alt="">
			</a>
		</div>
		<div class="col-6 text-nowrap">
			<div class="top20">
				<span class="navbar-text">
					<h1>Home Appliances Shop</h1>
				</span>
			</div>
		</div>

		<div class="col">
			<div class="top50">
				<a class="navbar-brand" href="/../SpringsSecurityLoginForm/logout">Logout</a>
			</div>
		</div>
	</div>
</nav>




