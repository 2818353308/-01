<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.user.userel" prefix="u" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Newspaper</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	
	<!-- Owl Carousel Assets -->
    <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="js/jquery-2.1.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="js/bootstrap.min.js"></script>
	
<style type="text/css">

.one{color:#0000FF;}

.two{color:#00FF00;}

.three{color:#FFFF00;}

.four{color:#00FFFF;}

.five{color:#CC9933;}

.six{ color:#FF66CC;}

.seven{color:#00FF00;}

#touxiang {
	/* 		margin:10px auto; */
	border-radius: 50%;
	height: 35px;
	width: 35px;
}
#touxiang2 {
	/* 		margin:10px auto; */
	border-radius: 50%;
	height: 25px;
	width: 25px;
}

.tiezi {
	margin: 0 auto;
	width: 600px;
	border: 1px solid #000;
}
.red{
	color: red;
}

</style>
</head>

<body>
<header>
	<!--Top-->
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<c:if test="${loginUser!=null }">
					<strong><img alt="" id="touxiang"
							src="${pageContext.request.contextPath}/${loginUser.head_portrait}">
						<i id="one">${loginUser.uname}</i>
						<i><a href="${pageContext.request.contextPath}/user/personal.htmlx">个人中心</a></i>
					</strong>
					</c:if>
				</div>
				<div class="col-md-6">
					<ul class="list-inline top-link link">
						<li><a href="index.jsp"><i class="fa fa-home"></i>首页</a></li>
<!-- 						<li><a href="contact.jsp"><i class="fa fa-comments"></i>联系我们</a></li> -->
						<li><a href="tiezi.jsp"><i class="fa fa-question-circle"></i>发帖</a></li>
						<c:choose>
							<c:when test="${loginUser!=null }">
								<li><a href="${pageContext.request.contextPath}/logout.htmlx">退出登录</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	
	<!--Navigation-->
    <nav id="menu" class="navbar container">
		<div class="navbar-header">
			<button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			<a class="navbar-brand" href="#">
				<div class="logo"><span>就是不正经</span></div>
			</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">首页</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Account <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="login.jsp">登录</a></li>
								<li><a href="register.jsp">注册</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">右友圈<i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
							    <li><a href="queryGpost.htmlx?params['g_type']=搞笑">搞笑</a></li>
								<li><a href="queryGpost.htmlx?params['g_type']=娱乐">娱乐</a></li>
								
							</ul>
						</div> 
					</div>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">发现 <i class="fa fa-arrow-circle-o-down"></i></a>
					<div class="dropdown-menu">
						<div class="dropdown-inner">
							<ul class="list-unstyled">
								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=搞笑">搞笑</a></li>
								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=校园">校园</a></li>
								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=游戏">游戏</a></li>
								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=老司机">老司机</a></li>
<%-- 								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=互动">互动</a></li> --%>
<%-- 								<li><a href="${pageContext.request.contextPath}/xianshi.htmlx?params['post_type']=情感">情感</a></li> --%>
							</ul>
						</div>
					</div>
				</li>
				<li><a href="contact.jsp"><i class="fa fa-envelope"></i>联系我们</a></li>
			</ul>
			<ul class="list-inline navbar-right top-social">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube"></i></a></li>
			</ul>
		</div>
	</nav>
</header>
	<div class="featured container">
		<div id="owl-demo" class="owl-carousel">
			<!-- <div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>套路</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p></p>
					</div>
					<img src="images/1.jpg" />
				</div>
			</div> -->
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>漂流瓶</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>梦到小兵张嘎，我是那个胖翻译？？？真特么刺激</p>
					</div>
					<img src="images/2.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>模糊</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>你接吻时遇到过什么尴尬事吗？</p>
					</div>
					<img src="images/3.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>风云莫测</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>梦到好多女鬼..她们说我丑</p>
					</div>
					<img src="images/8.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>科幻</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>家里管得严</p>
					</div>
					<img src="images/9.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>未知</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>纳尼纳尼</p>
					</div>
					<img src="images/10.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>动物</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>萌</p>
					</div>
					<img src="images/11.jpg" />
				</div>
			</div>
			<div class="item">
				<div class="zoom-container">
					<div class="zoom-caption">
						<span>我的世界</span>
						<a href="#">
							<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
						</a>
						<p>我没照片，但人超美</p>
					</div>
					<img src="images/12.jpg" />
				</div>
			</div>
		</div>
	</div>
	<!-- Header -->    
	
	<!-- /////////////////////////////////////////Content -->
	<div id="page-content" class="single-page container">
		<div class="row">
			<div id="main-content" class="col-md-8">
			<!-- 评论 -->
			<c:forEach var="item" items="${paper}">
				<div class="box">
					<div class="line"></div>
					<h1 class="vid-name"><a href="#">发表帖子的人的头像及用户名</a></h1>
					<div class="info">
						<h6>
							<img id="touxiang" alt="头像未加载出来" src="${pageContext.request.contextPath}/${item.user.head_portrait}">
							<a href="#">${item.user.uname}</a></h6>
						<span><i class="fa fa-calendar"></i>${item.post_time }</span> 
						<span><i class="fa fa-heart"></i>
							<c:choose>
									<c:when test="${item.state==1}"><a href="#"> 已赞 (${u:querytotal(item.post_id)}) </a></c:when>
									<c:otherwise><a href="${pageContext.request.contextPath}/user/dianzan.htmlx?t_id=${item.post_id }">未赞(${u:querytotal(item.post_id)})</a></c:otherwise>
							</c:choose>
						</span>
					</div>
					<div style="margin-top: 20px">
						<div class="zoom-container">
								<div class="zoom-caption">
								</div>
								<img src="${pageContext.request.contextPath}/${item.post_image }" />
							</div>
							<p>${item.post_content}</p>
					</div>
					<!-- 循环出该帖子的评论 -->
					<c:forEach  var="i" items="${item.list_Comment}">
						<h5><img alt="头像加载中" id="touxiang2" src="${pageContext.request.contextPath}/${i.user.head_portrait}">
							<font size="3px" color="green">${i.user.uname}</font>
						</h5>
						<p style="margin-top: 20px">&emsp;&emsp;${i.c_content}</p>
						<c:if test="${loginUser.uname==i.user.uname }">
						<div align="right"><a href="user/delete_comment.htmlx?c_id=${i.c_id}">删除</a></div>
						</c:if>
					</c:forEach>
					<!-- <div class="vid-tags">
						<a href="#">Animal</a>
						<a href="#">Aenean</a>
						<a href="#">Feugiat</a>
						<a href="#">Risus</a>
						<a href="#">Magna</a>
					</div> -->
					<div class="line"></div>
					<div class="comment">
						<h3>评论</h3>
						<form name="form1" method="post" action="${pageContext.request.contextPath}/user/add_comment.htmlx">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
									<input type="hidden" name="p_id" value="${item.post_id }"/>
										<textarea name="c_content" id="message" class="form-control" rows="4" cols="25" required="required"
										placeholder="评论内容" required></textarea>
									</div>						
									<button type="submit" class="btn btn-4 btn-block" name="btnBooking" id="btnBbooking">
								发送</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				</c:forEach>
				<div class="box">
					<div class="box-header header-natural">
						<h2>RELATED VIDEOS</h2>
					</div>
					<div class="box-content">
						<div class="row">
							<div class="col-md-4">
								<div class="wrap-vid">
									<div class="zoom-container">
										<div class="zoom-caption">
											<span>Youtube</span>
											<a href="#">
												<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
											</a>
											<p>Video's Name</p>
										</div>
										<img src="images/2.jpg" />
									</div>
									<h3 class="vid-name"><a href="#">Video's Name</a></h3>
									<div class="info">
										<h5>By <a href="#">Kelvin</a></h5>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="wrap-vid">
									<div class="zoom-container">
										<div class="zoom-caption">
											<span>Youtube</span>
											<a href="#">
												<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
											</a>
											<p>Video's Name</p>
										</div>
										<img src="images/2.jpg" />
									</div>
									<h3 class="vid-name"><a href="#">Video's Name</a></h3>
									<div class="info">
										<h5>By <a href="#">Kelvin</a></h5>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="wrap-vid">
									<div class="zoom-container">
										<div class="zoom-caption">
											<span>Youtube</span>
											<a href="#">
												<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
											</a>
											<p>Video's Name</p>
										</div>
										<img src="images/2.jpg" />
									</div>
									<h3 class="vid-name"><a href="#">Video's Name</a></h3>
									<div class="info">
										<h5>By <a href="#">Kelvin</a></h5>
										<span><i class="fa fa-calendar"></i>25/3/2015</span> 
										<span><i class="fa fa-heart"></i>1,200</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="sidebar" class="col-md-4">
				<!---- Start Widget ---->
				<div class="widget wid-follow">
						<div class="heading"><h4>Follow Us</h4></div>
						<div class="content">
							<ul class="list-inline">
								<li>
									<a href="facebook.com/">
										<div class="box-facebook">
											<span class="fa fa-facebook fa-2x icon"></span>
											<span>5250</span>
											<span>粉丝</span>
										</div>
									</a>
								</li>
								<li>
									<a href="facebook.com/">
										<div class="box-twitter">
											<span class="fa fa-twitter fa-2x icon"></span>
											<span>6600</span>
											<span>关注</span>
										</div>
									</a>
								</li>
								<li>
									<a href="facebook.com/">
										<div class="box-google">
											<span class="fa fa-google-plus fa-2x icon"></span>
											<span>6233</span>
											<span>获赞</span>
										</div>
									</a>
								</li>
							</ul>
							<img src="images/banner.jpg" />
						</div>
					</div>
				<!---- Start Widget ---->
				<div class="widget wid-post">
						<div class="heading"><h4>收藏夹</h4></div>
						<div class="content">
							<div class="post wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<a href="#">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
									</div>
									<img src="images/1.jpg" />
								</div>
								 <div class="wrapper">
									 <h5 class="vid-name"><a href="#">说说你的梦</a></h5>
								     <div class="info">
									 <span><i class="fa fa-calendar"></i>09/3/2017</span> 
								 </div>
								</div>
							</div>
							<div class="post wrap-vid">
								<div class="zoom-container">
											<div class="zoom-caption">
												<a href="#">
													<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
												</a>
											</div>
											<img src="images/2.jpg" />
										</div>
								<div class="wrapper">
									<h5 class="vid-name"><a href="#">套路表情包</a></h5>
									<div class="info">
										<span><i class="fa fa-calendar"></i>25/5/2017</span> 
									</div>
								</div>
							</div>
							<div class="post wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<a href="#">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
									</div>
									<img src="images/3.jpg" />
								</div>
								<div class="wrapper">
									<h5 class="vid-name"><a href="#">音乐收藏的时光</a></h5>
									<div class="info">
								         <span><i class="fa fa-calendar"></i>25/3/2017</span> 
									</div>
								</div>
							</div>
						</div>
					</div>
				<!---- Start Widget ---->
				<div class="widget ">
						<div class="heading"><h4>顶过的帖子</h4></div>
						<div class="content">
							<div class="wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<a href="">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
									</div>
									<img src="images/1.jpg" />
								</div>
								<h3 class="vid-name"><a href="#">熊孩子毁灭全世界</a></h3>
								<div class="info">
									<h5>By <a href="#">lily</a></h5>
									<span><i class="fa fa-calendar"></i>25/3/2017</span> 
									<span><i class="fa fa-heart"></i>1,300</span>
								</div>
							</div>
							<div class="wrap-vid">
								<div class="zoom-container">
									<div class="zoom-caption">
										<a href="">
											<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
										</a>
									</div>
									<img src="images/2.jpg" />
								</div>
								<h3 class="vid-name"><a href="#">神评论集中营</a></h3>
								<div class="info">
									<h5>By <a href="#">daviy</a></h5>
									<span><i class="fa fa-calendar"></i>25/5/2017</span> 
									<span><i class="fa fa-heart"></i>1,200</span>
								</div>
							</div>
							<div class="wrap-vid">
								<div class="zoom-container">
								<div class="zoom-caption">
									<a href="">
										<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
									</a>
								</div>
								<img src="images/3.jpg" />
							</div>
							<h3 class="vid-name"><a href="#">王者荣耀搞笑时刻</a></h3>
							<div class="info">
								<h5>By <a href="#">Kelvin</a></h5>
								<span><i class="fa fa-calendar"></i>15/3/2017</span> 
								<span><i class="fa fa-heart"></i>6,200</span>
							</div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
    
    <footer>
		<div class="wrap-footer">
			<%-- <div class="container">
				<div class="row">
					<div class="col-md-4 col-footer footer-1">
						<div class="footer-heading"><h1><span style="color: #fff;">NEWSPAPER</span></h1></div>
						<div class="content">
							<p>Never missed any post published in our site. Subscribe to our daly newsletter now.</p>
							<strong>Email address:</strong>
							<form action="#" method="post">
								<input type="text" name="your-name" value="" size="40" placeholder="Your Email" />
								<input type="submit" value="SUBSCRIBE" class="btn btn-3" />
							</form>
						</div>
					</div>
					<div class="col-md-4 col-footer footer-2">
						<div class="footer-heading"><h4>Tags</h4></div>
						<div class="content">
							<a href="#">animals</a>
							<a href="#">cooking</a>
							<a href="#">countries</a>
							<a href="#">city</a>
							<a href="#">children</a>
							<a href="#">home</a>
							<a href="#">likes</a>
							<a href="#">photo</a>
							<a href="#">link</a>
							<a href="#">law</a>
							<a href="#">shopping</a>
							<a href="#">skate</a>
							<a href="#">scholl</a>
							<a href="#">video</a>
							<a href="#">travel</a>
							<a href="#">images</a>
							<a href="#">love</a>
							<a href="#">lists</a>
							<a href="#">makeup</a>
							<a href="#">media</a>
							<a href="#">password</a>
							<a href="#">pagination</a>
							<a href="#">wildlife</a>
						</div>
					</div>
					<div class="col-md-4 col-footer footer-3">
						<div class="footer-heading"><h4>Link List</h4></div>
						<div class="content">
							<ul>
								<li><a href="#">MOST VISITED COUNTRIES</a></li>
								<li><a href="#">5 PLACES THAT MAKE A GREAT HOLIDAY</a></li>
								<li><a href="#">PEBBLE TIME STEEL IS ON TRACK TO SHIP IN JULY</a></li>
								<li><a href="#">STARTUP COMPANY’S CO-FOUNDER TALKS ON HIS NEW PRODUCT</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div> --%>
		</div>
		<div class="copy-right">
			<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">就是不正经</a></p>
		</div>
	</footer>
	<!-- Footer -->
	
	<!-- JS -->
	<script src="owl-carousel/owl.carousel.js"></script>
    <script>
    $(document).ready(function() {
      $("#owl-demo").owlCarousel({
        autoPlay: 3000,
        items : 5,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4]
      });

    });
    </script>
<script type="text/javascript">

  var i=0;

  var color = ["one","two","three","four","five","six","seven"];

  function changeColor(){

  var n = document.getElementById("one");

  n.className = color[i];

  if(i<color.length-1){

   i++;

}

else{

i=0;

}

  }

  setInterval(changeColor,500);

  window.onload = changeColor;

</script>
</body>
</html>
    
    