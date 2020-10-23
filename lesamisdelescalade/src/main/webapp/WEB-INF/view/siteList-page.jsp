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
		
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/style-mobile.css" />
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/siteList-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/siteList-style.css" />
		
		<!-- Tab name -->
		<title>Sites d'escalade</title>
	</head>

	<!-- Body -->
	<body id="siteBody">
		<%@ include file="common/navbar.jsp" %>
		
		<div id="siteContainer" class="container">
			Nos développeurs mettent tous en oeuvre pour construire ce havre de paix avec vue en contre-plongée sur la montagne !
			<br/>
			Revenez plus tard pour apprécier le spectacle ;)
		</div>
		
		<%@ include file="common/footer.jsp" %>
	</body>
</html>

