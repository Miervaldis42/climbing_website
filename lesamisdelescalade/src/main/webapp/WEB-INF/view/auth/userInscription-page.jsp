<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<!-- Header -->
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="inscriptionContainer" class="container">
			<!-- Toast: Error -->
			<c:if test="${not empty error}">
				<%@ include file="../notifications/error.jsp" %>
			</c:if>
			
			<div id="backToLoginButton">
				<a href="/lesamisdelescalade/auth/login">
					<img src="<%=request.getContextPath()%>/resources/assets/buttons/back_icon.png" alt="go back to login page" />
				</a>
			</div>
					
			<!-- Inscription -->
			<h2>Inscription</h2>
			<div id="inscriptionDescription">
				<p>Après cette inscription, tu feras parti(e) de la grande famille des 'amis de l'escalade' !</p>
				<p>Cela te permettra de commenter des sites d'escalade, modifier des informations sur les fiches de ces derniers et même réserver des topos !!</p>
				<p>Alors, n'hésite pas à adhérer ;)</p>
			</div>
			
			<form:form id="inscriptionForm" action="saveUser" modelAttribute="user" method="POST">
				<label>Nom de famille</label>
				<form:input path="lastname" />
				
				<label>Prénom</label>
				<form:input path="firstname" />
				
				<label>Adresse email</label>
				<form:input path="email" />
				
				<label>Password</label>
				<form:password path="password" />
				
				<!-- Submit button -->
				<input id="inscriptionButton" type="submit" value="Je m'inscris !" />
			</form:form>
		</div>
		
		<!-- Footer -->
		<%@ include file="../common/footer.jsp" %>
		
		<!-- Script : Toast - Transition out -->
		<script defer src="<%=request.getContextPath()%>/resources/js/toastTransition.js"></script>
	</body>

</html>