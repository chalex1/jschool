<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 11.04.2017
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>


<div class="cart">

</div>
<input type="button" class="order-btn" value="Make an order"/>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/cart.js"></script>
</body>
</html>
