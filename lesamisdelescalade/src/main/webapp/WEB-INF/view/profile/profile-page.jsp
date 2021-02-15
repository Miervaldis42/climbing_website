<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

    
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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/profile-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/profile-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Profil</title>
	</head>

	<!-- Body -->
	<body id="profileBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="profileContainer" class="container">
			<h2 class="title">Profil</h2>
			
			<!-- Profile navigation -->
			<div id="profile__nav">
				<a href="/lesamisdelescalade/profile/infos">
					<i class="fa fa-info"></i>
					Info
				</a>
				
				<c:if test="${ sessionScope.role == 'ADMIN' }">
					<a href="/lesamisdelescalade/profile/dashboard">
						<i class="fa fa-tachometer-alt"></i>
						Dashboard
					</a>
				</c:if>
				
				<a href="/lesamisdelescalade/profile/myTopos">
					<img src="<%=request.getContextPath()%>/resources/assets/navbar/topos_icon.png" />
					Mes topos
				</a>
			</div>
			
			<!-- User info -->
			<c:if test="${ section.equals('infos') }">
				<%@ include file="sections/userInfo.jsp" %>
			</c:if>
			
			<!-- Dashboard -->
			<c:if test="${ section.equals('dashboard') }">
				<%@ include file="sections/dashboard.jsp" %>
			</c:if>
			
			<!-- My topos -->
			<c:if test="${ section.equals('myTopos') }">
				<%@ include file="sections/myTopos.jsp" %>
			</c:if>
			
		</div>	<!-- End of Container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
	
	<!-- JS script -->
	<script defer src="<%=request.getContextPath()%>/resources/js/dashboardUtils.js"></script>
</html>

