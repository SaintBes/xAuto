///**
// * Created by admssa on 04.05.2016.
// */
////
function allClientsGet() {
    var pagelink = "/";
    var url = "allClients";
    $.ajax({
        url: url,
        method: "get",
        contentType: "application/json",
        dataType: "json",
        async: false,
        success: function (data) {

            var dataList = document.getElementById('json-datalist');
            var input = document.getElementById('email');
            data.forEach(function(item) {
                var option = document.getElementById("email").createElement("");
                option.value = item;
                dataList.appendChild(option);
            });
        }
    });

}


