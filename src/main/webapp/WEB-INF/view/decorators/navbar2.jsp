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
				<!-- Store Navbar -->
                  <li class="sidebar-item" >
                       <a href="${pageContext.request.contextPath}/Tasks/site" class="sidebar-link"> <i class="bi bi-shop"></i><span>Tasks</span></a>
                  </li>
                          
				   <!-- Receives -->
		           <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/storeInCharge/') >= 0}"> active </c:if>">
					  <a href="${pageContext.request.contextPath}/storeInCharge/receivesMappingStorePre" class="sidebar-link"> <i class="bi bi-receipt"></i><span>Receiving</span></a>
				   </li>
				    <!--  <li class="sidebar-item" >
						<a href="${pageContext.request.contextPath}/paidInOut/paidInOutanalysisStore" class="sidebar-link"> <i class="bi bi-shop"></i><span>Paid-Out</span></a>
					</li>-->
					<li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/storeInCharge/') >= 0}"> active </c:if>">
					  <a href="${pageContext.request.contextPath}/ledger/ledgerCallerStore" class="sidebar-link"> <i class="bi bi-receipt"></i><span>Ledger</span></a>
				   </li>
				   <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/storeInCharge/') >= 0}"> active </c:if>">
					  <a href="${pageContext.request.contextPath}/ledger/ledgerCallerStoreUpdated" class="sidebar-link"> <i class="bi bi-receipt"></i><span>Payroll Hours Ledger</span></a>
				   </li>
				   <!-- Regional Manager Payroll Summary -->
		             <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/payrollSummary/') >= 0}"> active </c:if>">
					    <a href="${pageContext.request.contextPath}/store/payrollSummary/getAll" class="sidebar-link"> <i class="bi bi-coin"></i><span>Payroll Summary</span></a>
				     </li>
					<!-- Core Schedule Templates -->
		             <li class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/coreScheduleTemplate/') >= 0}"> active </c:if>">
					    <a href="${pageContext.request.contextPath}/coreScheduleTemplate/coreScheduleTemplateDetails" class="sidebar-link"> <i class="bi bi-table"></i><span>Core Schedule Templates</span></a>
				     </li>
				  <!-- Support --> 
				  <li
					class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/support/') >= 0}"> active </c:if>" style="position: absolute; bottom: 0; width: 80%;">
					<a
					href="${pageContext.request.contextPath}/support/techSupportsite"
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
			    else if(url.includes('coreScheduleTemplate')) {
				          $('.taskstatus-submenu').show();
				          $('.taskstatus-submenu').addClass("active");
				          $(".taskstatus-submenu").prev().addClass('d-active');
				        }
				
			});
</script>