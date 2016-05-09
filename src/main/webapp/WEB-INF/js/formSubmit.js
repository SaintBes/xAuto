$('#requestAddSubmit').click(function(e){
    e.preventDefault();
    var addr_Json = [];
    $('#adressess .adress-select').each(function(){
        addr_Json.push({
           address: $(this).find('.adress-select').val()

        });
    });
    $('#addrJson').val(JSON.stringify(addr_Json));
    $('#requestForm').submit();

});