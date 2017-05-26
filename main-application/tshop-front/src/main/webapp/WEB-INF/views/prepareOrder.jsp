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

    <link href="static/styles/payment/modal.css" rel="stylesheet" type="text/css">
    <script src="static/js/payment/ipay.js"></script>
    <script type="text/javascript">
        var ipay = new IPAY({api_token: "YRF3C5RFICWISEWFR6GJ"});
    </script>

</head>
<body>
<script src="static/js/payment/ipay-modal.js"></script>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

<div class="container">
    <input class="hidden order-id" value="${id}"/>
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
    <input type="button" class="pay-by-card btn btn-default disabled" value="Pay by card"/><br><br>
    <input type="button" class="pay-by-card pay-by-card-sber btn btn-default disabled" value="Pay by sber card"/><br><br>
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
    <input type="button" class="discart-order-btn btn btn-default" value="Discart order"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/prepareorder.js"></script>
</body>
</html>
