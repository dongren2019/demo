$(function () {
    $.ajax({
        url:'/product/find_all',
        type:'post',
        dataType:'json',
        success:function(data){
            var tbody = $("#dataList").find("tbody");
            var ls;
            for(var p in data){//遍历json数组时，这么写p为索引，0,1
                ls+='<tr>\n' +
                    '                                <td><input name="ids" type="checkbox"></td>\n' +
                    '                                <td>'+data[p].id+'</td>\n' +
                    '                                <td>'+data[p].productNum+'</td>\n' +
                    '                                <td>'+data[p].productName+'</td>\n' +
                    '                                <td>'+data[p].cityName+'</td>\n' +
                    '                                <td>'+data[p].departureTimeStr+'</td>\n' +
                    '                                <td>'+data[p].productPrice+'</td>\n' +
                    '                                <td>'+data[p].productDesc+'</td>\n' +
                    '                                <td>'+data[p].productStatusStr+'</td>\n' +
                    '\n' +
                    '                                <td class="text-center">\n' +
                    '                                    <button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="all-order-manage-edit.html"\'>订单</button>\n' +
                    '                                    <button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="\orders\findById?id="+data[p].id\'>详情</button>\n' +
                    '                                    <button type="button" class="btn bg-olive btn-xs" onclick=\'location.href="all-order-manage-edit.html"\'>编辑</button>\n' +
                    '                                </td>\n' +
                    '                            </tr>'
            }
            tbody.html(ls);
        }
    });
});

