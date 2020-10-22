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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/splashscreen-mobile.css" />
		<link rel="stylesheet" type="text/css"  media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/splashscreen-style.css" />
		
		<title>Les amis de l'escalade</title>
	</head>

	<!-- Body -->
	<body id="splashscreen">
		<!-- Logo -->
		<img id="logo" src="<%=request.getContextPath()%>/resources/assets/logo.png" alt="logo" />
	
		<!-- Quote -->
		<div id="quote">
			<p>
				Si vous n'escaladez pas de montagnes,
				<br />Vous ne profiterez jamais de la vue.
			</p>
			<p id="author">Pablo Neruda</p>
		</div>
	</body>

	<!-- After 5s, redirection to the main page -->
	<script defer src="<%=request.getContextPath()%>/resources/js/splashscreenTransition.js"></script>
</html>

