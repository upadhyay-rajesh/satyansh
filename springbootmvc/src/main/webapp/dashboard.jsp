
	
	
	<%@page import="java.util.List"%>
<%@page import="com.springbootmvc.entity.FacebookUser"%>
<%=		request.getAttribute("result") %> <br><br><br><br>
	
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

