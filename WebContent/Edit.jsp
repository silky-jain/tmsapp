<%@page import="com.yash.tmsapp.serviceimpl.TrainingServiceImpl"%>
<%@page import="com.yash.tmsapp.service.TrainingService"%>
<%@page import="com.yash.tmsapp.domain.Training"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">

<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<jsp:include page="commons/header.jsp"></jsp:include>
<div class="main">

<form action="EditController?id=<%=request.getParameter("id") %>" method="post" class="updateform">
<h2>Update Training</h2>
<table class="formtable">
<%
TrainingService trainingService=new TrainingServiceImpl();
int id=Integer.parseInt(request.getParameter("id"));
Training training= trainingService.findById(id);

%>
<tr>
<td>Title</td>
<td><input type="text" class="form-control" name="title" placeholder="Enter Title" value="<%=training.getTitle() %>" required/></td>
</tr>
<tr>
<td>Objective</td>
<td><input type="text" class="form-control" name="objective" placeholder="Enter Objective" value="<%=training.getObjective()%> " required/></td>
</tr>
<tr>
<td>Course</td>
<td><input type="text"   class="form-control"name="course" placeholder="Enter Course" value="<%=training.getCourse() %>" required/></td>
</tr>
<tr>
<td>Mode</td>
<td><select class="form-control" style="width: 180px;" name="mode"  value="<%=training.getMode()%>">
	<option value="1">Classroom</option>
	<option value="2">Online</option>
</select></td>
</tr>
<tr>
<td>Batchsize</td>
<td><input type="number" class="form-control" name="batchsize" placeholder="Enter Batchsize" value="<%=training.getBatchsize()%>" required/></td>
</tr>
<tr>
<td>Expectation</td>
<td><input type="text" class="form-control" name="expectation" placeholder="Enter Expectation" value="<%=training.getExpectation()%>" required/></td>
</tr>
<tr>
<td>Duration</td>
<td><input type="number" class="form-control" name="duration" placeholder="Enter Duration" value="<%=training.getDuration()%>" required/></td>
</tr>

</table>
<br>
<br>
<input class="btn btn-info " type="submit" value="Update"/>
</form>
</div>
	<jsp:include page="commons/footer.jsp"></jsp:include>
</div>
</body>
</html>