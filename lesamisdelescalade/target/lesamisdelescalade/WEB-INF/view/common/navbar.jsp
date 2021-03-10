<header id="header">
	<!-- Logo -->
	<img id="header__logo" src="<%=request.getContextPath()%>/resources/assets/logo.png" />

	<!-- Navbar -->
	<nav id="header__navbar">
		<a href="/lesamisdelescalade/sites">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/mountains_icon.png" />
			Sites
		</a>
	
		<a href="/lesamisdelescalade/topos/list">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/topos_icon.png" />
			Topos
		</a>
		
		<c:if test="${ empty sessionScope.id }">
			<a href="/lesamisdelescalade/auth/login">
				<img src="<%=request.getContextPath()%>/resources/assets/navbar/climber_icon.png" />
				Vous ?
			</a>
		</c:if>
		<c:if test="${ !empty sessionScope.id }">
			<a href="/lesamisdelescalade/profile/infos">
				<img src="<%=request.getContextPath()%>/resources/assets/navbar/climber_icon.png" />
				${ sessionScope.firstname }
			</a>
		</c:if>
	</nav>
</header>