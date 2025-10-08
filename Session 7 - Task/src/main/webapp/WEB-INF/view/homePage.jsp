<html>
<head>

    <title>User Profile Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<h1>User Profile Form</h1>

<form action="saveUser" method="post" >
    <label>First Name:</label>
    <input type="text" name="firstName" placeholder="Enter your first name" required><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" placeholder="Enter your last name" required><br>

    <label>Email:</label>
    <input type="email" name="email" placeholder="Enter your email" required><br>

    <label>Date of Birth:</label>
    <input type="date" name="dateOfBirth" required><br>

    <label>City:</label>
    <input type="text" name="city" placeholder="Enter your city" required><br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
