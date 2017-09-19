$(document).ready(function () {
    var data = JSON.parse(localStorage.getItem("data"));
    localStorage.removeItem("data");

    //RENDERING DESTINATION FL
    var destinationFlights = data.destinationFlights;
    var tableBody = $("#destination-flights").find("tbody");

    $("#from-flights-found").append("<span>" + destinationFlights.length + "</span> ");

    console.log(JSON.stringify(destinationFlights));
    renderFlights(tableBody, destinationFlights);


});


function renderFlights(tableBody, flightsData) {
    for (var i = 0; i < flightsData.length; i++) {
        tableBody.append("<tr>");
        tableBody.append("<td class=\"td-number\">" + flightsData[i].flightNumber + "</td>");
        tableBody.append("<td class=\"td-time\">" +
            "<p>" + convertTimeToString(flightsData[i].departureTime) +
            "<span>" + flightsData[i].whence + "</span></p></td>");
        tableBody.append("<td class=\"td-time\">" +
            "<p>" + calculateArrivalTime(flightsData[i].departureTime, flightsData[i].flightTime) +
            "<span>" + flightsData[i].destination + "</span></p></td>");
        tableBody.append("<td class=\"td-stop text-center\">" +
            "<div class=\"stop-cn\">" +
            "<label>" + convertTimeToString(flightsData[i].flightTime) + " h</label>" +
            "<span class=\"stops\">" +
            "<span class=\"stop\"></span>" +
            "</span>" +
            "<label>1 Stop</label>" +
            "</div>");
        tableBody.append("<td class=\"td-price text-center\">" +
            "<span><ins>" + flightsData[i].price + "</ins> USD</span>" +
            "</td>");
        tableBody.append("</tr>");
    }
}

function calculateArrivalTime(departureTime, flightTime) {
    var departureSeconds = (Number(departureTime.hour) * 3600) + (Number(departureTime.minute) * 60);
    var flightSeconds = (Number(flightTime.hour) * 3600) + (Number(flightTime.minute) * 60);
    var arrivalSeconds = departureSeconds + flightSeconds;
    return [pad(Math.floor(arrivalSeconds / 3600) % 60),
        pad(Math.floor(arrivalSeconds / 60) % 60)
    ].join(":");
}

function pad(num) {
    if (num < 10) {
        return "0" + num;
    } else {
        return "" + num;
    }
}

function convertTimeToString(time) {
    var hour = time.hour;
    var min = time.minute;
    var output = "";
    if (hour < 10) output += "0";
    output += hour;
    output += ":";
    if (min < 10) output += "0";
    output += min;
    return output;
}