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
			<h3 class="panel-title">用户反馈信息</h3>
		</div>
		<div class="panel-body">
			<div class="page-body">
				<form id="query" action="${pageContext.request.contextPath}/queryfeed.htmlx" class="form-inline" role="form" method="post">
				</form>
			</div>
		</div>
		<div class="panel-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>反馈内容</th>
						<th>反馈人</th>
						<th>反馈email</th>
					</tr>
				</thead>
				
			<c:forEach var="item" items="${pageVo.result3}">
					<tr>
						<td>${item.f_content }</td>
						 <td>${item.f_name }</td>
						 <td>${item.f_email }</td>	
					</tr>
			</c:forEach> 
				<tfoot>
					<tr>
						<th colspan="9"><nav>
							<ul class="pagination">
								<c:choose>
									<c:when test="${pageVo.currentPage eq 1}">
										<li class="disabled"><a href="#"> &laquo; </a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#"
											onclick="javascript:query('${pageVo.currentPage-1}');">
												&laquo; </a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach var="page" begin="1" end="${pageVo.totalPage}">
									<c:choose>
										<c:when test="${pageVo.currentPage eq page}">
											<li class="active"><a href="#"> ${page} </a></li>
										</c:when>
										<c:otherwise>
											<li><a href="#" onclick="javascript:query('${page}');">
													${page} </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${pageVo.totalPage eq pageVo.currentPage}">
										<li class="disabled"><a href="#"> &raquo; </a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="javascript:query('${pageVo.currentPage+1}');">
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
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/easyUi/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function query(page) {
		$("#currentPage").val(page);
		$("#query")[0].submit();
	}
</script>
</html>