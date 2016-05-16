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
    <%--<script src="../js/myDatapicker.js"></script>--%>
    <script src="../js/getNewOrders.js"></script>
    <script src="../js/phoneNumber.js"></script>
    <script src="../js/jquery.maskedinput.js"></script>


    <link href="../css/jquery-ui.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/myChanges.css" rel="stylesheet">
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
               <li class="active"><a data-toggle="tab" href="#articles">Заявки</a></li>
                <li><a data-toggle="tab" href="#cars">Автомобілі</a></li>
                <li><a data-toggle="tab" href="#drivers">Водії</a></li>
                <li ><a data-toggle="tab" href="#about">Про додаток</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <li><a href="/#">Вихід</a></li>
            </form>
        </div>
    </div>
</nav>

<div class="container">
    <div class="tab-content">
        <div id="about" class="tab-pane fade">
            <h2>Панель адміністрування</h2>

            <p>Додаток управління резервуванням авто</p>

        </div>

        <div id="articles" class="tab-pane fade  in active">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#newOrders">Нові заявки</a></li>
                <li><a name="del" data-toggle="tab" href="#oldOrders">Відпрацьовані заявки</a></li>
            </ul>

            <div class="tab-content">
                <div id="newOrders" class="tab-pane fade in active">
                    <div class="container">
                        <table id="newOrdersTable" class="table table-striped">
                            <thead>
                            <tr>
                                <th>ПІП</th>
                                <th>Адреса</th>
                                <th>Відправлення</th>
                                <th>Повернення</th>
                                <th>Авто</th>
                                <th>Призначити</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="oldOrders" class="tab-pane fade">
                    <p>
                    <table id="oldOrdersTable" class="table table-striped">
                        <thead>
                        <tr>
                            <th>ПІП</th>
                            <th>Адреса</th>
                            <th>Відправлення</th>
                            <th>Повернення</th>
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

        <div id="cars" class="tab-pane fade">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#addcar">Додати автомобіль</a></li>
            <li><a data-toggle="tab" href="#removecar">Видалити автомобіль</a></li>
            <li><a data-toggle="tab" href="#updatecar">Корегувати автомобіль</a></li>
        </ul>

        <div class="tab-content">
            <div id="addcar" class="tab-pane fade in active">
                <h3>Додати авто</h3>
                <div class="jumbotron">
                    <form method="post" id="carAdd" action="/carAdd" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carName">Назва авто: </label>
                            <div class="col-sm-10">
                                <div id="car_name" class="ui-widget">
                                    <input type="text" class="form-control" name="carName" id="carName"
                                           placeholder="Марка, Модель" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carNumber">Номер авто: </label>
                            <div class="col-sm-6">
                                <div id="car_number" class="ui-widget">
                                    <input type="text" class="form-control" name="carNumber" id="carNumber"
                                           placeholder="Номер автомобыля" required>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carActive">Доступність: </label>
                            <div class="col-sm-6">
                                <div id="car_active" class="ui-widget">
                                    <select class="form-control" name="carActive" id="carActive">
                                        <option value="true">Автомобіль доступний для призначення</option>
                                        <option value="false">Автомобіль не доступний  для призначення</option>
                                        </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carActive">Водій: </label>
                            <div class="col-sm-6">
                                <div id="car_driver" class="ui-widget">
                                    <select class="form-control" name="carDriver" id="carDriver">
                                        <c:if test="${driversList.size()>0}">
                                        <c:forEach var="driver" items="${driversList}">
                                            <option value="${driver.driverId}">${driver.driverName}</option>
                                        </c:forEach>
                                        </c:if>

                                    </select>
                                </div>
                            </div>
                        </div>


                        <button id="car_cdd" type="submit" class="btn btn-default pull-right">Надіслати</button>

                    </form>

                </div>
            </div>
            <div id="removecar" class="tab-pane fade">
                <h3>Видалити авто</h3>

                <p>Список авто для видалення</p>
            </div>
            <div id="updatecar" class="tab-pane fade">
                <h3>Корегувати авто</h3>

                <p>Список авто для корегування</p>
            </div>

        </div>
    </div>

        <div id="drivers" class="tab-pane fade">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#adddriver">Додати водія</a></li>
                <li><a data-toggle="tab" href="#removedriver">Видалити водія</a></li>
                <li><a data-toggle="tab" href="#updatecadriver">Корегувати водія</a></li>
            </ul>

            <div class="tab-content">
                <div id="adddriver" class="tab-pane fade in active">
                    <h3>Додати водія</h3>

                    <div class="jumbotron">
                        <form method="post" id="addDrivewr" action="/addDriver" class="form-horizontal" role="form">
                            <div class="form-group">

                                <label class="control-label col-sm-2" for="driverName">ПІП </label>
                                <div class="col-sm-10">
                                    <div id="drvName" class="ui-widget">
                                        <input type="text" class="form-control" name="driverName" id="driverName"
                                               placeholder="Прізвище Ім`я По-батькові" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="phoneNumber">Телефон:</label>
                                <div class=" col-sm-6">
                                    <input id="phoneNumber" placeholder="Контактний номер телефону водія" type="text" class="form-control"
                                           name="driverPhone" required>
                                </div>
                            </div>
                            <button id="driverAdd" type="submit" class="btn btn-default pull-right">Надіслати</button>

                        </form>
                    </div>
                    <p>Форма додавання водїв</p>
                </div>
                <div id="removedriver" class="tab-pane fade">
                    <h3>Видалити водія</h3>

                    <p>Список водіїв для видалення</p>
                </div>
                <div id="updatecadriver" class="tab-pane fade">
                    <h3>Корегувати водія</h3>

                    <p>Список водїв для корегування</p>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
