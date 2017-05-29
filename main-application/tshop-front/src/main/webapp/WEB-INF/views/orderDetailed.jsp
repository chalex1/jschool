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

    <div class="col-sm-12 col-lg-6">
        <div class="form-group">
            <label>Categories</label>
            <select class="form-control order-payment-method">
                <option value="CASH">Cash</option>
                <option value="CARD">Card</option>
            </select>
        </div>

        <div class="form-group">
            <label>Delivery method</label>
            <select class="form-control order-delivery-method">
                <option value="DELIVERY">Delivery</option>
                <option value="PICKUP">Pickup</option>
            </select>
        </div>

        <%--<div class="form-group">--%>
        <%--<label>Categories</label>--%>
        <%--<select class="order-payment-status">--%>
        <%--<option value="NOTPAYED">Not payed</option>--%>
        <%--<option value="PAYED">Payed</option>--%>
        <%--</select>--%>
        <%--</div>--%>


        <div class="form-group">
            <label>Status</label>
            <select class="form-control order-status">
                <option value="INIT">INIT</option>
                <option value="PROCESS">PROCESS</option>
                <option value="PAID">PAID</option>
                <option value="DISCARDED">DISCARDED</option>
            </select>
        </div>

        <input type="button" class="order-save-btn btn btn-default" value="Save"/>
        <input type="button" class="goods-rtrn-btn btn btn-default" value="Cancel"/>
    </div>


</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/orderDetailed.js"></script>
</body>
</html>
