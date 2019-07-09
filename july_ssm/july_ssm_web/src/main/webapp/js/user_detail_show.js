$(function () {
    var id = getParameter("id");
    $.ajax({
        url:'/user/findUserDetail',
        type:'POST',
        dataType:'json',
        data:{'id':id},
        success:function(result) {
            console.log(result);
        }
    });
})