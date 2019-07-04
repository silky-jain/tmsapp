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
<% session.invalidate(); %>
<div class="container">
	<jsp:include page="commons/header.jsp"></jsp:include>
<div class="main">

<form action="UserLoginController" method="post">
<h3>${param.msg}</h3>
<h2>User Login</h2>
<table class="table-hover">
<tr>
<td>Login Name</td>
<td><input type="text" class="form-control" name="loginname" placeholder="Enter Login Name" required/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" class="form-control" name="password" placeholder="Enter Password" required/></td>
</tr>

</table>
<br>
<br>
<a  class="btn btn-info " href="UserRegistration.jsp">Register</a><input class="btn btn-success " type="submit" value="Log In"/>
</form>
</div>
	<jsp:include page="commons/footer.jsp"></jsp:include>
</div>
</body>
</html>