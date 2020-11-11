<header id="header">
	<!-- Logo -->
	<img id="header__logo" src="<%=request.getContextPath()%>/resources/assets/logo.png" />

	<!-- Navbar -->
	<nav id="header__navbar">
		<a href="/lesamisdelescalade/sites">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/mountains_icon.png" />
			Sites
		</a>
	
		<a href="#">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/topos_icon.png" />
			Topos
		</a>
		
		<a href="${ redirection }">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/climber_icon.png" />
			${ firstname }
		</a>
	</nav>
</header>