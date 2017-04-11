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

<div>
    Choose options:<br>
    <input type="radio" class="payment-method" name="payment-method" value="CASH" checked/> Cash <br>
    <input type="radio" class="payment-method" name="payment-method" value="CARD"/> Card <br>
    <br>

    <input type="radio" class="delivery-method" name="delivery-method" value="DELIVERY" checked/> Delivery <br>
    <input type="radio" class="delivery-method" name="delivery-method" value="PICKUP"/> Pickup <br>
    <input type="button" class="order-btn" value="Order"/>
    <input type="button" class="back-cart-btn" value="Back to cart"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/prepareorder.js"></script>
</body>
</html>
