<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/book_list.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layer.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<script src="js/jquery.js"></script>
<script>
/* 	$(function(){
		var category_id=${param.category_id};
		$.ajax({
			url:"bookCategortiesMain.do",
			dataType:"json",
			type:"post",
			data:{parent_id:category_id},
			success:function(data){
				for(var i=0;i<data.length;i++){
					var obj=data[i];
					var str="<li><a href='#'>"+obj.name+"</a></li>"
					if(i==0){
						$("#ul1").append($(str));
						$("#ul2").append($(str));						
					}else{
						$("#ul1").append($(str));	
					}
				}
				
			}
		});
	}); */

	/* 时间戳转化开始 */
	Date.prototype.format = function (fmt) { //author: meizz  
	    var o = {  
	        "M+": this.getMonth() + 1, //月份  
	        "d+": this.getDate(), //日  
	        "h+": this.getHours(), //小时  
	        "m+": this.getMinutes(), //分  
	        "s+": this.getSeconds(), //秒   下一行的p是季度
	        "q+": Math.floor((this.getMonth() + 3) / 3), 
	        "S": this.getMilliseconds() //毫秒  
	    };  
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    return fmt;  
	}  
	  
	String.prototype.format = function (args) {  
	    var result = this;  
	    if (arguments.length > 0) {  
	        if (arguments.length == 1 && typeof (args) == "loginTime") {  
	            for (var key in args) {  
	                if (args[key] != undefined) {  
	                    var reg = new RegExp("({" + key + "})", "g");  
	                    result = result.replace(reg, args[key]);  
	                }  
	            }  
	        }  
	        else {  
	            for (var i = 0; i < arguments.length; i++) {  
	                if (arguments[i] != undefined) {  
	                    //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题  
	                    var reg = new RegExp("({)" + i + "(})", "g");  
	                    result = result.replace(reg, arguments[i]);  
	                }  
	            }  
	        }  
	    }  
	    return result;  
	}
	function dateFormat(value) {
	    return value ? new Date(value*1000).format("yyyy-MM-dd hh:mm:ss") : "";  
	}
	 /* 时间戳转化结束 */
	 $(function(){
	$("#btn").trigger("click");
	});
		
	var cid=0;
	var flag=true;
	var orderStd="print_number";
	var pageSize=4;
	var pageNumber=1;
	function ini(cid1){
		cid=cid1;
		sale();
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
	function foo(category_id,name){		
			 $("#li_a").text(name); 
			var cname=$("#aa").text();
			 cid=category_id;
		//异步获取分类对应的图书信息
		$.ajax({
			url:"showProduct.do",
			data:{category_id:category_id},
			dataType:"json",
			success:function(productes){
				  $(".product_list").empty();
				for(var i=0;i<productes.length;i++){
					var pro = productes[i];					
					var newdate = new Date(pro.publish_time.time);
					var dates = newdate.format("yyyy年MM月");
					var str="<div class='pro_item'>"
	            	+"<div class='pro_picture'><a href='bookDetailShow.do?product_id="+pro.product_id+"&cname="+cname+"'><img src='"+pro.picture+"' /></a></div>"
	            	+"<div class='pro_info'>"
	            	+"<div class='pro_up'>"
	            	+"<div class='bookName'><a href='bookDetailShow.do?product_id="+pro.product_id+"&cname="+cname+"'>"+pro.name+"</a></div>"
	            	+"<div class='author'>作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>"+pro.author+"</span> 著，译<br />出&nbsp;版&nbsp;社：<span>"+pro.publishing+"</span><br /></div>"
	            	+"</div>"
	            	+"<div class='pro_down'>"
	            	+"<div class='pro_left'>"
	            	+"	出版时间："+dates+"<br />"
	            	+"  定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥"+pro.fixed_price+"</s>"
	            	+"</div>"
	            	+"<div class='pro_right'>"
	            	+"顾客评价：<span class='star'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />"
	            	+"销量：<b><font>"+pro.print_number+"</font></b><span class='user_price'></span> 京东价：<b>￥"+pro.lower_price+"</b>（43折)"
	                +"</div>"
	                +"</div>"
	                +"<div class='clear'></div>"
	                +"<div class='book_btn'>"
	                +"<a href='initCart.do?product_id="+pro.product_id+"&num=1&cname="+cname+"' class='buy'></a><input type='button' value='收藏' class='favorite' onclick='insert("+pro.product_id+")'/>"
	                +"</div>"
	                +"</div>"            
	                +"</div>";	              
					$(".product_list").append($(str));
					
				}
			}
		});
	}

	function changeOrder(){
		var cname=$("#aa").text();
		$.ajax({
			url:"showProductOrderAJAX.do",
			data:{cid:cid,orderStd:orderStd,flag:flag,pageSize:pageSize,pageNumber:pageNumber},
			dataType:"json",
			success:function(productes1){
				  $(".product_list").empty();
				for(var i=0;i<productes1.length;i++){				
					var pro = productes1[i];					
					var newdate = new Date(pro.publish_time.time);
					var dates = newdate.format("yyyy年MM月");
					var str="<div class='pro_item'>"
	            	+"<div class='pro_picture'><a href='bookDetailShow.do?product_id="+pro.product_id+"&cname="+cname+"'><img src='"+pro.picture+"' /></a></div>"
	            	+"<div class='pro_info'>"
	            	+"<div class='pro_up'>"
	            	+"<div class='bookName'><a href='bookDetailShow.do?product_id="+pro.product_id+"&cname="+cname+"'>"+pro.name+"</a></div>"
	            	+"<div class='author'>作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>"+pro.author+"</span> 著，译<br />出&nbsp;版&nbsp;社：<span>"+pro.publishing+"</span><br /></div>"
	            	+"</div>"
	            	+"<div class='pro_down'>"
	            	+"<div class='pro_left'>"
	            	+"	出版时间："+dates+"<br />"
	            	+"  定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥"+pro.fixed_price+"</s>"
	            	+"</div>"
	            	+"<div class='pro_right'>"
	            	+"顾客评价：<span class='star'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />"
	            	+"销量：<b><font>"+pro.print_number+"</font></b><span class='user_price'></span> 京东价：<b>￥"+pro.lower_price+"</b>（43折)"
	                +"</div>"
	                +"</div>"
	                +"<div class='clear'></div>"
	                +"<div class='book_btn'>"
	                +"<a href='initCart.do?product_id="+pro.product_id+"&num=1&cname="+cname+"' class='buy'></a><input type='button' value='收藏' class='favorite' onclick='insert("+pro.product_id+")'/>"
	                +"</div>"
	                +"</div>"            
	                +"</div>";	              
					$(".product_list").append($(str));
					
				}
			}
		});
	}
	//初始按照销量从少到多排序，这个方法是按照销量从多到少排序

	function sale(){	
		first();
		$("#filter-curr").toggleClass("down");
		orderStd ="print_number";
		changeOrder();
		flag=!flag;
	}
	flag=true;
	function price(){
		first();
		$("#li1").toggleClass("down price");
		orderStd="lower_price";
		changeOrder();
		flag=!flag;
	}
 
	
		flag = true;
	function rebate(){
		first();
		$("#li2").toggleClass("down discount");
		orderStd="print_number";
		changeOrder();
		flag=!flag;
	}
		
		flag = true;
	function great(){
		first();
		$("#li3").toggleClass("down");
		orderStd="print_number";
		changeOrder();
		flag=!flag;
	}
	
		flag = true;
	function atime(){
		first();
		$("#li4").toggleClass("down");
		orderStd="add_time";
		changeOrder();
		flag=!flag;
	}
	
		flag = true;
	function ptime(){
		first();
		$("#li5").toggleClass("down");
		orderStd="publish_time";
		changeOrder();
		flag=!flag;
	}
	
	function first(){
		pageNumber=1;
		changeOrder();
	}
	function one(){
		pageNumber=1;
		changeOrder();
	}
	function two(){
		pageNumber=2;
		changeOrder();
	}
	function last(){
		pageNumber=2;
		changeOrder();
	}
	$(function(){
		$.ajax({
			url:"newHotProduct.do",
			dataType:"json",
			success:function(data){
				for(var i=0;i<data.length;i++){
					var pro=data[i];
					var str=''					
		                +'<div class="book_pic">'
		                +'<div class=""><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说" target="_blank"><img style="width:80px; " src="'+pro.picture +'"/></a></div>'
		                +' </div>'
		                +' <div class="book_text">'
		                +'  <div class="book_name"><a href="bookDetailShow.do?product_id='+pro.product_id +'&cname=小说" target="_blank"><font color="#FF0000">'+pro.name +'</font></a></div>'
		                +' <div class="book_intr">'+pro.description +'</div>'
		                +' <div class="book_more"><a href="bookDetailShow.do?product_id='+pro.product_id +'&cname=小说" target="_blank">深度了解&gt;&gt;</a></div>'
		                +' </div>	';
		             $("#newnew").append($(str));
				}
				
			}
		});
	});
</script>
<body id="book">
<a id="a1" href="javascript:ini(${cid})"><button id="btn" type="button"></button></a>
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<!--位置-->
<div id="position" class="page_width">
	<ul id="ul2">
     	<li><a href="book.jsp">首页</a></li>
        <li>&gt;</li>
     	<li><a href = "book.jsp">图书</a></li>
        <li>&gt;</li>
     	<li><a href="#"><span id="aa">${name }</span></a></li>
        <li>&gt;</li>
        <c:forEach items="${ bookcategories}" var="tit" end="0">
     		<li ><a id="li_a" href='#'>${tit.name}</a></li>
        </c:forEach>
     </ul>
</div>
<!--主体main部分开始-->
<div class="clear"></div>

<div id="main" class="page_width">
<!--左侧开始-->
	<div id="left_list">
    	<div id="same_sort">
			<div class="book_tit" style="width:209px;"><h2>浏览同级分类<br /><span>Browse other categories</span></h2></div>
				<div class="book_content">
					<ul id="ul1">
					
					<c:forEach items="${ bookcategories}" var="detail">
						<li><a href="javascript:foo(${detail.category_id},'${detail.name}')">${detail.name}</a></li>
					</c:forEach>
					
                  
					</ul>
                    <div class="clear"></div>
					<div class="extra"><a href="#">返回上级分类&gt;&gt;</a></div>
				</div>
			</div>	
			
            <div class="books">
			<div class="book_title">
				<h2>新书推荐<br /><span>New Releases</span></h2>
			</div>
		<div class="book_info" id="newnew">
		</div>
			
		
			</div>
			
            
		
			<div class="ad_left_list">
            	<div class=""><a href="#" target="_blank"><img src="img/book_61.jpg" /></a></div>
				<div class=""><a href="#" target="_blank"><img src="img/book_47.jpg"></a></div>
			</div>

    </div>
<!--左侧结束-->

<!--右侧开始-->    
    <div id="right_list">
    <div class="page">
			<span class="btn btn-info" onclick="first()">＜</span>
			<span class="btn btn-info" onclick="one()">1</span>
			<span class="btn btn-info" onclick="two()">2</span>
			<span class="btn btn-info" onclick="last()">＞</span>
		</div>

		<div id="filter">
			<div class="fore item">排序：</div>
			<ul class="item tab">
                <li id='filter-curr' class="up"><b></b><a href="javascript:sale()">销售排行</a><span></span></li>
                <li id="li1" class='up price'><b></b><a href="javascript:price()">价格</a><span></span></li>
                <li  id="li2" class="up discount"><b></b><a href="javascript:rebate()">折扣</a><span></span></li>
                <li id="li3" class="up"><b></b><a href='javascript:great()'>好评度</a><span></span></li>
                <li  id="li4" class="up"><b></b><a href='javascript:atime()'>上架时间</a><span></span></li>
                <li  id="li5" class="up"><b></b><a href='javascript:ptime()'>出版时间</a><span></span></li>
			</ul>
			<span class="clear"></span>
		</div>
        
        <div class="page">
			
		</div>
        
        <div class="clear"></div>
        
        <div class="product_list">
        	<c:forEach items="${productList}" var="pro">
        	<div class="pro_item">
            	<div class="pro_picture"><a href='bookDetailShow.do?product_id=${pro.product_id}&cname="${name }"+'><img src='${pro.picture}' /></a></div>
                <div class="pro_info">
                	<div class="pro_up">
                    	<div class="bookName"><a href='bookDetailShow.do?product_id=${pro.product_id}&cname="${name }"'>+${pro.name}+</a></div>
                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>${pro.author }</span> 著，译<br />出&nbsp;版&nbsp;社：<span>${pro.publishing }</span><br /></div>
                    </div>
                    <div class="pro_down">
                    	<div class="pro_left">
                    	出版时间：
                    	<fmt:formatDate value="${pro.publish_time}" pattern="yyyy年MM月"/><br />
                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥${pro.fixed_price }</s>
                        </div>
                        <div class="pro_right">
                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />
                      销量：<b><font>${pro.print_number}</font></b><span class="user_price"></span> 京东价：<b>￥${pro.lower_price }</b>（43折)
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="book_btn">
                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" onclick='insert(${pro.product_id})'/>
                    </div>
                </div>            
            </div>                         
        	</c:forEach>
        </div><!--列表结束-->
        
        <div class="page">
			<span class="btn btn-info" onclick="first()">＜</span>
			<span class="btn btn-info" onclick="one()">1</span>
			<span class="btn btn-info" onclick="two()">2</span>
			<span class="btn btn-info" onclick="last()">＞</span>
		</div>
          
    </div>
<!--右侧结束-->

</div>

<div class="clear"></div>
<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
