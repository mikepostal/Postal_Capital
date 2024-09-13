<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html>
    <head>
        <title>Banner's Hallmark | Access Permission</title> 
  <style>
  
  
  select {
        width:180px;
        height:35px
    }
    
table.dataTable thead th, table.dataTable thead td {
	padding: 10px 18px;
	border-bottom: 1px solid #111;
}

.boxbody {
	overflow-x: scroll
}

.boxbody table thead th+th {
	min-width: 100px;
}

.boxbody table thead th+th {
	min-width: 100px;
}
</style>       
    </head>
    
	
    <body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Access Permission<!--  <small>advanced tables</small> -->
		</h1>
		<c:if test="${not empty msg}">
			<p id="hide" style="color: red;">${msg}</p>
		</c:if>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
			
				<div class="box">
				<div class="validationMsg" style="color: red;"></div>
				<br>
					<div class="box-header">						
						<div class="box-tools">
	                		<div class="input-group input-group-sm" style="width: 150px;">
	                		<button  type="button" id="saveData" class="btn btn-info pull-left">Save</button>&nbsp;
	             
	                	
	                	
	              	</div>
					</div>
					</div>
					
					<!-- /.box-header -->
					<div class="boxbody box-body table-responsive">
					
						<table id="example" class="table table-bordered table-striped">
						
							<thead>
								<tr>
									<th>AccessPermission URL</th>
									<th>AccessPermission Detailed Desc</th>
									<!-- <th>Actions</th> -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="accessPermission" items="${accessPermission}">
									<tr>			
										<td>${accessPermission.urlPath}</td>
										<td>${accessPermission.accessPermissionDetailedDesc}</td>			                            
									</tr>
								</c:forEach>							
							</tbody>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>

	</section>
	<!-- /.content -->

    <script>
    
    
  

    $(document).ready(function (){
	   	   var table = $('#example').DataTable({	      
		   	   "aLengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
	           "iDisplayLength": 100,
	   	   })	
	       
	   	$("#hide").delay(5000).fadeOut(500);
	    });  
	    

	    
	    
	   
	
   	    </script>
    </body>
</html>