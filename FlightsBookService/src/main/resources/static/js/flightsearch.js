$(document).ready(function () {
    $("#search-btn").click(function (event) {
        event.preventDefault();
        //TODO NOW ITS SENDING INPUT SHOULD CONVERT TO AIRPORT CODE
        var formData = {
            whenceAirportCode: $("#flight-from").val(),
            destinationAirportCode: $("#flight-to").val(),
            departureDate: $("#flight-departing").val(),
            peopleAmount: $("#adults-amount").val() +
            $("#children-amount").val()
        };
        console.log(formData.whenceAirportCode + " " + formData.destinationAirportCode +
        " " + formData.departureDate + " " + formData.peopleAmount);
    });


});