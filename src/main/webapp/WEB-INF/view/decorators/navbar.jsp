
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.sidebar::-webkit-scrollbar {
	display: none;
}
</style>
<div id="sidebar" class="active">
	<div class="sidebar-wrapper active shadow">
		<div class="sidebar-header">
			<div class="d-flex justify-content-between ">
				<div class="logo">
					<a href="${pageContext.request.contextPath}"><img
						style="height: 100px" width="236px"
						src="${pageContext.request.contextPath}/resources/assets/images/logo/yosalLogo.png"
						alt="Logo" srcset=""></a>
					<audio id="notification-sound"
						src="${pageContext.request.contextPath}/resources/assets/sounds/notification.wav"
						preload="auto"></audio>
				</div>
				<div class="toggler">
					<a href="#" class="sidebar-hide d-xl-none d-block"><i
						class="bi bi-x bi-middle"></i></a>
				</div>
			</div>
		</div>
		<div class="sidebar-menu">
			<ul class="menu">
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/dashboard/') >= 0}"> active </c:if>">
						<a href="${pageContext.request.contextPath}/dashboard/dashboard"
						class="sidebar-link"> <i class="bi bi-speedometer"></i><span>Dashboard</span></a>
					</li>
				</c:if>
				<c:if test="${role == 2}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/dashboard/') >= 0}"> active </c:if>">
						<a href="${pageContext.request.contextPath}/dashboard/tradersDashboard"
						class="sidebar-link"> <i class="bi bi-speedometer"></i><span>Dashboard</span></a>
					</li>
				</c:if>
				<c:if test="${role == 2}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/calander/') >= 0}"> active </c:if>">
						<a href="${pageContext.request.contextPath}/calander/allCalanders"
						class="sidebar-link"> <i class="bi bi-calendar-date-fill"></i><span>Calendar</span></a>
					</li>
				</c:if>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item  <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/calander/') >= 0 }"> active </c:if> has-sub">
						<a href="#" class="sidebar-link"><i
							class="bi bi-calendar-date-fill"></i><span>Calendar </span></a>
						<ul class="submenu po-submenu">
							<li class="submenu-item"><a
								href="${pageContext.request.contextPath}/calander/allCalanders"><i
									class="bi bi-calendar-day-fill"></i> Calendar </a></li>

							<li class="submenu-item"><a
								href="${pageContext.request.contextPath}/calander/allAffectedByCalander"><i
									class="bi bi-wallet-fill"></i> Affected By Calendar</a></li>

						</ul>
					</li>
				</c:if>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/tradepairs/') >= 0 || requestScope['javax.servlet.forward.request_uri'].indexOf('/categories/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/categories/allCategories"
						class="sidebar-link"> <i class="bi bi-hdd-stack-fill"></i><span>Trade
								Pairs</span></a>
					</li>
				</c:if>
				
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/marketInsight/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/marketInsight/allMarketInsight"
						class="sidebar-link"> <i class="bi bi-chat-left-text-fill"></i><span>Market
								Insight</span></a>
					</li>
				
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/users/') >= 0}"> active </c:if>">
						<a href="${pageContext.request.contextPath}/users/usersData"
						class="sidebar-link"> <i class="bi bi-people-fill"></i><span>Users</span></a>
					</li>
				</c:if>
				<li
					class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/pnl/') >= 0}"> active </c:if>">
					<a href="${pageContext.request.contextPath}/pnl/allpnl"
					class="sidebar-link"> <i class="bi bi-cash"></i><span>PNL</span></a>
				</li>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/accounts/') >= 0}"> active </c:if>">
						<a href="${pageContext.request.contextPath}/accounts/allAccounts"
						class="sidebar-link"> <i class="bi bi-badge-tm-fill"></i><span>Accounts</span></a>
					</li>
				</c:if>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/tradersAccounts/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/tradersAccounts/allTradersAccounts"
						class="sidebar-link"> <i class="bi bi-person-badge-fill"></i><span>Traders
								Accounts</span></a>
					</li>
				</c:if>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/tradingResources/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/tradingResources/allTradingResources"
						class="sidebar-link"> <i class="bi bi-folder-fill"></i><span>Guidelines</span></a>
					</li>
				</c:if>

				<c:if test="${role == 2}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/tradingResources/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/tradingResources/displayTradingResources"
						class="sidebar-link"> <i class="bi bi-folder-fill"></i><span>Guidelines</span></a>
					</li>
				</c:if>
				<c:if test="${role == 2}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/comment/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/comment/tradeCommentList"
						class="sidebar-link"> <i class="bi bi-chat-left-text-fill"></i><span>Trade
								Comment</span></a>
					</li>
				</c:if>
				<c:if test="${role == 1}">
					<li
						class="sidebar-item <c:if test="${requestScope['javax.servlet.forward.request_uri'].indexOf('/comment/') >= 0}"> active </c:if>">
						<a
						href="${pageContext.request.contextPath}/comment/displayTradeComment"
						class="sidebar-link"> <i class="bi bi-chat-left-text-fill"></i><span>Trade
								Comment</span></a>
					</li>
				</c:if>

			</ul>
		</div>
		<button class="sidebar-toggler btn x">
			<i data-feather="x"></i>
		</button>
	</div>
</div>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var url = window.location.href;
						if (url.includes('storeInCharge')) {
							$('.ext-submenu').show();
							$('.ext-submenu').addClass("active");
							$(".ext-submenu").prev().addClass('d-active');
						} else if (url.includes('vendor')
								|| url.includes('store')
								|| url.includes('chartOfAccount')
								/* || url.includes('accountClass') */
								|| url.includes('role')
								|| url.includes('users')
								|| url.includes('paymentTerm')
								|| url.includes('microservice')) {
							$('.setting-submenu').show();
							$('.setting-submenu').addClass("active");
							$(".setting-submenu").prev().addClass('d-active');
						} else if (url.includes('readSpreadsheet')) {
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

						else if (url.includes('Tasks')
								|| url.includes('regionaltasks')) {
							$('.tasks-submenu').show();
							$('.tasks-submenu').addClass("active");
							$(".tasks-submenu").prev().addClass('d-active');
						} else if (url.includes('Tasks')
								|| url.includes('districttasks')) {
							$('.taskstatus-submenu').show();
							$('.taskstatus-submenu').addClass("active");
							$(".taskstatus-submenu").prev()
									.addClass('d-active');
						} else if (url.includes('rmViewOnlyApprovedHour')) {
							$('.taskstatus-submenu').show();
							$('.taskstatus-submenu').addClass("active");
							$(".taskstatus-submenu").prev()
									.addClass('d-active');
						}
					});
</script>

<script>
    function playNotificationSound() {
        var sound = document.getElementById('notification-sound');
        sound.play().catch(error => console.error('Error playing sound:', error));
    }

    function checkTime() {
        var now = new Date();
        // Format the time to ISO string without time zone (e.g., "YYYY-MM-DD HH:MM:SS")
        var localDateTime = now.toISOString().replace("T", " ").substring(0, 19);
        
        //console.log(localDateTime);
        fetch("/Bannershallmark/calander/checkTime?currentTime=" + encodeURIComponent(localDateTime))
            .then(response => response.text())
            .then(result => {
               // console.log('Server response:', result);
                if (result.trim() === 'true') {
                    playNotificationSound();
                }
            })
            .catch(error => console.error('Fetch error:', error));
    }

    // Check the time every second
    setInterval(checkTime, 1000);
</script>
