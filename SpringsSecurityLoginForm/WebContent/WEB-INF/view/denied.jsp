<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
</head>
<jsp:include page="loginHeader.jsp" />
<body>

	<div class="container">
		<div class="top150">
			<div class="row justify-content-around">

				<div class="col-md-6">
					<c:if test="${not empty error}">
						<div style="color: red">
							<p class="lead">
						
						<span class="text-error">Login denied : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
					</p>
						</div>
					</c:if>
					
					<p>
						<a href="/SpringsSecurityLoginForm/login">Login Again</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>