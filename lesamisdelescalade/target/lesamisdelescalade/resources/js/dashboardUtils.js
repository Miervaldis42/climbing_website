function showUserEditForm() {
	var userEditForm = document.getElementById("usersTab__editUserForm");
	var userDetails = document.getElementById("usersTab__userDetailsContent");
	
	if(userDetails.style.display == '') {
		userDetails.style.display = 'none';
		userEditForm.style.display = '';
	} else {
		userDetails.style.display = '';
		userEditForm.style.display = 'none';
	}
}


function showSiteEditForm() {
	var siteEditForm = document.getElementById("sitesTab__editSiteForm");
	var siteDetails = document.getElementById("sitesTab__siteDetailsContent");
	
	if(siteDetails.style.display == '') {
		siteDetails.style.display = 'none';
		siteEditForm.style.display = '';
	} else {
		siteDetails.style.display = '';
		siteEditForm.style.display = 'none';
	}
}


function showSectorEditForm(id) {
	var sectorEditForm = document.getElementById("sitesTab__editSectorForm"+id);
	var sectorDetails = document.getElementById("sitesTab__sectorContent"+id);
	
	if(sectorDetails.style.display == '') {
		sectorDetails.style.display = 'none';
		sectorEditForm.style.display = '';
	} else {
		sectorDetails.style.display = '';
		sectorEditForm.style.display = 'none';
	}
}


function showRouteEditForm(id) {
	var routeEditForm = document.getElementById("sitesTab__editRouteForm"+id);
	var routeDetails = document.getElementById("sitesTab__routeContent"+id);
	
	if(routeDetails.style.display == '') {
		routeDetails.style.display = 'none';
		routeEditForm.style.display = '';
	} else {
		routeDetails.style.display = '';
		routeEditForm.style.display = 'none';
	}
}

function showLengthEditForm(id) {
	var lengthEditForm = document.getElementById("sitesTab__lengthForm"+id);
	var lengthDetails = document.getElementById("sitesTab__lengthContent"+id);
	
	if(lengthDetails.style.display == '') {
		lengthDetails.style.display = 'none';
		lengthEditForm.style.display = '';
	} else {
		lengthDetails.style.display = '';
		lengthEditForm.style.display = 'none';
	}
}