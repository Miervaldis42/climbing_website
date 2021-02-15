function showUserEditForm() {
	var userEditForm = document.getElementById("usersTab__editUserForm");
	var userDetails = document.getElementById("usersTab__userDetailscontent");
	
	if(userDetails.style.display == '') {
		userDetails.style.display = 'none';
		userEditForm.style.display = '';
	} else {
		userDetails.style.display = '';
		userEditForm.style.display = 'none';
	}
}