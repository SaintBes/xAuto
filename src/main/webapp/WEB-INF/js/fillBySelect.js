/**
 * Created by admssa on 24.05.2016.
 */
$(document).ready(function() {
    $('#carEditId').change(function(){
        var carId = $(this).val();
        $.get("getCars").done(function( data ) {
            for (i=0; i<data.length; i++){
                if(data[i].carId==carId){
                    $('#carEditName').val(data[i].carName);
                    $('#carEditNumber').val(data[i].carNumber);
                    $('#carEditActive').prop('selected',(data[i].carActive));
                    $('#carEditDriverId').val(data[i].carDriver.driverId);

                }
            }
        });
    });

    $('#drvEditId').change(function(){
        var driverId = $(this).val();
        $.get("getDrivers").done(function( data ) {
            for (i=0; i<data.length; i++){
                if(data[i].driverId==driverId){
                    $('#drvEditName').val(data[i].driverName);
                    $('#phoneNumberEdit').val(data[i].driverPhone);

                }
            }
        });
    });


});
