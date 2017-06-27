<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<meta charset="utf-8">
<link href="css/home.css?v=2" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
<div class="wrap">
  <div class="banner-show" id="js_ban_content">
    <div class="cell bns-01">
      <div class="con"> </div>
    </div>
    <div class="cell bns-02" style="display:none;">
      <div class="con"> <a href="#" target="_blank" class="banner-link"> <i>圈子</i></a> </div>
    </div>
   <!--  <div class="cell bns-03" style="display:none;">
      <div class="con"> <a href="#" target="_blank" class="banner-link"> <i>风暴</i></a> </div>
    </div> -->
  </div>
  <div class="banner-control" id="js_ban_button_box"> <a href="#" class="left">左</a> <a href="javascript:;" class="right">右</a> </div>
  <script type="text/javascript">
                ;(function(){
                    
                    var defaultInd = 0;
                    var list = $('#js_ban_content').children();
                    var count = 0;
                    var change = function(newInd, callback){
                        if(count) return;
                        count = 2;
                        $(list[defaultInd]).fadeOut(400, function(){
                            count--;
                            if(count <= 0){
                                if(start.timer) window.clearTimeout(start.timer);
                                callback && callback();
                            }
                        });
                        $(list[newInd]).fadeIn(400, function(){
                            defaultInd = newInd;
                            count--;
                            if(count <= 0){
                                if(start.timer) window.clearTimeout(start.timer);
                                callback && callback();
                            }
                        });
                    }
                    
                    var next = function(callback){
                        var newInd = defaultInd + 1;
                        if(newInd >= list.length){
                            newInd = 0;
                        }
                        change(newInd, callback);
                    }
                    
                    var start = function(){
                        if(start.timer) window.clearTimeout(start.timer);
                        start.timer = window.setTimeout(function(){
                            next(function(){
                                start();
                            });
                        }, 8000);
                    }
                    
                    start();
                    
                    $('#js_ban_button_box').on('click', 'a', function(){
                        var btn = $(this);
                        if(btn.hasClass('right')){
                            //next
                            next(function(){
                                start();
                            });
                        }
                        else{
                            //prev
                            var newInd = defaultInd - 1;
                            if(newInd < 0){
                                newInd = list.length - 1;
                            }
                            change(newInd, function(){
                                start();
                            });
                        }
                        return false;
                    });
                    
                })();
            </script>
  <div class="container">
    <div class="register-box">
      <div class="reg-slogan">登录</div>
      <div class="reg-slogan"><font color="red">${error}</font></div>
      <form id="login" method="post" action="${pageContext.request.contextPath}/login.htmlx" >
	      <div class="reg-form" id="js-form-mobile"> <br>
	        <br>
	        <div class="cell">
	          
	          <input type="text" placeholder="请输入您的用户名" name="uname" id="js-mobile_ipt" class="text" maxlength="11" />
	        </div>
	        <div class="cell">
	          
	          <input type="password" placeholder="请输入您的密码" name="upass" id="js-mobile_pwd_ipt" class="text" />
	          <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b> </div>
	<!--         <div class="bottom"> <a id="js-mobile_btn" href="javascript:;" class="button btn-green"> 立即登录</a></div> -->
	        <div class="bottom"> <input id="js-mobile_btn" class="button btn-green" type="submit" value="                  立即登录                     "/> </div>
	      <br>
	      <div><a href="register.jsp">还没有账号，点击注册</a></div>
	      <br>
		<div class="reg-slogan">
			<a href="index.jsp">返回首页</a>
		</div>
	      </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
 