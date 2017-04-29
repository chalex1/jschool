<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 11.04.2017
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

<input class="hidden goods-id" value="${id}"/>

<div class="container">
    <div class="col-sm-12 col-lg-6">
        <div class="form-group">
            <label>Model</label>
            <input type="text" class="goods-model form-control"/>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" min="0" class="goods-price form-control"/>
        </div>
        <div class="form-group">
            <label>Engine Type</label>
            <input type="text" class="goods-enginetype form-control"/>
        </div>
        <div class="form-group">
            <label>Color</label>
            <input Colourtype="text" class="goods-colour form-control"/>
        </div>
        <div class="form-group">
            <label>Transmission</label>
            <input type="text" class="goods-transmission form-control"/>
        </div>
        <div class="form-group">
            <label>Weight</label>
            <input type="number" min="0" class="goods-weight form-control"/>
        </div>
        <div class="form-group">
            <label>Volume</label>
            <input type="number" min="0" class="goods-volume form-control"/>
        </div>
        <div class="form-group">
            <label>Quantity</label>
            <input type="number" min="0" class="goods-quantity form-control"/>
        </div>
        <div class="form-group">
            <label>Categories</label>
            <div class="goods-categories">

            </div>
        </div>

        <input type="button" class="goods-save-btn btn btn-default" value="Save"/>
        <input type="button" class="goods-rtrn-btn btn btn-default" value="Cancel"/>
    </div>

</div>


<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/goodsDetailed.js"></script>
</body>
</html>
