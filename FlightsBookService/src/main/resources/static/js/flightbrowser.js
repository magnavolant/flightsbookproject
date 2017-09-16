$(document).ready(function () {
    var data = JSON.parse(localStorage.getItem("data"));
    localStorage.removeItem("data");

    var tableBody = $("tbody");

    for (var i = 0; i < data.length; i++) {
        tableBody.append("<tr>");
        tableBody.append("<td>" + data[i].flightNumber + "</td>");
        tableBody.append("<td>" + data[i].whence + "</td>");
        tableBody.append("<td>" + data[i].destination + "</td>");
        tableBody.append("<td>" + convertDateToString(data[i].departureDate) + "</td>");
        tableBody.append("<td>" + convertTimeToString(data[i].departureTime) + "</td>");
        tableBody.append("<td>" + convertTimeToString(data[i].flightTime) + "</td>");
        tableBody.append("<td>" + data[i].price + "</td>");
        tableBody.append("</tr>");
    }
});

function convertDateToString(date) {
    return date.dayOfMonth + "-" + date.monthValue + "-" + date.year;
}

function convertTimeToString(time) {
    return time.hour + ":" + time.minute;
}