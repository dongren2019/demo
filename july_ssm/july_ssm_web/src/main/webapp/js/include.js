$(function () {
    $.get("/main-header.html",function (data) {
        $("#header").html(data);
    });
    $.get("/main-sidebar.html",function (data) {
        $("#sidebar").html(data);
    });
    $.get("/main-footer.html",function (data) {
        $("#footer").html(data);
    });
    $.get("/pagination.html",function (data) {
        $("#pagination").html(data);
    });
});