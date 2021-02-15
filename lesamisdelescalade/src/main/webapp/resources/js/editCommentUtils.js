// Activate edit mode for a comment
function toggleEditCommentMode(id) {
	var userId = new Number(id);
	
	var commentContent = document.getElementById("commentContent"+id);
	var modifiedComment = document.getElementById("modifiedComment"+id);
	var deleteIcon = document.getElementById("deleteIcon"+id);


	if(commentContent.style.display == '') {
		
		modifiedComment.style.display = '';
		deleteIcon.style.display = 'none';
		commentContent.style.display = 'none';
		
	} else {

		commentContent.style.display = '';
		modifiedComment.style.display = 'none';
		deleteIcon.style.display = '';

	}

	return userId;
}