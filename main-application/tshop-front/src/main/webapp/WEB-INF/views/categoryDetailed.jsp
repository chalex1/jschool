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

<div class="container">
    <div class="col-sm-12 col-lg-6">
    <h3>Category:</h3>

        <input class="hidden category-id" value="${id}"/>
        <div class="form-group">
            <label>Category name</label>
        <input type="text" class="category-name form-control" maxlength="50"/>
        </div>
        <input type="button" class="save-category-btn btn btn-default" value="Save"/>
        <input type="button" class="cancel-save-btn btn btn-default" value="Cancel"/>
    </div>

</div>
<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/categoryDetailed.js"></script>
</body>
</html>
