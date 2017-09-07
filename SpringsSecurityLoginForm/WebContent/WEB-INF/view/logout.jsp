<html>
<head>
<title>Home Appliances Shop</title>
</head>
<jsp:include page="loginHeader.jsp" />
<body>

	<% session.invalidate(); %>
	<div class="container">
		<div class="top150">
			<div class="row justify-content-around">

				<div class="col-sm-4">
					<p class="lead">
						<span class="text-error">You are now logged out!!</span>
					</p>
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