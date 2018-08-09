<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="css/head.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	function search(){
		var value = $("#keyword").val();
		window.location.href="search.do?value="+value;
	} 
</script>
<!--快捷访问栏开始-->
<div id="shortcut">
	<div class="page_width">
		<ul>
			<li class="welcome">您好！欢迎来到京东商城！<span><a href="login.jsp">[请登录]</a>，新用户？<a href="register.jsp" class="link_reg">[免费注册]</a></span></li>
			<li class="my_order"><a href="orderList.jsp">我的订单</a></li>
			<li><a href="userHome.jsp">我的京东</a></li>
			<li><a href="myCart.jsp">我的购物车</a></li>
			<li class="sub">
                <a href="#" target="_blank">帮助中心</a>
            </li>
            <li><a href="logout.jsp">退出登录</a></li>
		</ul>
		<span class="clear"></span>
	</div>
</div>
<!--头部导航开始-->
<div id="header" class="page_width">

	<div id="logo">
    	<a href="book.jsp"><img src="images/logo.gif"width="251" height="46"/></a>
    </div>
    
    <div class="clear"></div>
    <div id="book_search">
    	<div id="allsort">
        	<div id="more_sort">
        		<strong>图书分类</strong>
            </div>
        </div>
        <div id="search">
        	<!--<div id="sub_search">-->
            	<input type="text" id="keyword" placeholder="输入查询的模糊内容"  />
            <!--</div>-->
            <input type="submit" id="btn_search" value="搜 索" onclick="search()"/>
        </div>
        
        <ul id="mycart">
        	<li id="cart_info">购物车<b><font color="#066FC9">${huowunum }</font></b>件</li>
            <li><font color="#ffffff">去结算</font></li>
        </ul>
    </div>
</div>
<!--头部导航结束-->


