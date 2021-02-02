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
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 767.98px)" href="<%=request.getContextPath()%>/resources/css/mobile/siteList-mobile.css" />
		
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="<%=request.getContextPath()%>/resources/css/desktop/siteList-style.css" />
		
		<script src="https://kit.fontawesome.com/b67ef61f81.js"></script>
		
		<!-- Tab name -->
		<title>Sites d'escalade</title>
	</head>

	<!-- Body -->
	<body id="siteBody">
		<%@ include file="../common/navbar.jsp" %>
		
		<div id="siteContainer" class="container">
			<h2 class="title">Sites d'escalade</h2>
			
			<!--  Search box -->
            <form:form id="searchSection" action="search" method="GET">
            	<!-- Name or location filter -->
                <input id="textSearch" name="searchedTerms" value="${ keywords }" type="text" placeholder="Cherchez par nom ou par lieu (ex: Alpes, France)" />
                
                <!-- Certification filter -->
                <select name="tagFilter">
                	<option value="all" ${chosenTag == "all" ? "selected" : ""}>Tout</option>
                	<option value="true" ${chosenTag == "true" ? "selected" : ""}>Officiel</option>
                	<option value="false" ${chosenTag == "false" ? "selected" : ""}>Non officiel</option>
                </select>
                
                <!-- Quotation filter -->
                <select name="quotationFilter">
               		<option value="all">Toutes difficultés</option>
                	<c:forEach items="${ quotationDifficulties }" var="quotationDifficulty">
                		<option value="${ quotationDifficulty }" ${ chosenQuotationMode != "all" && chosenQuotationMode == quotationDifficulty ? "selected" : ""}>${ quotationDifficulty.getMode() }</option>
                	</c:forEach>
                </select>
                
                <button type="submit">
				    <i class="fa fa-search-location"></i>
				</button>
            </form:form>
            

            <!-- If no sites -->
            <c:if test="${ empty sites }">
            	<div id="noSearchResult">
            		<i class="fa fa-map-signs" aria-hidden="true"></i>
	            	<p>Le Mont Olympe que tu cherches n'existe pas encore sur notre site malheureusement...</p>
	            	<p>Mais nous avons d'autres merveilleux sites d'escalade qui n'attendent que toi !</p>
            	</div>
            </c:if>
            
			<!-- Site list -->
			<c:if test="${ not empty sites }">
			
				<div id="siteCards">
					<c:forEach items="${ sites }" var="site">
						<a href="details?siteId= ${ site.id }">
							<div class="siteCard" style="background-image: url('<%=request.getContextPath()%>/resources/assets/sites/${ site.name }.jpg');">
								<!-- Official tag -->
								<c:if test="${ site.tag }">
									<div class="siteTag">
										<i class="fa fa-award" aria-hidden="true"></i>
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
						</a>
					</c:forEach>
				</div>

			</c:if>	<!-- End of site list -->

		</div>	<!-- End of Container -->
		
		<%@ include file="../common/footer.jsp" %>
	</body>
</html>

