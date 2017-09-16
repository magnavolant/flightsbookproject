$(document).ready(function () {
    $("#search-btn").click(function (event) {
        event.preventDefault();
        //TODO NOW ITS SENDING INPUT SHOULD CONVERT TO AIRPORT CODE

        var formData = {
                whenceAirportCode: $("#flight-from").val(),
                destinationAirportCode: $("#flight-to").val(),
                departureDate: getDateAsString($("#flight-departing").datepicker("getDate")),
                arrivalDate: getDateAsString($("#flight-returning").datepicker("getDate")),
                peopleAmount:
                Number($("#adults-amount").find("option:selected").text()) +
                Number($("#children-amount").find("option:selected").text())
            }
        ;
        postData(formData)
    });

    function postData(data) {
        $.ajax({
            url: "/getflights",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (data, status, jqXHR) {
                $("#flight-found-alert").fadeIn(500);
                localStorage.setItem("data", JSON.stringify(data));
                setTimeout(function () {
                    $("#flight-found-alert").fadeOut(500);
                    window.location.href = "/testflightspage";
                }, 1500);
            },
            error: function (xhr) {
                if (xhr.status === 404) {
                    $("#flight-not-found-alert").fadeIn(500);
                    setTimeout(function () {
                        $("#flight-not-found-alert").fadeOut(500);
                    }, 4000);
                }

            }
        });
    }
});

function getDateAsString(date) {
    if (date !== null) {
        //Date picker widget is bugged so we are adding one day to each picked date
        date.setDate(date.getDate() + 1);
        return date.toISOString().slice(0, 10);
    } else {
        return null;
    }
}