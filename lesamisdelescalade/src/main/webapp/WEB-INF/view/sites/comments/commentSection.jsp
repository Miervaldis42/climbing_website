<div id="siteDetails__commentList">
	<h3>Commentaires (${ empty comments.size() ? 0 : comments.size() })</h3>
	
	<c:if test="${ not empty sessionScope.role }">
		<form id="commentList__addCommentForm" action="addComment" method="POST">
			<input type="hidden" name="siteId" value="${ site.getId() }"/>
	
			<img id="addCommentForm__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ sessionScope.role.getRoleName() }.png">
			
			<div id="addCommentForm__form">
				<input id="addCommentForm__input" type="text" name="content" placeholder="Partager vos impressions sur ce site ici !" maxlength="255" />
				<button id="addCommentForm__submitButton" type="submit">
					<i class="fa fa-check"></i>
				</button>
			</div>
		</form>
	</c:if>
	
	<c:if test="${ empty comments }">
		<p id="commentList__empty">Sois le premier à nous narrer tes exploits sur ce site d'escalade ! ;)</p>
	</c:if>
	
	<!-- List of comments -->
	<c:forEach items="${ comments }" var="comment">
		<div class="commentList__comment">
		
			<!-- Avatar -->
			<img class="commentList__avatar" src="<%=request.getContextPath()%>/resources/assets/roles/${ comment.getUser().role.getRoleName() }.png">
			
			<div class="commentList__info">
				<div class="commentList__header">
					<!-- User name -->
					<p class="commentList__author">${ comment.getUser().firstname }</p>
					
					<!-- Date of creation or update -->
					<p>
						<c:if test="${ empty comment.getUpdatedAt() }">
							<span class="commentList__creationDate">Créé le: ${ commentCreationDates.get(comment.getId()) }</span>
						</c:if>
						<c:if test="${ not empty comment.getUpdatedAt() && commentUpdateDates.containsKey(comment.getId()) }">
							<span class="commentList__updateDate">(Modifié le: ${ commentUpdateDates.get(comment.getId()) }</span><span class="commentList__modifiedLastBy">, par ${ comment.getModifiedLastBy().getFirstname() })</span>
						</c:if>
					</p>
				</div>

				<!-- Comment content -->
				<div class="commentList__body">
					
					<!-- Comment text -->
					<div id="commentContent${ comment.getId() }" class="commentList__content">
						${ comment.getContent() }
					</div>
					
					<!-- Comment edit mode -->
					<div id="modifiedComment${ comment.getId() }" class="commentList__editMode" style="display: none;">
						<form action="editComment" method="POST">
							<input type="hidden" name="commentId" value="${ comment.getId() }" />
							<input type="hidden" name="siteId" value="${ site.id }" />
							<input type="hidden" name="userId" value="${ sessionScope.id }" />
							
							<input type="text" name="modifiedComment" value="${ comment.getContent() }" maxlength="255" />
							
							<button type="submit">
								<i class="fa fa-check"></i>
							</button>
						</form>
					</div>
				</div>

				
				<!-- Action buttons -->
				<c:if test="${ sessionScope.role == 'SUBSCRIBER' && comment.getUser().id == sessionScope.id || sessionScope.role == 'MEMBER' || sessionScope.role == 'ADMIN' }">
					<div class="commentList__footer">
						
						<!-- Edit button -->
						<button onclick="toggleEditCommentMode(${ comment.getId() })">
							<i class="fa fa-pencil-alt"></i>
						</button>
						
						<!-- Delete button -->
						<c:url var="deleteLink" value="/deleteComment">
							<c:param name="siteId" value="${ site.id }" />
							<c:param name="commentId" value="${ comment.getId() }" />
						</c:url>
						<a id="deleteIcon${ comment.getId() }" href="${ deleteLink }">
							<i class="fa fa-times" ></i>
						</a>
					</div>
				</c:if>
				
			</div>	<!-- End of comment info -->
		</div>	<!-- End of comment -->
	</c:forEach>
</div>