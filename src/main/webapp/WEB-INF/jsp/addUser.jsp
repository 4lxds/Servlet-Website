<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Add New User</h2>
<form action="users" method="post">
    <input type="hidden" name="action" value="add">
    <label>Username:</label><br>
    <input type="text" name="userName"><br><br>
    <label>Email:</label><br>
    <input type="email" name="email"><br><br>
    <label>Password:</label><br>
    <input type="password" name="password"><br><br>
    <input type="submit" value="Add User">
</form>
</body>
</html>
