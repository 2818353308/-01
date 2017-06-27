<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>管理员登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/assets/css/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>
		<font color="red">${adminerror }</font>
        <div class="page-container">
            <h1>管理员登录</h1>
            <form action="${pageContext.request.contextPath}/glogin.htmlx" method="post">
                <input type="text" name="uname" class="uname" placeholder="请输入正确的管理员用户名">
                <input type="password" name="upass" class="upass" placeholder="请输入正确的管理员密码">
                <button type="submit">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/statics/assets/js/jquery-1.8.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/statics/assets/js/supersized.3.2.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/statics/assets/js/supersized-init.js"></script>
        <script src="${pageContext.request.contextPath}/statics/assets/js/scripts.js"></script>

    </body>

</html>

