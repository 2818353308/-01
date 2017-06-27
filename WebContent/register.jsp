<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
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
      <div class="con"> </div>
    </div>
  <!--   <div class="cell bns-03" style="display:none;">
      <div class="con"> </div>
    </div> -->
  </div>
  <div class="banner-control" id="js_ban_button_box"> <a href="#" class="left">左</a> <a href="#" class="right">右</a> </div>
  <script type="text/javascript">
          (function(){
              
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
      <div class="reg-slogan"> 新用户注册</div>
      <form  method="post" action="${pageContext.request.contextPath}/register.htmlx" enctype="multipart/form-data">
      <div class="reg-form" id="js-form-mobile"> <br>
        <font color="red">${error}</font>
        <div class="cell">
          <input type="text" placeholder="请输入您的用户名" name="uname" id="js-mobile_ipt" class="text" maxlength="11" />
        </div>
        <div class="cell">
          
          <input type="password" placeholder="请输入您的密码" name="upass" id="js-mobile_pwd_ipt" class="text" />
          <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b> </div>
        <div> 
        	<input checked type="radio" name="sex" value="男"  />
        	<font size="5px">男</font>
        	<input type="radio" name="sex" value="女"  />
        	<font size="5px">女</font>
        </div>
        <div class="cell">
        	<input type="file" name="touxiang"  value="添加头像"  id="js-mobile_pwd_ipt" />
        </div>
        <div style="position:relative;" class="cell vcode">
<!--           <label for="js-mobile_vcode_ipt">输入验证码</label> -->
          <input type="text" name="vcode" id="js-mobile_vcode_ipt" class="text" maxlength="6" />
          <img class="button " id="js-get_mobile_vcode" onclick="javascript:this.src='${pageContext.request.contextPath}/loginVCode.htmlx?v='+new Date();" alt="" src="${pageContext.request.contextPath}/loginVCode.htmlx">
<!--           <a href="javascript:;" id="js-get_mobile_vcode" class="button btn-disabled"> 免费获取验证码</a> </div> -->
        </div>
      <div class="bottom"> <input type="submit" value="立即注册 " id="js-mobile_btn"  class="button btn-green"/> </div>
    	<br>
    	<div><a href="login.jsp">已经有账号了，点击登录</a></div>
    	  
    </div>
    </form>
  </div>
</div>
</div>
</body>
</html>

