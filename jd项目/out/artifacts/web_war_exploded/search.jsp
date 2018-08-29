<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索结果页</title>
<link type="text/css" rel="stylesheet" href="css/search_style.css"/>
</head>
<body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layer.js"></script>
<script>
	function research(){
		var value = $("#reinput").val();
		window.location.href="search.do?value="+value;
	}
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
</script>
<!--头部导航开始-->
<%@include file="head.jsp"%>

<div id="bodyPart">		

	<div class="crumb">
		全部结果&nbsp;&gt;&nbsp;
		<strong>"${value }"</strong>
	</div>
	
	<div class="left">
		
		<div id="commend" class="m rank">
			<div class="mt"><h2>热销商品</h2></div>
			<div class="mc">
				<ul>
				<c:forEach items="${list2 }" var="pro">
					<li class="fore">						
						<div class="p-img"><a href="bookDetailShow.do?product_id=${pro.product_id}&cname=cname" target="_blank"><img width="50" height="50" src="${pro.picture }"></a></div> 
						<div class="p-name"><a href="bookDetailShow.do?product_id=${pro.product_id}&cname=cname" target="_blank">${pro.name }</a></div> 
						<div class="p-price">${pro.lower_price }</div> 
					</li>					
				</c:forEach>
				</ul>
			</div>		
		</div>
	</div><!-------left结束------->
	<div class="right-extra">
		<div id="select" class="m">
			<div class="mt">
				<h1>"${value }"</h1><strong> 搜索结果</strong>
			</div>
		</div>	
		<div id="filter">
		<!-- 
			<div class="fore item">排序：</div>
			<ul class="item tab">
				<li class="curr"><a href="#">相关性</a><span></span></li>
				<li><a href="#">销量</a><span></span></li>
				<li><b></b><a href="#">价格</a><span></span></li>
				<li><a href="#">好评度</a><span></span></li>
				<li><a href="#">上架时间</a><span></span></li>
			</ul>
		 -->
			<div class="pagin pagin-m fr">
				<span class="text">1/1</span>
				<span class="prev-disabled">上一页<b></b></span>
				<span class="next-disabled">下一页<b></b></span>			
			</div>
			
			<ul class="extra">
				<!-- <li class="total"><span>共<strong></strong>个商品</span></li> -->
			</ul>			
		</div>
		<div id="plist" class="m">
			<ul class="list-h clearfix">
			<c:forEach items="${products }" var="product">
				<li>
					<div class="p-img"><a href="bookDetailShow.do?product_id=${product.product_id}&cname=cname" target="_blank"><img width="160" height="160" src="${product.picture }"></a></div>					
					<div class="p-name"><a href="bookDetailShow.do?product_id=${product.product_id}&cname=cname" target="_blank">${product.name } <font style="color: red;">${value }</font>${product.keywords}<font class="adwords" style="color:red;"></font></a></div>
					<div class="p-price"><del>￥${product.fixed_price }</del><em></em><strong>&nbsp;&nbsp;&nbsp;￥${product.lower_price }</strong></div>
					<div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>	
					<div class="btns"><a class="btn-buy" target="_blank" href="initCart.do?product_id=${product.product_id }&num=1">购买</a>
					<input type="button" value="收藏" class="btn-coll" onclick="insert(${product.product_id})">
					</div>
				</li>
			</c:forEach>
		
			</ul>
		</div>
		

		<div class="pagin fr">
			<span class="prev-disabled">上一页<b></b></span>
			<a href="#" class="current">1</a>
			<span class="next-disabled">下一页<b></b></span>
		</div>
		
		
	</div>
	<div class="m" id="re-search"> 
		<dl> 
			<dt>重新搜索</dt>
			<dd>
				<input id="reinput" type="text" placeholder="pub"  class="text">
				<input type="button" value="搜&nbsp;索"class="button" onclick="research()">
			</dd>
		</dl>
	</div>		
	
	<div style="clear:both;"></div>
	<!-- 页脚 -->
	<%@include file="footer.jsp"%>
	
</div>
</body>
</html>
