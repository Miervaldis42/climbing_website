<div id="dashboard__sitesTab">
	<h3>
		<img src="<%=request.getContextPath()%>/resources/assets/navbar/mountains_icon.png" />
		Sites
	</h3>

	<div id="sitesTab__content">
		<!-- 1st column: List of all sites -->
		<div id="sitesTab__siteList">
			<h4>Liste des sites d'escalade</h4>
			
			<c:forEach items="${ sites }" var="s">
				<a href="/lesamisdelescalade/dashboard/sites?siteId=${ s.id }" class="site__tile">
					<p>
						 ${ s.name } - ${ s.location }
					</p>
				</a>
			</c:forEach>
		</div>
		
		<c:if test="${ not empty site }">
			<!-- 2nd column: Site detail card -->
			<div class="details">					
				<h3>Id: ${ site.id }</h3>
						
				<div id="sitesTab__siteDetailsContent">
					<p>
						<span>Nom:</span> ${ site.name }
					</p>
					<p>
						<span>Lieu:</span> ${ site.location }
					</p>
					<p>
						<span>Officiel ?:</span> ${ site.tag ? 'Officiel' : '---' }
					</p>
					<p>
						<span>Description:</span> ${ site.description }
					</p>
					
				</div>
				
				<!-- Site edit -->
				<form id="sitesTab__editSiteForm" action="/lesamisdelescalade/dashboard/editSite" method="POST" style="display: none;">
					<input type="hidden" name="siteId" value="${ site.id }" />
					
					<div>
						<label>Officiel ?</label>
						<select name="tag">
							<option value="true" ${ site.tag == true ? 'selected' : '' }>Officiel</option>
							<option value="false" ${ site.tag == false ? 'selected' : '' }>Non officiel</option>
						</select>
					</div>
					
					<div>
						<label>Nom</label>
						<input type="text" name="name" value="${ site.name }" required />
					</div>
					
					<div>
						<label>Lieu</label>
						<input type="text" name="location" value="${ site.location }" required />
					</div>
					
					<div>
						<label>Description</label>
						<input type="text" name="desc" value="${ site.description }" required />
					</div>
					
					<button type="submit">
						<i class="fa fa-check"></i>
					</button>
				</form>
				
				<div class="actionButtons">
					<a onclick="showSiteEditForm()">
						<i class="fa fa-pencil-alt"></i>
					</a>
					
					<c:url var="deleteSiteLink" value="/dashboard/deleteSite">
						<c:param name="siteId" value="${ site.id }" />
					</c:url>
					<a onclick="if(!(confirm('Êtes-vous sûr de vouloir supprimer le site d\'escalade \'${ site.name }\' ?'))) return false" href="${ deleteSiteLink }">
						<i class="fa fa-times"></i>
					</a>
				</div>
			</div>
		
			<!-- 2nd column: List of all sectors -->
			<c:if test="${ not empty siteSectors && siteSectors.size() > 0 }">
				<div id="sitesTab__sectorList">
					<h4>Ses secteurs</h4>
					
					<c:forEach items="${ siteSectors }" var="s">
						<div class="sector_tile">
							<div>
								<h3>Id: ${ s.id }</h3>
								<p id="sitesTab__sectorContent${ s.id }">
									<span>Nom:</span> ${ s.name }
								</p>
							</div>
							
							<!-- Edit Sector -->
							<form id="sitesTab__editSectorForm${ s.id }" action="/lesamisdelescalade/dashboard/editSector" method="POST" style="display: none;">
								<input type="hidden" name="sectorId" value="${ s.id }" />
								
								<label>Nom</label>
								<input type="text" name="name" value="${ s.name }" required />
								
								<button type="submit">
									<i class="fa fa-check"></i>
								</button>
							</form>							
							
							<div class="actionButtons">
								<a onclick="showSectorEditForm(${ s.id })">
									<i class="fa fa-pencil-alt"></i>
								</a>
								
								<c:url var="deleteSectorLink" value="/dashboard/deleteSector">
									<c:param name="sectorId" value="${ s.id }" />
								</c:url>
								<a onclick="if(!(confirm('Êtes-vous sûr de vouloir supprimer le secteur \'${ s.name }\' ?'))) return false" href="${ deleteSectorLink }">
									<i class="fa fa-times"></i>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
			
			<!-- 3rd column: List of all site routes -->
			<c:if test="${ not empty siteRoutes && siteRoutes.size() > 0 }">
				<div id="sitesTab__routeList">
					<h4>Ses routes</h4>
					
					<c:forEach items="${ siteRoutes }" var="r">
						<h3>Id: ${ r.id }</h3>
						
						<div id="sitesTab__routeContent${ r.id }">
							<p>
								<span>Nom:</span> ${ r.name }
							</p>
							<p>
								<span>Cotation:</span> ${ r.quotation }
							</p>
							<p>
								<span>Liée au secteur:</span> ${ r.sector.name }
							</p>
						</div>
						
						<!-- Edit Route -->
						<form id="sitesTab__editRouteForm${ r.id }" action="/lesamisdelescalade/dashboard/editRoute" method="POST" style="display: none;">
							<input type="hidden" name="routeId" value="${ r.id }" />
							
							<label>Nom</label>
							<input type="text" name="name" value="${ r.name }" required />
							
							<label>Cotation</label>
							<select name="quotation">
								<c:forEach items="${ quotationList }" var="q">
									<option value="${ q }" ${ r.quotation == q ? "selected" : "" }> ${ q } </option>
								</c:forEach>
							</select>
							
							<button type="submit">
								<i class="fa fa-check"></i>
							</button>
						</form>							
						
						<div class="actionButtons">
							<a onclick="showRouteEditForm(${ r.id })">
								<i class="fa fa-pencil-alt"></i>
							</a>
							
							<c:url var="deleteRouteLink" value="/dashboard/deleteRoute">
								<c:param name="routeId" value="${ r.id }" />
							</c:url>
							<a onclick="if(!(confirm('Êtes-vous sûr de vouloir supprimer la route \'${ r.name }\' ?'))) return false" href="${ deleteRouteLink }">
								<i class="fa fa-times"></i>
							</a>
						</div>
					</c:forEach>
				</div>
			</c:if>
			
			<!-- 4th column: List of all site lengths -->
			<c:if test="${ not empty siteLengths && siteLengths.size() > 0 }">
				<div id="sitesTab__lengthList">
					<h4>Ses longueurs</h4>
					
					<c:forEach items="${ siteLengths }" var="l">
						<h3>Id: ${ l.id }</h3>
						
						<div id="sitesTab__lengthContent${ l.id }">
							<p>
								<span>Liée à la route:</span> ${ l.route.name }
							</p>
							<p>
								<span>Nom:</span> ${ l.name }
							</p>
							<p>
								<span>Cotation:</span> ${ l.quotation }
						</p>
						</div>
						
						<!-- Edit Length -->
						<form id="sitesTab__editLengthForm${ l.id }" action="/lesamisdelescalade/dashboard/editLength" method="POST" style="display: none;">
							<input type="hidden" name="lengthId" value="${ l.id }" />
							
							<label>Nom</label>
							<input type="text" name="name" value="${ l.name }" required />
							
							<label>Cotation</label>
							<select name="quotation">
								<c:forEach items="${ quotationList }" var="q">
									<option value="${ q }" ${ l.quotation == q ? "selected" : "" }> ${ q } </option>
								</c:forEach>
							</select>
							
							<button type="submit">
								<i class="fa fa-check"></i>
							</button>
						</form>							
						
						<div class="actionButtons">
							<a onclick="showLengthEditForm(${ l.id })">
								<i class="fa fa-pencil-alt"></i>
							</a>
							
							<c:url var="deleteLengthLink" value="/dashboard/deleteLength">
								<c:param name="lengthId" value="${ l.id }" />
							</c:url>
							<a onclick="if(!(confirm('Êtes-vous sûr de vouloir supprimer la longueur \'${ l.name }\' ?'))) return false" href="${ deleteLengthLink }">
								<i class="fa fa-times"></i>
							</a>
						</div>
					</c:forEach>
				</div>
			</c:if>
			

			<!-- 5th column: List of all site topos -->
			<c:if test="${ not empty siteTopos && siteTopos.size() > 0 }">
				<div id="sitesTab__topoList">
					<h4>Ses topos</h4>
					
					<c:forEach items="${ siteTopos }" var="t">
						<div>
							<h3>Id: ${ t.id }</h3>
							<p>
								<span>Propriétaire:</span> ${ t.owner.firstname }
							</p>
							<p>
								<span>Nom:</span> ${ t.name }
							</p>
							<p>
								<span>Status:</span> ${ t.status.getStatusName() }
							</p>
							<p>
								<span>Description:</span> ${ t.description }
							</p>
							<p>
								<span>Date de parution:</span> ${ siteTopoDates.get(t.id) }
							</p>
							<c:if test="${ not empty t.getBorrower() }">
								<p>
									<span>Demande d'emprunt ou prêté à:</span>
									 ${ t.getBorrower().firstname }
								</p>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</c:if>

		</c:if>

	</div>
</div>