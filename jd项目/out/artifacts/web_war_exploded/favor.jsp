<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的收藏夹</title>

<link rel="stylesheet" type="text/css" href="css/userOther.css" />
<link rel="stylesheet" type="text/css" href="css/fav_message.css" />
<link type="text/css" rel="stylesheet" href="css/delete_order_style.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layer.js"></script>
</head>
<script>
	function del(img){
		var value = $(img).parent().find("input").val();
		var product_id = parseInt(value);
		$.ajax({
			url:"delInterest.do",
			data:{product_id:product_id},
			success:function(message){
				if("取消成功！"==message){
					$(img).parent().parent().remove();
					layer.msg(message);
				}else{
					layer.msg(message);
				}
			}
		});
	}
	function initCart(){
		var trs = $("#fav_product tr:not(:first)");
		trs.each(function(){
			var product_id = $(this).find("#input").val();
			$.ajax({
				url:"initCart.do",
				data:{product_id:product_id,num:1},
				success:function(){
					layer.msg("增加到购物车成功！！！");
				}	
			});
			$(this).remove();
		})
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
			 <a href="#">我的收藏夹</a>
        </div>
	</div>
	<div class="main">
		<!-- 左侧栏目 -->
		<%@include file="left.jsp"%>
		<!--右侧-->
<div id="right_order">
	<div id="trade">
	<table width="100%" id="trade_record" cellpadding="0" cellspacing="0">
    	<tr bgcolor="#FBF7EE">
        	<th align="left" colspan="6">&nbsp;收藏夹</th>
        </tr>
        <tr style="line-height:35px;">
        	
            <td colspan="6"><a href="javascript:initCart()"><img src="images/btn_03.gif" /></a></td>
        </tr>
        <tr><td colspan="6">
        <table width="100%" id="fav_product" cellpadding="0" cellspacing="0">
            <tr  align="center" bgcolor="#FBF7EE">
                <td width="5%"></td>
                <td width="20%">商品图片</td>
                <td width="32%">商品名称</td>
                <td width="10%">价格</td>
                <td width="11%">库存</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${maps }" var="map">
            <tr>
            	<td align="center"><input type="checkbox" style="border:1px solid #CCCCCC;" /></td>
                <td align="center"><a href="#"><img style="width:90px;height:120px;margin-top:10px;margin-bottom:10px;" src="${map.key.picture }" /></a></td>
                <td style="padding-left:5px;">
                <a href="#" style="font-size:14px;font-weight:bold;">${map.key.name }	
			</a><br />
			<span style="color:#999999;">收藏时间：
				<fmt:formatDate value="${map.value }" pattern="yyyy年MM月dd日  hh:mm:ss" />
				
				
				</span></td>
                <td align="center"><b>￥${map.key.lower_price }</b></td>
                <td align="center">现货</td>
                <td align="right" style="padding-right:8px;border-right:none;">
                	<a href="initCart.do?product_id=${map.key.product_id }&num=1"><img src="images/btn_07.gif" /></a><br />
                	<input id="input" type="hidden" value = "${map.key.product_id}"/>
                    <img src="images/btn_13.gif" style="margin-top:4px;" onclick="del(this)"/>
                </td>
            </tr>
            </c:forEach>
           
            
            
        </table>
        </td></tr>
        <tr>
        	<td colspan="5" style="marign-top:15px;border-right:none;">
            <div style="float:left;padding-top:6px;">&nbsp;<input type="checkbox" />全选</div>
            <div style="float:left;padding-top:6px;margin-left:6px;"">       	
                <a href="initCart.jsp"><img src="images/btn_07.gif"/></a>
            </div>
            </td>
        	<td align="right"><div id="page"><a href="#">1</a></div></td>
        </tr>
    </table>
    	
    
	</div>
</div>
</div>
</div>
<!--主体结束-->

<!-- 底部栏目 -->
	<%@include file="footer.jsp"%>
</div>
</body>
</html>
