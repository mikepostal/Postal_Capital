<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Banners Hallmark - All Users</title>        
    </head>
    
	
<body>
	 <div id="main" class='layout-navbar'>
           <div id="main-content">

                <div class="page-heading">
                    <div class="page-title mb-5">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Users</h3>
                                <!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Dashboard</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Users
                                        </li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <section class="section blnk-db ">
                        <%@ include file="../common/error-and-success-message.jsp" %> 
                        <div class="card">
                            <div class="card-body">
                                <div class="ig-dflx ">

                                        <a href="${pageContext.request.contextPath}/users/addUsers" class="btn btn-primary " >  <i class="bi bi-credit-card-2-back "></i> New User</a>
                                   
                                </div>
                            </div>  
                        </div>

                           <div class="card">
                            <div class="card-body  ">
                            <div class="inv-data-tble">
                                <table class="table table-striped  " id="table-p"  >
                                    <thead>
                                        <tr>
                                            
                                           <th>Name</th>		
											<!-- <th>Last name</th> -->
											<th>Email</th>
											<th>Address</th>
											<th>Country</th>
											<th>City</th>
											<th>ZIP</th>
											<th>Phone</th>
											<th>Role</th>
											<!-- <th>Date Changed</th> -->
										    <th width="10%">Action</th>		
                                        </tr>
                                    </thead>
                                    <tbody>
	                                    <c:forEach var="users" items="${users}">
											<tr>
												<td>${users.firstname} ${users.lastname}</td>
												<td>${users.email}</td>
												<%-- <td>${users.dateChanged}</td> --%>
												<td>${users.addressLine1},${users.addressLine2},${users.addressLine3}</td>
												<td>${users.country}</td>
												<td>${users.city}</td>
												<td>${users.postalCode}</td>
												<td>${users.phoneNumber}</td>
												<td>${users.role.name}</td>
												
											    <td class="td-actions">
					                                <div class="action-buttons">
					                                
					                                   <a class="" title="Edit" href="${pageContext.request.contextPath}/users/getUsers?id=${users.id}">
					                                   	<span class="badge bg-success"><i class="bi bi-pencil"></i></span></a>
					                                	
					                                	<a class="red" href="${pageContext.request.contextPath}/users/deleteUsers/${users.id}" onclick="return confirm('Are you sure to delete?')" id="remove">
					                                   		<span class="badge bg-danger"><i class="bi bi-trash-fill"></i></span></a>
					                                 </div>			                                
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
                            <p>Developed by <span class="text-danger"><i class="bi bi-heart"></i></span>  <a
                                    href="#">Suntek IT Solutions </a></p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>


   	<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

</body>
</html>