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
<input class="hidden order-id" value="${id}"/>
<div class="container">
    <h3 class="payment-status-header"></h3>
    <input type="button" class="discard-btn btn btn-default hidden" value="Discard"/>
    <input type="button" class="pay-cash-btn btn btn-default hidden" value="Pay with cash"/>
    <input type="button" class="try-again-btn btn btn-default hidden" value="Try again"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/payment.js"></script>
</body>
</html>
