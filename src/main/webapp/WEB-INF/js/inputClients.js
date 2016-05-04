///**
// * Created by admssa on 04.05.2016.
// */
////
$( document ).ready (function allClientsGet() {
    var pagelink = "/";
    var url = "allClients";
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


