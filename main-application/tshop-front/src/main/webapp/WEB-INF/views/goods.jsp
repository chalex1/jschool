<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 28.03.2017
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

<div>
    Название <input type="text" class="filter-goods-name"/>
    Цена от <input type="text" class="filter-goods-price-from"/>
    Цена до <input type="text" class="filter-goods-price-to"/>
    Показывать пустые <input type="checkbox" class="filler-goods-show-empty"/>
    <input type="button" class="find-goods-btn" value="Find"/>
</div>

<input type="button" value="Add" class="add-new-goods-btn"/>
<div class="goods"></div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/goods.js"></script>
</body>
</html>
