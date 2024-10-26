<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Login Page</p><br>
	<form action="login">
		Email : <input type=email name=em><br>
		Password : <input type=password name=pwd><br>
		
		
		
		<input type=submit value=Login>
		
		
	</form>
	
	<%=
		request.getAttribute("result")
%>

</body>
</html>