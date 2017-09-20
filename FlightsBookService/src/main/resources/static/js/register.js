$(document).ready(function () {

    //REGISTER VARS
    var emailAddress = $("#email");
    var password = $("#password");


    //BUTTON LISTENER
    $("#register-btn").click(function (event) {
        event.preventDefault();

        var formData = {
            email: emailAddress.val(),
            password: password.val()
        };
        console.log(JSON.stringify(formData));
        postData(formData)
    });


    function postData(data) {
        $.ajax({
            url: "/register",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (data, status, jqXHR) {
                console.log(JSON.stringify(data));
                if (data.success === true) {
                    $("#user-created").fadeIn(500);
                    document.getElementById("user-already-exists").style.display = "none";
                    document.getElementById("user-created").style.color = "#33cc33";
                    document.getElementById("email").style.border = "none";

                } else {
                    $("#user-already-exists").fadeIn(500);
                    document.getElementById("user-created").style.display = "none";
                    document.getElementById("user-already-exists").style.color = "#e60000";
                    document.getElementById("email").style.border = "2px solid #e60000";

                }

            }
        });
    }
});
