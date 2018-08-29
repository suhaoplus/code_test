<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/user_changepassword.css" rel="stylesheet"/>
<title>修改密码</title>
<style>
	#sp2{
		color:#be3131;
	}
</style>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	function sub(){
		var oval = $("#oldpass").val();
		var nval = $("#newpass").val();
		var nval2 = $("#newpass2").val();
		if(nval==nval2){
			$.ajax({
				url:"changepassword.do",
				data:{oval:oval,nval:nval},
				success:function(msg){	
					$("#sp1").html(msg);
					if("密码修改成功！请使用新密码重新登录！"==msg){
						$("#sp1").css("color","#228B22");
						setTimeout(function(){
							window.location="login.jsp";
						},2000)
					}else{
						$("#sp1").css("color","#be3131");
					}
					
				}
			});
		}else{
			$("#sp2").html("两次密码不一致！");
			
		}
		
	}
	//取消修改密码的操作
	function exit(){
		window.location="userHome.jsp";
	}
</script>
<body>
<!--头部导航开始-->
<%@include file="head.jsp"%>

<div id="bodyPart">
	<div class="w">
		<div class="crumb">
			 <a href="#">首页</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">我的京东</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">修改密码</a>
        </div>
	</div>
	
	<div class="main">
		<!-- 左侧栏目 -->
		<%@include file="left.jsp"%>
		<!-- 右侧栏目 -->
		<div class="right1">
			<table class="table_a">
				<tr>
					<th align="left" colspan="2"><strong>修改密码</strong></th>
				</tr>
				<tr>
					<td width="10%" align="center">
						旧密码：</td>
					<td><input type="password" id="oldpass"></td>
				</tr>
				<tr>
					<td width="10%" align="center">新密码：</td>
					<td><input type="password" id="newpass"></td>
				</tr>
				<tr>
					<td width="10%" align="center">确认密码：</td>
					<td><input type="password" id="newpass2"><span id="sp2"></span></td>
				</tr>
				<tr>
					<td class="align_Center" colspan="2">
						<!-- <input id="i1" type="submit" value="修改密码" ">
						<input id="i2" type="submit" value="取消" "> -->
						<button id="i1" onclick="sub()">修改密码</button>
						<button id="i2" onclick="exit()">取消</button>
						<span id="sp1"></span>
					</td>
				</tr>
			</table>
		</div>		
	</div>
	<!-- 底部栏目 -->
	<%@include file="footer.jsp"%>

		
</div>

</body>
</html>
