<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<p><font color=red size=5><b>Login Page</b></font></p>
	<form action="GlobalServlet?type=login" method="post">
	<table border="0">
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		
		
		<tr>
			<td><input type="submit" value="Sign In"></td>
			<td><input type="reset"></td>
		</tr>
	</table>
	 <%= request.getAttribute("result") %>
	</form>
</center>
</body>
</html>