<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/siteDetails-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/siteDetails-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Site details</title>
	</head>

	<body id="siteDetailsBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="siteDetailsContainer" class="container">
			<h2 class="title">Détails du site</h2>
			
			<div id="siteDetailsCard">
				<img id="siteCover" src="<%=request.getContextPath()%>/resources/assets/sites/${ site.name }.jpg" />

				<c:if test="${ site.tag }">
					<i id="siteTag" class="fa fa-award" aria-hidden="true"></i>
				</c:if>

				<div id="siteInfo">
					<div id="siteHeader">
						<h2>${ site.name }</h2>
						<p id="siteLocation">${ site.location }</p>
						<p>${ site.description }</p>
					</div>
					
					<br />
					<div id="siteElements">
						<div id="siteSectors">
							<h3><i class="fas fa-map-signs"></i> Secteurs</h3>
							
							<c:if test="${ empty sectors }">
								<p class="center">---</p>
							</c:if>
							<ul>								
								<c:forEach items="${ sectors }" var="sector">
									<li>${ sector.name }</li>
								</c:forEach>
							</ul>
						</div>
						
						<br />
						<div id="siteRoutes">
							<h3><i class="fas fa-route"></i> Routes</h3>
							
							<c:if test="${ empty routes }">
								<p class="center">---</p>
							</c:if>
							<ul>
								<c:forEach items="${ routes }" var="route">
									<li>${ route.name } - ${ route.quotation }</li>
								</c:forEach>
							</ul>
						</div>
						
						<br />
						<div id="siteLengths">
							<h3><i class="fas fa-wave-square"></i> Longueurs</h3>
							
							<c:if test="${ empty lengths }">
								<p class="center">---</p>
							</c:if>
							<ul>
								<c:forEach items="${ lengths }" var="length">
									<li>${ length.name } - ${ length.quotation }</li>
								</c:forEach>
							</ul>
						</div>
					</div>					
				</div>

			</div>
		</div>	<!-- End of container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
</html>