<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
	<h1>用户注册界面</h1>
	<form method="post" action="RegistServlet">
	<table width="600">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>昵称</td>
			<td><input type="text" name="nickname"></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册"></td>
		</tr>
	</table>
	</form>
</body>
</html>
