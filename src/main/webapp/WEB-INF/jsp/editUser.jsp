<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Edit User</h2>
<form action="users" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${user.id}">
    <label>Username:</label><br>
    <input type="text" name="userName" value="${user.userName}"><br><br>
    <label>Email:</label><br>
    <input type="email" name="email" value="${user.email}"><br><br>
    <label>Password:</label><br>
    <input type="password" name="password"><br><br>
    <input type="submit" value="Update User">
</form>
</body>
</html>
