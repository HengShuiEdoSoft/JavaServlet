<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentList</title>
<style type="text/css">
table {
	width: 800px;
	line-height: 30px;
	text-align: center;
	border: 1px solid #CCC;
	border-collapse: collapse;
}

td {
	border: 1px solid #CCC;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>学生列表</h1>
	<table style="background: #EEE">
		<thead>
			<tr>
				<td>ID</td>
				<td>标题</td>
				<td>TitleSpell</td>
				<td>web</td>
				<td>Key</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stu" items="${stulist}">
				<tr>
					<td>${stu.getID()}</td>
					<td>${stu.getTitle()}</td>
					<td>${stu.getTitleSpell()}</td>
					<td>${stu.getTitleWeb()}</td>
					<td>${stu.getKeyWords()}</td>
					<td><a href="/studelete.do?ID=${stu.getID()}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>