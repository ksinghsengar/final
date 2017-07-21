$(document).ready(function () {
    $("#submitForm").on('click',function () {

        $.ajax({
            type: "POST",
            url: "/addTopic",
            data: {
                name: $("#topicName").val(),
                visibility: $("#topicvisibility").val()
            },
            success: function (response) {
                console.log("hello");
            },
            error: function (error) {
                console.log(" Error: " + JSON.stringify(error));

            }
        });

    });

});
