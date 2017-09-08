<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="resources/css/core.css" var="coreCss" />
<spring:url value="resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<title>Home Appliance Shop</title>
</head>

<jsp:include page="loginHeader.jsp" />
<body>
	<div class="container top50">
		<form:form method="post" action="addcustomer" commandName="customer">
			<h3 class="text-success text-center">New Customer Details</h3>
			<table class="table table-striped top50">
				<tr>
					<td><form:label path="customerId">
							<spring:message code="label.customerId" />
						</form:label></td>
					<td><form:input path="customerId" /></td>
				</tr>
				<tr>
					<td><form:label path="firstName">
							<spring:message code="label.firstName" />
						</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">
							<spring:message code="label.lastName" />
						</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="emailId">
							<spring:message code="label.emailId" />
						</form:label></td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="phoneNumber">
							<spring:message code="label.phoneNumber" />
						</form:label></td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td><form:label path="address">
							<spring:message code="label.address" />
						</form:label></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="city">
							<spring:message code="label.city" />
						</form:label></td>
					<td><form:input path="city" /></td>
				</tr>
			</table>
			<div class="top50 row">
				<div class="col left250">
					<button type=submit class="btn btn-success">Create User</button>
				</div>
				<div class="col-2">
					<button type="button" class="btn btn-success"
						onclick="location.href='/SpringsSecurityLoginForm/login'">Go to Login Page</button>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>