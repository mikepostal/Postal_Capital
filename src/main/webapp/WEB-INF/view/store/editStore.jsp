<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Banners Hallmark - Edit Site</title>
	</head>
	<body>
		<div id="main" class='layout-navbar'>
            <div id="main-content">



                <div class="page-heading">

                    <div class="page-title mb-5">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Edit Site</h3>
                                <!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/store/stores">Site</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Edit Site
                                        </li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <section class="section blnk-db">
                     <form:form class="form-horizontals" method="post" id="user_form"
						name="user_form" onsubmit="saveForm()" action="${pageContext.request.contextPath}/store/updateStore" modelAttribute="store">
						<form:input type="hidden" path="id"/>
						<form:input type="hidden" path="storeUnqId"/>
						<form:input type="hidden" path="accountClassUnqId"/>
					        <%@ include file="../common/error-and-success-message.jsp" %>  

                      
                            <div class="card tp-inpt">
                                <div class="card-body">

                              <%--       <div class="row">
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="user-id">User Id</label>
                                                <form:input type="number" id="userId" class="form-control" path="userId" maxlength="9"
                                                    placeholder="User Id" name="userId"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="is-active">Is Active</label>
                                                <fieldset class="">
                                                   
                                                    <form:select type="text" name="isActive" id="isActive"
															path="isActive" class="form-select"
															placeholder="Is Active" value="" >
															<form:option value="true">True</form:option>
															<form:option value="false">False</form:option>
													</form:select>
                                                </fieldset>

                                            </div>
                                        </div>
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="role">Role</label>
                                                <fieldset class="">
                                                   <form:select type="text" name="role" id="role"
																	path="role" class="form-select"
																	placeholder="Role" value=""  >
															<form:option value="">Select Role</form:option>
															<form:option value="Manager">Manager</form:option>
													</form:select>
                                                </fieldset>
    
                                            </div>
                                            </div>
                                    </div> --%>
                                    
                                    
                                    <div class="row">
                                    
                                    
                                          <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="store-name">Site Name</label>
                                                <form:input type="text"  maxlength="50" name="storeName" id="storeName"
																	path="storeName" class="form-control"
																	placeholder="Site Name" value="" required="true" readonly="true"  />
                                            </div>
                                        </div>
                                    
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">  
                                                <label for="store"> Site </label>                                             
                                                <form:input type="number" min="1" max="1000000" pattern="([0-9]|[0-9]|[0-9])" name="store" id="store" onkeypress="return isNumberKey(event)"
																	path="store" class="form-control"
																	placeholder="Site" value="" required="true"  readonly="true" />
                                            </div>
                                        </div>
                                        
                                          <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="is-active">Is Active</label>
                                                <fieldset class="">
                                                   
                                                    <form:select type="text" name="isActive" id="isActive"
															path="isActive" class="form-select"
															placeholder="Is Active" value="" >
															<form:option value="true">True</form:option>
															<form:option value="false">False</form:option>
													</form:select>
                                                </fieldset>

                                            </div>
                                        </div>
                                        
                                                                   
                                    </div>
                                    

                                    <div class="row">
                                        
                                       <div class="col-md-4 col-12">
                                            <div class="form-group">  
                                                <label for="site"> Store </label>                                             
                                                <form:input type="number" min="1"  max="1000000" name="site" id="site" onkeypress="return isNumberKey(event)"
																	path="oldStore" class="form-control"
																	placeholder="Store" value="" />
                                            </div>
                                        </div>  
                                        
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">  
                                                <label for="size"> Size </label>                                             
                                               <form:input type="number" min="1"  max="100000" name="size" id="size" onkeypress="return isNumberKey(event)"
																	path="size" class="form-control"
																	placeholder="Size" value=""  />
                                            </div>
                                        </div>
                                    
                                       <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="manager-first-name">Manager First Name</label>
                                                <form:input type="text" maxlength="50" name="managerFirstName" id="managerFirstName"
															path="managerFirstName" class="form-control"
															placeholder="Manager First Name" value="" />
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="manager-last-name">Manager last Name</label>
                                               <form:input type="text"  maxlength="50" name="managerLastName" id="managerLastName"
															path="managerLastName" class="form-control"
															placeholder="Manager Last Name" value=""  />
                                            </div>
                                        </div>

                                        <div class="col-md-4 col-12">
                                            <div class="form-group">  
                                                <label for="mngr-id"> Manager ID </label>                                             
                                                <form:input type="text" name="mgr_id" id="mgr_id"
																	path="mgr_id" class="form-control"
																	placeholder="Manager ID" value=""  />
                                            </div>
                                        </div>

                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="store-email">Site Email</label>
                                                <form:input type="email" maxlength="100" name="storeEmail" id="storeEmail"
																	path="storeEmail" class="form-control"
																	placeholder="Site Email" value=""  />
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="description">Description</label>
                                                <form:input type="text"   maxlength="250" name="description" id="description"
																	path="description" class="form-control"
																	placeholder="Description" value=""  />
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">  
                                                <label for="hmk-account"> Hallmark Account </label>                                             
                                               <form:input type="number"  name="hmkAcct" id="hmkAcct" onkeypress="return isNumberKey(event)"
																	path="hmkAcct" class="form-control"
																	placeholder="Hallmark  Account" value=""  />
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="dm">DM</label>
                                               <form:input type="text" name="dm" id="dm"
																	path="dm" class="form-control"
																	placeholder="DM" value=""  />
                                            </div>
                                        </div>

                                   


                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="dm-email">DM Email</label>
                                               <form:input type="email" maxlength="100" name="dmEmail" id="dmEmail"
																	path="dmEmail" class="form-control"
																	placeholder="DM Email" value=""  />
                                            </div>
                                        </div>

                                       
                                        <div class="col-md-4 col-12">
                                            <div class="form-group">
                                                <label for="state">State</label>
                                                <form:input type="text"   maxlength="50" name="state" id="state"
																	path="state" class="form-control"
																	placeholder="State" value=""  />
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Regional Manager Name</label>
												<form:input type="text" maxlength="100" name="rm" id="rm"
													path="rm" class="form-control"
													placeholder="Regional Manager Name" value="" required="true" />
											</div>
										</div>
	
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Regional Manager Email</label>
												<form:input type="email" maxlength="100" name="rmEmail"
													id="rmEmail" path="rmEmail" class="form-control"
													placeholder="Regional Manager Email" value=""
													required="true" />
											</div>
										</div>
										
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Center Name</label>
												<form:input type="text" maxlength="100" name="centerName"
													id="centerName" path="centerName" class="form-control"
													placeholder="Center Name" value="" />
											</div>
										</div>
										
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Address</label>
												<form:input type="text" maxlength="255" name="address"
													id="address" path="address" class="form-control"
													placeholder="Address" value="" />
											</div>
										</div>
										
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Phone Number</label>
												<form:input type="text" maxlength="50" name="phoneNumber"
													id="phoneNumber" path="phoneNumber" class="form-control"
													placeholder="Phone Number" value="" />
											</div>
										</div>
										
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Assistant Manager 1</label>
												<form:input type="text" maxlength="100" name="assistantManagerOne"
													id="assistantManagerOne" path="assistantManagerOne" class="form-control"
													placeholder="Assistant Manager 1" value="" />
											</div>
										</div>			
							
										<div class="col-md-4 col-12">
											<div class="form-group">
												<label for="name">Assistant Manager 2</label>
												<form:input type="text" maxlength="100" name="assistantManagerTwo"
													id="assistantManagerTwo" path="assistantManagerTwo" class="form-control"
													placeholder="Assistant Manager 2" value="" />
											</div>
										</div>

                                    </div>
                                    
                                </div>
                            </div>                           

                            <div class="row">
                                <div class="col-12 d-flex justify-content-center">
                                    <button type="submit" class=" c-btn btn btn-primary me-3 mb-1" id="updateForm">Update</button>
                                    <a href="${pageContext.request.contextPath}/store/stores" class="c-btn btn btn-danger  mb-1">Cancel</a>
                              
                                
                                </div>
                            </div>
                        </form:form>

                    </section>

                </div>



                <footer>
                    <div class="footer clearfix mb-0 text-muted c-ftr">
                        <div class="float-start">
                            <p>2021 &copy; Banners Hallmark</p>
                        </div>
                        <div class="float-end">
                            <p>Developed by <span class="text-danger"><i class="bi bi-heart"></i></span> <a
                                    href="#">Suntek
                                    IT Solutions </a></p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
		
	    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
	
<script>
	 function saveForm() {
			document.getElementById("updateForm").disabled = true;       
	    }
</script>
		<script>
		    var filterActive;
		
		    function filterCategory(category) {
		        if (filterActive != category) {
		
		            // reset results list
		            $('.filter-cat-results .f-cat').removeClass('active-inv-v');
		
		            // elements to be filtered
		            $('.filter-cat-results .f-cat')
		                .filter('[data-cat="' + category + '"]')
		                .addClass('active-inv-v');
		
		            // reset active filter
		            filterActive = category;
		        }
		    }
		
		    // $('.f-cat').addClass('active');
		
		    $('.filtering select').change(function () {
		        if ($(this).val() == 'cat-all') {
		            $('.filter-cat-results .f-cat').addClass('active-inv-v');
		            filterActive = 'cat-all';
		        } else {
		            filterCategory($(this).val());
		        }
		    });
		    
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