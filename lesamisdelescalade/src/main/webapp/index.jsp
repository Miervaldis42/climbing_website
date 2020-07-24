<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/stylesheet.css" />
		<script defer src="<%=request.getContextPath()%>/resources/js/script.js"></script>
		<title>Les amis de l'escalade</title>
	</head>

	<body>
		<img src="<%=request.getContextPath()%>/resources/assets/mountainClimber.png" />
		<h1>Welcome !</h1>
		
		<br />
		<div id="button">
			<input type="button" onclick="doSomething()" value="Try it !" />
			<h3>
			<a href="test">Click Here</a>
		</h3>
		</div>
	</body>
</html>