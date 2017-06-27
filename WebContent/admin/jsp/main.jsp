<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员管理</title>
<link
	href="${pageContext.request.contextPath}/statics/easyUi/themes/default/easyui.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/statics/easyUi/themes/icon.css"
	rel="stylesheet" />
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height: 60px; background: #B3DFDA; padding: 10px">
		您好，管理员
		系统时间为<%=new Date() %>。<a href="${pageContext.request.contextPath}/admin/glogin.jsp">退出</a>
	</div>
	<div data-options="region:'west',split:true,title:'菜单栏'"style="width: 200px; padding: 10px;">
		<ul class="easyui-tree">
			<li>
				<span>管理员管理如下</span>
				<ul>
					<li>
						<a onclick="changeRightContent('/admin/gpost.jsp')">
							<span>管理员发帖</span>
						</a>
					</li>
					<li>
						<a onclick="changeRightContent('/admin_paper.htmlx')">
							<span>查看用户帖子</span>
						</a>
					</li>
					<li>
						<a onclick="changeRightContent('/query.htmlx')">
							<span>查看管理员发帖</span>
						</a>
					</li>
					<!-- <li>
						<a onclick="changeRightContent('/query1.htmlx')">
							<span>查看所有的管理员</span>
						</a>
					</li> -->
					<li>
						<a onclick="changeRightContent('/queryfeed.htmlx')">
							<span>查看所有用户的反馈</span>
						</a>
					</li>
					<li>
						<a onclick="changeRightContent('/queryuser.htmlx')">
							<span>查看所有用户的信息</span>
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	<div data-options="region:'center',title:'内容区域'">
		<iframe id="rightContent" name="rightContent" src="${pageContext.request.contextPath}/query.htmlx" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/easyUi/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function changeRightContent(url){
		$("#rightContent").attr("src","${pageContext.request.contextPath}"+url);
	}

</script>
</html>