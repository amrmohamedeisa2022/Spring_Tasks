<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">
</head>
<body>
<div class="form-container">
    <h1>User Form</h1>
    <form:form action="processForm" modelAttribute="user">
        <form:input type="text" placeholder="username" path="username" /><br><br>
        <form:input type="password" placeholder="password" path="password" /><br><br>

        <form:select path="country">
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

        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
