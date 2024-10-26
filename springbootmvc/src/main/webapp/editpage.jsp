
	
	
	<%@page import="java.util.List"%>
<%@page import="com.springbootmvc.entity.FacebookUser"%>
<%=		request.getAttribute("result") %> <br><br><br><br>
	
	<%		
	
		List<FacebookUser> f22=(List<FacebookUser>)request.getAttribute("result1") ;
		if(f22.size()>0){
		for(FacebookUser f2:f22){
		%>
		<%= "****************************************" %><br>
		<p>Edit Page</p><br>
		<form action="editprofile1">
		Name : <input type=text name=nm value=<%= f2.getName() %>><br>
		Password : <input type=text name=pwd value=<%= f2.getPassword() %>><br>
		Email : <input type=email name=em value=<%= f2.getEmail() %> disabled><br>
		Address : <input type=text name=ad value=<%= f2.getAddress() %>><br>
		<input type=submit value=Edit><br>
		</form>
		<%
		}
		}
		%>
<%=		request.getAttribute("result2") %>
