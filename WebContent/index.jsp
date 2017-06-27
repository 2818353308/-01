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
	
    <title>首页</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	
	<!-- Owl Carousel Assets -->
    <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="owl-carousel/owl.theme.css" rel="stylesheet">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	 <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	
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
					<strong><a><img alt="" id="touxiang"
							src="${pageContext.request.contextPath}/${loginUser.head_portrait}">
							</a>
							<i id="one">${loginUser.uname}</i>
						
						<i><a href="${pageContext.request.contextPath}/user/personal.htmlx">个人中心</a></i>
					</strong>
					</c:if>
				</div>
				<div class="col-md-6">
					<ul class="list-inline top-link link">
						<li><a href="index.jsp"><i class="fa fa-home"></i> 首页</a></li>
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
				<li><a href="index.jsp"><i class="fa fa-home"></i> 首页</a></li>
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
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">发现<i class="fa fa-arrow-circle-o-down"></i></a>
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
				<li><a href="contact.jsp"><i class="fa fa-envelope"></i> 联系我们</a></li>
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
	<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>	
	<div class="featured container">
		<div class="row">
			<div class="col-sm-8">
				<!-- Carousel -->
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="images/1.jpg" alt="First slide">
							<!-- Static Header -->
							<div class="header-text hidden-xs">
								<div class="col-md-12 text-center">
									<h2>这特么都是套路</h2>
									<br>
									<h3>我的内心毫无波澜  甚至有点想吃黄焖鸡米饭</h3>
									<br>
								</div>
							</div><!-- /header-text -->
						</div>
						<div class="item">
							<img src="images/2.jpg" alt="Second slide">
							<!-- Static Header -->
							<div class="header-text hidden-xs">
								<div class="col-md-12 text-center">
									<h2>午夜孤独综合症患者</h2>
									<br>
									<h3>我真想下辈子，变成你喜欢的人，而不喜欢你.</h3>
									<br>
								</div>
							</div><!-- /header-text -->
						</div>
						<div class="item">
							<img src="images/3.jpg" alt="Third slide">
							<!-- Static Header -->
							<div class="header-text hidden-xs">
								<div class="col-md-12 text-center">
									<h2>句子控</h2>
									<br>
									<h3>但凡不能杀死你的，最终都会使你更强大</h3>
									<br>
								</div>
							</div><!-- /header-text -->
						</div>
					</div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div><!-- /carousel -->
			</div>
			<div class="col-sm-4" >
				<div id="owl-demo-1" class="owl-carousel">
					<img src="images/slide-2.jpg" />
					<img src="images/slide-1.jpg" />
					<img src="images/slide-3.jpg" />
				</div>
				<img src="images/banner.jpg" />
			</div>
		</div>
	</div>
	
	<!-- /////////////////////////////////////////Connt -->
	<div id="page-content" class="index-page container">
		<div class="row">
			<div id="main-content"><!-- background not working -->
				<div class="col-md-6">
					<div class="box wrap-vid">
						<div class="zoom-container">
							<div class="zoom-caption">
								<!-- <span class="youtube">优酷</span> -->
								<a href="#">
									<i class="  " style="color: #fff"></i>
								</a>
								<p>我最帅</p>
							</div>
							<img src="images/4.jpg" />
						</div>
						<h3 class="vid-name"><a href="#">搞笑</a></h3>
						<div class="info">
							<h5>By <a href="#">嘴硬</a></h5>
							<span><i class="fa fa-calendar"></i>25/3/2015</span> 
							<span><i class="fa fa-heart"></i>520</span>
						</div>
						<p class="more">&emsp;&emsp;金涛怒道：“唐笑，我忍你很久了。你再侮辱我，我就......”
						<br/>&emsp;&emsp;唐笑不屑的挺起胸膛，“你又怎么样？用一句话来形容你做合适，问君能有几多丑，恰似驴脸又似癞皮狗。
						别人长脑袋是为了显高，你倒好，连高都没显出来，不服，咬我啊？”
						<br/>&emsp;&emsp;金涛冷哼一声，“你好？有缸粗没缸高，除了屁股全是腰。你的出生，简直就是厂家对全世界的道歉。”
						</p>
					</div>
					<div class="box">
						<div class="box-header header-vimeo">
							<h2>精彩瞬间</h2>
						</div>
						<div class="box-content">
							<div class="row">
								<div class="col-md-6">
									<div class="wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">优酷</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-5x" style="color: #fff"></i>
												</a>
												<p>骑蜗牛的小菇凉</p>
											</div>
											<img src="images/2.jpg" />
										</div>
										<h3 class="vid-name"><a href="#">骑蜗牛的小菇凉</a></h3>
										<div class="info">
											<h5>By <a href="#">兰因壁月</a></h5>
											<span><i class="fa fa-calendar"></i>25/3/2015</span> 
											<span><i class="fa fa-heart"></i>7,300</span>
										</div>
									</div>
									<p class="more">【形容一个女孩长得漂亮】<p>
									    你的酒窝没有酒，我却醉的像条狗<p>
									    把你放在古代就可以撑起一个青楼，把你放在现代就可以重振整个东莞<p>
									    姑娘，可以麻烦你笑一下吗，我的咖啡忘了加糖了
									</p>
								</div>
								<div class="col-md-6">
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">腾讯</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>夏伤</p>
											</div>
											<img src="images/1.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">夏伤</a></h5>
											<div class="info">
												<h6>By <a href="#">lily</a></h6>
												<span><i class="fa fa-heart"></i>5,200 / <i class="fa fa-calendar"></i>25/1/2017</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">爱奇艺</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>人影独坐</p>
											</div>
											<img src="images/2.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">人影独坐</a></h5>
											<div class="info">
												<h6>By <a href="#">Mark君</a></h6>
												<span><i class="fa fa-heart"></i>7,800 / <i class="fa fa-calendar"></i>25/3/2017</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">腾讯</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>柠檬一般酸</p>
											</div>
											<img src="images/3.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">柠檬一般酸</a></h5>
											<div class="info">
												<h6>By <a href="#">小左</a></h6>
												<span><i class="fa fa-heart"></i>5,700 / <i class="fa fa-calendar"></i>24/4/2017</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">优酷</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>由始至终</p>
											</div>
											<img src="images/1.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">由始至终</a></h5>
											<div class="info">
												<h6>By <a href="#">酒小茶</a></h6>
												<span><i class="fa fa-heart"></i>6,200 / <i class="fa fa-calendar"></i>23/2/2017</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box">
						<div class="box-header header-photo">
							<h2>Photos</h2>
						</div>
						<div class="box-content">
							<div id="owl-demo-2" class="owl-carousel">
								<div class="item">
									<img src="images/1.jpg" />
									<img src="images/2.jpg" />
								</div>
								<div class="item">
									<img src="images/3.jpg" />
									<img src="images/5.jpg" />
								</div>
								<div class="item">
									<img src="images/8.jpg" />
									<img src="images/9.jpg" />
								</div>
								<div class="item">
									<img src="images/10.jpg" />
									<img src="images/11.jpg" />
								</div>
								<div class="item">
									<img src="images/12.jpg" />
									<img src="images/13.jpg" />
								</div>
							</div>
						</div>
					</div>
					<div class="box">
						<div class="box-header header-natural">
							<h2>推荐</h2>
						</div>
						<div class="box-content">
							<div class="row">
								<div class="col-md-6">
									<img src="images/6.jpg" />
									<h3><a href="#">“套路走了那么多，为什么还是闪了老腰哈哈哈哈”</a></h3>
									<span><i class="fa fa-heart"></i> 7,200 / <i class="fa fa-calendar"></i> 25/3/2017 / <i class="fa fa-comment-o"> / </i> 57 <i class="fa fa-eye"></i> 945</span>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half"></i>
									</span>
									<p>我人生中最大的一次奇迹，就是在我最穷的时候，睡觉梦见了一串彩票开奖号码，于是我孤注一掷，把身上仅有的几十块钱全部买了彩票，最后奇迹果然发生了：因为没钱吃饭，我喝了一个星期的白开水都没死！</p>
								</div>
								<div class="col-md-6">
									<img src="images/7.jpg" />
									<h3><a href="#">明明吃的是粥，却像喝了碗酒，看不到天明与哀愁</a></h3>
									<span><i class="fa fa-heart"></i> 6,600 / <i class="fa fa-calendar"></i> 16/1/2017 / <i class="fa fa-comment-o"> / </i> 85 <i class="fa fa-eye"></i> 1007</span>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half"></i>
									</span>
									<p>我们总是像智者一样去劝慰别人，却像傻子一样折磨自己，很多时候，跟自己过不去的是自己，一切烦恼的根源都在于自己。不要嘲笑别人的疤，那是你没经历过的伤！</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="col-md-3">
                   <!---- Start Widget ---->
					<div class="widget wid-vid">
						<div class="heading">
							<h4>视频</h4>
						</div>
						<div class="content">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#most">搞笑的</a></li>
								<li><a data-toggle="tab" href="#popular">流行的</a></li>
								<li><a data-toggle="tab" href="#random">随机的</a></li>
							</ul>
							<div class="tab-content">
								<div id="most" class="tab-pane fade in active">
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="youtube">优秀</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>我的梦想</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">那就想着吧</a></h5>
											<div class="info">
												<h6>By <a href="#">做梦</a></h6>
												<span><i class="fa fa-heart"></i>1,200 <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">蓝天</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>白云</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">下雨了</a></h5>
											<div class="info">
												<h6>By <a href="#">水货</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="youtube">老崔</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>催泪</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">我都哭了</a></h5>
											<div class="info">
												<h6>0 <a href="#">....</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div id="popular" class="tab-pane fade">
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>偏爱自由</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">吊丧扩</a></h5>
											<div class="info">
												<h6>By <a href="#">持宠而娇</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="youtube">Youtube</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>Video's Name</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">晴</a></h5>
											<div class="info">
												<h6>By <a href="#">无情便是王</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">风</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>晚风撩人</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">夜无邪</a></h5>
											<div class="info">
												<h6>By <a href="#">泛泛之交</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div id="random" class="tab-pane fade">
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">酒</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>诡寒老酒</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">沉沦</a></h5>
											<div class="info">
												<h6>By <a href="#">挽歌</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">情</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>借风抱你</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">包</a></h5>
											<div class="info">
												<h6>By <a href="#">头疼</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="post wrap-vid">
										<div class="zoom-container">
											<div class="zoom-caption">
												<span class="vimeo">竟然</span>
												<a href="#">
													<i class="fa fa-play-circle-o fa-3x" style="color: #fff"></i>
												</a>
												<p>国际公寓房</p>
											</div>
											<img src="images/4.jpg" />
										</div>
										<div class="wrapper">
											<h5 class="vid-name"><a href="#">傻大哥</a></h5>
											<div class="info">
												<h6>By <a href="#">九点</a></h6>
												<span><i class="fa fa-heart"></i>1,200 / <i class="fa fa-calendar"></i>25/3/2015</span>
												<span class="rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half"></i>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
                    <!---- Start Widget ---->
					<div class="widget wid-gallery">
						<div class="heading"><h4>Gallery</h4></div>
						<div class="content">
							<div class="col-md-4">
								<div class="row">
									<a href="#"><img src="images/14.jpg" /></a>
									<a href="#"><img src="images/15.jpg" /></a>
									<a href="#"><img src="images/20.jpg" /></a>
								</div>
							</div>
							<div class="col-md-4">
								<div class="row">
									<a href="#"><img src="images/16.jpg" /></a>
									<a href="#"><img src="images/17.jpg" /></a>
									<a href="#"><img src="images/21.jpg" /></a>
								</div>
							</div>
							<div class="col-md-4">
								<div class="row">
									<a href="#"><img src="images/18.jpg" /></a>
									<a href="#"><img src="images/19.jpg" /></a>
									<a href="#"><img src="images/14.jpg" /></a>
								</div>
							</div>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-new-post">
						<div class="heading"><h4>热帖</h4></div>
						<div class="content">
							<h6>水若小檬心i</h6>
							<img src="images/22.jpg" />
							<ul class="list-inline">
								<li><i class="fa fa-calendar"></i>15/3/2017</li> 
								<li><i class="fa fa-comments"></i>6,200</li>
							</ul>
							<p>想着要学习却三分钟热度，记得要把没看完的剧追完也搁下了，当初的厘米秀也不积极抢胶囊了，坚持最久的就是睡觉吃饭</p>
							<h6>悟到尽头一场空</h6>
							<img src="images/23.jpg" />
							<ul class="list-inline">
								<li><i class="fa fa-calendar"></i>07/1/2017</li> 
								<li><i class="fa fa-comments"></i>7,700</li>
							</ul>
							<p>梦里的光怪陆离，在这里书刻，记录那些飘忽无踪的行程，睡觉也是一种行程，记录梦中的世界，分分钟有另一种感悟！</p>
							<h6>汝灼华过桃夭</h6>
							<img src="images/24.jpg" />
							<ul class="list-inline">
								<li><i class="fa fa-calendar"></i>18/5/2017</li> 
								<li><i class="fa fa-comments"></i>8,200</li>
							</ul>
							<p>那句话应该很多人都知道吧   瘦是饿出来的，懂事都是没人疼出来的。表面上我只是一个十七八岁懵懵懂懂的小女孩，可真正懂我的人都说我心里很成熟  坚强。愿我们都被世界温柔以待！</p>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-recent-post">
						<div class="heading"><h4>话题</h4></div>
						<div class="content">
							<span>聊天不能缺表情 <a href="#">2812318个斗图大师</a></span>
							<span>喵星人根据地<a href="#">52265个铲屎官</a></span>
							<span>生活中最想哭的瞬间<a href="#">52338个小哭包</a></span>
							<span>说多了都是泪<a href="#">159712个泪痕</a></span>
							<span>小逗比大脑洞<a href="#">120847个脑洞君</a></span>
							<span>上学那点事儿<a href="#">58948个学徒</a></span>
							
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<!---- Start Widget ---->
					<div class="widget wid-tags">
						<div class="heading"><h4>搜索</h4></div>
						<div class="content">
							<form role="form" class="form-horizontal" method="post" action="">
								<input type="text" placeholder="请输入搜索的关键字" value="" name="v_search" id="v_search" class="form-control">
							</form>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-tags">
						<div class="heading"><h4>标签</h4></div>
						<div class="content">
							<a href="#">动物</a>
							<a href="#">烹饪</a>
							<a href="#">国家</a>
							<a href="#">爱好的事物</a>
							<a href="#">照片</a>
							<a href="#">动漫</a>
							<a href="#">视频</a>
							<a href="#">旅行</a>
							<a href="#">娱乐</a>
							<a href="#">爱</a>
							<a href="#">竞技场</a>
							<a href="#">美妆</a>
					        <a href="#">绘画作品</a>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-comment">
						<div class="heading"><h4>发帖巨人</h4></div>
						<div class="content">
							<div class="post">
								<a href="#">
									<img src="images/ava-1.jpg" class="img-circle"/>
								</a>
								<div class="wrapper">
									<a href="#"><h5>橘子i?</h5></a>
									<ul class="list-inline">
										<li><i class="fa fa-calendar"></i>11/5/2017</li> 
										<li><i class="fa fa-thumbs-up"></i>2,100</li>
									</ul>
								</div>
							</div>
							<div class="post">
								<a href="#">
									<img src="images/ava-2.png" class="img-circle"/>
								</a>
								<div class="wrapper">
									<a href="#"><h5>Miss.大魔王</h5></a>
									<ul class="list-inline">
										<li><i class="fa fa-calendar"></i>23/2/2017</li> 
										<li><i class="fa fa-thumbs-up"></i>6,500</li>
									</ul>
								</div>
							</div>
							<div class="post">
								<a href="#">
									<img src="images/ava-3.jpeg" class="img-circle"/>
								</a>
								<div class="wrapper">
									<a href="#"><h5>-终将陌路/21</h5></a>
									<ul class="list-inline">
										<li><i class="fa fa-calendar"></i>06/3/2017</li> 
										<li><i class="fa fa-thumbs-up"></i>5,200</li>
									</ul>
								</div>
							</div>
							<div class="post">
								<a href="#">
									<img src="images/ava-4.jpg" class="img-circle"/>
								</a>
								<div class="wrapper">
									<a href="#"><h5>2333专员</h5></a>
									<ul class="list-inline">
										<li><i class="fa fa-calendar"></i>02/1/2017</li> 
										<li><i class="fa fa-thumbs-up"></i>6,800</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-banner">
						<div class="content">
							<img src="images/banner-2.jpg" class="img-responsive"/>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-categoty">
						<div class="heading"><h4>Category</h4></div>
						<div class="content">
							<select class="col-md-12">
								<option>Mustard</option>
								<option>Ketchup</option>
								<option>Relish</option>
							</select>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-calendar">
						<div class="heading"><h4>日历</h4></div>
						<div class="content">
							<center><form action="" role="form">        
								<div class="">
									<div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">                </div>
									<input type="hidden" id="dtp_input2" value="" /><br/>
								</div>
							</form></center>
						</div>
					</div>
					<!---- Start Widget ---->
					<div class="widget wid-tweet">
						<div class="heading"><h4>审帖专区</h4></div>
						<div class="content">
							随着右星人在地球势力不断扩大，小右已经快要忙shi了！！特发公告诚邀广大右友担任最右审帖员一职。
						<p><i class="fa fa-twitter"></i>如何成为审帖员？</p>
							1.满足以下基本条件：<p>
							   i 注册时间满足30天；<p>
							   ii 经常登录“最右”； <p>
							   iii 具有一定的粉丝数量；<p>
							2.满足上述基本条件后，小右会根据需要逐步开放申请资格，获得申请资格后小右会私信通知你呦！   
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
			<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">最右</a></p>
		</div>
	</footer>
	<!-- Footer -->
	
	<!-- JS -->
	<script src="owl-carousel/owl.carousel.js"></script>
    <script>
    $(document).ready(function() {
      $("#owl-demo-1").owlCarousel({
        autoPlay: 3000,
        items : 1,
        itemsDesktop : [1199,1],
        itemsDesktopSmall : [400,1]
      });
	  $("#owl-demo-2").owlCarousel({
        autoPlay: 3000,
        items : 3,
        
      });
    });
    </script>
	
	
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	$('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
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
    
    