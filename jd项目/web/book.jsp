<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(
		function(){
		var showIndex = 0; //要显示的图片的索引号
		var demo; //定时器
		autoScroll(); //不间断切换方法
		function autoScroll(){
			$("#pfocus_btn li").removeClass("current");
			$("#pfocus_btn a").removeClass("textcolor");
			$("#pfocus_btn li").eq(showIndex).addClass("current");
			$("#pfocus_btn a").eq(showIndex).addClass("textcolor");
			$("#pfocus_piclist li").eq(showIndex).fadeIn("slow");
			$("#pfocus_piclist li").eq(showIndex-1).hide();
			showIndex++;
			showIndex=showIndex>=5?0:showIndex;
			demo=setTimeout(autoScroll,2000);
		}
		
		function stopScroll(){
			clearTimeout(demo); //清除定时器
		}
		//鼠标移入移出小图按钮时执行
		$("#pfocus_btn li").hover(function(){
			stopScroll();
			$("#pfocus_btn li").removeClass("current");
			$("#pfocus_btn a").removeClass("textcolor");
			$(this).addClass("current");
			currentId=$(this).attr("id");
			picId = currentId.substring(currentId.length-1);
			$("#pfocus_btn a").eq(picId).addClass("textcolor");
			$("#pfocus_piclist li").hide();
			$("#pfocus_piclist li").eq(picId).fadeIn("slow");
		},function(){
			currentId=$(this).attr("id");
			picId = currentId.substring(currentId.length-1);
			showIndex = picId;
			autoScroll();
		})
		//鼠标移入移出大图时执行
		$("#pfocus_piclist li").hover(function(){
			stopScroll();
			$("#pfocus_piclist li").hide();
			$(this).show();
			currentId=$(this).attr("id");
			picId = currentId.substring(currentId.length-1);
			$("#pfocus_btn li").eq(picId).addClass("current");
			$("#pfocus_btn a").eq(picId).addClass("textcolor");
			
		},function(){
			currentId=$(this).attr("id");
			picId = currentId.substring(currentId.length-1);
			showIndex = picId;
			autoScroll();
		})
		
	})
</script>
<script>
	$(function(){
		$.ajax({
			url:"bookCategortiesMain.do",
			dataType:"json",
			data:{parent_id:0},
			success:function(data){
				for(var i=0;i<data.length;i++){
					var obj = data[i];
					//alert(obj.name);
					var str = "<div class='item'><h3><b>&gt;</b><a href='bookCategoriesDetail.do?category_id="+obj.category_id+"&name="+obj.name+"' class='dot'>"+obj.name+"</a></h3></div>";
					$(".sort_list").append($(str));
				}
			}
		});
	});
	
	
	var pageNumber=1;
	
	function new1(){
		var cid=21;
		var orderStd="add_time";
		var flag=true;
		var pageSize=3;
			$.ajax({
				url:"showProductOrderNew.do",
				data:{cid:cid,orderStd:orderStd,flag:flag,pageSize:pageSize,pageNumber:pageNumber},
				dataType:"json",
				success:function(productes1){
					  $("#newbooks").empty();
					  $("#newhotbooks").empty();
					  var count=1;
					for(var i=0;i<productes1.length;i++){				
						var pro = productes1[i];					
						var str='		<li>'
							+'<div class="pic_name"><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说" target="_blank">'+pro.name+'</a></div>'
							+'<div class="pic_book">'
							+'	<div class=""><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说"  target="_blank"><img src="'+pro.picture+'" /></a></div>'
							+'</div>'
							+'<div class="pic_intr"><a href="#" target="_blank">'+pro.description+'</a></div>'
							+'<div class="pic_price">定价：<del>￥'+pro.fixed_price+'</del></div>'
							+'<div class="pic_price">会员价：<strong>￥'+pro.lower_price+'</strong></div>'
							+'</li>	';           
						$("#newbooks").append($(str));						
					}
				}
			});
			 pageNumber=2;
	}
	$(function(){new1();prints();});
	
	function new2(){
		new1();
		pageNumber=1;
	}
	
	function prints(){
		var cid=22;
		var orderStd="print_number";
		var flag=true;
		var pageSize=8;
		var pageNumber=1;
		$.ajax({
			url:"showProductOrderPrint.do",
			data:{cid:cid,orderStd:orderStd,flag:flag,pageSize:pageSize,pageNumber:pageNumber},
			dataType:"json",
			success:function(productes1){
				  $("#hotbooks").empty();
				for(var i=0;i<productes1.length;i++){				
					var pro = productes1[i];					
					var str='<li>'
						+'<div class="pic_name"><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说" target="_blank">'+pro.name+'</a></div>'
						+'<div class="pic_book">'
						+'	<div class=""><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说"  target="_blank"><img src="'+pro.picture+'" /></a></div>'
						+'</div>'
						+'<div class="pic_intr"><a href="bookDetailShow.do?product_id='+pro.product_id+'&cname=小说" target="_blank">'+pro.description+'</a></div>'
						+'<div class="pic_price">定价：<del>￥'+pro.fixed_price+'</del></div>'
						+'<div class="pic_price">会员价：<strong>￥'+pro.lower_price+'</strong></div>'
						+'</li>	';           
					$("#hotbooks").append($(str));
					
				}
			}
		});
}
	
									
					
					

</script>
<style type="">
	#new1:hover,#new2:hover{
		cursor:pointer;
		background-color:#be3131;
	}
</style>
</head>
<body id="book">

<!--头部导航开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<!--主体main部分开始-->
<div class="main page_width">
	<!--左边部分开始-->
	<div id="left">
    	<div id="book_sort">
        	<div class="sort_title">
            	<h2>图书分类</h2>
            </div>
            <div class="sort_list">
           
            </div>          
        </div>
        
        <div id="publishers">
        	<div class="book_title">
				<h2>品牌出版商<br /><span>Top Publishers</span></h2>
			</div>
            <ul>
            	<li class='fore'><a href='#' target="_blank">人民出版社</a></li>
                <li class=''><a href='#' target="_blank">人民文学出版社</a></li>
                <li class=''><a href='#' target="_blank">中华书局</a></li>
                <li class=''><a href='#' target="_blank">生活・读书・新知三联书店</a></li>
                <li class=''><a href='#' target="_blank">商务印书馆</a></li>
                <li class=''><a href='#' target="_blank">科学出版社</a></li>
                <li class=''><a href='#' target="_blank">北京大学出版社</a></li>
                <li class=''><a href='#' target="_blank">中国人民大学出版社</a></li>
                <li class=''><a href='#' target="_blank">广东省出版集团</a></li>
                <li class=''><a href='#' target="_blank">河北出版传媒集团</a></li>
                <li class=''><a href='#' target="_blank">上海文艺出版集团</a></li>
                <li class=''><a href='#' target="_blank">重庆出版集团</a></li>
                <li class=''><a href='#' target="_blank">复旦大学出版社</a></li>
                <li class=''><a href='#' target="_blank">江苏译林出版社</a></li>
                <li class=''><a href='#' target="_blank">法律出版社</a></li>
                <li class=''><a href='#' target="_blank">时代光华图书有限公司</a></li>
                <li class=''><a href='#' target="_blank">童趣出版公司</a></li>
                <li class=''><a href='#' target="_blank">连环画出版社</a></li>
                <li class=''><a href='#' target="_blank">新华文轩出版传媒股份有限公司</a></li>
                <li class=''><a href='#' target="_blank">中国经济出版社</a></li>
            </ul>
        </div>
   
    </div>
    <!--左边部分结束-->
    
    <!--中间部分开始-->
    <div id="middle">
    	<div id="slide">
        	
            <div id="pfocus">
                <div id="pfocus_piclist">
                    <ul>
                        <li id="p0"><a href="#"><img src="img/ad01.jpg" /></a></li>
                        <li id="p1"><a href="#"><img src="img/ad02.jpg" /></a></li>
                        <li id="p2"><a href="#"><img src="img/ad03.jpg" /></a></li>
                        <li id="p3"><a href="#"><img src="img/ad04.jpg" /></a></li>
                        <li id="p4"><a href="#"><img src="img/ad05.jpg" /></a></li>
                        <li id="p5"><a href="#"><img src="img/ad06.jpg" /></a></li>
                    </ul>
                </div>
    			<div id="pfocus_btn">
                    <ul>
                        <li class="current" id="b0"><a href="#" class="textcolor">1</a></li>
                        <li id="b1"><a href="#">2</a></li>
                        <li id="b2"><a href="#">3</a></li>
                        <li id="b3"><a href="#">4</a></li>
                        <li id="b4"><a href="#">5</a></li>
                        <li id="b5"><a href="#">6</a></li>
                    </ul>
    			</div>
			</div>
        </div>
        
       
        
        <div class="clear"></div>
        
        <div id="new_books">
			<div class="book_tit">
				<h2><b style="font-size:16px;color:#289703;font-family: 'microsoft yahei',arial;">新书速递</b><br /><span>New Title Express</span></h2>
				<ul class="tab">	 
		  			<li id="new1"  onclick="new1()">1</li>	
                    <li  id="new2" onclick="new2()">2</li >
                  
				</ul>
			</div>
	        <div class='book_content'>
				<ul class="pic_list" id="newbooks">		
				
				</ul>
			</div>
       	</div>
        
        <div class="ad_middle"><a href="" target="_blank">
			<img height="120" width="546" src="img/book_14.jpg"/></a>
		</div>
        
        <div id="editor_recommend">
        	<div class="book_tit">
				<h2>热销图书<br /><span>Editor's Picks</span></h2>
			</div>
            <div class="book_content">
				<ul class="pic_list" id="hotbooks">
				
					
				</ul>
			</div>
           
        </div>
        
        
       
        
        
        <div id="discount">
			<div class="book_tit">
				<h2>超低折扣<br /><span>Discount Books</span></h2>
				
                <div class="extra">
					<a href="#" target="_blank">全部特价&gt;&gt;</a>
				</div>
			</div>
			<div class="book_content">
				<ul class="pic_list">
				<c:forEach items="${list4}" var="pro">
					<li>
						<div class="pic_book">
							<div><a href="bookDetailShow.do?product_id=${pro.product_id }&cname=小说" target="_blank"><img src="${pro.picture }" /></a></div>
						</div>
						<div class="pic_intr">
                        	<a href="bookDetailShow.do?product_id=${pro.product_id }&cname=小说" target="_blank">${pro.name }</a>
                        </div>
						<div class="pic_price">定价：<del>￥${pro.fixed_price }</del></div>
						<div class="pic_price">会员价：<strong>￥${pro.lower_price }</strong></div>
					</li>
				</c:forEach>
					
				</ul>
			</div>
			<br/>
			
		</div>
        
         	
    </div>
    <!--中间部分结束-->
    
    <!--右边部分开始-->
    <div id="right">
    	<div class="" id="report">
			<div class="book_tit">
				<h2>图书资讯<br /><span>Book News</span></h2>
			</div>
			<div class="book_content">
				<ul>
					<c:forEach items="${list2}" var="news">
                     <li>・<a  Target="_blank"  href="#">${news.title }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
        
        <div id="week_sale">
			<div class="book_tit">
				<h2>每周畅销榜<br /><span>Daily Bestsellers</span></h2>
			</div>
            <div class="book_content">
            	
                <ul class="rank">
                <c:forEach items="${list5 }" var="pro">
					<li class='fore'>
                   
                        <div class='p-img'><a href='bookDetailShow.do?product_id=${pro.product_id }&cname=小说' target='_blank'><img style="width:60px;" src='${pro.picture }'/></a></div>
                        <div class='p-name'><a href='bookDetailShow.do?product_id=${pro.product_id }&cname=小说'  target='_blank'>${pro.name }</a></div>
                        <div class='pic_price'>定价：<del>￥${pro.fixed_price }</del></div>
                        <div class='pic_price'>会员价：<strong>￥${pro.lower_price }</strong></div>
                    </li>
                </c:forEach>
               
				</ul>
            </div>       
		</div>
        
        <!-- 广告位  -->
        
        <div id="new_sale">
			<div class="book_tit">
				<h2>新书热销榜<br /><span>Hot New Books</span></h2>
			</div>
            <div class="book_content">
                <ul class="rank" >
                <c:forEach items="${hotnewbooks }" var="pro">
					<li class='fore'>
                	<div class='p-img'><a href='bookDetailShow.do?product_id=${pro.product_id }&cname=小说' target='_blank'><img style='width:60px;' src='${pro.picture }'/></a></div>
                	<div class='p-name'><a href='bookDetailShow.do?product_id=${pro.product_id }&cname=小说'  target='_blank'>${ pro.name}</a></div>
                	<div class='pic_price'>定价：<del>￥${ pro.fixed_price}</del></div>
                	<div class='pic_price'>会员价：<strong>￥${pro.lower_price }</strong></div>
                	</li>
                </c:forEach>
				</ul>
				
            </div>

		</div>
        
    </div>
    <!--右边部分结束-->
</div>

<%@include file="footer.jsp" %>
</body>
</html>
