<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 11.04.2017
  Time: 21:21
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


    <select class="order-payment-method">
        <option value="CASH">Cash</option>
        <option value="CARD">Card</option>
    </select>

    <select class="order-delivery-method">
        <option value="DELIVERY">Delivery</option>
        <option value="PICKUP">Pickup</option>
    </select>

    <select class="order-payment-status">
        <option value="NOTPAYED">Not payed</option>
        <option value="PAYED">Payed</option>
    </select>


    <select class="order-status">
        <option value="INIT">INIT</option>
        <option value="ARRANGED">ARRANGED</option>
        <option value="READY">READY</option>
    </select>
    
    long clientId;
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/orderDetailed.js"></script>
</body>
</html>
