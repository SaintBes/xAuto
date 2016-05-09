
var placeSearch, autocomplete;
var componentForm = {
    street_number: 'short_name',
    route: 'long_name',
    locality: 'long_name',
    administrative_area_level_1: 'short_name',
    country: 'long_name',
    postal_code: 'short_name'

};


//function initAutocomplete() {
//
//    autocomplete = new google.maps.places.Autocomplete(
//     (document.getElementById('autocomplete_adr')),
//        {types: ['geocode']});
//    autocomplete.addListener('place_changed', fillInAddress);
//
//}

function initAutocomplete() {
    var autocompletes = [];
    $('.adress-select').each(function(){
        autocompletes.push(new google.maps.places.Autocomplete(
            $(this).get(0),
            {types: ['geocode']}))
    })
}

function fillInAddress() {
    // Get the place details from the autocomplete object.
    var place = autocomplete.getPlace();




}

// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var geolocation = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            var circle = new google.maps.Circle({
                center: geolocation,
                radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
        });
    }
}