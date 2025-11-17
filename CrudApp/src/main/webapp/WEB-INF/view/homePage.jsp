<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Products Data</h1>

    <div class="mb-3">
        <form:form action="addProduct" method="get">
            <input type="submit" class="btn btn-success" value="Add new Product"/>
        </form:form>
    </div>

    <div class="table-responsive tbl-div">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Show Details</th>
                <th scope="col">Add/Update</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productsList}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>
                        <form:form action="showProductDetails" method="get">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="submit" class="btn btn-primary" value="View Details"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="updateProduct" method="get">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="submit" class="btn btn-warning" value="Add/Update Details"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="deleteProduct" method="get">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="submit" class="btn btn-danger" value="Delete"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
