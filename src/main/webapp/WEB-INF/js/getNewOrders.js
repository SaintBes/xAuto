/**
 * Created by admssa on 13.05.2016.
 */
$( document ).ready (function allNewOrdersGet() {
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
            var html_addr ='';
            var html_cars ='';


            var carNumbers = function(){
                var pagelink = "/";
                var url = "getCars";
                $.ajax({
                    url: url,
                    method: "get",
                    contentType: "application/json",
                    dataType: "json",
                    async: false,
                    success: function (carsData) {
                        carsData.forEach(function(car ){html_cars+= '<option value='+car.carId+'>'+car.carNumber+'</option>';});
                    }
                })
                };




            $("#newOrdersTable").find("tr:gt(0)").remove();

            var table = document.getElementById("newOrdersTable");


            orders.forEach(function (order){
                order.orderAddresses.forEach(function(addr){
                    html_addr += '<div>'+addr.adressess+'</div>';
                });
                $('#newOrdersTable').append("+<tr id=" +'order' + order.orderId + "><td>" + order.orderClient.clientName + "</td><td>" + html_addr +
                    "</td><td>" +new Date(order.orderTimeStart).toDateString() + "</td><td>"  +new Date(order.orderTimeOver).toDateString() + "</td><td>"
                    + '<select id="carsSelect" name="carsSelect"></select>'                   + "</td><td>" + "Кнопка" + "</td></tr>");
            });
            carNumbers();
            $("#carsSelect").append(html_cars);


        },

    });
});