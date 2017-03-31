<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/file1.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  

</head>
<body>

<jsp:include page="user_navigation.jsp"></jsp:include>   

  
<div class="container-fluid" style="margin-top:0px;margin-bottom:0px;">    
  <div class="row" >
  
    <div class="col-sm-1">
    </div>
    
    <div class="col-sm-10" style="background-image:url('${pageContext.request.contextPath}/images/home.jpg'); height:100%;" >  
    
    <br><br><br>
    
    
    <table class="table table-hover" style="color:white;">
    	<tr><td>Name</td><td>Location</td><td>Phone no.</td></tr>
    	<%
    	int len=(Integer)request.getAttribute("length");
    	for(int i=0;i<len;i++){ 
    	%>
    	<tr><td><%=request.getAttribute("hosp_name"+i) %></td><td><%=request.getAttribute("hosp_loc"+i) %></td><td><%=request.getAttribute("hosp_contact"+i) %></td></tr>
    	<%
    	} 
    	%>
   	</table>
    
    
    
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><br><br><br></div>
    <div class="col-sm-2"></div>
   
	</div>
	
	<div class="col-sm-1">
    </div>

	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
