<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

    <title>Employee Registration Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="form-container">
<h1>Employee Registration Form</h1>

<form:form action="processform" modelAttribute="employee" method="post">



    User Name  <form:input type="text" placeholder="username" path="username" />
    <form:errors path="username" cssClass="error"/>   <br><br>


    Email Address  <form:input type="text" placeholder="email" path="email" />
    <form:errors path="email"  cssClass="error"/>

    <br><br>

    Password  <form:input type="text" placeholder="password" path="password" />
    <form:errors path="password"  cssClass="error"/>

    <br><br>
    Confirm Password  <form:input type="text" placeholder="confirmPassword" path="confirmPassword" />
    <form:errors path="confirmPassword"  cssClass="error"/>

    <br><br>
    <input type="submit" value="Submit"/>
</form:form>

</div>

</body>
</html>
