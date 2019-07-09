$(function () {
    var id = getParameter("id");
    $.ajax({
        url: '/permission/getOtherPermissionListByRoleId',
        type: 'get',
        dataType: 'json',
        data:{'roleId':id},
        success: function (data) {
            var content = "";
            for(p in data){
                content+='<tr>\n' +
                    '                            <td>\n' +
                    '                                <input name="ids" type="checkbox" value="'+data[p].id+'">\n' +
                    '                            </td>\n' +
                    '                            <td>'+data[p].id+'</td>\n' +
                    '                            <td>'+data[p].permissionName+'</td>\n' +
                    '                            <td>'+data[p].url+'</td>\n' +
                    '\n' +
                    '                        </tr>';
            }
            $("#dataList").find('tbody').html(content);
        }
    });
});

addPermissionsToRole = function () {
    var id = getParameter("id");
    var ids = [];
    $("input[name='ids']:checked").each(function () {
        ids.push($(this).val());
    })
    $.ajax({
        url: '/role/addPermissionsToRole',
        type: 'post',
        dataType: 'json',
        data:{'roleId':id,'ids':ids.join('-')},
        success: function (data) {
            if(data.flag=="true"){
                location.href="/role/show_addPermissionsToRole_page?id="+id;
            }else{
                alert("error");
            }
        }
    });
}

