<div id="profile__dashboard">

	<!-- Dashboard navbar -->
	<div id="dashboard__nav">
		<!-- General -->
		<a href="/lesamisdelescalade/profile/dashboard">
			<i class="fa fa-tachometer-alt"></i>
			Info-clés
		</a>
		
		<!-- Users -->
		<a href="/lesamisdelescalade/dashboard/users">
			<i class="fa fa-users"></i>
			Utilisateurs
		</a>
		
		<!-- Sites -->
		<a href="/lesamisdelescalade/dashboard/sites">
			<img src="<%=request.getContextPath()%>/resources/assets/navbar/mountains_icon.png" />
			Sites
		</a>		
	</div>
	

	<!-- Dashboard content -->
	<div id="dashboard__content">
		<c:if test="${ section == 'dashboard' && dashSection == 'keyInfo' }">
			<%@ include file="../dashboard/keyInfo.jsp" %>
		</c:if>
		
		<c:if test="${ dashSection == 'users' }">
			<%@ include file="../dashboard/users.jsp" %>
		</c:if>
		
		<c:if test="${ dashSection == 'sites' }">
			<%@ include file="../dashboard/sites.jsp" %>
		</c:if>
	</div>
</div>