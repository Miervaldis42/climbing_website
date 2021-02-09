<div id="profile__myTopos">
	<p>Test</p>
	
	<c:if test="${ empty myTopos || !myTopos.length > 0 }">
		<p>Tu ne possèdes pas de topo pour l'instant.</p>
	</c:if>
	
	<c:if test="${ not empty myTopos && myTopos.length > 0 }">
		<c:forEach items="${ myTopos }" var="topo">
			<p>${ topo.name }</p>
			<p>${ topo.location }</p>
			<p>${ topo.description }</p>
			<p>${ topo.publishedDate }</p>
			<p>${ topo.status }</p>
		</c:forEach>
	</c:if>
</div>