<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>BannersHallmark | Edit Store</title>
</head>
<body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Edit Store</h1>
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
						name="user_form" action="${pageContext.request.contextPath}/store/updateStore" modelAttribute="store">
						<form:input type="hidden" path="id"/>
						<form:input type="hidden" path="storeUnqId"/>
						<div class="container">
							<div class="row centered-form">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<div class="panel panel-default">
										<!-- <div class="panel-heading">
                                        <h3 class="panel-title">Edit Admin Role </h3>
                                    </div> -->
										<div class="panel-body">
											<div class="row">
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="userId">User Id</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text"  name="userId" id="userId"
															path="userId" class="form-control"
															placeholder="User Id" value="" />
													</div>
												</div>
												</div>
												
												
                                                <div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="isActive">Is Active</label>
													</div>
												 
													<div class="form-group">
														<form:select type="text" name="isActive" id="isActive"
															path="isActive" class="form-control"
															placeholder="Is Active" value="" >
															<form:option value="1">True</form:option>
															<form:option value="0">False</form:option>
														</form:select>
													</div>
												</div>									
											</div>
											</div>

											<!-- Start -->

											<div class="row">
											
											<div class="col-4">
												<div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="managerFirstName">Manager First Name</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" maxlength="50" name="managerFirstName" id="managerFirstName"
															path="managerFirstName" class="form-control"
															placeholder="Manager First Name" value="" />
													</div>
												</div>
											</div>
											
											    <div class="col-4">
												<div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="managerLastName">Manager Last Name</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text"  maxlength="50" name="managerLastName" id="managerLastName"
															path="managerLastName" class="form-control"
															placeholder="Manager Last Name" value=""  />
													</div>
												</div>
												</div>
												
												<div class="col-4">	
												<div class="col-xs-12 col-sm-12 col-md-4">
													<div class="form-group">
														<label for="storeEmail">Store Email</label>
													</div>
												 
													<div class="form-group">
														<form:input type="email" maxlength="100" name="storeEmail" id="storeEmail"
																	path="storeEmail" class="form-control"
																	placeholder="Store Email" value=""  />
													</div>
												</div>										
											</div>
											</div>

											
											
											<!-- start -->
											<div class="row">
											
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="role">Role</label>
													</div>
												 
													<div class="form-group">
														<form:select type="text" name="role" id="role"
																	path="role" class="form-control"
																	placeholder="Role" value=""  >
															<form:option value=""></form:option>
															<form:option value="Manager">Manager</form:option>
														</form:select>
													</div>
												</div>	
												</div>
																																		
											</div>
											
											<!-- start -->
											<div class="row">
											<div class="col-6">												
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="store">Store</label>
													</div>
												

													<div class="form-group">
														<form:input type="number" min="1" max="1000000" pattern="([0-9]|[0-9]|[0-9])" name="store" id="store" onkeypress="return isNumberKey(event)"
																	path="store" class="form-control"
																	placeholder="Store" value="" required="true" readonly="true" />
													</div>
												</div>
												</div>
													
												<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="description">Description</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" maxlength="250" name="description" id="description"
																	path="description" class="form-control"
																	placeholder="Description" value=""  />
													</div>
												</div>																							
											</div>
											</div>
											
											<!-- start -->
											<div class="row">
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="hmkAcct">HMK Account</label>
													</div>
												 
													<div class="form-group">
														<form:input type="number" name="hmkAcct" id="hmkAcct" onkeypress="return isNumberKey(event)"
																	path="hmkAcct" class="form-control"
																	placeholder="HMK Account" value=""  />
													</div>
												</div>
												</div>	
												
												<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="dm">DM</label>
													</div>
											 
													<div class="form-group">
														<form:input type="text" name="dm" id="dm"
																	path="dm" class="form-control"
																	placeholder="DM" value=""  />
													</div>
												</div>																							
											</div>
											</div>
											
											<!-- start -->
											<div class="row">
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="mgr_id">MNGR Id</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" name="mgr_id" id="mgr_id"
																	path="mgr_id" class="form-control"
																	placeholder="MNGR Id" value=""  />
													</div>
												</div>
												</div>
													
												<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="state">State</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text"  maxlength="50" name="state" id="state"
																	path="state" class="form-control"
																	placeholder="State" value=""  />
													</div>
												</div>																							
											</div>
											</div>
											
											<!-- start -->
											<div class="row">
											
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="site">Site</label>
													</div>
												 
													<div class="form-group">
														<form:input type="number" min="1"  max="1000000" name="site" id="site"
																	path="site" class="form-control"
																	placeholder="Site" value="" required="true"  readonly="true"  />
													</div>
												</div>	
												</div>
												
												<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="storeName">Store Name</label>
													</div>
												 
													<div class="form-group">
														<form:input type="text" maxlength="100" name="storeName" id="storeName"
																	path="storeName" class="form-control"
																	placeholder="Store Name" value="" required="true" readonly="true"  />
													</div>
												</div>																							
											</div>
											</div>
											
											<!-- start -->
											<div class="row">
											<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="size">Size</label>
													</div>
												 
													<div class="form-group">
														<form:input type="number" name="size" id="size" onkeypress="return isNumberKey(event)"
																	path="size" class="form-control"
																	placeholder="Size" value=""  />
													</div>
												</div>
												</div>
													
												<div class="col-6">
												<div class="col-xs-12 col-sm-12 col-md-6">
													<div class="form-group">
														<label for="dmEmail">DM Email</label>
													</div>
												 
													<div class="form-group">
														<form:input type="email" name="dmEmail" id="dmEmail"
																	path="dmEmail" class="form-control"
																	placeholder="DM Email" value=""  />
													</div>
												</div>																							
											</div>
											</div>
											
										</div>
										<div class="box-footer">
											<a href="${pageContext.request.contextPath}/store/stores" class="btn btn-warning">Cancel /
												Back</a>
											<button type="submit" id="saveForm" class="btn btn-info pull-right">Update</button>
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
<script>
	function isNumberKey(evt)
	{
	   var charCode = (evt.which) ? evt.which : evt.keyCode;
	   if (charCode < 48 || charCode > 57)
	      return false;	
	   return true;
	};
</script>
</body>
</html>