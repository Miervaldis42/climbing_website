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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/siteDetails-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/siteDetails-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Site details</title>
	</head>

	<body id="siteDetailsBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<!-- Container -->
		<div id="siteDetailsContainer" class="container">
			<h2 class="title">Détails du site</h2>


			<!-- Site details -->
			<div id="siteDetails">
				<img id="siteDetails__img" src="<%=request.getContextPath()%>/resources/assets/sites/${ site.name }.jpg" />
				
				<!-- Edit icon & mode -->
				<%@ include file="./details/editMode.jsp" %>
				
				<!-- Display mode -->
				<%@ include file="./details/displayMode.jsp" %>
			</div> <!-- End of SiteDetails -->


			<!-- Site comments -->
			<%@ include file="./comments/commentSection.jsp" %>

		</div>	<!-- End of container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
	
	<script defer src="<%=request.getContextPath()%>/resources/js/editDetailsUtils.js"></script>
	<script defer src="<%=request.getContextPath()%>/resources/js/editCommentUtils.js"></script>
</html>