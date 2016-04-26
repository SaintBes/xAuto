<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-ui.js"></script>
    <script src="../js/myDatapicker.js"></script>


    <title>xAuto</title>
    <link href="../css/jquery-ui.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>

    <style>
        body {
            position: relative;
        }
        /*#section1 {padding-top:50px;height:500px;color: #fff; background-color: #f1f1f1;}*/
        #section1 {padding-top:50px;height:500px; background-color: #f1f1f1;}
        #section2 {padding-top:50px;height:500px; background-color: #a6ced4;}
        #section3 {padding-top:50px;height:500px; background-color: #f1f1f1;}
        #section41 {padding-top:50px;height:500px; background-color: #a6ced4;}
        #section42 {padding-top:50px;height:500px;  background-color: #f1f1f1;}
    </style>
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" data-target="#myNavbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">xAuto</a>

           </div>
        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input type="text" id="datepicker"  class="form-control"  ></p>
            </div>
        </form>
        <div>

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav">

                    <li><a href="#sendReq" data-toggle="modal" data-target="#sendReq">Подати заявку</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Авто <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#section1">АА0017АК</a></li>
                            <li><a href="#section2">АА5511МО</a></li>
                            <li><a href="#section3">АА5522МО</a></li>
                            <li><a href="#section41">АА5533МО</a></li>
                            <li><a href="#section42">АА5544МО</a></li>
                        </ul>
                    </li>

                </ul>


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
                        <%--<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#reg">--%>
                            <%--Реєстрація--%>
                        <%--</button>--%>
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



    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="sendReq" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Подати заявку на авто</h4>
            </div>
            <div class="modal-body">
                <form id="requestForm"  class="form-horizontal" role="form">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">ПІП: </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="Прізвище, ім'я, по батькові">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="adr">Адреса: </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adr" placeholder="Місце призначення">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="datepicker2">Дата: </label>
                        <div class=" col-sm-10">
                                <input type="text" id="datepicker2"  class="form-control"  ></p>
                          </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="time">Тривалість поїздки: </label>
                        <div class=" col-sm-10">

                        <select id="time" multiple class="form-control">
                                    <option>9:00</option>
                                    <option>10:00</option>
                                    <option>11:00</option>
                                    <option>12:00</option>
                                    <option>13:00</option>
                                    <option>14:00</option>
                                    <option>15:00</option>
                                    <option>16:00</option>
                                    <option>17:00</option>
                                </select>

                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default">Надіслати</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
            </div>
        </div>

    </div>
</div>


<div class="modal fade" id="reg" role="dialog">
    <div class="modal-dialog">
          <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Реєстрація</h4>

            </div>

            <form id="registrationForm" class="form-horizontal" action="register.html" method="POST">
                <p>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Електронна пошта</label>

                    <div class="col-xs-5">
                        <LABEL ACCESSKEY=S>
                            <input type="text" class="form-control" name="email"/>
                        </LABEL>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label">Пароль</label>

                    <div class="col-xs-5">
                        <LABEL ACCESSKEY=S>
                            <input type="password" class="form-control" name="password"/>
                        </LABEL>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-9 col-xs-offset-3">
                        <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Надіслати</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container">
<div id="section1" class="container-fluid">
    <h1>АА0017АК</h1>
    <p>Audi A8L</p>
    <table class="table">
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Час</th>--%>
            <%--<th>ФІО</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <tbody>
        <tr class="danger">
            <td>9:00</td>
            <td>Скабодін О.В.</td>
         </tr>
        <tr class="danger">
            <td>10:00</td>
            <td>Скабодін О.В.</td>
        </tr>
        <tr>
            <td>11:00</td>
            <td></td>
        </tr>
        <tr>
            <td>12:00</td>
            <td></td>
        </tr>
        <tr class="danger">
            <td>13:00</td>
            <td>Рибіна Л.В.</td>
        </tr>
        <tr class="danger">
            <td>14:00</td>
            <td>Рибіна Л.В.</td>
        </tr>
        <tr>
            <td>15:00</td>
            <td></td>
        </tr>
        <tr>
            <td>16:00</td>
            <td></td>
        </tr>
        <tr >
            <td>17:00</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<div id="section2" class="container-fluid">
    <h1>АА5511МО</h1>
    <p>Toyota Camry 2.5</p>
    <table class="table">
        <%--<thead>--%>
        <%--<tr>--%>
        <%--<th>Час</th>--%>
        <%--<th>ФІО</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <tbody>
        <tr>
            <td>9:00</td>
            <td></td>
        </tr>
        <tr>
            <td>10:00</td>
            <td></td>
        </tr>
        <tr>
            <td>11:00</td>
            <td></td>
        </tr>
        <tr>
            <td>12:00</td>
            <td></td>
        </tr>
        <tr >
            <td>13:00</td>
            <td></td>
        </tr>
        <tr >
            <td>14:00</td>
            <td></td>
        </tr>
        <tr>
            <td>15:00</td>
            <td></td>
        </tr>
        <tr>
            <td>16:00</td>
            <td></td>
        </tr>
        <tr >
            <td>17:00</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<div id="section3" class="container-fluid">
    <h1>АА5522МО</h1>
    <p>Toyota Camry 2.5</p>
    <table class="table">
        <%--<thead>--%>
        <%--<tr>--%>
        <%--<th>Час</th>--%>
        <%--<th>ФІО</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <tbody>
        <tr>
            <td>9:00</td>
            <td></td>
        </tr>
        <tr>
            <td>10:00</td>
            <td></td>
        </tr>
        <tr>
            <td>11:00</td>
            <td></td>
        </tr>
        <tr>
            <td>12:00</td>
            <td></td>
        </tr>
        <tr >
            <td>13:00</td>
            <td></td>
        </tr>
        <tr >
            <td>14:00</td>
            <td></td>
        </tr>
        <tr>
            <td>15:00</td>
            <td></td>
        </tr>
        <tr>
            <td>16:00</td>
            <td></td>
        </tr>
        <tr >
            <td>17:00</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<div id="section41" class="container-fluid">
    <h1>АА5533МО</h1>
    <p>Toyota Camry 2.5</p>
    <table class="table">
        <%--<thead>--%>
        <%--<tr>--%>
        <%--<th>Час</th>--%>
        <%--<th>ФІО</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <tbody>
        <tr>
            <td>9:00</td>
            <td></td>
        </tr>
        <tr>
            <td>10:00</td>
            <td></td>
        </tr>
        <tr>
            <td>11:00</td>
            <td></td>
        </tr>
        <tr>
            <td>12:00</td>
            <td></td>
        </tr>
        <tr >
            <td>13:00</td>
            <td></td>
        </tr>
        <tr >
            <td>14:00</td>
            <td></td>
        </tr>
        <tr>
            <td>15:00</td>
            <td></td>
        </tr>
        <tr>
            <td>16:00</td>
            <td></td>
        </tr>
        <tr >
            <td>17:00</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<div id="section42" class="container-fluid">
    <h1>АА5544МО</h1>
    <p>Toyota Camry 2.5</p>
    <table class="table">
        <%--<thead>--%>
        <%--<tr>--%>
        <%--<th>Час</th>--%>
        <%--<th>ФІО</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <tbody>
        <tr>
            <td>9:00</td>
            <td></td>
        </tr>
        <tr>
            <td>10:00</td>
            <td></td>
        </tr>
        <tr>
            <td>11:00</td>
            <td></td>
        </tr>
        <tr>
            <td>12:00</td>
            <td></td>
        </tr>
        <tr >
            <td>13:00</td>
            <td></td>
        </tr>
        <tr >
            <td>14:00</td>
            <td></td>
        </tr>
        <tr>
            <td>15:00</td>
            <td></td>
        </tr>
        <tr>
            <td>16:00</td>
            <td></td>
        </tr>
        <tr >
            <td>17:00</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
