<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/sign.css" />
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="">
	#msg{
		color:#ce3131;
	}
</style>
</head>
<script>
	/* //利用ajax进行表单提交的方法
	function commit(){
		//获取页面输入框的值
		var login_name =$("#login_name").val();
		var password = $("#password").val();
		//表单提交
		$.ajax({
			url:"login.do",
			data:{login_name:login_name,password:password},
			success:function(msg){
				if(msg=="用户名或密码错误！"){
					$("#msg").html(msg);
				}else{
					window.location.href="book_list.jsp";
				}			
			}
		});
	} */
		function sendLogin(){
		$("#login_form").submit();
	}
</script>
<body>
<!--快捷访问栏开始-->
<%@include file="head1.jsp"%>
<!--登录-->
<div id="bodyPart">

	<div class="login_logo">
    	<img src="images/logo_login.gif" />
    </div>
    <div id="login">
    	<div class="login_tit">
        	<h2>用户登录</h2><span></span>
        </div>
        <div class="login_form">
        	<div class="form">
			<form id="login_form" action="login.do" method="post">
             	<div class="form_info">
                	<div class="label">用户名：</div><input type="text" name="login_name" class="text"/>
                </div>
             	<div class="form_info">
                	<div class="label">密码：</div><input type="password" name="password" class="text"/>
                </div>
                <div class="form_info">
                	<div class="label">&nbsp;</div>
                	<input type="checkbox" checked="checked"/>记住用户名 
                </div>
                <div class="form_info">
                	<div class="label">&nbsp;</div>
                	<a href="javascript:"><img id="login_btn" src="images/login.jpeg" onclick="sendLogin()"/></a>
                	<span id="msg">${msg }</span>
                </div>
                <div class="cor_web">
                    使用合作网站账号登录京东：<br />
                    <img src="images/cor_web.jpeg" />
                </div>
			</form>
            </div>
            
            <div class="login_right">
            	<p>还不是京东商城用户？</p>
				<div class="guide_content">
                	现在免费注册成为京东商城用户，便能立刻享受便宜又放心的购物乐趣。
                </div>
                <div id="new_register"><a href="register.jsp"><img src="images/new_reg.jpeg" /></div>
				<!--<div id="other_register"><a href="#">企业用户注册</a>   <a href="#">校园用户注册</a></div>-->
            </div>
        </div>
    </div>
    
</div>

<div class="clear"></div>
<!--脚部开始-->
<%@include file="footer1.jsp"%>
</body>
</html>
