<div id="dashboard__usersTab">
	<h3>
		<i class="fa fa-users"></i>
		Utilisateurs
	</h3>

	<div id="usersTab__content">
		<!-- 1st column: List of all users -->
		<div id="usersTab__userList">
			<h4>Liste des utilisateurs</h4>
	
			<c:forEach items="${ users }" var="u">
				<a href="/lesamisdelescalade/dashboard/users?userId=${ u.id }" class="user__tile">
					<img class="avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ u.role.getRoleName() }.png" alt="${ u.firstname } - ${ u.role.getRoleName() }"/>
					<p>
						 ${ u.firstname } ${ u.lastname }
					</p>
				</a>
			</c:forEach>
		</div>
		
		<c:if test="${ not empty user }">
			<!-- 2nd column: User detail card -->
			<div id="usersTab__userDetails">					
				<h3>Id: ${ user.id }</h3>
						
				<div id="usersTab__userDetailscontent">
					<p>
						<span>Rôle:</span> ${ user.role.getRoleName() }
					</p>
					
					<div class="user__info">
						<p>
							<span>Nom de famille:</span> ${ user.lastname }
						</p>
						<p>
							<span>Prénom:</span> ${ user.firstname }
						</p>
						<p>
							<span>Adresse mail:</span> ${ user.email }
						</p>
					</div>
					
					<div class="user__dates">
						<p>
							<span>Date de création:</span> ${ user.createdAt }
						</p>
						<p>
							<span>Dernière modification:</span> ${ empty user.updatedAt ? '---' : user.updatedAt }
						</p>
					</div>					
				</div>
				
				<!-- User edit -->
				<form id="usersTab__editUserForm" action="/lesamisdelescalade/dashboard/editUser" method="POST" style="display: none;">
					<input type="hidden" name="userId" value="${ user.id }" />
					
					<div>
						<label>Rôle</label>
						<select name="role">
							<c:forEach items="${ roles }" var="r">
								<option value="${ r }" ${ r == user.role ? 'selected' : '' }>${ r.getRoleName()  }</option>
							</c:forEach>
						</select>
					</div>
					
					<div>
						<label>Nom de famille</label>
						<input type="text" name="lastname" value="${ user.lastname }" required />
					</div>
					
					<div>
						<label>Prénom</label>
						<input type="text" name="firstname" value="${ user.firstname }" required />
					</div>
					
					<div>
						<label>Adresse email</label>
						<input type="text" name="email" value="${ user.email }" required />
					</div>
					
					<button type="submit">
						<i class="fa fa-check"></i>
					</button>
				</form>
				
				<div id="usersTab__userActionButtons">
					<a onclick="showUserEditForm()">
						<i class="fa fa-pencil-alt"></i>
					</a>
					
					<c:url var="deleteUserLink" value="/dashboard/deleteUser">
						<c:param name="userId" value="${ user.id }" />
					</c:url>
					<a onclick="if(!(confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?'))) return false" href="${ deleteUserLink }">
						<i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			
			<!-- 3rd column: His/Her topos  -->
			<c:if test="${ not empty userTopos && userTopos.size() > 0 }">
				<div id="usersTab__userToposList">
					<h4>Ses topos</h4>

					<c:forEach items="${ userTopos }" var="t">
						<div>
							<p>
								<span>Nom:</span> ${ t.name }
							</p>
							<p>
								<span>Lié au site:</span> ${ t.getSite().name }
							</p>
							<p>
								<span>Status:</span> ${ t.status.getStatusName() }
							</p>
							<p>
								<span>Description:</span> ${ t.description }
							</p>
							<p>
								<span>Date de parution:</span> ${ t.publishedDate }
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
			
			<!-- 4th column: His/Her comments  -->
			<c:if test="${ not empty userComments && userComments.size() > 0 }">
				<div id="usersTab__userCommentsList">
					<h4>Ses commentaires</h4>
					
					<c:forEach items="${ userComments }" var="c">
						<div>
							<p>
								<span>Sur le site:</span> ${ c.site.name }
							</p>
							<p>
								<span>Contenu:</span> ${ c.content }
							</p>
							<p>
								<span>Créé le:</span> ${ c.createdAt }
							</p>
							
							<c:if test="${ not empty c.updatedAt }">
								<p>
									<span>Modifié le:</span> ${ c.updatedAt }
								</p>
								<p>
									<span>Modifié par:</span> ${ c.modifiedLastBy.firstname }
								</p>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</c:if>

		</c:if>

	</div>	<!-- Dashboard - Users tab content -->
</div>