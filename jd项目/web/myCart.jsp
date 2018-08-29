<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/myCart_style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layer.js"></script>
<script src="js/jquery.js"></script>
<title>我的购物车</title>
<style>
	.Img:hover,#del:hover,#li1:hover,#li2:hover,#li3:hover,#li4:hover{
		cursor: pointer;
	}
	#t1{
		border-collapse: collapse;
	}
	#t1 tr,#t1 td{
		border:1px solid #666;
	}
</style>
</head>
<script>
	//计算购物列表中的商品总价
	function sum(){
		var s=0; 
		var trs = $("#CartTb tr:not(:first):not(:last)");
		trs.each(function(){
			s+=parseInt($(this).find('input').val())*parseFloat($(this).find("#price").text());
		});
		$("#cartBottom_price").html(s.toFixed(2));
	}
	//页面加载完后，调用sum()
	$(function(){
		sum();
	});
	//增加收藏
	function insert(product_id){
		$.ajax({
			url:"insertIntoInterest.do",
			data:{product_id:product_id,bak:''},
			success:function(message){
				if("收藏失败！请登录！"==message){
					window.location.href="login.jsp";
				}else {
					layer.msg(message);
				}
			}
		});
	}	
	//删除的商品增加到购物车
	function initCart(product_id){
		window.location.href="initCart.do?product_id="+product_id+"&num=1&cname=no"
	}
	//商品数量减一方法
	function lessen(img,product_id){
		var input = $(img).parent().next().find("#num");
		$.ajax({
			url:"myCartReduce.do",
			data:{product_id:product_id},
			success:function(){
				var value = $(input).val();
				if(value==1){
					$(input).val(1);
					sum();
				}else{
					$(input).val(parseInt(value)-1);
					sum();
				}
			}
		});		
	}
	
	//商品数量加一方法
	function raise(img,product_id){
		var input = $(img).parent().prev().find("#num");
		$.ajax({
			url:"myCartAdd.do",
			data:{product_id:product_id},
			success:function(){
				var value = $(input).val();
				$(input).val(parseInt(value)+1);
				sum();
				
			}
		});				
	}
	//删除一行数据的方法
	function del(span,product_id){
		var tr=$(span).parent().parent();
		
		$.ajax({
			url:"myCartDelOne.do",
			data:{product_id:product_id},
			success:function(){		
				$(span).parent().parent().remove();
				var str = "<tr>"
					+"<td style='width: 70px;'>"+$(tr).find("td:first").text()+"</td>"
					+"<td style='text-align: left;'><a href='"+$(tr).find("#hr").attr("href")+"'>"+$(tr).find("#huowu").text()+"</a></td>"
					+"<td style='width: 150px;'><span>￥</span><span class='price'>"+$("#cartBottom_price").text()+"</span></td>"
					+"<td style='width: 125px;'>"+$(tr).find("input").val()+"</td><td style='width: 100px;'><span style='cursor:pointer;' onclick='initCart("+product_id+")'>重新购买</span> | <span style='cursor:pointer;'onclick='insert("+product_id+");'>收藏</span></td>"
					+"</tr>";
				$("#tab").append($(str));
				sum();				
			}
		});				
	}
	//删除所有商品的方法
	function delAll(){
		var trs = $("#CartTb tr:not(:first):not(:last)");
		$.ajax({
			url:"myCartDelAll.do",
			data:{product_id:product_id},
			success:function(){
				trs.each(function(){
					var id = $(this).find("#span_2").text();
					var product_id=parseInt(id);
					$(this).remove();
					var str = "<tr>"
						+"<td style='width: 70px;'>"+$(this).find("td:first").text()+"</td>"
						+"<td style='text-align: left;'><a href='"+$(this).find("#hr").attr("href")+"'>"+$(this).find("#huowu").text()+"</a></td>"
						+"<td style='width: 150px;'><span>￥</span><span class='price'>"+$(this).find("#price").text()+"</span></td>"
						+"<td style='width: 125px;'>"+$(this).find("input").val()+"</td><td style='width: 100px;'><span style='cursor:pointer;' onclick='initCart("+product_id+")'>重新购买</span> | <span style='cursor:pointer;'onclick='insert("+product_id+");'>收藏</span></td>"
						+"</tr>";
					$("#tab").append($(str));
				});	
				 sum();	
			}	    		
		});				
	}
		
	
</script>
<body>
<!------------头部------------->
<%@include file="head1.jsp" %>

<div id="bodyPart">
	<div id="top">
		<div id="logo"></div>
		<div id="Cart">
			<ul>
				<li id="myCart" class="white">1.我的购物车</li>
				<li id="writeInfo">2.填写核对订单信息</li>
				<li id="successSub">3.成功提交订单</li>				
			</ul>
		</div>
	</div>
	<div id="top_myCart"></div>
	<div class="List_cart">
		<h2>
			<strong>我挑选的商品</strong>
		</h2>
		<div class="cart_table">
			<table id="CartTb" cellpadding="0" cellspacing="0" width="600">
				<tr class="align_Right">
					<td>商品编号</td>
					<td>商品名称</td>
					<td>京东价</td>
					<td>返现</td>
					<td>赠送积分</td>
					<td>商品数量</td>
					<td>删除商品</td>
				</tr>
				<c:forEach items="${maps }" var="map">
				<tr>
					<td><span id="span_2">${map.key.product_id}</span></td>
					<td id="align_Left">
						<div id="c_img"><a id="hr" href="bookDetailShow.do?product_id=${map.key.product_id }&cname=${cname}"><img style="width:50px;" src="${map.key.picture}"></a></div>
						<div id="c_info"><span style="font-size:16px;" id="huowu"><a href="bookDetailShow.do?product_id=${map.key.product_id }&cname=${cname}">${map.key.name}</a></span><br><span class="redColor"></div>
					</td>
					<td class="price">￥<span id="price">${map.key.lower_price}</span></td>
					<td>￥<span>0.00</span></td>
					<td>0</td>
					<td width="70">
						<div id="eqNum">
							<ul>
								<li class="Img"><img src="img/bag_close.gif" onclick="lessen(this,${map.key.product_id})"/></li>
								
								<li><input type="text"  value="${map.value}"  id="num" /></li>
							
								<li class="Img"><img src="img/bag_open.gif" onclick="raise(this,${map.key.product_id})"/></li>
							</ul>
						</div>
					</td>
					<td><span id="del" onclick="del(this,${map.key.product_id})">删除</span></td>
				</tr>			
				</c:forEach>
				<tr>
					<td colspan="7" class="align_Right" height="40"><b>商品总金额(不含运费)：<span>￥</span><span id="cartBottom_price" class="price">898.00</span>元</b></td>
				</tr>
			</table>
			<div id="cart_op">
				<ul>
					<li id="li1">寄存购物车</li>
					<li id="li2" onclick="delAll()">清空购物车</li>
					<li id="li3">凑单商品</li>
					<li id="li4"><a href="bookMain.do"><img src="img/btn0603_1.jpg"/></a><a id="aaa" href="orderInfoSure.do"><img src="img/btn0603_2.jpg"/></a></li>
				</ul>
			</div>
			
			<div id="DeledSkuInfo">
				<div>已删除商品，您可以重新购买或加入收藏夹：</div>
				<div id="divDeledSku">
					<div class="delItem">
						<table id="tab" class="delItem">
							
						</table>
					</div>
				</div>
			</div>

		</div><!---cart_table--->
	</div>
	
	
	
	<div class="List_cart t">
		<h2>
			<strong>我收藏的商品<span id="smallSize">(现在就放入购物车吧！)</span><a href="showInterest.do" id="extra">进入收藏夹>></a></strong>
		</h2>
		<div id="notFav" style="height:300px;">
		<table width="100%" id="t1" cellpadding="0" cellspacing="0">
			<c:forEach items="${maps2 }" var="map2">
            <tr>
            <td align="center"><a href="#"><img style="width:90px;height:120px;margin-top:10px;margin-bottom:10px;" src="${map2.key.picture }" /></a></td>
            	<td align="center">
                <a href="#" style="font-size:14px;font-weight:bold;">${map2.key.name }	
			</a>
			</td>
			<td align="center">
			<span style="color:#999999;">收藏时间：
				<fmt:formatDate value="${map2.value }" pattern="yyyy年MM月dd日  hh:mm:ss" />
  			</span></td>
                <td align="center"><b>￥${map2.key.lower_price }</b></td>
                <td align="center">现货</td>
                <td align="right" style="padding-right:8px;border-right:none;">
                	<a href="initCart.do?product_id=${map2.key.product_id }&num=1"><img src="images/btn_07.gif" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            </c:forEach>
		</table>
		</div>
	</div>
	<div id="help">
		帮我们改进购物车	</div>	
</div>
<!-- 页脚1 -->
<%@include file="footer1.jsp" %>

</body>
</html>
