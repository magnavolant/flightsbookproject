$(document).ready(function () {
    var data = JSON.parse(localStorage.getItem("data"));
    localStorage.removeItem("data");

    //VARS
    var destinationFlights = data.destinationFlights;
    var returningFlights = data.returningFlights;
    var destinationTableBody = $("#destination-flights").find("tbody");
    var returningTableBody = $("#returning-flights").find("tbody");
    var totalFlightsFound = destinationFlights.length;

    //RENDERING DESTINATION FLIGHTS
    $("#from-flights-found").append("<span>" + destinationFlights.length + "</span> ");
    renderFlights(destinationTableBody, destinationFlights);

    //RENDERING RETURN FLIGHTS IF 2 WAYS PICKED
    if (returningFlights !== null) {
        totalFlightsFound += returningFlights.length;
        $("#to-flights-found").append("<span>" + returningFlights.length + "</span> ");
        renderFlights(returningTableBody, returningFlights);

    } else {
        $("#ret-tab").attr("hidden", "hidden");
    }

    //RENDERING TOTAL FLIGHTS
    $("#total-found").append(totalFlightsFound);

});

function renderFlights(tableBody, flightsData) {
    for (var i = 0; i < flightsData.length; i++) {
        var html = "";
        html += "<tr>";
        html += "<td class=\"td-number\">" + flightsData[i].flightNumber + "</td>";
        html += "<td class=\"td-time\">" +
            "<p>" + convertTimeToString(flightsData[i].departureTime) +
            "<span>" + flightsData[i].whence + "</span></p></td>";
        html += "<td class=\"td-time\">" +
            "<p>" + calculateArrivalTime(flightsData[i].departureTime, flightsData[i].flightTime) +
            "<span>" + flightsData[i].destination + "</span></p></td>";
        html += "<td class=\"td-stop text-center\">" +
            "<div class=\"stop-cn\">" +
            "<label>" + convertTimeToString(flightsData[i].flightTime) + " h</label>" +
            "<span class=\"stops\">" +
            "<span class=\"stop\"></span>" +
            "</span>" +
            "<label>1 Stop</label>" +
            "</div>";
        html += "<td class=\"td-price text-center\">" +
            "<span><ins>" + flightsData[i].price + "</ins> USD</span>" +
            "</td>";
        html += "</tr>";
        tableBody.append(html);
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