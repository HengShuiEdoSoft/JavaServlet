<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/add.do" method="post">
<label>姓名</label><input type="text" name="stuName" value="王大多"/><br/>
<label>年龄</label><input type="text" name="stuAge" value="23"/><br/>
<label>性别</label><select name="stuSex"><option value="男">男</option><option value="女">女</option></select><br/>
<input type="submit" name="sub" value="提交"/>
</form>
</body>
</html>