<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Banners Hallmark</title>        
    </head>
    
	
<body>
	 <div id="main" class='layout-navbar'>
           <div id="main-content">

                <div class="page-heading">
                    <div class="page-title mb-5">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Sales rate page</h3>
                                <!-- <p class="text-subtitle text-muted">Navbar will appear in top of the page.</p> -->
                            </div>
                        </div>
                    </div>
				<section class="section blnk-db ">
                        <%@ include file="../common/error-and-success-message.jsp" %> 
                        

                           <div class="card">
                            <div class="card-body  ">
                            <div class="inv-data-tble">
                                <table class="table table-striped  " id="table-p"  >
                                    <thead>
                                        <tr>
                                           <th>Store No</th>	
                                           <th>Rate</th>	
                                           	
                                          
                                       </tr>
                                    </thead>
                                    <tbody>
	                                    <c:forEach var="salesRate" items="${salesRate}">
											<tr>
												<td>${salesRate.site}</td>
												<td>${salesRate.salesRate}</td>
												
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