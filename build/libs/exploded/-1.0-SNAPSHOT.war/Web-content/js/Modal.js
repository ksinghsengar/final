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


    $("#submitLink").on('click',function () {

        $.ajax({
            type: "POST",
            url: "/addLink",
            data: {
                url: $("#link").val(),
                description: $("#description").val()
            },
            success: function (response) {
                console.log("hello");
            },
            error: function (error) {
                console.log(" Error: " + JSON.stringify(error));

            }
        });

    });

    $("#submitDocument").on('click',function () {

        $.ajax({
            type: "POST",
            url: "/addResource",
            data: {
                filePath: $("#document").val(),
                description: $("#documentDescription").val()
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
