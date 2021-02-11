<div id="siteDetails__displayMode">	
	<div id="displayMode__siteInfo">
		<c:if test="${ site.tag }">
			<i id="displayMode__tag" class="fa fa-award" aria-hidden="true"></i>
		</c:if>
		
		<div id="siteInfo__header">
			<h2>${ site.name }</h2>
			<p>${ site.location }</p>
			<p>${ site.description }</p>
		</div>
		
		<br />
		<div id="siteInfo__elements">
			<!-- Sectors -->
			<div>
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
			
			<!-- Routes -->
			<br />
			<div>
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
			
			<!-- Lengths -->
			<br />
			<div>
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
	</div> <!-- End of siteInfo -->

</div>