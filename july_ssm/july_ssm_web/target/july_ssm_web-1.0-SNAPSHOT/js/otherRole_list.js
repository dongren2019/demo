$(function () {
    var id = getParameter("id");
    $.ajax({
        url: '/role/getOtherRoleListByUserId',
        type: 'get',
        dataType: 'json',
        data:{'userId':id},
        success: function (data) {
            var content = "";
            for(p in data){
                content+='<tr>\n' +
                    '                            <td>\n' +
                    '                                <input name="ids" type="checkbox" value="'+data[p].id+'">\n' +
                    '                            </td>\n' +
                    '                            <td>'+data[p].id+'</td>\n' +
                    '                            <td>'+data[p].rolename+'</td>\n' +
                    '                            <td>'+data[p].roleDesc+'</td>\n' +
                    '\n' +
                    '                        </tr>';
            }
            $("#dataList").find('tbody').html(content);
        }
    });
});

addRolesToUser = function () {
    var id = getParameter("id");
    var ids = [];
    $("input[name='ids']:checked").each(function () {
        ids.push($(this).val());
    })
    $.ajax({
        url: '/user/addRolesToUser',
        type: 'post',
        dataType: 'json',
        data:{'userId':id,'ids':ids.join('-')},
        success: function (data) {
            if(data.flag=="true"){
                location.href="/user/show_otherRoleList_page?id="+id;
            }else{
                alert("error");
            }
        }
    });
}

