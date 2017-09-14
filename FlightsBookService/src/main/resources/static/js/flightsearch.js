$(document).ready(function () {


    $("#search-btn").click(function (event) {
        event.preventDefault();
        //TODO NOW ITS SENDING INPUT SHOULD CONVERT TO AIRPORT CODE

        //Date picker widget is bugged so we are adding one day to each picked date
        var date = $("#flight-departing").datepicker("getDate");
        date.setDate(date.getDate() + 1);

        var formData = {
            whenceAirportCode: $("#flight-from").val(),
            destinationAirportCode: $("#flight-to").val(),
            departureDate: date.toISOString().slice(0,10),
            peopleAmount: Number($("#adults-amount").find("option:selected").text()) +
            Number($("#children-amount").find("option:selected").text())
        };
        console.log(JSON.stringify(formData));
        postData(formData)
    });

    function postData(data) {
        $.ajax({
            url: "/getflights",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (data, status, jqXHR) {
                console.log(JSON.stringify(data));
                console.log(status);
                console.log(jqXHR);
                window.location.href = "http://stackoverflow.com"
            }
        });
    }
});