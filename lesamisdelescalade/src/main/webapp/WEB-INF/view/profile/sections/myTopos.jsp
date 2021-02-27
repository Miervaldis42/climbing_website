<div id="profile__myTopos">	
	<div id="myTopos__addForm">
		<h3 class="title">Ajouter un nouveau Topo</h3>

		<form id="myTopos__form" action="addMyTopo" method="POST">
			<input type="hidden" name="ownerId" value="${ sessionScope.id }" />
			
			<label for="myTopo__name">Nom du topo</label>
			<input id="myTopo__name" type="text" name="name" maxlength="45" />
			
			<label for="myTopo__desc">Description</label>
			<textarea id="myTopo__desc" type="text" name="desc" maxlength="255"></textarea>
			
			<label>Lié à quel site d'escalade ?</label>
			<select name="site">
				<c:forEach items="${ allSites }" var="site">
					<option value="${ site.id }">${ site.name }</option>
				</c:forEach>
			</select>
			
			<button id="myTopo__submitButton" type="submit">
				<i class="fa fa-check"></i>
			</button>
		</form>
	</div>


	<!-- Empty 'My Topos' list -->
	<c:if test="${ empty myTopos && myTopos != null }">
		<p div="myTopos__empty">Tu ne possèdes pas de topo pour l'instant.</p>
	</c:if>


	<!-- Full 'My Topos' list -->
	<c:if test="${ not empty myTopos }">
		<h3 class="title">Mes Topos</h3>

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
					 		<span>${ topo.name }</span> - <span>${ topo.getSite().name }</span>
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
								<div class="myTopos__borrowerAvatar">
									<img class="myTopos__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ topo.getBorrower().role.getRoleName() }.png">
									<p>${ topo.getBorrower().firstname }</p>
								</div>
								
								<c:if test="${ topo.status == 'LENT' }">
									<p class="myTopos__borrowerEmail">
										<i class="fa fa-paper-plane"></i> ${ topo.getBorrower().email }
									</p>
								</c:if>
							</div>
						</div>	<!-- End of borrower -->


						<!-- Action buttons -->
						<div class="myTopos__actionIcons">
							<c:url var="reservation" value="/profile/reservation">
								<c:param name="topoId" value="${ topo.id }" />
							</c:url>
							
							<c:if test="${ topo.status == 'PENDING' }">
								<a href="${ reservation }&reservationStatus=accept">
									<i class="fa fa-check"></i>
								</a>
								
								<a href="${ reservation }&reservationStatus=refuse">
									<i class="fa fa-times"></i>
								</a>
							</c:if>
							
							<c:if test="${ topo.status == 'LENT' }">
								<a href="${ reservation }&reservationStatus=end">
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