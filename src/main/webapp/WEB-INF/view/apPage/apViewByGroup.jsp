<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Banners Hallmark - Access Permissions To Features</title>        
    </head>
    <body>
    	<div id="main" class='layout-navbar'>
        	<div id="main-content">
                <div class="page-heading">
                    <div class="page-title mb-5">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Access Permissions To Features</h3>
                                <!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/role/roleData">User Roles</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Access Permissions To Features
                                        </li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <section class="section blnk-db ">
                        <div class="card">
                         <form id="submitData" method="post" >
                            <div class="card-body ">
								<div class="inv-data-tble">
									<table class="table" id="table-p-chk-bx-access">
										<thead>
											<tr>
												<th>
													<div class="form-check">
														<div class="checkbox">
															<input type="checkbox" name="checkAll" class="form-check-input checkAll">
														</div>
													</div>
												</th>
												<th>Features</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="accessPermission" items="${accessPermissionGroup}">
												<tr>
													<td>
														<div class="form-check">
															<div class="checkbox">
																<input type="checkbox" name="urlData" 
																	<c:if test="${accessId.contains(accessPermission.accessPermissionsByGroupID)}">checked</c:if>
																	class="example-select-single  form-check-input"
																	value="${accessPermission.accessPermissionsByGroupID}">
															</div>
														</div>
													</td>
													<td>${accessPermission.accessPermissionsByGroupName} </td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
                        </form>
                        </div>
                        <div class="row">
                            <div class="col-12 d-flex justify-content-center mb-10">
                                  <button type="button"  id="saveId"class=" c-btn btn btn-primary me-3 mb-1">Save</button>
                                <a href="${pageContext.request.contextPath}/role/roleData" class="c-btn btn btn-danger  mb-1">Cancel</a>
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
                            <p>Developed by <span class="text-danger"><i class="bi bi-heart"></i></span>  <a href="#">Suntek IT Solutions </a></p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
	   	<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
	    <script>
			var table = $('#table-p-chk-bx-access').DataTable({
				"bPaginate": false,
				"bLengthChange": false,
				"scrollX": true,
				columnDefs: [{
					orderable: false,
					targets: 0,
				}],
				'order': [1, 'asc'],
				oLanguage: {
					oPaginate: {
						sNext: '<span class="pagination-default">&#x276f;</span>',
						sPrevious: '<span class="pagination-default">&#x276e;</span>'
					}
				}
			});
			$("#saveId").click( function() {
				document.getElementById("saveId").disabled = true;     
				var urlData = [];
				$('[name=urlData]:checked').each(function() {
					urlData.push($(this).val());
				});
				if (urlData.length > 0) {
					$('#submitData').attr('action',
							"${pageContext.request.contextPath}/role/deleteUrl/${roleId}/accessId/"+ urlData + " ");
					$("#submitData").submit();
				} else {
					$('#submitData').attr('action',
							"${pageContext.request.contextPath}/role/deleteUrlData/${roleId} ");
					$("#submitData").submit();
				}
			});
		</script>
	</body>
</html>
