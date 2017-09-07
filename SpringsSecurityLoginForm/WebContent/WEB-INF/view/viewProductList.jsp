<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrap.min.css" />
<link href="${bootstrap.min.css}" rel="stylesheet" />
<title>Home Appliances Shop</title>
</head>
<jsp:include page="appHeader.jsp" />
<body>
<div class="top20">
	<div class="container">
			<div class="row">
				<div class="button-margin">
					
				<c:if test="${!empty model.categoryList}">
					<c:forEach items="${model.categoryList}" var="category">
						<button type="button" class="btn btn-outline-info" 
						onclick="location.href='/SpringsSecurityLoginForm/getProductByCategory/${category.categoryId}'">
						${category.categoryName}</button>
					</c:forEach>
				</c:if>
			</div>
</div>

			
			<div class="top20">
				<c:if test="${!empty model.productList}">
					<table class="table table-striped">

						<tr>
							<th>Product Name</th>
							<th>Product Price</th>
							<th>Product Description</th>
							<th>Available Quantity</th>
							<th>Order</th>
						</tr>
						<c:forEach items="${model.productList}" var="product">
							<tr>
								<td>${product.productName}</td>
								<td>${product.productPrice}</td>
								<td>${product.productDescription}</td>
								<td>${product.avaliableQuantity}</td>
								<td><button type="button" class="btn btn-success">Order</button></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>