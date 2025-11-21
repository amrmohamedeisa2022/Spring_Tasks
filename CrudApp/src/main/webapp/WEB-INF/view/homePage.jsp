<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>

<h1>Products Data</h1>
<div class="tbl-div container mt-4">
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Show Details</th>
            <th>Add/Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>

                <td>
                    <form:form action="showProductDetails" method="get">
                        <input type="hidden" name="id" value="${item.id}" />
                        <input type="submit" class="btn btn-primary" value="View Details"/>
                    </form:form>
                </td>

                <td>
                    <form:form action="showUpdateForm" method="get">
                        <input type="hidden" name="id" value="${item.id}" />
                        <input type="submit" class="btn btn-warning" value="Add/Update"/>
                    </form:form>
                </td>

                <td>
                    <form:form action="deleteProduct" method="get">
                        <input type="hidden" name="id" value="${item.id}" />
                        <input type="submit" class="btn btn-danger" value="Delete"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="mt-3">
        <form:form action="addProductForm" method="get">
            <input type="submit" class="btn btn-success" value="Add new Product"/>
        </form:form>
    </div>
</div>
</body>
</html>