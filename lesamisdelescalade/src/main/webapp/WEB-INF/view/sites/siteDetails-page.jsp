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
			<div id="siteDetails__commentList">
				<h3>Commentaires (${ empty comments.size() ? 0 : comments.size() })</h3>
				
				<c:if test="${ empty comments }">
					<p id="commentList__empty">Sois le premier à nous narrer tes exploits sur ce site d'escalade ! ;)</p>
				</c:if>
				
				<!-- List of comments -->
				<c:forEach items="${ comments }" var="comment">
					<div class="commentList__comment">
						<img class="commentList__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ comment.getUser().role.getRoleName() }.png">
						
						<div class="commentList__content">
							<p class="commentList__author">${ comment.getUser().firstname }</p>
							
							<p>
								<c:if test="${ empty comment.getUpdatedAt() }">
									<span class="commentList__creationDate">Créé le: ${ commentCreationDates.get(comment.getId()) }</span>
								</c:if>
								<c:if test="${ not empty comment.getUpdatedAt() && commentUpdateDates.containsKey(comment.getId())}">
									<span class="commentList__updateDate">(Modifié le: ${ commentUpdateDates.get(comment.getId()) }<span>
									<span class="commentList__modifiedLastBy"> par ${ comment.getModifiedLastBy().getFirstname() })<span>
								</c:if>
							</p>

							<div class="commentList__text">
								${ comment.getContent() }
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>	<!-- End of container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
	
	<script defer src="<%=request.getContextPath()%>/resources/js/editDetailsUtils.js"></script>
</html>