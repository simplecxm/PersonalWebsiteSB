$(document).ready(function () {
    $.ajax({
        type        : 'post',
        url         : 'http://localhost:8080/user/get_user_info.do',
        contentType : 'application/json;charset=utf-8',
        dataType    : 'json',
        data        :  data
    })
});