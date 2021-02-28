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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/topos-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/topos-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Topos</title>
	</head>

	<!-- Body -->
	<body id="topoBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="topoContainer" class="container">
			<c:if test="${not empty success}">
				<%@ include file="../notifications/success.jsp" %>
			</c:if>


			<h2 class="title">Topos</h2>
			
			<!-- Empty Topo list -->
			<c:if test="${ empty topoList || topoList.size() < 0 }">
				<div id="emptyTopoList">
					<p>
						<i class="fa fa-address-book"></i>
						<br />
						Tous les topos sont malheureusement soit déjà prêtés, soit en attente de confirmation.
						<br />
						N'hésite pas à revenir plus tard pour peut-être découvrir de nouveaux topos !
					</p>
				</div>
			</c:if>
			
			<!-- Topo list -->
			<c:if test="${ not empty topoList && topoList.size() > 0 }">
				<div id="topoList">			
					<c:forEach items="${ topoList }" var="topo">
						<div class="topoCard ${ not empty sessionScope.id ? 'topoCard--turn' : '' }">
							<div class="front">
								<img src="<%=request.getContextPath()%>/resources/assets/topos/${ topo.id % 10 }.png" class="topoCard__img" />
								
								<!-- Topo card header -->
								<div class="topoCard__header">
									<p>${ toposDates.get(topo.id) }</p>
								</div>
								
								<!-- Topo card body -->
								<div class="topoCard__body">
									<p class="topoCard__info">
										<span class="topoCard__name">${ topo.name }</span> - <span class="topoCard__location">${ topo.getSite().name }</span>
									</p>
		
									<p class="topoCard__desc">${ topo.description }</p>
								</div>
								
								<!-- Topo card footer -->
								<div class="topoCard__footer">
									<img class="topoCard__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ topo.owner.role.getRoleName() }.png">
									<p class="topoCard__owner">
										${ topo.owner.firstname }
									</p>
								</div>
							</div><!-- End of front card -->
							
							<div class="back">
								<p>Si ce topo t'intéresse, n'hésite pas à cliquer sur le bouton ci-dessous pour le réserver !</p>
								
								<c:url var="bookTopo" value="bookTopo">
									<c:param name="topoId" value="${ topo.id }" />
									<c:param name="borrowerId" value="${ sessionScope.id }" />
								</c:url>
								<a href="${ bookTopo }">
									<i class="fa fa-ticket-alt"></i>
									C'est parti !
								</a>
							</div>
						</div>
					</c:forEach>
				</div>	<!-- End of Topo list -->
			</c:if>

		</div>	<!-- End of Container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
	
	<!-- Script : Toast - Transition out -->
	<script defer src="<%=request.getContextPath()%>/resources/js/toastTransition.js"></script>
</html>

