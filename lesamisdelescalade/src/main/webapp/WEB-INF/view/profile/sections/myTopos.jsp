<div id="profile__myTopos">	
	<c:if test="${ empty myTopos && myTopos != null }">
		<p div="myTopos__empty">Tu ne possèdes pas de topo pour l'instant.</p>
	</c:if>
	
	<c:if test="${ not empty myTopos }">
		<div id="myTopos__list">
			<c:forEach items="${ myTopos }" var="topo">
				<div class="myTopos__topo">
					<div class="myTopos__status myTopos__status--${fn:toLowerCase(topo.status)}"></div>
					
					<!-- Body -->
					<div class="myTopos__body">
						<div class="myTopos__date">
					 		<p><i class="fa fa-clock"></i> ${ myToposDates.get(topo.id) }</p>
					 	</div>
					 	
					 	<p class="myTopos__title">
					 		<span>${ topo.name }</span> - <span>${ topo.getSite().location }</span>
					 	</p>
					 	
					 	<p class="myTopos__desc">${ topo.description }</p>
				 	</div>
					
					<!-- Borrower -->
					<c:if test="${ not empty topo.borrower }"> 
						<div class="myTopos__lent">
							<c:if test="${ topo.status == 'PENDING' }">
								<p>Souhaite réserver:</p>
							</c:if>
							
							<c:if test="${ topo.status == 'LENT' }">
								<p>Emprunté par:</p>
							</c:if>
							
							<div class="myTopos__borrower">
								<img class="myTopos__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ topo.getBorrower().role.getRoleName() }.png">
								<p>${ topo.getBorrower().firstname }</p>
							</div>
						</div>	<!-- End of borrower -->


						<!-- Action buttons -->
						<div class="myTopos__actionIcons">
							<c:url var="reservation" value="/lesamisdelescalade/profile/myTopos/reservation">
								<c:param name="topoId" value="${ topo.id }" />
								<c:param name="topoStatus" value="${ fn:toLowerCase(topo.status) }" />
							</c:url>
							
							<c:if test="${ topo.status == 'PENDING' }">
								<a href="${ reservation }">
									<i class="fa fa-check"></i>
								</a>
								
								<a href="${ reservation }">
									<i class="fa fa-times"></i>
								</a>
							</c:if>
							
							<c:if test="${ topo.status == 'LENT' }">
								<a href="${ reservation }">
									<i class="fa fa-eraser"></i>
								</a>
							</c:if>
						</div>
					</c:if>

				</div>
			</c:forEach>
		</div>
	</c:if>

</div>	<!-- End of My Topos -->