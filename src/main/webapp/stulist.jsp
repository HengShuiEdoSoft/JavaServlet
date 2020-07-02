<%@page import="java.util.List"%>
<%@page import="com.edo.mysql.DAL"%>
<%@page import="com.edo.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style type="text/css">
table {
	width: 600px;
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
	<%
		//out.println(request.getAttribute("list"));
	List<String> list = (List<String>) request.getAttribute("list");
	for(String item:list){
		%><p style='color:blue'><%=item %></p>
	<%}
	%>
	<c:forEach var="item" items="${list}">
		<p>${item}</p>
	</c:forEach>
	<%
		List<String> lst = (List<String>) request.getAttribute("list");
	for (String item : lst) {
	%>
	<div>
		<%
			out.print(item);
		%>
	</div>
	<%
		}
	%>
	<table style="background: #EEE">
		<thead>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>录入时间</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stu" items="${stulst}">
				<tr>
					<td>${stu.getId()}</td>
					<td>${stu.getStuName()}</td>
					<td>${stu.getStuSex()}</td>
					<td>${stu.getAge()}</td>
					<td>${stu.getCdate()}</td>
					<td><a href="/studelete.do?ID=${stu.getId()}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%
		List<Student> lst1 = DAL.StuList();
	 request.setAttribute("lst1",lst1);
	%>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>录入时间</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stu" items="${lst1}">
				<tr>
					<td>${stu.getId()}</td>
					<td>${stu.getStuName()}</td>
					<td>${stu.getStuSex()}</td>
					<td>${stu.getAge()}</td>
					<td>${stu.getCdate()}</td>
					<td><a href="/studelete.do?ID=${stu.getId()}">删除</a></td>
				</tr>
				<p></p>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>