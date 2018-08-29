var Login = function () {

    var handleLogin = function() {
        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                login_name: {
                    required: true
                },
                login_pass: {
                    required: true
                },
                remember: {
                    required: false
                },
                loginValidateCode: {
                    required: true,
                    remote: {
                        url: "checkValidateCodeYesOrNot",
                        type: "post",
                        dataType: "json",
                        data: {
                            validateCode: function () {
                                return $("#loginValidateCode").val();
                            }
                        }
                    }
                }
            },

            messages: {
                login_pass: {
                    required: "用户名不能为空！"
                },
                login_pass: {
                    required: "密码不能为空！"
                },
                loginValidateCode: {
                    required: "请输入验证码",
                    remote: "验证码错误"
                }
            },

            invalidHandler: function (event, validator) { //display error alert on form submit
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function (error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function (form) {
                form.submit();
            }
        });

        $('#login_pass').keydown(function (e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    login();
                }
                return false;
            }
        });
        //输入密码回车默认登陆
        $("#login_name").bind("keydown", function (e) {
            if (e.which == 13) {
                e.preventDefault();
                $("#login_pass").focus();
            }
        }).focus();

        $("#loginBtn").bind("click",login);

        function login(){
            $("#login_pass").val($("#login_pass").val());
            $('.login-form').submit();
        }
    };

    return {
        //main function to initiate the module
        init: function () {

            handleLogin();

        }
    };

}();
