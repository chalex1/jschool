<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 07.04.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>

<%--<nav class="menu navbar">--%>
<%--<div class="container">--%>
<%--<ul class="menuclass nav nav-pills">--%>
<%--<li><a href="/">Home</a></li>--%>
<%--<li><a href="goods">Goods</a></li>--%>
<%--<li><a href="orders">Orders</a></li>--%>
<%--<li><a href="categories">Categories</a></li>--%>
<%--<li><a href="cart">Cart</a></li>--%>

<%--</ul>--%>
<%--<ul class="nav nav-pills navbar-right">--%>
<%--<li><a href="client?id=1">User info</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</nav>--%>
<nav class="navbar ">

    <div class="container delimiter">
        <div class="navbar-header">
            <img src="static/img/2pedalss.png"/>
            <a class="navbar-brand" href="#">Two Pedals</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="goods">Bikes</a></li>
                <li><a href="orders">Orders</a></li>
                <li><a href="categories">Categories</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="cart">Cart</a></li>
                <li><a href="client?id=1">User info</a></li>
            </ul>

        </div>

    </div>
</nav>

<div class="container">
    <span id="errorMessage" class="bg-info"></span>
</div>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<br>
