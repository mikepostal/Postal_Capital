
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
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
			<!-- District Navbar -->
				
               <li class="sidebar-item">
                  <a href="${pageContext.request.contextPath}/Tasks/initiator" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Initiate Task</span></a>
               </li>
                   
               <li class="sidebar-item">
                <a href="${pageContext.request.contextPath}/ledger/ledgerCallerDistrict" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Ledger</span></a>
                  <!--  <a href="${pageContext.request.contextPath}/dailyReport/dailyReport/1/156" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Sales Ledger</span></a>-->
               </li> 
               
               <li class="sidebar-item">
                <a href="${pageContext.request.contextPath}/ledger/ledgerSummaryDistrict/2023/3" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Ledger Summary</span></a>
                  <!--  <a href="${pageContext.request.contextPath}/dailyReport/dailyReport/1/156" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Sales Ledger</span></a>-->
               </li>
               
               <li class="sidebar-item">
                <a href="${pageContext.request.contextPath}/ledger/ledgerCallerDistrictUpdated" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Payroll Hours Ledger</span></a>
                  <!--  <a href="${pageContext.request.contextPath}/dailyReport/dailyReport/1/156" class="sidebar-link"> <i class="bi bi-plus-circle-fill"></i><span>Sales Ledger</span></a>-->
               </li> 
               
               <!-- District Manager Payroll Summary -->
	             <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/payrollSummary/') >= 0}"> active </c:if>">
				    <a href="${pageContext.request.contextPath}/district/payrollSummary/getAll" class="sidebar-link"> <i class="bi bi-coin"></i><span>Payroll Summary</span></a>
			     </li>
               
               <!-- <li class="sidebar-item">
                   <a href="${pageContext.request.contextPath}/Tasks/districttasks" class="sidebar-link"> <i class="bi bi-people"></i><span>Task Status</span></a>
               </li>
               
               <li class="sidebar-item" >
						<a href="${pageContext.request.contextPath}/paidInOut/paidInOutanalysisDistrict" class="sidebar-link"> <i class="bi bi-shop"></i><span>Paid-Out</span></a>
					</li> -->
					
				 <li class="sidebar-item" >
						<!-- <a href="${pageContext.request.contextPath}/Tasks/districtCompleted" class="sidebar-link"> <i class="bi bi-shop"></i><span>Review Tasks</span></a> -->
						<a href="${pageContext.request.contextPath}/Tasks/districtCompleted2/0/All/0" class="sidebar-link"> <i class="bi bi-shop"></i><span>Review Tasks</span></a>
					</li>	
					
				<!-- District Manager Approved Hours -->
	             <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/dmApprovedHour/') >= 0}"> active </c:if>">
				    <a href="${pageContext.request.contextPath}/dmApprovedHour/dmApprovedHours" class="sidebar-link"> <i class="bi bi-hourglass-split"></i><span>District Manager Approved Hours</span></a>
			     </li>
			     
			     <!-- Coupon Report -->
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/district/couponCode/') >= 0}"> active </c:if>">
					<a
					href="${pageContext.request.contextPath}/district/couponCode/getAll"
					class="sidebar-link"> <i class="bi bi-tags"></i><span>Coupons</span></a>
				</li>
               
               <!-- Support --> 
				  <li
					class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/support/') >= 0}"> active </c:if>" style="position: absolute; bottom: 0; width: 80%;">
					<a
					href="${pageContext.request.contextPath}/support/techSupportdistrict"
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
			    else if(url.includes('dmApprovedHour')) {
			          $('.taskstatus-submenu').show();
			          $('.taskstatus-submenu').addClass("active");
			          $(".taskstatus-submenu").prev().addClass('d-active');
			        }
				
			});
</script>