
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="sidebar" class="active">
	<div class="sidebar-wrapper active">
		<div class="sidebar-header">
			<div class="d-flex justify-content-between">
				<div class="logo">
					<a href="${pageContext.request.contextPath}"><img
						src="${pageContext.request.contextPath}/resources/assets/images/logo/logo.png"
						alt="Logo" srcset=""></a>
				</div>
				<div class="toggler">
					<a href="#" class="sidebar-hide d-xl-none d-block"><i
						class="bi bi-x bi-middle"></i></a>
				</div>
			</div>
		</div>
		<div class="sidebar-menu">
			<ul class="menu">

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/Bannershallmark/'}"> active </c:if>">
					<a href="${pageContext.request.contextPath}/" class="sidebar-link">
						<i class="bi bi-grid"></i> <span>Dashboard</span>
				</a>
				</li>

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetail/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/readSpreadsheet/') >= 0}"> active </c:if> has-sub"><a
					href="#" class="sidebar-link"> <i class="bi bi-file-earmark"></i>
						<span>Invoices</span></a>
					<ul class="submenu invoice-submenu">
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/invoiceDetail/invoiceDetails">
								<i class="bi bi-file-earmark-check"></i> Verified
						</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/readSpreadsheet/getSpreadsheetPendingEdit">
								<i class="bi bi-file-earmark-break"></i> Unverified
						</a></li>
					</ul></li>

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/receive/') >= 0}"> active </c:if>">
					<a href="${pageContext.request.contextPath}/receive/receives"
					class="sidebar-link"> <i class="bi bi-box-arrow-in-down-right"></i><span>Receives</span></a>
				</li>

				<li
					class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/purchaseOrder/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/unverifiedPOZapier/') >= 0}"> active </c:if> has-sub">
					<a href="#" class="sidebar-link"><i class="bi bi-cart"></i><span>Purchase
							Orders</span></a>
					<ul class="submenu po-submenu">
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/purchaseOrder/purchaseOrders"><i
								class="bi bi-cart-check"></i> Verified </a></li>

						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/unverifiedPOZapier/unverifiedPOZapierDetails"><i
								class="bi bi-cart-dash"></i> Unverified</a></li>

					</ul>
				</li>

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/chartOfAccount/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/itemGroup/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/payby/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/store/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/vendor/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/role/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/accessPermission/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/users/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/paymentTerm/') >= 0}"> active </c:if> has-sub">
					<a href="#" class="sidebar-link"> <i class="bi bi-gear-fill"></i>
						<span>Settings</span></a>
					<ul class="submenu setting-submenu">
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/vendor/vendors"> <i
								class="bi bi-people"></i> Vendors
						</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/store/stores"><i
								class="bi bi-shop"></i> Sites</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/chartOfAccount/chartOfAccounts"><i
								class="bi bi-graph-up"></i> Chart Accounts</a></li>

						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/role/roleData"><i
								class="bi bi-bookmark-check"></i> User Roles</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/users/usersData"><i
								class="bi bi-person"></i> Users</a></li>
					</ul>
				</li>
				
				
				<!--  Tasks  -->
				
				
				<li class="sidebar-item has-sub">
                   <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Tasks</span></a>
                   <ul class="submenu tasks-submenu">
                     <li class="submenu-item">
                      <a href="${pageContext.request.contextPath}/Tasks/initiator"> <i class="bi bi-plus-circle-fill"></i> Initiate</a>
                    </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/Tasks/approverr"> <i class="bi bi-check"></i> Approve</a>
                    </li>
                    <li class="submenu-item">
                        <a href="${pageContext.request.contextPath}/Tasks/regionaltasks"> <i class="bi bi-map"></i> Regional</a>
                    </li>
                    </ul>
                </li>
				

				<!-- Receives -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/storeInCharge/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/storeInCharge/receivesMapping"
					class="sidebar-link"> <i class="bi bi-receipt"></i><span>Receiving</span></a>
				</li>
				
				<!-- PODeatils -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/poItemDetail/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/poItemDetail/poItemDetails"
					class="sidebar-link"> <i class="bi bi-info-circle"></i><span>PO Details</span></a>
				</li>
				
				
				<!-- Support --> 
				  <li
					class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/support/') >= 0}"> active </c:if>" style="position: absolute; bottom: 0; width: 80%;">
					<a
					href="${pageContext.request.contextPath}/support/techSupport"
					class="sidebar-link"> <i class="bi bi-person-circle"></i><span>Support</span></a>
				</li>  

			</ul>
		</div>
		<button class="sidebar-toggler btn x">
			<i data-feather="x"></i>
		</button>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				var url = window.location.href;
				if (url.includes('storeInCharge')) {
					$('.ext-submenu').show();
					$('.ext-submenu').addClass("active");
					$(".ext-submenu").prev().addClass('d-active');
				} else if (url.includes('vendor') || url.includes('store')
						|| url.includes('chartOfAccount')
						|| url.includes('role') || url.includes('users')
						|| url.includes('paymentTerm')) {
					$('.setting-submenu').show();
					$('.setting-submenu').addClass("active");
					$(".setting-submenu").prev().addClass('d-active');
				} else if (url.includes('invoiceDetail')
						|| url.includes('readSpreadsheet')) {
					$('.invoice-submenu').show();
					$('.invoice-submenu').addClass("active");
					$(".invoice-submenu").prev().addClass('d-active');
				} else if (url.includes('purchaseOrder')
						|| url.includes('unverifiedPOZapier')) {
					$('.po-submenu').show();
					$('.po-submenu').addClass("active");
					$(".po-submenu").prev().addClass('d-active');
				} else if (url.includes('storeInCharge')) {
					$('.ext-submenu').show();
					$('.ext-submenu').addClass("active");
					$(".ext-submenu").prev().addClass('d-active');
				} else if (url.includes('poItemDetail')) {
					$('.ext-submenu').show();
					$('.ext-submenu').addClass("active");
					$(".ext-submenu").prev().addClass('d-active');
				}
				
				else if(url.includes('Tasks') 
			          || url.includes('regionaltasks')) {
			          $('.tasks-submenu').show();
			          $('.tasks-submenu').addClass("active");
			          $(".tasks-submenu").prev().addClass('d-active');
			        }
			    else if(url.includes('Tasks') 
			          || url.includes('districttasks')) {
			          $('.taskstatus-submenu').show();
			          $('.taskstatus-submenu').addClass("active");
			          $(".taskstatus-submenu").prev().addClass('d-active');
			        }
				
			});
</script>