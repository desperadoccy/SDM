$(function() {
    $.get("header.html", function(data) {
        console.log("test");
        $("#header").html(data);
    });
});