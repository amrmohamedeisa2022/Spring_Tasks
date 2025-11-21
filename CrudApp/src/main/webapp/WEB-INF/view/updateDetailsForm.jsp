<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>

<h1>Update Product</h1>

<%--@elvariable id="product" type=""--%>
<form:form action="updateProduct" method="post" modelAttribute="product">
    <form:hidden path="id" />
    <form:hidden path="productDetails.id" />
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <div class="form-group">
                    <label for="id">Product ID</label>
                    <form:input path="id" cssClass="form-control" readonly="true"/>
                </div>

                <div class="form-group">
                    <label for="name">Product Name</label>
                    <form:input path="name" cssClass="form-control" placeholder="Enter product name"/>
                    <form:errors path="name" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="expirationDate">Expiration Date</label>
                    <form:input path="productDetails.expirationDate" cssClass="form-control" placeholder="yyyy-mm-dd"/>
                </div>

                <div class="form-group">
                    <label for="manufacturer">Manufacturer</label>
                    <form:input path="productDetails.manufacturer" cssClass="form-control" placeholder="Manufacturer"/>
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input path="productDetails.price" cssClass="form-control" placeholder="Price"/>
                </div>

                <div class="form-group">
                    <label for="available">Availability</label>
                    <form:input path="productDetails.available" cssClass="form-control" placeholder="true or false"/>
                </div>

                <input type="submit" class="btn btn-primary" value="Update Product"/>
            </div>
        </div>
    </div>
</form:form>

</body>
</html>