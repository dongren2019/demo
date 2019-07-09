$(function () {
    var pageSize=2;
    var pageNum=1;
    load(pageNum,pageSize);
});

function load(pageNum,pageSize) {
    $.ajax({
        url:'/user/find_all?pageSize='+pageSize+"&pageNum="+pageNum,
        type:'get',
        dataType:'json',
        success:function(result){
            var tbody = $("#dataList").find("tbody");
            var ls;
            var data = result.list;
            for(var p in data){//遍历json数组时，这么写p为索引，0,1
                ls+='<tr>\n' +
                    '                                <td><input name="ids" type="checkbox"></td>\n' +
                    '                                <td>'+data[p].id+'</td>\n' +
                    '                                <td>'+data[p].username+'</td>\n' +
                    '                                <td>'+data[p].email+'</td>\n' +
                    '                                <td>'+data[p].phoneNum+'</td>\n' +
                    '                                <td>'+data[p].statusStr+'</td>\n' +
                    '                                <td class="text-center">\n' +
                    '                                    <button type="button" class="btn bg-olive btn-xs" onclick="showUserDetailPage('+data[p].id+')">详情</button>\n' +
                    '                                    <button type="button" class="btn bg-olive btn-xs" onclick="showOtherRoleListPage('+data[p].id+')">添加角色</button>\n' +
                    '                                </td>\n' +
                    '                            </tr>'
            }
            tbody.html(ls);
            $("#totalPage").html(result.pages);
            $("#totalCount").html(result.total);
            var begin;
            var end;
            if(result.pages<5){
                begin = 1;
                end = result.pages;
            }else{
                begin = pageNum - 2;
                end = pageNum+2;
                if(begin<1){
                    begin = 1;
                    end = begin +4;
                }
                if(end>result.pages){
                    end = result.pages;
                    begin = end -4;
                }
            }

            var ul="";
            ul+='<li>\n' +
                '            <a href="javascript:load('+1+','+pageSize+')" aria-label="Previous">首页</a>\n' +
                '                </li>';
            if(pageNum-1<1){
                ul+='<li id="preNum"><a href="javascript:load('+(pageNum)+','+pageSize+')">上一页</a></li>';
            }else{
                ul+='<li id="preNum"><a href="javascript:load('+(pageNum-1)+','+pageSize+')">上一页</a></li>';
            }
            for(var i=begin;i<=end;i++){
                if(i==pageNum){
                    ul+='<li><span style="background-color: #01ff70"><a href="javascript:load('+i+','+pageSize+')">'+i+'</a></span></li>';
                }else{
                    ul+='<li><a href="javascript:load('+i+','+pageSize+')">'+i+'</a></li>';
                }
            }
            if(pageNum+1>result.pages){
                ul+='<li id="ProNum"><a href="javascript:load('+(pageNum)+','+pageSize+')">下一页</a></li>';
            }else{
                ul+='<li id="ProNum"><a href="javascript:load('+(pageNum+1)+','+pageSize+')">下一页</a></li>';
            }
            ul+='<li>\n' +
                '            <a href="javascript:load('+result.pages+','+pageSize+')" aria-label="Next">尾页</a>\n' +
                '                </li>';
            $(".pagination").html(ul);
        }
    });
}

modifyPageSize = function () {
    load(1,$("select[name='pageSize']").val());
};
showUserDetailPage = function (id) {
    location.href="/user/show_userDeatil_page?id="+id;
}

showOtherRoleListPage = function (id) {
    location.href="/user/show_otherRoleList_page?id="+id;
}