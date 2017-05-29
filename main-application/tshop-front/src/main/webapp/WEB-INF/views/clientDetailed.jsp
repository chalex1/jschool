<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 12.04.2017
  Time: 0:51
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
        <div class="col-sm-12 col-lg-6">
            <div class="form-group">
                <label>Login</label>
                <input type="text" class="account-login form-control disabled chk-notempty chk-less10" readonly/>
                <span class="help-block check-account-login"></span>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="text" class="account-password form-control chk-notempty chk-less10"/>
                <span class="help-block check-account-password"></span>
            </div>
            <div class="form-group">
                <label>Name</label>
                <input type="text" class="account-name form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Surname</label>
                <input type="text" class="account-surname form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" class="account-email form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Birthday</label>
                <input type="date" class="account-birthday form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Country</label>
                <input type="text" class="address-country form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>City</label>
                <input type="text" class="address-city form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Postcode</label>
                <input type="text" class="address-postcode form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Street</label>
                <input type="text" class="address-street form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Home</label>
                <input type="text" class="address-home form-control"/>
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label>Flat</label>
                <input type="text" class="address-flat form-control"/>
                <span class="help-block"></span>
            </div>
            <input type="button" class="client-save-btn btn btn-default" value="Save"/>
        </div>
</div>


<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/clientDetailed.js"></script>
<script src="static/js/formValidator.js"></script>
</body>
</html>
