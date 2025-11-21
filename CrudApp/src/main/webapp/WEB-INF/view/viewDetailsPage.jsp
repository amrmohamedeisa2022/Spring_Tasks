<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
</head>
<body>
<div class="container mt-5">
    <h2>Product Details</h2>
    <div class="card p-3 mt-3">
        <p><strong>Name:</strong> ${product.name}</p>
        <p><strong>Expiration:</strong> ${product.productDetails.expirationDate}</p>
        <p><strong>Manufacturer:</strong> ${product.productDetails.manufacturer}</p>
        <p><strong>Price:</strong> ${product.productDetails.price}</p>
        <p><strong>Availability:</strong>
            <c:choose>
                <c:when test="${product.productDetails.available}">Available</c:when>
                <c:otherwise>Not Available</c:otherwise>
            </c:choose>
        </p>

    </div>
    <a href="<c:url value='/addProductForm'/>" class="btn btn-primary mt-3">Add Another Product</a>
</div>
</body>
</html>