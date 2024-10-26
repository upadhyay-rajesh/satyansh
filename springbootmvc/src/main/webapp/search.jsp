<script>
	function display(){
		var v=document.getElementById("soption").value;
		
		if(v=="name"){
			document.getElementById("myresult").innerHTML="Enter Name <input type=text name=name><input type=submit value=search>"
		}
		if(v=="email"){
			document.getElementById("myresult").innerHTML="Enter Email <input type=email name=email><input type=submit value=search>"
		}
		if(v=="address"){
			document.getElementById("myresult").innerHTML="Enter Address <input type=text name=address><input type=submit value=search>"
		}
	}
</script>
	
	
	<%@page import="java.util.List"%>
<%@page import="com.springbootmvc.entity.FacebookUser"%>
<%=		request.getAttribute("result") %> <br><br><br><br>
	
	<form action="searchprofile1">
		<select name="soption" id="soption" onchange="display()">
			<option value="email">search by email</option>
			<option value="name">search by name</option>
			<option value="address">search by city</option>
		</select>
		<div id="myresult"></div>
	</form>
	
	<%		
	
		List<FacebookUser> f22=(List<FacebookUser>)request.getAttribute("result1") ;
		if(f22.size()>0){
		for(FacebookUser f2:f22){
		%>
		<%= "****************************************" %><br>
		<%= f2.getName() %><br>
		<%= f2.getPassword() %><br>
		<%= f2.getEmail() %><br>
		<%= f2.getAddress() %><br>
		
		<%
		}
		}
		%>

