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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <%--<script src="js/myDatapicker.js"></script>--%>
    <%--<script src="js/getNewOrders.js"></script>--%>
    <script src="js/phoneNumber.js"></script>
    <script src="js/jquery.maskedinput.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/myTables.js"></script>
    <script src="js/activeTabPane.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/fillBySelect.js"></script>



    <link href="css/jquery-ui.css" rel="stylesheet">
    <link href="css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">

    <link href="css/myChanges.css" rel="stylesheet">
    <title>Панель керування</title>
</head>
<body>
<nav class="navbar navbar-inverse">

    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand">Панель адміністрування</a>
        </div>
        <div id="tabs">
            <ul id="mainTab" class="nav navbar-nav">
               <li class="active"><a data-toggle="tab" href="#articles">Заявки</a></li>
                <li><a data-toggle="tab" href="#cars">Автомобілі</a></li>
                <li><a data-toggle="tab" href="#drivers">Водії</a></li>
                <li ><a data-toggle="tab" href="#about">Про додаток</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <li><a href="logout">Вихід</a></li>
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
                        <c:if test="${newOrders.size()>0}" >
                            <c:forEach var ="order" items="${newOrders}">
                                <tr id="order${order.orderId}">
                                    <td>${order.orderClient.clientName}</td>

                                    <td>
                                        <c:forEach var="addr" items="${order.orderAddresses}">
                                            <div>
                                                    ${addr.adressess}
                                            </div>
                                        </c:forEach>
                                    </td>
                                    <jsp:useBean id="dateObject" class="java.util.Date" />
                                    <jsp:setProperty name="dateObject" property="time" value="${order.orderTimeStart}" />
                                    <td><fmt:formatDate value="${dateObject}" pattern="dd/MM/yyyy k:mm" /></td>

                                   <jsp:setProperty name="dateObject" property="time" value="${order.orderTimeOver}" />
                                    <td><fmt:formatDate value="${dateObject}" pattern="dd/MM/yyyy k:mm " /></td>
                                    <form method="post" id="setOrderCar" action="setOrderCar" class="form-horizontal" role="form">
                                <td>
                                        <select id="carSelect${order.orderId}" name="carSelect" class="form-control">

                                            <c:forEach var="car" items="${allCarsList}">
                                                <c:if test="${(car.busyTimeStart==0 && car.busyTimeOver==0) || ((order.orderTimeStart<car.busyTimeStart || order.orderTimeStart>car.busyTimeOver)  && (order.orderTimeOver<car.busyTimeStart || order.orderTimeOver>car.busyTimeOver)) }">
                                               <option value="${car.carId}"> ${car.carNumber}</option>

                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>


                                            <input id="orderId" name="orderId" type="hidden" value="${order.orderId}" >
                                            <button class="btn btn-default">OK</button>

                                    </td>
                                    </form>
                                </tr>
                            </c:forEach>
</c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
                <p>
                <div id="oldOrders" class="tab-pane fade">
                    <p>
                    <table id="oldOrdersTable" class="display">
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
            <c:if test="${oldOrders.size()>0}" >
                <c:forEach var ="oldOrder" items="${oldOrders}">
            <tr id="order${oldOrder.orderId}">
                <td>${oldOrder.orderClient.clientName}</td>

                <td>
                    <c:forEach var="addrOld" items="${oldOrder.orderAddresses}">
                        <div>
                                ${addrOld.adressess}
                        </div>
                    </c:forEach>
                </td>
                    <jsp:useBean id="dateObjectOld" class="java.util.Date" />
                    <jsp:setProperty name="dateObjectOld" property="time" value="${oldOrder.orderTimeStart}" />
                <td><fmt:formatDate value="${dateObjectOld}" pattern="dd/MM/yyyy k:mm" /></td>

                    <jsp:setProperty name="dateObjectOld" property="time" value="${oldOrder.orderTimeOver}" />
                   <td><fmt:formatDate value="${dateObjectOld}" pattern="dd/MM/yyyy k:mm " /></td>
                <td>
                    <div>${oldOrder.orderCar.carName}</div>
                    <div>${oldOrder.orderCar.carNumber}</div>
                </td>
                </c:forEach>

            </c:if>
                        </tbody>
                        </table>


                    </p>
                </div>
            </p>
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
                    <form method="post" id="carAdd" action="carAdd" class="form-horizontal" role="form">
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
                            <label class="control-label col-sm-2" for="carDriverId">Водій: </label>
                            <div class="col-sm-6">
                                <div id="car_driver" class="ui-widget">
                                    <select class="form-control" name="carDriverId" id="carDriverId">
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

                <div>
                    <table id="allCars" class="table table-striped">
                        <thead>
                        <tr>
                            <th>Назва</th>
                            <th>Номер</th>
                            <th>Видалити</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="car" items="${allCarsList}">
                            <tr>
                                <form method="post" id="deleteCar" action="deleteCar" class="form-horizontal" role="form">
                                    <td>${car.carName}</td>
                                    <td>${car.carNumber}</td>
                                    <input name="delCarId" type="hidden" value="${car.carId}">
                                    <td><button style="width: inherit" class="form-control btn-default">Видалити</button> </td>
                                </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="updatecar" class="tab-pane fade">
                <h3>Корегувати авто</h3>
                <div class="jumbotron">
                    <form method="post" id="editCar" action="carUpdate" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="drvEditId">Авто:</label>
                            <div class="col-sm-10">
                                <div id="carEdit" class="ui-widget">
                                    <select id="carEditId" name="carId" class="form-control">
                                        <c:forEach var="car" items="${allCarsList}">
                                            <option value=${car.carId}>${car.carName}(${car.carNumber})</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carEditName">Назва авто: </label>
                            <div class="col-sm-10">
                                <div id="car_edit_name" class="ui-widget">
                                    <input type="text" class="form-control" name="carName" id="carEditName"
                                           placeholder="Марка, Модель" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carEditNumber">Номер авто: </label>
                            <div class="col-sm-6">
                                <div id="car_edit_number" class="ui-widget">
                                    <input type="text" class="form-control" name="carNumber" id="carEditNumber"
                                           placeholder="Номер автомобыля" required>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carEditActive">Доступність: </label>
                            <div class="col-sm-6">
                                <div id="car_edit_active" class="ui-widget">
                                    <select class="form-control" name="carActive" id="carEditActive">
                                        <option value="true">Автомобіль доступний для призначення</option>
                                        <option value="false">Автомобіль не доступний  для призначення</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="carEditDriverId">Водій: </label>
                            <div class="col-sm-6">
                                <div id="car_edit_driver" class="ui-widget">
                                    <select class="form-control" name="carDriverId" id="carEditDriverId">
                                        <c:if test="${driversList.size()>0}">
                                            <c:forEach var="driver" items="${driversList}">
                                                <option value="${driver.driverId}">${driver.driverName}</option>
                                            </c:forEach>
                                        </c:if>

                                    </select>
                                </div>
                            </div>
                        </div>


                        <button id="car_edit_cdd" type="submit" class="btn btn-default pull-right">Надіслати</button>

                        </form>
                    </div>
            </div>

        </div>
    </div>

        <div id="drivers" class="tab-pane fade">
            <ul id="drvrs" class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#adddriver">Додати водія</a></li>
                <li><a data-toggle="tab" href="#removedriver">Видалити водія</a></li>
                <li><a data-toggle="tab" href="#updatecadriver">Корегувати водія</a></li>
            </ul>

            <div class="tab-content">
                <div id="adddriver" class="tab-pane fade in active">
                    <h3>Додати водія</h3>

                    <div class="jumbotron">
                        <form method="post" id="addDrivewr" action="addDriver" class="form-horizontal" role="form">
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
             </div>
                <div id="removedriver" class="tab-pane fade">
                    <h3>Видалити водія</h3>
                    <div>
                    <table id="allDrivers" class="table table-striped">
                        <thead>
                        <tr>
                            <th>ПІП</th>
                            <th>Телефон</th>
                            <th>Видалити</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="drv" items="${driversList}">
                        <tr>
                            <form method="post" id="deleteDriver" action="deleteDriver" class="form-horizontal" role="form">
                            <td>${drv.driverName}</td>
                            <td>${drv.driverPhone}</td>
                            <input name="delDriverId" type="hidden" value="${drv.driverId}">
                            <td><button style="width: inherit" class="form-control btn-default">Видалити</button> </td>
                            </form>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </div>

                </div>
                <div id="updatecadriver" class="tab-pane fade">
                    <h3>Корегувати водія</h3>
                    <div class="jumbotron">
                        <form method="post" id="updateDriver" action="updateDriver" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="drvEditId">Водій:</label>
                                <div class="col-sm-10">
                                    <div id="drvId" class="ui-widget">
                                        <select id="drvEditId" name="drvId" class="form-control">
                                            <c:forEach var="drv" items="${driversList}">
                                                <option value=${drv.driverId}>${drv.driverName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="drvEditName">ПІП:</label>
                                <div class="col-sm-10">
                                    <div id="drvUpdName" class="ui-widget">
                                        <input type="text" class="form-control" name="driverName" id="drvEditName"
                                               placeholder="Прізвище Ім`я По-батькові" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="phoneNumberEdit">Телефон:</label>
                                <div class=" col-sm-6">
                                    <input id="phoneNumberEdit" placeholder="Контактний номер телефону водія" type="text" class="form-control"
                                           name="driverPhone" required>
                                </div>
                            </div>
                            <button id="driverUpdate" type="submit" class="btn btn-default pull-right">Надіслати</button>
                        </form>
                    </div>

            </div>
        </div>
    </div>
</div>
<%--<div class="alert alert-danger" role="alert">${error}</div>--%>

</body>
</html>
