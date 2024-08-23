<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Banners Hallmark | Sites</title>
<style type="text/css">
#table-p_wrapper .action-buttons {
	display: flex;
	align-items: center;
}
</style>
</head>
<body>
	<div id="main" class='layout-navbar'>
		<div id="main-content">

			<div class="page-heading">
				<div class="page-title mb-5">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>Sites</h3>
							<!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
						</div>
						<div class="col-12 col-md-6 order-md-2 order-first">
							<nav aria-label="breadcrumb"
								class="breadcrumb-header float-start float-lg-end">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="${pageContext.request.contextPath}">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="page">Sites
									</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				<section class="section blnk-db ">
					<%@ include file="../common/error-and-success-message.jsp"%>
					<div class="card">
						<div class="card-body">
							<div class="c-dflx">

								<div class="upld-bill-dlt">

									<%-- <form class="form" method="post" enctype="multipart/form-data"
										action="${pageContext.request.contextPath}/store/uploadInBulk">
										<input type="file" id="real-file" hidden="hidden" name="file"
											accept=".xls, .xlsx" />
										<button type="button" class="btn btn-info" id="custom-button">Choose
											a file</button>
										<span id="custom-text">No file chosen, yet.</span> <input
											type="submit" class="btn btn-warning upld-btn"
											value="Upload file" disabled>
									</form>


									<button id="syncFromBill"
										style="margin-left: .5rem !important;" type="button"
										style="margin-left: 300px;" class="btn btn-danger">Delete
										All</button> --%>

								</div>
								<a href="${pageContext.request.contextPath}/store/addStore"
									class="btn btn-primary "> <i class="bi bi-bag-plus "></i>
									New Site
								</a>

							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-body">
							<div class="c-dflx">

								<fieldset class="form-group me-2">
									<select class="form-select" name="formal" id="invoiceType"
										onchange="javascript:handleSelect(this)" required>
										<option
											value="${pageContext.request.contextPath}/store/stores">All
											Sites</option>

										<option
											value="${pageContext.request.contextPath}/store/storesIsActive/false"
											<c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('false') >= 0}"> selected = "selected" </c:if>>Deleted</option>

										<option
											value="${pageContext.request.contextPath}/store/storesIsActive/true"
											<c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('true') >= 0}"> selected = "selected" </c:if>>Active</option>
									</select>
								</fieldset>

							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-body  ">
							<div class="inv-data-tble">
								<table class="table table-striped " id="table-p">
									<thead>
										<tr>
											<th>Site</th>
											<th>Site Name</th>
											<th>State</th>
											<th>Manager Name</th>
											<th>Email</th>
											<th>Size</th>
											<!--    <th>Created Date</th> -->
											<th>Deleted?</th>
											<th>Actions</th>

										</tr>
									</thead>
									<tbody>


										<c:forEach var="store" items="${stores}">

											<tr>

												<td>${store.store}<c:if
														test="${not store.isSynchronized()}">
														<span style="color: red; font-size: 25px;">*</span>
													</c:if>
												</td>
												<td>${store.storeName}</td>
												<td>${store.state}</td>
												<%-- <td>${store.userId}</td> --%>
												<td>${store.managerFirstName}&nbsp;${store.managerLastName}</td>
												<td>${store.storeEmail}</td>

												<td>${store.size}</td>
												<%-- <td>${store.createdDateTime}</td> --%>
												<td><c:choose>
														<c:when test="${ not store.isActive}">
												   	Deleted     
												    </c:when>
														<c:otherwise>
												    Active
												    </c:otherwise>
													</c:choose></td>

												<td class="td-actions">
													<%-- <div class="action-buttons">
														<a class="" title="Edit"
															href="${pageContext.request.contextPath}/store/getStore/${store.id}">
															<span class="badge bg-success"><i
																class="bi bi-pencil"></i></span>
														</a>
													</div> --%>
												<c:choose>
														<c:when test="${store.isActive}">

															<div class="action-buttons">
																<a class="" title="Edit"
																	href="${pageContext.request.contextPath}/store/getStore/${store.id}">
																	<span class="badge bg-success"><i
																		class="bi bi-pencil"></i></span>
																</a> <a class="red"
																	href="${pageContext.request.contextPath}/store/deleteStore/${store.id}"
																	onclick="return confirm('Are you sure to delete?')"
																	id="remove"> <span class="badge bg-danger"><i
																		class="bi bi-trash-fill"></i></span></a>
																<c:if test="${not store.isSynchronized()}">
																	<a class=""
																		href="${pageContext.request.contextPath}/store/readStore/${store.id}"
																		onclick="return confirm('Are you sure to Update?')"
																		id="remove"> <span class="badge btn-info">
																			<!-- 													<i class="bi bi-bootstrap-reboot"></i></span></a> -->
																			<!-- 													<i class="bi bi-arrow-counterclockwise"></i> -->
																			<i class="bi bi-arrow-repeat"></i>
																	</span>
																	</a>
																</c:if>
															</div>

														</c:when>
														<c:otherwise>
															<div class="action-buttons">
																<a class="red"
																	href="${pageContext.request.contextPath}/store/undeleteStore/${store.id}"
																	onclick="return confirm('Are you sure to Undelete?')"
																	id="remove"> <span class="badge btn-warning">
																		<!-- 															<i class="bi bi-trash-fill"></i></span></a> -->
																		<!-- 															<i class="bi bi-lock-fill"></i> -->
																		<img class="icon-image"
																		src="${pageContext.request.contextPath}/resources/assets/images/un-delete.png">
																</span>
																</a>
															</div>
														</c:otherwise>
													</c:choose>
												</td>


											</tr>

										</c:forEach>




									</tbody>
								</table>
							</div>
						</div>

					</div>
				</section>
			</div>

			<footer>
				<div class="footer clearfix mb-0 text-muted c-ftr">
					<div class="float-start">
						<p>2021 &copy; Banners Hallmark</p>
					</div>
					<div class="float-end">
						<p>
							Developed by <span class="text-danger"><i
								class="bi bi-heart"></i></span> <a href="#">Suntek IT Solutions </a>
						</p>
					</div>
				</div>
			</footer>
		</div>
	</div>




	<script
		src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

	<script>
		$('#syncFromBill')
				.on(
						'click',
						function(e) {
							if (confirm('Are you sure to delete all Sites ?')) {
								document.getElementById("syncFromBill").disabled = true;
								window.location = "${pageContext.request.contextPath}/store/deleteAll";
							}
						});
	</script>

	<script>
		const realFileBtn = document.getElementById("real-file");
		const customBtn = document.getElementById("custom-button");
		const customTxt = document.getElementById("custom-text");

		customBtn.addEventListener("click", function() {
			realFileBtn.click();
		});

		realFileBtn.addEventListener("change", function() {
			if (realFileBtn.value) {
				customTxt.innerHTML = realFileBtn.value
						.match(/[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];

				$('.upld-btn').removeAttr("disabled");

			} else {
				customTxt.innerHTML = "No file chosen, yet.";
				$('.upld-btn').Attr("disabled");
			}
		});

		function handleSelect(elm) {
			window.location = elm.value;
		}
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
</body>
</html>