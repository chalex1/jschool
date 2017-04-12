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

<div class="container">

    <input type="button" value="Add Bike" class="add-new-goods-btn btn btn-default"/>
    <br>
    <br>
    <br>
    <div class="form-inline">
        <div class="form-group">
            <label class="sr-only" for="filterGoodsName">Model</label>
            <input type="text" id="filterGoodsName" class="filter-goods-name form-control" placeholder="Model"/>
        </div>
        <div class="form-group">
            <label class="sr-only" for="filterGoodsPriceFrom">Price from</label>
            <input type="number" class="filter-goods-price-from form-control" id="filterGoodsPriceFrom"
                   placeholder="Price from"/>
        </div>
        <div class="form-group">
            <input type="number" class="filter-goods-price-to form-control" placeholder="Price to"/>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" class="filler-goods-show-empty"/> In stock
            </label>
        </div>
        <input type="button" class="find-goods-btn btn btn-default" value="Find"/>
    </div>
    <br>

    <div class="goods"></div>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/goods.js"></script>
</body>
</html>
