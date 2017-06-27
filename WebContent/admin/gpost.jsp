<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<!-- Owl Carousel Assets -->
<link
	href="${pageContext.request.contextPath}/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/owl-carousel/owl.theme.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.4.0/css/font-awesome.min.css"
	type="text/css">

<!-- jQuery and Modernizr-->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>

<!-- Core JavaScript Files -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<style type="text/css">
.one {
	color: #0000FF;
}

.two {
	color: #00FF00;
}

.three {
	color: #FFFF00;
}

.four {
	color: #00FFFF;
}

.five {
	color: #CC9933;
}

.six {
	color: #FF66CC;
}

.seven {
	color: #00FF00;
}

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

.red {
	color: red;
}
</style>
</head>
<body>

	<div id="page-content" class="archive-page container">
		<div class="">
			<div class="row">
				<div id="main-content" class="col-md-8">
					<div class="box">
						<center>
							<div class="box-header">
								<h1 class="center">发表帖子</h1>
							</div>
						</center>
						<div class="box-content">
							<div id="contact_form" style="width: 800px; height: 700px;">
								<form enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/post.htmlx"
									method="post">
									<div align="center" style="width: 500px; height: 300px;">
										<label> <span>发帖类型</span> <select name="g_type">
												<option value="搞笑">搞笑</option>
												<option value="娱乐">娱乐</option>
										</select>
										</label> <label> <span>发帖内容</span> <textarea cols="80"
												rows="10" name="g_content"></textarea>
										</label> <label> <span>上传头像</span> <input type="file"
											name="fiels" />
										</label>

										<center>
											<input type="submit" value="官方发帖" />
										</center>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>

<!-- JS -->
<script
	src="${pageContext.request.contextPath}/owl-carousel/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			autoPlay : 3000,
			items : 5,
			itemsDesktop : [ 1199, 4 ],
			itemsDesktopSmall : [ 979, 4 ]
		});

	});
</script>
<script type="text/javascript">
	var i = 0;

	var color = [ "one", "two", "three", "four", "five", "six", "seven" ];

	function changeColor() {

		var n = document.getElementById("one");

		n.className = color[i];

		if (i < color.length - 1) {

			i++;

		}

		else {

			i = 0;

		}

	}

	setInterval(changeColor, 500);

	window.onload = changeColor;
</script>
</html>