<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Registration Page</p><br>
	<form action="register">
		Name  : <input type=text name=nm> <br>
		Password : <input type=password name=pwd><br>
		Email : <input type=email name=em><br>
		Address : <input type=text name=address><br>
		
		<input type=submit>
		
		
	</form>
	
	<%=
		request.getAttribute("result")
%>

</body>
</html>