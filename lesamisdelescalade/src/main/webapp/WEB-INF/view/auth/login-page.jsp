<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/login-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/login-style.css" />
		
		<!-- Tab name -->
		<title>Page de connexion</title>
	</head>

	<!-- Body -->
	<body id="loginBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="loginContainer" class="container">
			<h2>Bonjour jeune grimpeur(euse) !</h2>

			<form:form id="loginForm" method="POST" action="login">
				<div class="field">
					<label for="typedEmail">Adresse email</label>
					<input type="text" name="typedEmail" autofocus />
				</div>
				
				<div class="field">
					<label for="typedPassword">Mot de passe</label>
					<input type="password" name="typedPassword" />
				</div>
				
				<input id="loginButton" type="submit" value="Et c'est parti !" />
			</form:form>

			<!-- Links: Forgotten password & New climber -->
			<div id="loginLinks">
				<a href="#">Mot de passe oublié ?</a>
				<a href="userInscription">Nouveau par ici ?</a>
			</div>
		</div>
		
		<%@ include file="../common/footer.jsp" %>
	</body>
</html>