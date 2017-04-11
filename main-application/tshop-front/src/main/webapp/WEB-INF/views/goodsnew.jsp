<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 11.04.2017
  Time: 12:07
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
    <input type="text" class="goods-name"/> Name<br>
    <input type="number" min="0" class="goods-price"/> Price <br>
    <input type ="text" class="goods-brand"/> Brand <br>
    <input type="text" class="goods-colour"/> Colour <br>
    <input type="text" class="goods-info"/> Info <br>
    <input type="number" min="0" class="goods-weight"/> Weight<br>
    <input type="number" min="0" class="goods-volume"/> Volume<br>
    <input type="number" min="0" class="goods-quantity"/> Quantity<br>
    <div class="goods-categories">

    </div>
    <input type="button" class="goods-save-btn" value ="Save"/>
</div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/goodsNew.js"></script>
</body>
</html>
