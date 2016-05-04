<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-ui.js"></script>
    <script src="../js/myDatapicker.js"></script>
    <script src="../js/jquery.datetimepicker.full.min.js"></script>
    <script src="../js/inputClients.js"></script>

    <script src="../js/emailValidation.js"></script>


    <title>xAuto</title>
    <link href="../css/myChanges.css" rel="stylesheet">
    <link href="../css/jquery-ui.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">

    <link href="../css/jquery.datetimepicker.min.css" rel="stylesheet">

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
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

            <a class="navbar-brand" href="#">  <img src="/img/logo.png" width="100" align="left" >xAuto</a>

           </div>
        <form class="navbar-form navbar-left">

        </form>
        <div>

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav">

                        </ul>
                    </li>

                </ul>


                   <div id="logindiv" class="navbar-collapse collapse">


                    <form class="navbar-form navbar-right" method="post" action="/j_spring_security_check" role="form"
                          id="loginform">

                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" name="j_username">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name="j_password">
                        </div>
                        <button id="login" type="submit" class="btn btn-success" value="Login">Увійти</button>

                    </form>


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
    <div class="page-header">
  <h2>Подати заявку на авто</h2>
        </div>
 <div class="jumbotron">

    <form  id="requestForm"  class="form-horizontal" role="form" >

        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Електронна адреса: </label>
            <div id="autocomplete" class="col-sm-10">
                <input  type="email" class="form-control" name="email"  id="email"  autocomplete="on" list="json-datalist" placeholder="Ваша електронна адреса, наприклад: petro@uim.kiev.ua" onkeyup="allClientsGet()" >
                <datalist id="json-datalist"></datalist>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="adr">Адреса: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="adr" placeholder="Місце призначення">
            </div>
        </div>

        <div class="form-group">

                <label class="control-label col-sm-2" for="date_timepicker_start">Початок поїздки:</label>

            <div class=" col-sm-6">

                <input  id="date_timepicker_start" type="text" value="" class="form-control">
                </div>
               </div>
        <div class="form-group">
        <label class="control-label col-sm-2" for="date_timepicker_end">Повернення:</label>
        <div class=" col-sm-6">
            <input id="date_timepicker_end" type="text" value="" class="form-control"></p>
        </div>
            </div>
        <button type="submit" class="btn btn-default pull-right">Надіслати</button>
    </form>

</div>
</div>
</body>
</html>
