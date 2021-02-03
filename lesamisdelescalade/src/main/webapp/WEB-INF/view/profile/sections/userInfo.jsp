<div id="profile__userInfo">
	<div id="profile__role">
		<img src="<%=request.getContextPath()%>/resources/assets/roles/${ sessionScope.role.getRoleName() }.png" />
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
</div>