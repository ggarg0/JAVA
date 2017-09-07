<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Home Appliances Shop</title>

<spring:url value="resources/css/core.css" var="coreCss" />
<spring:url value="resources/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/logout" var="logout" />

<nav class="navbar navbar-light" style="background-color: #5bc0de;">
 <div class="row">
  <div class="col-4">
    <img src="resources/images/icon.jpg" alt="An image to show the text doesn't wrap">
  </div>
  <div class="col-7 text-nowrap">
  <div class="top50">
  <span class="navbar-text">

    <h1>Home Appliances Shop</h1>
  </span>
  
   </div>
  </div>
 
</div>
</nav>
