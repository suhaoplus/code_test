<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/userInfo.css" />
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css" />
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>
	<!--快捷访问栏开始-->
	<%@include file="head.jsp"%>

	<div id="bodyPart">

		<div id="cart_left">
			<div id="succeed">
				<div class="corner tl"></div>
				<div class="corner tr"></div>
				<div class="corner bl"></div>
				<div class="corner br"></div>
				<div class="success">
					<b>&nbsp;</b> <a
						href="myCart.do?product_id=${product.product_id }&num=${num}&cname=${cname}"
						class="btn_pay"></a> <a href="book.jsp" class="btn_continue"></a>
				</div>
				<div id="cart_yb"></div>
			</div>

			<div id="similar">
				<div class="pro_tit">
					<div class="t_left"></div>
					<h2>购买该商品的用户还购买了</h2>
				</div>
				<div class="similar_data">
					<ul>
					<c:forEach items="${list1 }" var="pro1">
						<li>
							<div class="s_img">
								<a href="bookDetailShow.do?product_id=${pro1.product_id }&cname=小说"><img style="width:100px;"src="${pro1.picture }" />
							</div>
							<div class="s_info">
								<p>${pro1.name }</p>
								<b>￥${pro1.lower_price }</b>
								<div class="btn_add">
									<a href="initCart.do?product_id=${ pro1.product_id}+"&num=1&cname=小说">&nbsp;</a>
								</div>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
				<div class="m_bottom">
					<div class="bottom_left"></div>
				</div>
			</div>
			<div id="similar">
				<div class="pro_tit">
					<div class="t_left"></div>
					<h2>您可能还需要以下商品</h2>
				</div>
				<div class="similar_data">
					<ul>
						<c:forEach items="${list2 }" var="pro2">
						<li>
							<div class="s_img">
								<a href="bookDetailShow.do?product_id=${pro2.product_id }&cname=小说"><img style="width:100px;" src="${pro2.picture }" />
							</div>
							<div class="s_info">
								<p>${pro2.name }</p>
								<b>￥${pro2.lower_price }</b>
								<div class="btn_add">
									<a href="initCart.do?product_id=${ pro2.product_id}+"&num=1&cname=小说">&nbsp;</a>
								</div>
							</div>
						</li>
					</c:forEach>
						
					</ul>
				</div>
				<div class="m_bottom">
					<div class="bottom_left"></div>
				</div>
			</div>

		</div>

		<div id="cart_right">
			<div class="m" id="mycart_detail">
				<div class="corner tl"></div>
				<div class="corner tr"></div>
				<div class="corner bl"></div>
				<div class="corner br"></div>
				<div class="mt">
					<h2>
						<s></s>我的购物车
					</h2>
				</div>
				<div id="cart_content">
					<p>刚加入购物车的商品</p>
					<c:forEach items="${maps }" var="map" begin="${fn:length(maps)-1 }">
						<div>
							<div class="pro_img">
								<img style="width:70px;"src=${map.key.picture }></img>
							</div>
							<div class="pro_name">${map.key.name }<b>￥${map.key.lower_price }</b>
							</div>
						</div>
						<div class="clear"></div>
					</c:forEach>
					<p>您购物车中的其它商品</p>
					<div class="cart_total">
					<c:if test="${fn:length(maps)>=2 }">
						<c:forEach items="${maps }" var="map" end="${fn:length(maps)-2}">
							<div>
								<div class="pro_img">
									<img style="width:70px;" src="${map.key.picture }"></img>
								</div>
								<div class="pro_name">${map.key.name }<b>￥${map.key.lower_price }</b>
								</div>
							</div>
							<div class="clear"></div>
						</c:forEach>
					</c:if>
						共<b>${huowunum}</b>件商品<br /> 金额总计：<b>￥<span id="span2">${sum}</span></b>
					</div>
					<div>
						<a href="myCart.do?cname=${cname}" class="btn_pay"></a>
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
