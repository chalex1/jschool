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

        Your order number is: <h4><span class="order-number"></span></h4>

        Status: <h4><span class="order-status"></span></h4>

        Delivering method: <h4><span class="order-delivery"></span></h4>

        Address: <h4><span class="order-address"></span></h4>

        Goods: <h4><span class="order-goods"></span></h4>

        Total price: <h4><span class="order-price"></span></h4>

        <input type="button" class="ok-btn btn btn-default" value="Ok"/>
        <%--<input type="button" class="goods-rtrn-btn btn btn-default" value="Cancel"/>--%>
    </div>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/orderInfo.js"></script>
</body>
</html>

