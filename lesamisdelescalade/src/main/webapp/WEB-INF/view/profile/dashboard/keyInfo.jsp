<div id="dashboard__display">
	<h3>
		<i class="fa fa-tachometer"></i>
		Info-clés
	</h3>
	
	<div id="kpiTab__content">
		
		<!-- Users card -->
		<div class="kpiTab__card">
			<h4 class="kpiTab__cardTitle">Amis de l'escalade</h4>
			
			<div class="kpiTab__cardBody">
				<div>
					<p>${ users }</p>
					<p>Fédéré(e)s</p>
				</div>

				<div>
					<p>
						dont <span>${ admins }</span> administrateurs du site
					</p>
					<p>
						dont <span>${ members }</span> membres organisateurs
					</p>
					<p>
						dont <span>${ subscribers }</span> d'abonné(e)s
					</p>
				</div>
			</div>
		</div>
		
		<!-- Sites card -->
		<div class="kpiTab__card">
			<h4 class="kpiTab__cardTitle">Sites d'escalade</h4>
			
			<div class="kpiTab__cardBody">
				<div>
					<p>${ sites }</p>
					<p>Sites</p>
				</div>
				
				<div>
					<p>
						Nombre total de secteurs: <span>${ sectors }</span>
					</p>
					<p>
						Nombre total de routes: <span>${ routes }</span>
					</p>
					<p>
						Nombre total de longueurs: <span>${ lengths }</span>
					</p>
				</div>
			</div>
		</div>
		
		
		<!-- Topos card -->
		<div class="kpiTab__card">
			<h4 class="kpiTab__cardTitle">Topos</h4>
			
			<div class="kpiTab__cardBody">
				<div>
					<p>
						${ topos }
						<p>Topos</p>
					</p>
				</div>
			</div>
		</div>
		
	</div>
</div>