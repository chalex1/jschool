<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 09.04.2017
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

Название категории:

<div>
    <input class="hidden category-id" value="${id}"/>
    <input type="text" class="category-name" maxlength="50" value = "${name}"/>
    <input type="button" class="save-category-btn" value="Сохранить"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/categoryDetailed.js"></script>
</body>
</html>
