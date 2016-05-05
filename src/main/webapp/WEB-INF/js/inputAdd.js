var room = 1;
function add_fields() {
    room++;
    var objTo = document.getElementById('addr')
    var divtest = document.createElement("div");
    divtest.innerHTML = '<div><p><input type="text"  class="adress-select" /></p></div>';

    objTo.appendChild(divtest)
}