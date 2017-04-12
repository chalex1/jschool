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

<div class="container">
    <div class="col-sm-12 col-lg-6">
        <h3>New category:</h3>
        <div class="form-group">
            <label>Category name</label>
            <input type="text" class="newcategory form-control" maxlength="50"/>
        </div>
        <input type="button" class="sendnewcategorybtn btn btn-default" value="Add"/>
        <input type="button" class="cancel-save-btn btn btn-default" value="Cancel"/>
    </div>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/newcategory.js"></script>
</body>
</html>
