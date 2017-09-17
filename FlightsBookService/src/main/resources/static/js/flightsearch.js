$(document).ready(function () {

    //"FROM" FIELD VARS
    var fromField = $("#flight-from");
    var fromValue = $("#from-value");
    var fromList = $("#from-dropdown");
    //"TO" FIELD VARS
    var toField = $("#flight-to");
    var toValue = $("#to-value");
    var toList = $("#to-dropdown");

    //FIELD TYPING LISTENERS
    fromField.keyup(function () {
        getAirports(fromField, fromList);
    });

    toField.keyup(function () {
        getAirports(toField, toList);
    });

    //FIELD CLICK LISTENERS
    fromField.click(function () {
        fromField.val("");
    });

    toField.click(function () {
        toField.val("");
    });

    //DROPDOWN LISTS LISTENERS
    fromList.on("click", "li", function (event) {
        swapFormValues(event, fromField, fromValue, fromList);
    });
    toList.on("click", "li", function (event) {
        swapFormValues(event, toField, toValue, toList);
    });

    //BUTTON LISTENER
    $("#search-btn").click(function (event) {
        event.preventDefault();
        //TODO NOW ITS SENDING INPUT SHOULD CONVERT TO AIRPORT CODE

        var formData = {
            whenceAirportCode: fromValue.val(),
            destinationAirportCode: toValue.val(),
            departureDate: getDateAsString($("#flight-departing").datepicker("getDate")),
            arrivalDate: getDateAsString($("#flight-returning").datepicker("getDate")),
            peopleAmount:
            Number($("#adults-amount").find("option:selected").text()) +
            Number($("#children-amount").find("option:selected").text())
        };
        console.log(JSON.stringify(formData));
        postData(formData)
    });

    //FUNCTIONS
    function swapFormValues(event, field, value, list) {
        field.val($(event.target).text());
        value.val($(event.target).text().substr(0, 3));
        list.empty();
    }

    function getAirports(field, list) {
        list.empty();
        if (field.val() !== "") {
            list.css({'display': ''});
            $.ajax({
                url: "/getAirports/" + field.val(),
                type: "GET",
                contentType: "application/json",
                success: function (data, status, jqXHR) {
                    for (var i = 0; i < data.length; i++) {
                        $("<li class='ss'>" + data[i].airportCode + "  " + data[i].town + "</li>").hide().appendTo(list)
                            .delay(i * 120).fadeIn(230);
                    }
                }
            });
        } else {
            list.css({'display': 'none'});
        }
        //SOMETIMES IS BUGGED
        // setTimeout(function () {
        //     list.empty();
        // }, 5000);
    }

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

    function getDateAsString(date) {
        if (date !== null) {
            //Date picker widget is bugged so we are adding one day to each picked date
            date.setDate(date.getDate() + 1);
            return date.toISOString().slice(0, 10);
        } else {
            return null;
        }
    }

});

