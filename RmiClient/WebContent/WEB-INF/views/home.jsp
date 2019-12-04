<%-- <%@ include file="/WEB-INF/views/includes/includes.jsp" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Home">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content pt-3">
	    	<nav aria-label="breadcrumb" class="">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="#">Home</a></li>
			  </ol>
			</nav>
			<div class="row">
				<c:forEach var="product" items="${products}" >
					<div class="col-md-4">
			          <div class="card mb-4 shadow-sm">
			            <img class="bd-placeholder-img card-img-top" src="assets/img/default.png" width="100%" height="225" focusable="false" role="img" aria-label="Placeholder: ${product.getTitle()}">
			            <div class="card-body">
			              <h5 class="card-title">${product.getTitle()}</h5>
			              <p class="card-text"><c:out value="${product.getDescription()}" /></p>
			              <div class="d-flex justify-content-between align-items-center">
			                <div class="btn-group">
			                  <c:choose>
			                  	<c:when test="${!product.getAvailable()}">
			                  		<a href="" class="btn btn-sm btn-primary">Emprunter</a>
			                  		<a href="" class="btn btn-sm btn-outline-secondary">Acheter</a>
			                  	</c:when>
				              	<c:otherwise>
			                  		<a href="" class="btn btn-sm btn-outline-primary">Reserver</a>
			                  	</c:otherwise>
				              </c:choose>
			                </div>
			                <div class="btn-group">
			                	<small class="btn btn-sm btn-dark">+D�tails</small>
			                </div>
			                
			              </div>
			            </div>
			          </div>
				     </div>
			     </c:forEach>
			</div>
	    </section>
	</jsp:attribute>
</t:template>

