<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 09.04.2017
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

Введите название новой категории:

<div>
    <input type="text" class="newcategory" maxlength="50"/>
    <input type="button" class="sendnewcategorybtn" value="Добавить"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/newcategory.js"></script>
</body>
</html>
