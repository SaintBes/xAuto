$(function() {
    $( "#datepicker" ).datepicker();
});
$(function() {
    $( "#datepicker2" ).datepicker();
});



jQuery(function(){
    jQuery('#date_timepicker_start').datetimepicker({
     onShow:function( ct ){
            this.setOptions({
                maxDate:jQuery('#date_timepicker_end').val()?jQuery('#date_timepicker_end').val():false
            })
        },
        timepicker:true,
        lang:'ua'
    });
    jQuery('#date_timepicker_end').datetimepicker({
       onShow:function( ct ){
            this.setOptions({
                minDate:jQuery('#date_timepicker_start').val()?jQuery('#date_timepicker_start').val():false

            })
        },
        timepicker:true,
        lang:'ua'
    });
});

