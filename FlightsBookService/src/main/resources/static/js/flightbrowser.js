$(document).ready(function () {
    var data = JSON.parse(localStorage.getItem("data"));
    localStorage.removeItem("data");

    console.log(JSON.stringify(data));

});