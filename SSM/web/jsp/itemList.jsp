<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/queryList.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
	<td>商品id<input type="text" name="items.id" /></td>
	<td>商品名称<input type="text" name="items.name" /></td>
	<td><a action="${pageContext.request.contextPath }/queryItemById.action">查询</a></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${list}" var="items" >
<tr>
	<td><input type="checkbox" name="ids" value="${items.id}"></td>
	<td>${items.name }</td>
	<td>${items.price }</td>
	<td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${items.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${items.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>