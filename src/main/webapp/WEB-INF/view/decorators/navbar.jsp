
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
				<!-- Admin Navbar -->
                <!--  
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/Bannershallmark/'}"> active </c:if>">
					<a href="${pageContext.request.contextPath}/" class="sidebar-link">
						<i class="bi bi-grid"></i> <span>Dashboard</span>
				</a>
				</li>-->
				
				 
				 
				 
				 
				
				     <!--  Operations  -->
				     
				 <li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
				     <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Operations</span></a>
				     <ul class="submenu tasks-submenu">
				       <li class="submenu-item" >
                          <a href="${pageContext.request.contextPath}/ledger/ledgerCallerAdmin"> <i class="bi bi-check"></i>Ledger</a>
                      </li>
                      <li class="submenu-item" >
                          <a href="${pageContext.request.contextPath}/ledger/ledgerCallerAdminUpdated"> <i class="bi bi-check"></i>Payroll Hours Ledger</a>
                      </li>
                      <li class="submenu-item" >
                          <a href="${pageContext.request.contextPath}/admin/payrollSummary/getAll"> <i class="bi bi-check"></i>Payroll Summary</a>
                      </li>
                      <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/ledger/salesPlans"> <i class="bi bi-check"></i> Plans</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/ledger/dates/2023/2022"> <i class="bi bi-check"></i> Mapping</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/ledger/summaryAdmin/2024/3"> <i class="bi bi-check"></i> Summary</a>
                     </li>
                     <!--  <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/connectAndRelate/findConnectReportByYearByQuarter/2023/3"> <i class="bi bi-check"></i> Connect And Relate</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/dailyReportTracking/dailyReportTrackingByMonthCaller"> <i class="bi bi-check"></i> Reports Tracking</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/poItemDetail/poUploadStatus/allRecievedinv"> <i class="bi bi-check"></i> Po Upload Status</a>
                     </li>  --> 
                    <!--   <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/ledger/performance/2023/1/0"> <i class="bi bi-check"></i> Performance</a>
                     </li> -->
                    </ul> 
				 </li>    
				 
				 
				 
				 <!--  Employee Reviews  -->
				 				 
				 <c:if test="${sessionScope.id==4 or sessionScope.id==94 or sessionScope.id==97 or sessionScope.id==17}">
				 
			     <li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
				     <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Review</span></a>
				     <ul class="submenu tasks-submenu">
				     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/review/findAllEmployees"> <i class="bi bi-check"></i> Employees</a>
                     </li>
				       <li class="submenu-item" >
                          <a href="${pageContext.request.contextPath}/review/allCompetency/0"> <i class="bi bi-check"></i>Competency Definitions</a>
                      </li>
                      <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/review/quarterReviewFormat/2023/0"> <i class="bi bi-check"></i> Annual Review Formats</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/review/quarterReviewSearchResults/0/2023/0"> <i class="bi bi-check"></i> Annual Review</a>
                     </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/pivot"> <i class="bi bi-check"></i> Annual Review Summary ( BETA )</a>
                     </li>
                    </ul> 
				 </li>
				 
				 </c:if>
				     
				<!--  <li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetailssumstat/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/ledger/ledgerCallerAdmin"
					class="sidebar-link"> <i class="bi bi-file-earmark-check"></i><span>Ledger</span></a>
				</li>
				<li
					class="sidebar-link" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetailssumstat/') >= 0}"> active </c:if>">
                       <a href="${pageContext.request.contextPath}/ledger/salesPlans"> <i class="bi bi-check"></i>Sales Plans</a>
				</li>-->
				<!-- <li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
                   <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Reporting</span></a>
                    <ul class="submenu tasks-submenu">
                    <li class="submenu-item" >
                      <a href="${pageContext.request.contextPath}/ledger/yearsDates"> <i class="bi bi-plus-circle-fill"></i>Dates</a>
                   </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/ledger/map"> <i class="bi bi-check"></i>Mapping</a>
                    </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/ledger/quareterYears"> <i class="bi bi-check"></i>Quarters</a>
                    </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/ledger/salesPlans"> <i class="bi bi-check"></i>Sales Plans</a>
                    </li>
                     <li class="submenu-item">
                         <a href="${pageContext.request.contextPath}/ledger/ledgerCallerAdmin"> <i class="bi bi-check"></i>Ledger</a>
                    </li>
                     </ul>
                </li> -->
                
               
				
				
				<!--  Retail Net  -->
				
				<li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
                   <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Retail Net</span></a>
                    <ul class="submenu tasks-submenu">
                    <li class="submenu-item" >
                      <a href="${pageContext.request.contextPath}/pickDeclineDetails/viepickDeclineDetailsByCompletion/inv"> <i class="bi bi-plus-circle-fill"></i>Pick Decline Details</a>
                   </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/saleStatusByStore/vieSaleStatusByStore"> <i class="bi bi-check"></i>Sales Status by Store</a>
                    </li>
                     <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/lossPrevention/all"> <i class="bi bi-check"></i>Loss prevention</a>
                    </li>
                     </ul>
                </li>
				
				
				
				<!--  Tasks  -->
				
				
				<li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
                   <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Tasks</span></a>
                    <ul class="submenu tasks-submenu">
                    <li class="submenu-item" >
                      <a href="${pageContext.request.contextPath}/Tasks/initiator"> <i class="bi bi-plus-circle-fill"></i> Initiate</a>
                   </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/Tasks/approverr"> <i class="bi bi-check"></i> Approve</a>
                    </li>
                    <li class="submenu-item">
                        <a href="${pageContext.request.contextPath}/Tasks/regionaltasks"> <i class="bi bi-map"></i> Status</a>
                     </li>
                     </ul>
                </li>
				
				

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetaila/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/readSpreadsheet/') >= 0}"> active </c:if> has-sub"><a
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
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/invoiceDetail/getRejectedInvoices">
								<i class="bi bi-file-earmark-break"></i> Rejected
						</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/invoiceDetail/rentInvoiceSummary">
								<i class="bi bi-file-earmark-break"></i> Rent Summary ( BETA )
						</a></li>
						<!--  
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/invoiceDetail/invoiceDetailssumstat">
								<i class="bi bi-file-earmark-check"></i> Accounts Payable Summary
						</a></li>-->
					</ul></li>
                
                
               <!--  <li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetailssumstat/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/invoiceDetail/invoiceDetailssumstat"
					class="sidebar-link"> <i class="bi bi-file-earmark-check"></i><span>Accounts Payable Summary</span></a>
				</li> --> 
				
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/invoiceDetailssumstatPaginated/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/invoiceDetail/invoiceDetailssumstatPaginated/All/All"
					class="sidebar-link"> <i class="bi bi-file-earmark-check"></i><span>Accounts Payable Summary</span></a>
				</li>
				
				
				<!--  
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/reviewinvoice/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/invoiceDetail/reviewinvoice"
					class="sidebar-link"> <i class="bi bi-file-earmark-check"></i><span>Review Invoice</span></a>
				</li>-->
                
                
                 <!-- 
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/receive/') >= 0}"> active </c:if>">
					<a href="${pageContext.request.contextPath}/receive/receives"
					class="sidebar-link"> <i class="bi bi-box-arrow-in-down-right"></i><span>Receives</span></a>
				</li>-->

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
				
				
				<!-- Receives -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/storeInCharge/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/storeInCharge/receivesMapping2/itemNotReceived"
					class="sidebar-link"> <i class="bi bi-receipt"></i><span>Receiving</span></a>
				</li>
				
				
				<!-- PODeatils -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/poItemDetail/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/poItemDetail/poItemDetails"
					class="sidebar-link"> <i class="bi bi-info-circle"></i><span>Credit Memo Queue</span></a>
				</li>
				
				<!-- Coupon Report -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/couponCode/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/couponCode/getAll"
					class="sidebar-link"> <i class="bi bi-tags"></i><span>Coupons</span></a>
				</li>
				
				<!-- District Manager Approved Hours -->
	             <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/rmViewOnlyApprovedHour/') >= 0}"> active </c:if>">
				    <a href="${pageContext.request.contextPath}/rmViewOnlyApprovedHour/rmViewOnlyApprovedHours" class="sidebar-link"> <i class="bi bi-hourglass-split"></i><span>District Manager Approved Hours</span></a>
			     </li>
				
				<!-- Sales Reporting -->
				<li
					class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/summary/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/summary/yearlySummary"
					class="sidebar-link"> <i class="bi bi-file-earmark-break"></i><span>Summary</span></a>
				</li>
				

				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/chartOfAccount/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/itemGroup/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/payby/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/store/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/vendor/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/role/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/accessPermission/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/users/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/paymentTerm/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/microservice/') >= 0}"> active </c:if> has-sub">
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
						<%-- <li class="submenu-item"><a
							href="${pageContext.request.contextPath}/accountClass/accountClasses"><i 
								class="bi bi-journal-code"></i> Account Classes</a></li> --%>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/role/roleData"><i
								class="bi bi-bookmark-check"></i> User Roles</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/users/usersData"><i
								class="bi bi-person"></i> Users</a></li>
						<li class="submenu-item"><a
							href="${pageContext.request.contextPath}/microservice/services"><i
								class="bi bi-hand-index"></i> Services</a></li>
					</ul>
				</li>
				
				<!-- Old links -->
				
				<li class="sidebar-item has-sub" <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/Tasks/') >= 0}"> active </c:if>">
                   <a href="#" class="sidebar-link"> <i class="bi bi-list-task"></i> <span>Old Links</span></a>
                    <ul class="submenu tasks-submenu">
                    <li class="submenu-item" >
                      <a href="${pageContext.request.contextPath}/"> <i class="bi bi-grid"></i> Dashboard</a>
                   </li>
                    <li class="submenu-item">
                       <a href="${pageContext.request.contextPath}/receive/receives"> <i class="bi bi-box-arrow-in-down-right"></i> Receives</a>
                    </li>
                     </ul>
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
						/* || url.includes('accountClass') */
						|| url.includes('role') || url.includes('users')
						|| url.includes('paymentTerm') || url.includes('microservice')) {
					$('.setting-submenu').show();
					$('.setting-submenu').addClass("active");
					$(".setting-submenu").prev().addClass('d-active');
				} else if ( url.includes('readSpreadsheet')) {
					$('.invoice-submenu').show();
					$('.invoice-submenu').addClass("active");
					$(".invoice-submenu").prev().addClass('d-active');
				} 
				
				/*else if (url.includes('invoiceDetail/invoiceDetails')) {
					$('.invoice-submenu').show();
					$('.invoice-submenu').addClass("active");
					$(".invoice-submenu").prev().addClass('d-active');
				} */
				
				else if (url.includes('purchaseOrder')
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
			    else if(url.includes('rmViewOnlyApprovedHour')) {
			          $('.taskstatus-submenu').show();
			          $('.taskstatus-submenu').addClass("active");
			          $(".taskstatus-submenu").prev().addClass('d-active');
			        }
			});
</script>