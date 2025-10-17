<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">
</head>
<body>
<div class="form-container">
    <h1>User Form</h1>

    <form:form action="processForm" modelAttribute="user" method="post">
    User Name  <form:input type="text" placeholder="username" path="username" />
        <form:errors path="username" cssClass="error"/>   <br><br>
     Password   <form:input type="password" placeholder="password" path="password" /><br><br>


        age <form:input type="text" placeholder="age" path="age" />
        <form:errors path="age" cssClass="error"/>   <br><br>


        email <form:input type="text" placeholder="email" path="email" />
        <form:errors path="email" cssClass="error"/>   <br><br>

        phone <form:input type="text" placeholder="phone" path="phone" />
        <form:errors path="phone" cssClass="error"/>   <br><br>


     Country   <form:select path="country">
            <form:option value="us">US</form:option>
            <form:option value="australia">AUS</form:option>
            <form:option value="egypt">Egypt</form:option>
            <form:option value="germany">Germany</form:option>
        </form:select>

        <p>Preferred programming Languages </p>
        Java <form:radiobutton path="programmingLanguage" value="Java"/>
        C# <form:radiobutton path="programmingLanguage" value="C#"/>
        C++ <form:radiobutton path="programmingLanguage" value="C++"/>
        C <form:radiobutton path="programmingLanguage" value="C"/>
        <br>

        <p>Preferred Operating Systems </p>
        Windows <form:checkbox path="operatingSystems" value="Windows"/>
        Mac <form:checkbox path="operatingSystems" value="Mac"/>
        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        <br>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
