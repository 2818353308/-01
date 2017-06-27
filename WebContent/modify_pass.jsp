<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<meta charset="utf-8">
<link href="css/home.css?v=2" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<style type="text/css">
.success {
	color: green;
}

.error {
	color: red;
	size: 30px;
}
</style>
<body>
	<div class="wrap">
		<div class="banner-show" id="js_ban_content">
			<div class="cell bns-01">
				<div class="con"></div>
			</div>
			<div class="cell bns-02" style="display: none;">
				<div class="con">
					<a  target="_blank" class="banner-link"> <i>圈子</i></a>
				</div>
			</div>
		</div>
		<div class="banner-control" id="js_ban_button_box">
			<a class="left">左</a> <a href="" class="right">右</a>
		</div>
		<script type="text/javascript">
			;
			(function() {

				var defaultInd = 0;
				var list = $('#js_ban_content').children();
				var count = 0;
				var change = function(newInd, callback) {
					if (count)
						return;
					count = 2;
					$(list[defaultInd]).fadeOut(400, function() {
						count--;
						if (count <= 0) {
							if (start.timer)
								window.clearTimeout(start.timer);
							callback && callback();
						}
					});
					$(list[newInd]).fadeIn(400, function() {
						defaultInd = newInd;
						count--;
						if (count <= 0) {
							if (start.timer)
								window.clearTimeout(start.timer);
							callback && callback();
						}
					});
				}

				var next = function(callback) {
					var newInd = defaultInd + 1;
					if (newInd >= list.length) {
						newInd = 0;
					}
					change(newInd, callback);
				}

				var start = function() {
					if (start.timer)
						window.clearTimeout(start.timer);
					start.timer = window.setTimeout(function() {
						next(function() {
							start();
						});
					}, 8000);
				}

				start();

				$('#js_ban_button_box').on('click', 'a', function() {
					var btn = $(this);
					if (btn.hasClass('right')) {
						//next
						next(function() {
							start();
						});
					} else {
						//prev
						var newInd = defaultInd - 1;
						if (newInd < 0) {
							newInd = list.length - 1;
						}
						change(newInd, function() {
							start();
						});
					}
					return false;
				});

			})();
		</script>
		<div class="container">
			<div class="register-box">
				<div class="reg-slogan">修改密码</div>
				<div class="reg-slogan">
					<font color="red">${error}</font>
				</div>
				<form id="modify_pass" method="post"
					action="${pageContext.request.contextPath}/modify_pass.htmlx">
					<div class="reg-form" id="js-form-mobile">
						<div class="cell">
							<input type="text" placeholder="请输入您的原密码" name="jupass"
								id="js-mobile_ipt" class="text" maxlength="11" />
						</div>
						<div class="cell">
							<input type="password" placeholder="请输入您的新密码" name="xupass"
								id="xupass" class="text" />
							<!-- 	          <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b>  -->
						</div>
						<!--         <div class="bottom"> <a id="js-mobile_btn" href="javascript:;" class="button btn-green"> 立即登录</a></div> -->
						<div class="cell">
							<input type="password" placeholder="请重新输入您的新密码" name="cxupass"
								id="js-mobile_pwd_ipt" class="text" />
							<!-- 	          <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b>  -->
						</div>
						<div class="bottom">
							<input id="js-mobile_btn" class="button btn-green" type="submit"
								value="                  确认修改                     " />
						</div>
						<br>
						<div class="reg-slogan">
							<a href="personal/personal.jsp">返回个人中心</a>
						</div>
					</div>
				</form>

			</div>

		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/assets/js/modernizr.custom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#modify_pass").validate({
			rules : {
				jupass : {
					required : true,
					minlength : 5
				},
				xupass : {
					required : true,
					minlength : 5
				},cxupass:{
					required : true,
					equalTo:"#xupass"
				}
			},//错误提示
			messages : {
				jupass : {
					required : "旧密码必须填写！",
					minlength : "旧密码长度最小5位"
				},
				xupass : {
					required : "新密码必须填写！",
					minlength : "新密码长度最小5位"
				},cxupass:{
					required : "重复密码必须填",
					equalTo:"两次密码必须一致"
				}
			},
			success : "success",//成功样式
			error : "error"//错误样式
		});
	});
</script>
</html>
