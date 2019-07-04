<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.yash.tmsapp.domain.Training"%>
<%@page import="java.util.List"%>
<%@page import="com.yash.tmsapp.serviceimpl.TrainingServiceImpl"%>
<%@page import="com.yash.tmsapp.service.TrainingService"%>
<%@page import="com.yash.tmsapp.serviceimpl.UserServiceImpl"%>
<%@page import="com.yash.tmsapp.service.UserService"%>
<%@page import="com.yash.tmsapp.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">

<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	
	<%
		User user = (User) session.getAttribute("loggedInUser");
	%>
	<div class="container">
		<jsp:include page="commons/header.jsp"></jsp:include>
		<div class="main">
			
			<h2 class="welcome">
				Welcome :
				<%=user.getName()%></h2>
			<%
				
				TrainingService trainingService = new TrainingServiceImpl();
				String search=request.getParameter("search");
				System.out.println(search+"search");
				List<Training> trainings=null;
				if(search==null){
					trainings = trainingService.listTraining(user.getId(),user.getRole());
				}
				else{
				 trainings = trainingService.find(search);
				}
				request.setAttribute("trainings", trainings);
				
			%>
			<form action="DeleteSelectedController" method="post" class="dashboardform" >
			
			<h4>${param.msg}</h4>
			<c:if test="${empty trainings }">
			
				<h4 align="center">${"No Training Requested"}</h4>
			</c:if>
			<c:if test="${not empty trainings}">
			<br>
			<br>
		
				<div class="md-form mt-0">
					<input class="form-control" type="text" name="search" placeholder="Search" aria-label="Search">
					<button type="submit" class="btn btn-info " formaction="User-Dashboard.jsp">Search</button>
				</div>
				<button type="submit" class="btn btn-info deleteselected ">DeleteSelected</button>
				<table  style="margin: 0 auto; text-align: center;padding: 5px; width: 80%;"  class=" table table-hover">
				
					<tr>
						<th>Check</th>
						<th>Title</th>
						<th>Objective</th>
						<th>Course</th>
						<th>Mode</th>
						<th>Batchsize</th>
						<th>Expectation</th>
						<th>Duration</th>
						<th colspan="2">Operations</th>
					</tr>
					<%
						for (int i=trainings.size()-1 ;i>=0;i--) {
					%>
					<tr>
						<td><input type="checkbox"  name="select"
							value="<%=trainings.get(i).getId()%>"></td>
						<td><%=trainings.get(i).getTitle()%></td>
						<td><%=trainings.get(i).getObjective()%></td>
						<td><%=trainings.get(i).getCourse()%></td>
						<% int mode=trainings.get(i).getMode(); 
						String modeString=null;
							if(mode==1){
								 modeString="Classroom";
							}
							else
								modeString="online";
						%>
						<td><%=modeString%></td>
						<td><%=trainings.get(i).getBatchsize()%></td>
						<td><%=trainings.get(i).getExpectation()%></td>
						<td><%=trainings.get(i).getDuration()%></td>
						
						<%
							int id=trainings.get(i).getId();
						
						%>
						<td><a  class="btn btn-info "  href="DeleteController?id=<%=id %>">Delete</a></td>
						<td><a   class="btn btn-info " href="Edit.jsp?id=<%=id%>">Edit</a></td>
					</tr>
					<%
						}
					%>
				</table>
				</form>
			</c:if>

		</div>
		<jsp:include page="commons/footer.jsp"></jsp:include>
	</div>

</body>
</html>