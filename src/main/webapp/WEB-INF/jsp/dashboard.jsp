<%--
  Created by IntelliJ IDEA.
  User: admssa
  Date: 26.04.2016
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-ui.js"></script>
    <script src="../js/myDatapicker.js"></script>

    <link href="../css/jquery-ui.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <title>Панель керування</title>
</head>
<body>
<nav class="navbar navbar-inverse">

    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand">Панель адміністрування</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a data-toggle="tab" href="#about">Про додаток</a></li>
                <li><a data-toggle="tab" href="#articles">Заявки</a></li>
                <li><a data-toggle="tab" href="#users">Управління автомобілями</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <li><a href="/#">Вихід</a></li>
            </form>
        </div>
    </div>
</nav>

<div class="container">
    <div class="tab-content">
        <div id="about" class="tab-pane fade in active">
            <h2>Панель адміністрування</h2>

            <p>Додаток управління резервуванням авто</p>

        </div>

        <div id="articles" class="tab-pane fade">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#addarticle">Нові заявки</a></li>
                <li><a name="del" data-toggle="tab" href="#removearticle">Відпрацьовані заявки</a></li>
            </ul>

            <div class="tab-content">
                <div id="addarticle" class="tab-pane fade in active">
                    <div class="container">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>ПІП</th>
                                <th>Адреса</th>
                                <th>Час</th>
                                <th>Дата</th>
                                <th>Авто</th>
                                <th>Призначити</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="removearticle" class="tab-pane fade">
                    <p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ПІП</th>
                            <th>Адреса</th>
                            <th>Час</th>
                            <th>Дата</th>
                            <th>Авто</th>
                                                </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        </table>


                    </p>
                </div>
            </div>
        </div>

        <div id="users" class="tab-pane fade">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#adduser">Додати автомобіль</a></li>
                <li><a data-toggle="tab" href="#removeuser">Видалити автомобіль</a></li>
                <li><a data-toggle="tab" href="#updateuser">Корегувати автомобіль</a></li>
            </ul>

            <div class="tab-content">
                <div id="adduser" class="tab-pane fade in active">
                    <h3>Додати авто</h3>

                    <p>Форма додавання авто</p>
                </div>
                <div id="removeuser" class="tab-pane fade">
                    <h3>Видалити авто</h3>

                    <p>Список авто для видалення</p>
                </div>
                <div id="updateuser" class="tab-pane fade">
                    <h3>Корегувати авто</h3>

                    <p>Список авто для корегування</p>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
