<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<!-- Meta -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <!-- CSS -->
		<link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/assets/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
		
		<!-- Tab name -->
		<title>Sites d'escalade</title>
	</head>

	<!-- Body -->
	<body style="background-image: url('<%=request.getContextPath()%>/resources/assets/mountain.jpg')">
		<%@ include file="navbar.jsp" %>
		
		<div class="container">
			Nos développeurs mettent tous en oeuvre pour construire ce havre de paix avec vue en contre-plongée sur la montagne ! 
			<br/>
			Revenez plus tard pour apprécier le spectacle ;)
		</div>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>

