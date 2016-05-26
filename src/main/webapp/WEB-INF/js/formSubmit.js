$(document).ready(function(){
$('#requestAddSubmit').click(function(e){
    e.preventDefault();
    var addr_Json = [];
    $('.adress-select').each(function(){
        addr_Json.push({
            adressess: $(this).val()


    });

    });


    $('#addrJson').val(JSON.stringify(addr_Json));
    $('#submit-form').trigger('click');
    //$('#requestForm').submit();






    });
    });




