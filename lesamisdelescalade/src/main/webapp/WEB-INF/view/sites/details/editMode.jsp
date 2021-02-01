<!-- Edit icon -->
<div id="siteDetails__editIcon" onclick="showEditDetails()">
	<i class="fa fa-pencil-alt"></i>
</div>


<!-- Edit mode -->
<div id="siteDetails__editMode" style="display: none;">
	<form:form action="editInfo" method="GET">
		<input type="hidden" name="siteId" value="${ site.id }" />
		
		<!-- Tag field -->
		<div id="editMode__siteTag">
			<label id="editMode__tag">Officiel ?</label>
			<select id="editMode__tag" name="siteTag" value="${ site.tag }" readonly>
				<option value="true">Officiel</option>
				<option value="false">Non officiel</option>
			</select>
		</div>
		
		
		<!-- Name field -->
		<div id="editMode__siteName">
			<label for="editMode__name">Nom du site</label>
			<input id="editMode__name" value="${ site.name }" readonly />
		</div>
		
		
		<!-- Location field -->
		<div id="editMode__siteLocation">
			<label for="editMode__location">Lieu</label>
			<input id="editMode__location" value="${ site.location }" readonly />
		</div>
		
		
		<!-- Description field -->
		<div id="editMode__siteDesc">
			<label for="editMode__description">Description</label>
			<textarea id="editMode__description" readonly> ${ site.description } </textarea>
		</div>
		
		
		<!-- Sectors, routes & lengths -->
		<div id="editMode__components">
		
			<!-- Sector list -->
			<div id="editMode__sectors">
				<h3>
					Secteurs
					
					<button type="button" onclick="addASector()">
						<i class="fa fa-plus"></i>
					</button>
				</h3>
				
				<div>
					<c:if test="${ sectors == null }">
						<p>---</p>
					</c:if>
					
					<!--  List of existing sectors -->
					<c:forEach items="${ sectors }" var="sector">
						<c:if test="${ not empty sector.id }">
							<input type="hidden" name="sectorId" value="${ sector.id }" />
						</c:if>
						<label for="sectorCreation"> Secteur: </label>
						<input id="sectorCreation" name="sector" value="${ sector.name }" />
					</c:forEach>
				</div>
			</div>	<!-- End of Sector list -->
			
			
			<!-- Route list -->
			<div id="editMode__routes">
				<h3>
					Routes
				
					<button type="button" onclick="${ sectors != null } ? addARoute() : ''">
						<i class="fa fa-plus"></i>
					</button>
				</h3>
				
				<div>
					<c:if test="${ sectors == null }">
						<p>Aucune route ne peut être créée si le site d'escalade n'a pas de secteurs !</p>
					</c:if>
	
					<c:if test="${ routes == null }">
						<p>---</p>
					</c:if>			
					
					<!-- List of existing routes -->
					<c:forEach items="${ routes }" var="route">
						<c:if test="${ not empty route.id }">
							<input type="hidden" name="routeId" value="${ route.id }" />
						</c:if>
						
						<label for="existingRoutes"> Route: </label>
						<input id="existingRoutes" name="route" type="text" value="${ route.name }" />
						
						<select name="routeQuotation">
							<c:forEach items="${ quotations }" var="q">
								<option value="${ q }" ${ route.quotation == q ? "selected" : "" }> ${ q } </option>
							</c:forEach>
						</select>
					</c:forEach>
				</div>
				
				
				<!-- Route quotation selection -->
				<select id="routeQuotationSelect" name="routeQuotation" disabled="disabled" style="display: none;">
					<c:forEach items="${ quotations }" var="q">
						<option id="routeQuotationOption" value="${ q }"> ${ q } </option>
					</c:forEach>
				</select>
				
				<!-- Route sector selection -->
				<select id="routeSectorSelect" name="routeSector" disabled="disabled" style="display: none;">
					<c:forEach items="${ sectors }" var="s">
						<option id="routeSectorOption" value="${ s.id }"> ${ s.name } </option>
					</c:forEach>
				</select>
			</div> <!-- End of Route list -->
			
			
			<!-- Length list -->
			<div id="editMode__lengths">
				<h3>
					Longueurs
	
					<button type="button" onclick="${ routes != null } ? addALength() : ''">
						<i class="fa fa-plus"></i>
					</button>
				</h3>
				
				<div>
					<c:if test="${ routes == null }">
						<p>Aucune longueur ne peut être créée si le site d'escalade n'a pas de routes !</p>
					</c:if>
					
					<c:if test="${ lengths == null }">
						<p> --- </p>
					</c:if>
		
					<!-- Existing lengths -->
					<c:forEach items="${ lengths }" var="length">
						<c:if test="${ not empty length.id }">
							<input type="hidden" name="lengthId" value="${ length.id }" />
						</c:if>
	
						<label for="existingLengths"> Longueur: </label>
						<input type="text" id="existingLengths" name="length" value="${ length.name }" />
						
						<select name="lengthQuotation">
							<c:forEach items="${ quotations }" var="q">
								<option value="${ q }" ${ length.quotation == q ? "selected" : "" }> ${ q } </option>
							</c:forEach>
						</select>
					</c:forEach>
				</div>
				
				
				<!-- Length quotation selection -->
				<select id="lengthQuotationSelect" name="lengthQuotation" disabled="disabled" style="display: none;">
					<c:forEach items="${ quotations }" var="q">
						<option id="lengthQuotationOption" value="${ q }"> ${ q } </option>
					</c:forEach>
				</select>
				
				<!-- Length route selection -->
				<select id="lengthRouteSelect" name="lengthRoute" disabled="disabled" style="display: none;">
					<c:forEach items="${ routes }" var="r">
						<option id="lengthRouteOption" value="${ r.id }"> ${ r.name } </option>
					</c:forEach>
				</select>
			</div>	<!-- End of Length list -->
		</div>
		
		
		<!-- Submit button -->
		<button type="submit">
			<i class="fa fa-check"></i>
		</button>
	</form:form>
</div>