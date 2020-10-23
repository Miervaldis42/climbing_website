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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/userInscription-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/userInscription-style.css" />
		
		<!-- Tab name -->
		<title>Inscription - Grimpeur(euse)</title>
	</head>

	<!-- Body -->
	<body id="inscriptionBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="inscriptionContainer" class="container">			
			<h2>Inscription</h2>
			<p>Après cette inscription, tu feras parti(e) de la grande famille des 'Amis de l'escalade' !</p>
			<p>Cela te permettra de commenter des sites d'escalade, modifier des informations sur les fiches de ces derniers et même réserver des topos !!</p>
			<p>Alors, n'hésite pas à adhérer ;)</p>
			
			<form:form id="inscriptionForm" action="saveUser" modelAttribute="user" method="POST">
				<label>Nom de famille</label>
				<form:input path="lastname" />
				
				<label>Prénom</label>
				<form:input path="firstname" />
				
				<label>Adresse email</label>
				<form:input path="email" />
				
				<label>Password</label>
				<form:password path="password" />
				
				<input id="inscriptionButton" type="submit" value="Je m'inscris !" />
			</form:form>
		</div>
		
		<%@ include file="../common/footer.jsp" %>
	</body>

</html>