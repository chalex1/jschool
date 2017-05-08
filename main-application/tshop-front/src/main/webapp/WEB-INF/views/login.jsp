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
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

<div class="container">
    <h3>Please, sign in </h3>
    <form action="login" method="post">
        <input type="text" name="username"/>
        <input type="password" name="userpassword"/>
        <input type="submit" value="submit" class="btn btn-default"/>
    </form>
    <h3>or <a href="clientnew"> create a new account</a></h3>

</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/goods.js"></script>
</body>
</html>

