<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Banners Hallmark - Add Users</title>
</head>
<body>
	<div id="main" class='layout-navbar'>
		<div id="main-content">



			<div class="page-heading">

				<div class="page-title mb-5">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>Add User</h3>
							<!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
						</div>
						<div class="col-12 col-md-6 order-md-2 order-first">
							<nav aria-label="breadcrumb"
								class="breadcrumb-header float-start float-lg-end">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="${pageContext.request.contextPath}/users/usersData">
											Users</a></li>
									<li class="breadcrumb-item active" aria-current="page">Add
										User</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>

				<section class="section blnk-db">
					<form:form class="form-horizontals" method="post" id="user_form"
						onsubmit="saveForm()" name="user_form" action="addNewUsers"
						modelAttribute="users">
						<%@ include file="../common/error-and-success-message.jsp"%>

						<div class="card tp-inpt">
							<div class="card-body shadow">

								<div class="row" id="row1">
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="firstname">First Name</label>
											<form:input type="text" maxlength="50" name="firstname"
												id="firstname" path="firstname" class="form-control"
												placeholder="First Name " value="" required="true" />
										</div>
									</div>
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="lastname">Last Name</label>
											<form:input type="text" maxlength="50" name="lastname"
												id="lastname" path="lastname" class="form-control"
												placeholder="Last Name" value="" required="true" />
										</div>
									</div>

									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="email">Email</label>
											<form:input type="email" name="email" id="email" path="email"
												class="form-control" placeholder="email" value=""
												required="true" />
										</div>
									</div>
								</div>

								<div class="row" id="row4">
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="addressLine">Address</label>
											<form:input type="text" maxlength="250" name="addressLine"
												id="addressLine" path="addressLine" class="form-control"
												placeholder="Address" value="" />
										</div>
									</div>
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="role">Role</label>
											<form:select type="text" required="true" name="role"
												id="role" path="role.id" class="form-select" value="">
												<form:option value="">--Select Role--</form:option>

												<c:forEach items="${role}" var="role">
													<form:option value="${role.id}">${role.name}</form:option>
												</c:forEach>


											</form:select>
										</div>
									</div>


								</div>

								<div class="row" id="row4">
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="username">Username</label>
											<form:input type="text" maxlength="10" name="zipCode"
												id="username" path="username" class="form-control"
												placeholder="User Name" value="" required="true" />
										</div>
									</div>
									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="createpassword">Password</label>
											<form:input type="password" maxlength="20"
												name="createpassword" id="createpassword" path="password"
												class="form-control" placeholder="Password " value=""
												required="true" />
										</div>
									</div>

									<div class="col-md-4 col-12">
										<div class="form-group">
											<label for="confirmpassword">Confirm Password</label>
											<form:input type="password" maxlength="20"
												name="confirmpassword" id="confirmpassword" path=""
												class="form-control" placeholder=" Confirm Password "
												value="" required="true" />
											<p class="text-danger" id="show"></p>

										</div>
									</div>

								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-12 d-flex justify-content-center">
								<button type="submit" class=" c-btn btn btn-primary me-3 mb-1"
									id="saveData">Save</button>
								<a href="${pageContext.request.contextPath}/users/usersData"
									class="c-btn btn btn-danger  mb-1">Cancel</a>

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
		function checkPasswordMatch() {
			var newpassword = $("#createpassword").val();
			var confirmPassword = $("#confirmpassword").val();
			if (newpassword != confirmPassword)
				$("#show").text("Passwords does not match!");
			else
				$("#show").text("Passwords match.");
		}
		$(document).ready(function() {
			$("#confirmpassword").keyup(checkPasswordMatch);
		});
	</script>

	<script>
		function saveForm() {
			document.getElementById("saveData").disabled = true;
		}
	</script>
</body>
</html>