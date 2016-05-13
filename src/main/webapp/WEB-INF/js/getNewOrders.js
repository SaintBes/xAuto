/**
 * Created by admssa on 13.05.2016.
 */
$( document ).ready (function allClientsGet() {
    var pagelink = "/";
    var url = "newOrders";
    $.ajax({
        url: url,
        method: "get",
        contentType: "application/json",
        dataType: "json",
        async: false,
        success: function (data) {
            var orders = data;
            $("#newOrdersTable").find("tr:gt(0)").remove();
            var table = document.getElementById("newOrdersTable");


            orders.forEach(function (order){
                //$("#newOrdersTable").append("<tr><td>" +order.orderClient.clientName + "" </td><td>"+</td><td>order.orderTimeStart</td><td>order.orderTimeOver</td></tr>")

            });



        }

    });
});