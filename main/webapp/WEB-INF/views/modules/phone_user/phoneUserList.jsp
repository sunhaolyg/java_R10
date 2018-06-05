<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/phone_user/phoneUser/">用户信息列表</a></li>
		<shiro:hasPermission name="phone_user:phoneUser:edit"><li><a href="${ctx}/phone_user/phoneUser/form">用户信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="phoneUser" action="${ctx}/phone_user/phoneUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>年龄：</label>
				<form:input path="age" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:input path="sex" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>地址：</label>
				<form:input path="address" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>生日：</label>
				<input name="birth" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${phoneUser.birth}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>电话：</label>
				<form:input path="number" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>地址</th>
				<th>生日</th>
				<th>电话</th>
				<shiro:hasPermission name="phone_user:phoneUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="phoneUser">
			<tr>
				<td><a href="${ctx}/phone_user/phoneUser/form?id=${phoneUser.id}">
					${phoneUser.name}
				</a></td>
				<td>
					${phoneUser.age}
				</td>
				<td>
					${phoneUser.sex}
				</td>
				<td>
					${phoneUser.address}
				</td>
				<td>
					<fmt:formatDate value="${phoneUser.birth}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${phoneUser.number}
				</td>
				<shiro:hasPermission name="phone_user:phoneUser:edit"><td>
    				<a href="${ctx}/phone_user/phoneUser/form?id=${phoneUser.id}">修改</a>
					<a href="${ctx}/phone_user/phoneUser/delete?id=${phoneUser.id}" onclick="return confirmx('确认要删除该用户信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>