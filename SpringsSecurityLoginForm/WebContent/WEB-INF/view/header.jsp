<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/css/hello.css" var="coreCss" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/logout" var="logout" />

<nav class="navbar navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home Appliances Shop</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<%-- <a href="<c:url value='j_spring_security_logout'/>">Logout</a></h4> --%>
				<li class="active"><a href="${logout}">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>