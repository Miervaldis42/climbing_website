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