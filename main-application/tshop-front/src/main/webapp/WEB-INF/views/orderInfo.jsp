<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 24.05.2017
  Time: 13:27
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
    <input class="hidden order-id" value="${id}"/>
    <h3>Order Info</h3>

    <div class="col-sm-12 col-lg-6">

        Your order number is: <div class="order-number"></div>

        Status: <div class="order-status"></div>

        Delivering method: <div class="order-delivery"></div>

        Address: <div class="order-address"></div>

        Goods: <div class="order-goods"></div>

        Total price: <div class="order-price"></div>

        <input type="button" class="ok-btn btn btn-default" value="Ok"/>
        <%--<input type="button" class="goods-rtrn-btn btn btn-default" value="Cancel"/>--%>
    </div>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/orderInfo.js"></script>
</body>
</html>

