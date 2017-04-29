<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 07.04.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>


<nav class="navbar ">

    <div class="container delimiter">
        <div class="navbar-header">
            <img src="static/img/2pedalss.png"/>
            <a class="navbar-brand" href="#">Without Two Pedals</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="goods">MotoBikes</a></li>
                <sec:authorize access="hasAuthority('ADMIN') or hasAuthority('CLIENT')">
                    <li><a href="orders">Orders</a></li>
                </sec:authorize>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <li><a href="categories">Categories</a></li>
                </sec:authorize>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>${user}</li>
                <li><a href="cart">Cart</a></li>
                <sec:authorize access="hasAuthority('ADMIN') or hasAuthority('CLIENT')">
                    <li><a href="client"><sec:authentication property="principal.username"/></a></li>
                    <li><a href="logout">logout</a></li>
                </sec:authorize>
            </ul>


        </div>

    </div>
</nav>

<div class="container">
    <span id="errorMessage" class="bg-info"></span>
</div>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<br>
