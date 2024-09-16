<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>BannersHallmark | Add AccessPermission</title>
</head>
<body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Add Access Permission</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="box box-info">
				<div class="overlay" id="loading_overlay" style="display: none;">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<div class="container">
					<!-- Horizontal Form -->
					<form:form class="form-horizontals" method="post" id="user_form"
						name="user_form" action="addNewAccessPermission" modelAttribute="accessPermission">
						<div class="container">
							<div class="row centered-form">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<div class="panel panel-default">
										<!-- <div class="panel-heading">
                                        <h3 class="panel-title">Edit Admin Role </h3>
                                    </div> -->
										<div class="panel-body">
											<div class="row">
											<div class="col-4">
											
											
											<%-- <div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="id">Id</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" name="id" id="id"
															path="id" class="form-control"
															placeholder="id" value="" required="true"/>
													</div>
												</div>	 --%>
												<div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="urlPath">Access Permission URL Path</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" name="urlPath" id="urlPath"
															path="urlPath" class="form-control"
															placeholder="url Path" value="" required="true"/>
													</div>
												</div>	
												
												<div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="urlPath">AccessPermission Detailed Desc.</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" name="accessPermissionDetailedDesc" id="accessPermissionDetailedDesc"
															path="accessPermissionDetailedDesc" class="form-control"
															placeholder="AccessPermission Detailed Desc" value="" required="true"/>
													</div>
												</div>																						
											</div>
			                                </div>
										</div>
										<div class="box-footer">
											<a href="${pageContext.request.contextPath}/permissionPage/apData" class="btn btn-warning">Cancel /
												Back</a>
											<button type="submit" id="saveForm" class="btn btn-info pull-right">Save</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
					</form:form>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>

</body>

 


</html>