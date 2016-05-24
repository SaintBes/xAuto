///**
// * Created by admssa on 24.05.2016.
// */
//window.onload = function(){
//
//    var url = document.location.toString();
//    if (url.match('#')) {
//        $('.nav-tabs a[href=#' + url.split('#')[1] + ']').tab('show');
//    }
//
//    //Change hash for page-reload
//    $('.nav-tabs a[href=#' + url.split('#')[1] + ']').on('shown', function (e) {
//        window.location.hash = e.target.hash;
//    });
//}

    $(document).ready(function() {
        //$('a[data-toggle="tab"]').click(function (e) {
        //    var hash = $(this).attr('href');
        //    location.hash = hash;
        //
        //
        //});
        //
        //
        //$(function() {

            var hash = window.location.hash;
            var $nav = $('ul.nav a[href="' + hash + '"]');


            hash && $nav.tab('show');

        //});


});