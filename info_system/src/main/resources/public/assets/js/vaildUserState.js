$(document).ready(function () {
    $.ajax({
        type:"POST",
        dataType:"json",
        url:"/vaildUser",
        success:function (data) {
            if (data.loginError=="true") {
                alert("请重新登录");
                window.parent.location.href="/login";
            }
        }
    })
});