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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/siteList-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/siteList-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Sites d'escalade</title>
	</head>

	<!-- Body -->
	<body id="siteBody">
		<%@ include file="common/navbar.jsp" %>
		
		<div id="siteContainer" class="container">
			<h2 class="title">Sites d'escalade</h2>
			
			<!-- Site list -->
			<div id="siteCards">
				
				<c:forEach items="${ sites }" var="site">
					<div class="siteCard" style="background-image: url('<%=request.getContextPath()%>/resources/assets/sites/${ site.name }.jpg');">
						<!-- Official tag -->
						<c:if test="${ site.tag }">
							<div class="siteTag">
								<p>Officiel - Les amis de l'escalade</p>
							</div>
						</c:if>
						
						<!-- Site main info -->
						<div class="siteMainInfo">
							<p class="siteCardName">${ site.name }</p>
							<p class="siteCardLocation">
								<i class="fas fa-map-marker-alt"></i> 
								${ site.location }
							</p>
						</div>
					
						<div class="siteSubInfo">
							<div> 
								<i class="fas fa-award" title="Cotation"></i>						
								<c:choose>
								  <c:when test="${ quotation.get(site.id) == null }">
								    -
								  </c:when>
								  <c:otherwise>
								    ${ quotation.get(site.id) }
								  </c:otherwise>
								</c:choose>
							</div>
							
							<div>
								<i class="fas fa-map-signs" title="Nombre de secteurs"></i>
								${ infos.get(site.id).get(1) }
							</div>
							
							<div>
								<i class="fas fa-route" title="Nombre de routes"></i>
								${ infos.get(site.id).get(2) }
							</div>
							
							<div>
								<i class="fas fa-wave-square" title="Nombre de longueurs"></i>
								${ infos.get(site.id).get(3) }
							</div>
						</div>
						
					</div>
				</c:forEach>
				
			</div>
		</div>
		
		<%@ include file="common/footer.jsp" %>
	</body>
</html>

