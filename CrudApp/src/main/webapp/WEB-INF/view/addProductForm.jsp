<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<form:form action="processAddProduct" modelAttribute="detailsModel" method="post">
    <div class="container mt-5">


        <div class="form-group">
            <label for="name">Product Name</label>
            <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
            <form:errors path="name" cssClass="error"/>
        </div>


        <div class="form-group">
            <label for="expirationDate">Expiration Date</label>
            <form:input type="text" cssClass="form-control" path="expirationDate" placeholder="dd/mm/yyyy"/>
            <form:errors path="expirationDate" cssClass="error"/>
        </div>


        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input type="text" cssClass="form-control" path="manufacturer" placeholder="Manufacturer"/>
            <form:errors path="manufacturer" cssClass="error"/>
        </div>


        <div class="form-group">
            <label for="price">Price</label>
            <form:input type="text" cssClass="form-control" path="price" placeholder="Price"/>
            <form:errors path="price" cssClass="error"/>
        </div>


        <div class="form-group">
            <label for="available">Availability</label>
            <form:input type="text" cssClass="form-control" path="available" placeholder="0 or 1"/>
            <form:errors path="available" cssClass="error"/>
        </div>

        <input type="submit" class="btn btn-primary"/>
    </div>
</form:form>

</body>
</html>
