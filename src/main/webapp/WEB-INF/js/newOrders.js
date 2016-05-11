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

            $("#email").autocomplete({
                source: data
            });
        }

    });
});