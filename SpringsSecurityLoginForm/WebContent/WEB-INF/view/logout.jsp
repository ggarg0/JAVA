<html>
<head>
    <title>Home Appliances Shop</title>
</head>
<jsp:include page="header.jsp" />
<body>
<% session.invalidate(); %>
You are now logged out!!
<%-- <jsp:forward page="/login"></jsp:forward> --%>
<%  response.sendRedirect("/SpringsSecurityLoginForm/login");%>
<jsp:include page="footer.jsp" />
</body>
</html>