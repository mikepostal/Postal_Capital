<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Ledger</title> 
        <style>
				input::-webkit-outer-spin-button,
				input::-webkit-inner-spin-button {
				  -webkit-appearance: none;
				  margin: 0;
				}
        </style>       
    </head>
    
	
    <body>
    
    	 <div id="main" class='layout-navbar'>
           <div id="main-content">

                <div class="page-heading">
                    <div class="page-title mb-5">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Sales ledger for Site ${site}</h3>
                                <!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Dashboard</a></li>
                                       
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
							<div class="row">

								<div class="col-5">
									<fieldset class="form-group me-2">
										<label>Select Site</label>
										<select class="form-select" name="formal" id="filterReceived"
											onchange="dailyBySite(this)">
											<option value="#">Site ${site}</option>
											<c:forEach var="stores" items="${stores}">
												<option
													value="${pageContext.request.contextPath}/dailyReport/dailyReport/${monthh}/${stores.store}">Site
													${stores.store}</option>
											</c:forEach>

										</select>
									</fieldset>
								</div>

								<div class="col-7">
									<fieldset class="form-group">
										<label>Select Month</label>
										<select class="form-select" onchange="dailyByMonth(this)">
											<option value="#">${m}</option>
											<option value="${pageContext.request.contextPath}/dailyReport/dailyReport/1/${site}">Jan</option>
											<option value="${pageContext.request.contextPath}/dailyReport/dailyReport/2/${site}">Feb</option>
											<option value="${pageContext.request.contextPath}/dailyReport/dailyReport/3/${site}">Mar</option>
											<option value="${pageContext.request.contextPath}/dailyReport/dailyReport/4/${site}">Apr</option>
											<option value="${pageContext.request.contextPath}/dailyReport/dailyReport/5/${site}">May</option>
										</select>
									</fieldset>
								</div>
								
							</div>
						</div>  
                        </div>
                           <div class="card">
                            <div class="card-body  ">
                              <div class="inv-data-tble" style="overflow-x:auto;">
                                <table class="table table-striped table-bordered" id="t1"> 
                                    <thead>
                                       <tr style="text-align: center;">
											<th width="8%" colspan="3"><span>TY Data</span> - <span>LY Data</span></th>
											<th colspan="2">TY <br>Actual $</th>
											<th colspan="2">TY <br>Plan $</th>
											<th>TY Strech</th>
											<th colspan="2">% to <br>Plan</th>
											<th colspan="2">LY <br>Actual $</th>
											<th>% <br>to LY <br>(Comp)</th>
											<th colspan="2">TY Trans</th>
											<th>CR</th>
											<th>Conversion</th>
											<th>CR %</th>
											<th>2023 Trans</th>
											<th>2022 Trans</th>
											<th>TY IAT</th>
											<th>2022 IAT</th>
											<th>TY IAT GOAL</th>
											<th style = "display:none"></th>
										</tr>
                                    </thead>
                                    <tbody style="text-align: center;">
                                   		 <tr>
                                   		 	<td colspan="3">${m}</td>
											<td>Day</td>
											<td>Cum</td>
											<td>Day</td>
											<td>Cum</td>
											<td>10% inc.</td>
											<td>Day</td>
											<td>Cum</td>
											<td>Day</td>
											<td>Cum</td>
											<td>Day</td>
											<td>CR</td>
											<td>NON CR</td>
											<td>Signups</td>
											<td colspan="6"></td>
											<td>10% inc.</td>
											<td style = "display:none"></td>
										</tr>
										
										<c:forEach var="i" begin="${day[0]}" end="${day[0] + 6}" step="1">
											<tr>
												<td colspan="3">${w1[i].day}<br>${w1[i].tDate}<br>${w1[i].lDate} </td>
												<td>$<fmt:formatNumber value="${w1[i].tyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tycum2}" maxFractionDigits="0" /></td>
												
												<td>$<fmt:formatNumber value="${w1[i].tpPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tpcum2}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tyStrech}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentTyDay}%</td>
												<td>${w1[i].percentTyCum}%</td>
												<td>$<fmt:formatNumber value="${w1[i].lyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].lycum2}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentLyDay}%</td>
												<td>${w1[i].cr}</td>
												<td>${w1[i].nonCr}</td>
												<td>
													<input type="number" maxlength="50" style="border:0px;" 
																id="signUps" class="form-control signUps"
																placeholder="Enter..." value="${w1[i].signUps}" />
												</td>
												<td>${w1[i].conversion}%</td>
												<td>${w1[i].percentCr}%</td>
												<td>${w1[i].transBefore}</td>
												<td>${w1[i].transAfter}</td>
												<td>$${w1[i].tyIat}</td>
												<td>$${w1[i].iat}</td>
												<td>$${w1[i].tyIatGoal}</td>
												<td hidden="">${w1[i].id}</td>
											</tr>
										</c:forEach>

										<tr style="text-align: center;">
                                   		 	<td colspan="3">Week 1 Total</td>
                                   		 	
                                   		 	<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">MTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">QTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tycum - w1[quarter].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tpcum - w1[quarter].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].lycum - w1[quarter].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">YTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[0]].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										
										<tr>
                                   		 	<td colspan="24"></td>
										</tr>
										
										<c:forEach var="i" begin="${day[1]}" end="${day[1] + 6}" step="1">
											<tr>
												<td colspan="3">${w1[i].day}<br>${w1[i].tDate}<br>${w1[i].lDate} </td>
												<td>$<fmt:formatNumber value="${w1[i].tyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tycum2}" maxFractionDigits="0" /></td>
												
												<td>$<fmt:formatNumber value="${w1[i].tpPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tpcum2}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tyStrech}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentTyDay}%</td>
												<td>${w1[i].percentTyCum}%</td>
												<td>$<fmt:formatNumber value="${w1[i].lyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].lycum2}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentLyDay}%</td>
												<td>${w1[i].cr}</td>
												<td>${w1[i].nonCr}</td>
												<td>
													<input type="number" maxlength="50" style="border:0px;" 
																id="signUps" class="form-control signUps"
																placeholder="Enter..." value="${w1[i].signUps}" />
												</td>
												<td>${w1[i].conversion}%</td>
												<td>${w1[i].percentCr}%</td>
												<td>${w1[i].transBefore}</td>
												<td>${w1[i].transAfter}</td>
												<td>$${w1[i].tyIat}</td>
												<td>$${w1[i].iat}</td>
												<td>$${w1[i].tyIatGoal}</td>
												<td hidden="">${w1[i].id}</td>
											</tr>
										</c:forEach>
										
										<tr style="text-align: center;">
                                   		 	<td colspan="3">Week 2 Total</td>
                                   		 	
                                   		 	<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">MTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tycum2 + w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tpcum2 + w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].lycum2 + w1[month[0]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">QTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tycum - w1[quarter].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tpcum - w1[quarter].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].lycum - w1[quarter].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">YTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[1]].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										
										 <tr>
                                   		 	<td colspan="24"></td>
										</tr>
										
										<c:forEach var="i" begin="${day[2]}" end="${day[2] + 6}" step="1">
											<tr>
												<td colspan="3">${w1[i].day}<br>${w1[i].tDate}<br>${w1[i].lDate} </td>
												<td>$<fmt:formatNumber value="${w1[i].tyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tycum2}" maxFractionDigits="0" /></td>
												
												<td>$<fmt:formatNumber value="${w1[i].tpPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tpcum2}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tyStrech}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentTyDay}%</td>
												<td>${w1[i].percentTyCum}%</td>
												<td>$<fmt:formatNumber value="${w1[i].lyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].lycum2}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentLyDay}%</td>
												<td>${w1[i].cr}</td>
												<td>${w1[i].nonCr}</td>
												<td>
													<input type="number" maxlength="50" style="border:0px;" 
																id="signUps" class="form-control signUps"
																placeholder="Enter..." value="${w1[i].signUps}" />
												</td>
												<td>${w1[i].conversion}%</td>
												<td>${w1[i].percentCr}%</td>
												<td>${w1[i].transBefore}</td>
												<td>${w1[i].transAfter}</td>
												<td>$${w1[i].tyIat}</td>
												<td>$${w1[i].iat}</td>
												<td>$${w1[i].tyIatGoal}</td>
												<td hidden="">${w1[i].id}</td>
											</tr>
										</c:forEach>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">Week 3 Total</td>
                                   		 	
                                   		 	<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">MTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tycum2 + w1[month[1]].tycum2 + w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tpcum2 + w1[month[1]].tpcum2 + w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].lycum2 + w1[month[1]].lycum2 + w1[month[0]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">QTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tycum - w1[quarter].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tpcum - w1[quarter].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].lycum - w1[quarter].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">YTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[2]].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										
										 <tr>
                                   		 	<td colspan="24"></td>
										</tr>
										<c:forEach var="i" begin="${day[3]}" end="${day[3] + 6}" step="1">
											<tr>
												<td colspan="3">${w1[i].day}<br>${w1[i].tDate}<br>${w1[i].lDate} </td>
												<td>$<fmt:formatNumber value="${w1[i].tyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tycum2}" maxFractionDigits="0" /></td>
												
												<td>$<fmt:formatNumber value="${w1[i].tpPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tpcum2}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tyStrech}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentTyDay}%</td>
												<td>${w1[i].percentTyCum}%</td>
												<td>$<fmt:formatNumber value="${w1[i].lyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].lycum2}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentLyDay}%</td>
												<td>${w1[i].cr}</td>
												<td>${w1[i].nonCr}</td>
												<td>
													<input type="number" maxlength="50" style="border:0px;" 
																id="signUps" class="form-control signUps"
																placeholder="Enter..." value="${w1[i].signUps}" />
												</td>
												<td>${w1[i].conversion}%</td>
												<td>${w1[i].percentCr}%</td>
												<td>${w1[i].transBefore}</td>
												<td>${w1[i].transAfter}</td>
												<td>$${w1[i].tyIat}</td>
												<td>$${w1[i].iat}</td>
												<td>$${w1[i].tyIatGoal}</td>
												<td hidden="">${w1[i].id}</td>
											</tr>
										</c:forEach>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">Week 4 Total</td>
                                   		 	
                                   		 	<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">MTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tycum2 + w1[month[2]].tycum2 + w1[month[1]].tycum2 + w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tpcum2 + w1[month[2]].tpcum2 + w1[month[1]].tpcum2 + w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].lycum2 + w1[month[2]].lycum2 + w1[month[1]].lycum2 + w1[month[0]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">QTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tycum - w1[quarter].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tpcum - w1[quarter].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].lycum - w1[quarter].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">YTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[3]].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										
										 <tr>
                                   		 	<td colspan="24"></td>
										</tr>
									<c:if test="${monthh==3}">
										<c:forEach var="i" begin="${day[4]}" end="${day[4] + 6}" step="1">
											<tr>
												<td colspan="3">${w1[i].day}<br>${w1[i].tDate}<br>${w1[i].lDate} </td>
												<td>$<fmt:formatNumber value="${w1[i].tyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tycum2}" maxFractionDigits="0" /></td>
												
												<td>$<fmt:formatNumber value="${w1[i].tpPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tpcum2}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].tyStrech}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentTyDay}%</td>
												<td>${w1[i].percentTyCum}%</td>
												<td>$<fmt:formatNumber value="${w1[i].lyPrice}" maxFractionDigits="0" /></td>
												<td>$<fmt:formatNumber value="${w1[i].lycum2}" maxFractionDigits="0" /></td>
												<td>${w1[i].percentLyDay}%</td>
												<td>${w1[i].cr}</td>
												<td>${w1[i].nonCr}</td>
												<td>
													<input type="number" maxlength="50" style="border:0px;" 
																id="signUps" class="form-control signUps"
																placeholder="Enter..." value="${w1[i].signUps}" />
												</td>
												<td>${w1[i].conversion}%</td>
												<td>${w1[i].percentCr}%</td>
												<td>${w1[i].transBefore}</td>
												<td>${w1[i].transAfter}</td>
												<td>$${w1[i].tyIat}</td>
												<td>$${w1[i].iat}</td>
												<td>$${w1[i].tyIatGoal}</td>
												<td hidden="">${w1[i].id}</td>
											</tr>
										</c:forEach>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">Week 5 Total</td>
                                   		 	
                                   		 	<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].lycum2}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">MTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tycum2 + w1[month[3]].tycum2 + w1[month[2]].tycum2 + w1[month[1]].tycum2 + w1[month[0]].tycum2}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tpcum2 + w1[month[3]].tpcum2 + w1[month[2]].tpcum2 + w1[month[1]].tpcum2 + w1[month[0]].tpcum2}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].lycum2 + w1[month[3]].lycum2 + w1[month[2]].lycum2 + w1[month[1]].lycum2 + w1[month[0]].lycum2}"/></td>											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">QTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tycum - w1[quarter].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tpcum - w1[quarter].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].lycum - w1[quarter].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
										<tr style="text-align: center;">
                                   		 	<td colspan="3">YTD Total</td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tycum}"/></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].tpcum}"/></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>$<fmt:formatNumber type="number" maxFractionDigits="0" value="${w1[month[4]].lycum}"/></td>
											<td></td>
											<td colspan="11"></td>
										</tr>
									</c:if>
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
	<script>
		$(function() {
			var sideBtn = document.getElementById("sideBtn");
			sideBtn.click();
		});

		$('#t1 input').change(function(){
			var invs={}; 
			var invvcnt=0;
			var inp1 = $(this).closest("tr").find("input").get(0);
			var sub=$(this).closest("tr").find("td:eq(21)").html();
			var invv={};
			
			invv.id=sub;
			invv.inp1=inp1.value;
			invs[invvcnt]=invv
			console.log(invs);
	 		    
			var json = JSON.stringify(invs);
			
			$.ajax({
				url : "${pageContext.request.contextPath}/dailyReport/adminUpdate",
				type : "POST",
				//contentType : "application/json; charset=utf-8",
				data : {json:json},
				success : function(response) {
					//alert(JSON.stringify(response));
					if (response.data == "1") {
						location.reload();
					}
					if (response.result == "ERROR") {
						alert("Something went wrong, Please try again after sometime");
					} else if (response.result == 'noPermission') {
						alert("You don't have permission for this action.");
					}
				}
			});
 		   
		});
		
		function dailyByMonth(a) {
			var link = a.value;
			window.location = link;
		}
		
		function dailyBySite(a) {
			var link = a.value;
			window.location = link;
		}
		
		
	</script>

</body>
</html>