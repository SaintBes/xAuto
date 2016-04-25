<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <title>xAuto</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <%--<style type="text/css">--%>
        <%--body {--%>
            <%--padding-top: 60px;--%>
            <%--padding-bottom: 40px;--%>
        <%--}--%>
    <%--</style>--%>
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<a href="/">--%>
            <p class="navbar-brand">xAuto</p>
            <%--</a>--%>
        </div>

    <div id="logindiv" class="navbar-collapse collapse">
        <%--<sec:authorize access="!isAuthenticated()">--%>
            <form class="navbar-form navbar-right" method="post" action="/j_spring_security_check" role="form"
                  id="loginform">

                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control" name="j_username">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control" name="j_password">
                </div>
                <button id="login" type="submit" class="btn btn-success" value="Login">Увійти</button>
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#reg">
                    Реєстрація
                </button>
            </form>
        <%--</sec:authorize>--%>

        <sec:authorize access="isAuthenticated()">
            <c:url var="logoutUrl" value="/logout"/>
            <form class="navbar-form navbar-right" action="${logoutUrl}" method="post">
                <a href="/dashbosrd" class="btn btn-link" role="button">Адміністрування</a>
                <input class="btn btn-warning" type="submit" value="Вихід"/>
            </form>
        </sec:authorize>
    </div>
    </div>
</div>


</body>
</html>
