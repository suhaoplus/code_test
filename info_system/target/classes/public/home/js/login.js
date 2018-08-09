function login(){
    $.ajax({
        type:"POST",
        url:"/loginController",
        dataType:"json",
        data:{
            "loginName":$("#login_name").val(),
            "password":($("#login_pass").val())
        },
        async:true,
        success: function(data) {
            if (data.result=="admin")
                window.location.href="home/main.html";
            else if(data.result=="staff")
                window.location.href="home/main.html";

            else if (data.result=="wrong")
                $.toast({
                    heading: 'Error',
                    text: '用户名或密码错误!',
                    showHideTransition: 'fade',
                    icon: 'error',
                    position:'top-right'
                })
            else if (data.result=="empty")
                $.toast({
                    heading: 'Error',
                    text: '账号被停用!',
                    showHideTransition: 'fade',
                    icon: 'error',
                    position:'top-right'
                })
        }
    });
    return false;
}