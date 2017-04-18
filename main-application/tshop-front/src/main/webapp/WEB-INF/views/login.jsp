<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 14.04.2017
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="username"/>
    <input type="password" name="userpassword"/>
    <input type="submit" value="Login"/>
</form>

</body>
</html>
