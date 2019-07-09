$(function () {
    //当表单提交时，调用所有的校验方法
    addUser = function () {
        //1.发送数据到服务器
        /*if(checkUsername() && checkPassword() && checkEmail()){
            //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123*/
        $.ajax({
            url: '/user/save',
            type: 'post',
            data: $('form').serialize(),
            dataType: 'json',
            success: function (data) {
                //处理服务器响应的数据  data  {flag:true,errorMsg:"注册失败"}
                if (data.flag == "true") {
                    //注册成功，跳转成功页面
                    location.href = "/user/show_userList_page";
                } else {
                    alert("error");
                    //注册失败,给errorMsg添加提示信息
                    // $("#errorMsg").html(data.errorMsg);

                }
            }
        });

        /*}
        //2.不让页面跳转
        return false;
        //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交*/
    };

});