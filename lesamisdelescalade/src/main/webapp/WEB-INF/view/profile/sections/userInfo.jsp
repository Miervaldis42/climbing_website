<div id="profile__userInfo">
	<div id="profile__role">
		<img src="<%=request.getContextPath()%>/resources/assets/roles/${ sessionScope.role.getRoleName() }.png" alt="Ton rôle - ${ sessionScope.role.getRoleName() }"/>
		${ sessionScope.role.getRoleName() }
	</div>
	
	<div id="profile__info">
		<p>
			<span>Nom:</span>
			${ sessionScope.lastname }
		</p>
		<p>
			<span>Prénom:</span>
			${ sessionScope.firstname }
		</p>
		<p>
			<span>Adresse email:</span>
			${ sessionScope.email }
		</p>
	</div>
	
	<a id="profile__logoutButton" href="logout">
		<i class="fa fa-couch"></i>
		Déconnexion
	</a>
</div>