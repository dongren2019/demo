$(function () {
    var id = getParameter("id");
    $.ajax({
        url:'/orders/findOrdersById',
        type:'get',
        dataType:'json',
        data:{'id':id},
        success:function(result) {
            $("input[name='orderNum']").val(result.orderNum);
            $("input[name='orderTimeStr']").val(result.orderTimeStr);
            $("input[name='productName']").val(result.product.productName);
            $("input[name='cityName']").val(result.product.cityName);
            $("input[name='departureTimeStr']").val(result.product.departureTimeStr);
            $("input[name='peopleCount']").val(result.peopleCount);
            $("textarea[name='orderDesc']").val(result.orderDesc);

            var content = "";
            var travellers = result.travellers;
            $.each(travellers, function (n, value) {
                content+='<tr>\n' +
                    '                            <td><input type="text" size="10"\n' +
                    '                                       readonly="readonly" value="'+value.travellerTypeStr+'"></td>\n' +
                    '                            <td><input type="text" size="10"\n' +
                    '                                       readonly="readonly" value="'+value.name+'"></td>\n' +
                    '                            <td><input type="text" size="20"\n' +
                    '                                        readonly="readonly" value="'+value.sex+'"></td>\n' +
                    '                            <td><input type="text" size="15"\n' +
                    '                                        readonly="readonly" value="'+value.phoneNum+'"></td>\n' +
                    '                            <td><input type="text" size="28"\n' +
                    '                                        readonly="readonly" value="'+value.credentialsTypeStr+'"></td>\n' +
                    '                            <td><input type="text" size="10"\n' +
                    '                                       readonly="readonly" value="'+value.credentialsNum+'"></td>\n' +
                    '                        </tr>';
            });
            $("#dataList").find("tbody").html(content);

            $("#memberNickname").text(result.member.nickname);
            $("#memberName").text(result.member.name);
            $("#memberPhone").text(result.member.phoneNum);
            $("#memberEmail").text(result.member.email);

            $("#payTypeStr").text(result.payTypeStr);
            $("#productPrice").text(result.product.productPrice);
        }
    });
})