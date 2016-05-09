var room = 1;
function add_fields() {
    room++;
    var objTo = document.getElementById('addr')
    var divtest = document.createElement("div");
    divtest.innerHTML = '<div><input type="text"  class="adress-select form-control"  placeholder="Місце призначення" /></div>';

    objTo.appendChild(divtest)
    initAutocomplete();
}