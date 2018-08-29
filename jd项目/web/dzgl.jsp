<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css"/>
<link rel="stylesheet" type="text/css" href="css/userOther.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layer.js"></script>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	$(function(){
		$("#addr").hide();
	})
	function update(){}
	function del(id,input){
		$(input).parent().parent().parent().remove();
	}
	function add(){
		$("#addr").show();
	}
	function sub(){
		$("#addr").hide();
		var receive_name = $("#rename").val();
		var province = $("#select1 option:selected").text()+$("#select2 option:selected").text()+$("#select3 option:selected").text();
		var address = $("#add").val();
		var zipcode = $("#zip").val();
		var mobile =$("#mobile").val();
		var email = $("#email").val();
		$.ajax({
			url:"insertAddr.do",
			data:{receive_name:receive_name,province:province,address:address,zipcode:zipcode,mobile:mobile,email:email},
			success:function(data){
				if("没有登录！"==data){
					widow.location.href="login.jsp";
				}else{
					layer.msg(data);
				}
				
			}
		});
	}
</script>
<body>
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>

<div id="bodyPart">
	<div class="w">
		<div class="crumb">
			 <a href="#">首页</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">我的京东</a>
			 &nbsp;&gt;&nbsp;
			 <a href="#">地址管理</a>
        </div>
	</div>
	<!--主界面-->
	<div class="main">
	<!--左侧-->
	<%@include file="left.jsp"%>
	<!--右侧-->
	<div id="right_order">
		<div class="addr_m">
	    	<div class="addr_tit"><h3>收货地址管理</h3></div>
	        <div class="addr_c">
	        <c:forEach items="${list }" var="addr">
	        	<div class="addr_list">
	            	<div class="addr_num"><h3>1</h3></div>
	                <div class="addr_info">
	                <table>
	                	<tr>
	                    	<td>收&nbsp;货&nbsp;人：</td>
	                        <td>${addr.receive_name }</td>
	                    </tr>
	                    <tr>
	                    	<td>省&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
	                        <td>${addr.province }</td>
	                    </tr>
	                    <tr>
	                    	<td>地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	                        <td>${addr.address }</td>
	                    </tr>
	                    <tr>
	                    	<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	                        <td>${addr.zipcode }</td>
	                    </tr>
	                    <tr>
	                    	<td>联系电话：</td>
	                        <td>${addr.mobile }</td>
	                    </tr>
	                    <tr>
	                    	<td>手&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
	                        <td>${addr.telephone }</td>
	                    </tr>
	                    <tr>
	                    	<td>电子邮件：</td>
	                        <td>${addr.email }</td>
	                    </tr>
	                    <tr>
	                    	<td></td>
	                        <td style="height:24px" align="center" ><input type="button" value="修改" onclick="javascript:update(${addr.reveive_address_id})"/>&nbsp;<input type="button" value="删除" onclick="javascript:del(${addr.reveive_address_id},this)"/></td>
	                    </tr>
	                </table>
	                </div>
	            </div>
	        </c:forEach>
	            
	          
				<div class="clear" style="clear:both;"></div>
	    	<div id="addr_new">如果您有新地址，请<a href="javascript:add()">添加新地址</a></div>
	    	</div>
		</div>
	    <div class="addr_m" id="addr">
	    	<div class="addr_tit"><h3>地址维护</h3></div>
	        <div class="addr_c">
	        	<div id="addr_add">
	            	<table>
	                	<tr>
	                    	<td>收&nbsp;货&nbsp;人：</td>
	                        <td><input id="rename" type="text"/><font color="#ff0000">*</font></td>
	                    </tr>
	                    <tr>
	                    	<td>省&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
	                        <td>
	                        	<select id="select1">
	                            	<option>北京&nbsp;&nbsp;</option>
	                            	<option>河北&nbsp;&nbsp;</option>
	                            </select>
	                            <select id="select2">
	                            	<option>海淀区&nbsp;&nbsp;</option>
	                            	<option>丰台区&nbsp;&nbsp;</option>
	                            	<option>朝阳区&nbsp;&nbsp;</option>
	                            	<option>大兴区&nbsp;&nbsp;</option>
	                            	<option>房山区&nbsp;&nbsp;</option>
	                            	<option>东城区&nbsp;&nbsp;</option>
	                            	<option>西城区&nbsp;&nbsp;</option>
	                            	<option>延庆区&nbsp;&nbsp;</option>
	                            </select>
	                            <select id="select3">
	                            	<option>二环以内&nbsp;&nbsp;</option>
	                            	<option>二环到三环以内&nbsp;&nbsp;</option>
	                            	<option>三环到四环以内&nbsp;&nbsp;</option>
	                            	<option>四环到五环以内&nbsp;&nbsp;</option>
	                            </select>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<td>地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	                        <td><input id="add" type="text" size="32"/><font color="#ff0000">*</font></td>
	                    </tr>
	                    <tr>
	                    	<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	                        <td><input id="zip" type="text"/></td>
	                    </tr>
	                    <tr>
	                    	<td>联系电话：</td>
	                        <td><input id="mobile" type="text"/>如：6543788</td>
	                    </tr>
	                    <tr>
	                    	<td>手&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
	                        <td><input id="phone" type="text"/>我们会用免费短信通知你发货信息</td>
	                    </tr>
	                    <tr>
	                    	<td>电子邮件：</td>
	                        <td><input id="email" type="text"/></td>
	                    </tr>
	                    <tr>
	                    	<td></td>
	                        <td style="height:44px" ><input type="button" value="提交" onclick="sub()"/></td>
	                    </tr>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
	</div>
</div>
<!--主体结束-->

<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
