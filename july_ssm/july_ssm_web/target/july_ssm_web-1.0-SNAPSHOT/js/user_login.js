$(function () {
    userLogin = function(){
        $.ajax({
            url: '/login.do',
            type: 'post',
            data: $('form').serialize(),
            dataType: 'json',
            success: function (data) {
                alert(123);
            }
        });
    }
})