<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 07.04.2017
  Time: 23:07
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
    <div class="col-sm-12 col-lg-6">
        <h3>Categories</h3>
        <input type="button" value="Add" class="addNewCategoryBtn btn btn-default"/>
        <div class="categories "></div>
    </div>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/category.js"></script>
</body>
</html>
