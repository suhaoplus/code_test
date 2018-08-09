$(document).ready(function () {
    $.ajax({
        type:"GET",
        url:"/vaildUserAdmin",
        dataType:"json",
        success:function (data) {
            if (data.loginError=="true")
                window.location.href="/login.html";
            else if (data.loginError=="student")
                window.location.href="/student.html";
            else if (data.loginError=="teacher")
                window.location.href="/teacher.html";
            else if (data.type=="null")
                window.location.href="/login.html"
        }
    })
});