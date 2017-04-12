<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 11.04.2017
  Time: 18:30
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
    <h3>Choose options:</h3>
    <h4>Payment method</h4>
    <div class="radio">
        <label>
            <input type="radio" class="payment-method" name="payment-method" value="CASH" checked/>
            Cash
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" class="payment-method" name="payment-method" value="CARD"/>
            Card
        </label>
    </div>

    <h4>Delivering method</h4>
    <div class="radio">
        <label>
            <input type="radio" class="delivery-method" name="delivery-method" value="DELIVERY" checked/>
            Delivery to the account address
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" class="delivery-method" name="delivery-method" value="PICKUP"/>
            Pick up from the shop
        </label>
    </div>
    <input type="button" class="order-btn btn btn-default" value="Order"/>
    <input type="button" class="back-cart-btn btn btn-default" value="Back to cart"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/prepareorder.js"></script>
</body>
</html>
