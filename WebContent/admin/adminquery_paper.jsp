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
<link
	href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body style="padding: 10px;">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">查看所有用户发送的帖子</h3>
		</div>
		<div class="panel-body">
			<div class="page-body">
				<form id="query" action="${pageContext.request.contextPath}/admin_paper.htmlx" class="form-inline" role="form" method="post">
					<input type="hidden" name="currentPage" id="currentPage" />
					<div class="form-group">
						<label class="sr-only" for="name">类型</label> 
						<select name="params['post_type']">
							<option value="搞笑">搞笑</option>
							<option value="校园">校园</option>
							<option value="游戏">游戏</option>
							<option value="老司机">老司机</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>
			</div>
		</div>

		<div class="panel-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>用户名称</td>
						<td>用户头像</td>
						<td>帖子类型</td>
						<td>帖子内容</td>
						<td>帖子图片</td>
						<td>发表时间</td>
						<td>操作</td>
					</tr>
				</thead>
				
			<c:forEach var="item" items="${admin_paper.result}">
					<tr>
						<td>${item.user.uname }</td>
						 <td><img alt="" style="border-radius: 50%;" height="50px;" width="50px;" src="${pageContext.request.contextPath}/${item.user.head_portrait}"></td>
						<td>${item.post_type }</td>
						<td width="500px">${item.post_content}</td>
						<td><img alt="" height="80px;" width="80dx;" src="${pageContext.request.contextPath}/${item.post_image }"></td>
						<td>${item.post_time }</td>
						<td><a href="admin_deletePaper.htmlx?post_id=${item.post_id }">删除</a></td>
					</tr>
			</c:forEach> 
				<tfoot>
					<tr>
						<th colspan="9"><nav>
							<ul class="pagination">
							<c:choose>
									<c:when test="${admin_paper.currentPage eq 1}">
										<li class="disabled"><a href=""> &laquo; </a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#"
											onclick="javascript:query('${admin_paper.currentPage-1}');">
												&laquo; </a></li>
									</c:otherwise>
								</c:choose>
							<c:forEach var="page" begin="1" end="${admin_paper.totalPage}">
									<c:choose>
										<c:when test="${admin_paper.currentPage eq page}">
											<li class="active"><a href="#"> ${page} </a></li>
										</c:when>
										<c:otherwise>
											<li><a href="#"
												onclick="javascript:query('${page}');">
													${page} </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<c:choose>
									<c:when test="${admin_paper.totalPage eq admin_paper.currentPage}">
										<li class="disabled"><a href=""> &raquo; </a></li>
									</c:when>
									<c:otherwise>
										<li ><a href="#"
											onclick="javascript:query('${admin_paper.currentPage+1}');">
												 &raquo; </a></li>
									</c:otherwise>
							</c:choose>
						</ul>
							</nav></th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<form id="query1" method="post" action="${pageContext.request.contextPath}/admin_paper.htmlx">
			<input type="hidden" name="currentPage" id="currentPage" />
	</form>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/easyUi/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function query(page){
		$("#currentPage").val(page);
		$("#query")[0].submit();
	}
</script>
</html>