
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Blank Page">
	<jsp:attribute name="content">
		<nav aria-label="breadcrumb" class="">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="#">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Library</li>
		  </ol>
		</nav>

	    <!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-md-4">
		          <div class="card mb-4 shadow-sm">
		            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail">
		            <title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		            <div class="card-body">
		              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <button type="button" class="btn btn-sm btn-outline-secondary">Emprunter</button>
		                  <button type="button" class="btn btn-sm btn-outline-secondary">Acheter</button>
		                </div>
		                <small class="text-muted">9 mins</small>
		              </div>
		            </div>
		          </div>
			     </div>
			</div>
	    </section>
	</jsp:attribute>
</t:template>

