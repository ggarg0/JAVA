<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrap.min.css" />
<link href="${bootstrap.min.css}" rel="stylesheet" />
    <title>Home Appliances Shop</title>
</head>
<jsp:include page="appHeader.jsp" />
<body>

  

<div class="container">
<div class="top50">
<c:if  test="${!empty employeeList}">
<table class="table table-striped">

<tr>
    <th>Employee Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Job Id</th>
    <th>Salary</th>
    <th>Manager Id</th>    
    <th>Department Id</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td><a href="editEmp/${emp.id}"> ${emp.id}</a></td>
        <td>${emp.firstname} </td>
        <td>${emp.lastname} </td>
        <td>${emp.email} </td>
        <td>${emp.telephone} </td>
        <td>${emp.jobid} </td>
                
        <td>${emp.salary}</td>
        <td>${emp.managerid}</td>
        <td>${emp.departmentid}</td>
       
    </tr>
</c:forEach>
</table>
</c:if>
</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>