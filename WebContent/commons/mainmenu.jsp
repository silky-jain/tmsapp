<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:if test="${sessionScope.loggedInUser==null }">			
				<a href="#">Home</a> |
				<a href="#">About</a> |
				<a href="#">Contact</a> |
				<a href="UserLogin.jsp">LogIn</a> |
				<a href="UserRegistration.jsp">SignUp</a>
	</c:if>
	<c:if test="${sessionScope.loggedInUser!=null }">
		<c:if test="${sessionScope.loggedInUserRole==1}">
				<a href="User-Dashboard.jsp">List Training</a> |
			
				<a href="logout.jsp">LogOut</a> 
				</c:if>
				<c:if test="${sessionScope.loggedInUserRole==2}">
				<a href="User-Dashboard.jsp">List Training</a> |
				<a href="RequestTraining.jsp">Request Training</a> |
				<a href="logout.jsp">LogOut</a> 
				</c:if>
	</c:if>