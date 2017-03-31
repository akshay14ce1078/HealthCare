<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Emergency</title>
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
    
    <div class="col-sm-10" style="background-image:url('${pageContext.request.contextPath}/images/pic.jpg'); height:100%;" >  
    
    <br><br><br>



	<div class="col-sm-2">
    </div>
    
    <div class="col-sm-8">
    <form method="post" action="${pageContext.request.contextPath}/suggesthosp">
	<div class="form-group">
  		<label for="sel1" style="color:white;">Sufferings:</label>
  		<select name="suffering" class="form-control" id="sel1">
    		<option value="Chest Pain">Chest Pain</option>
    		<option value="Abdominal Pain">Abdominal Pain</option>
    		<option value="Back Pain">Back Pain</option>
    		<option value="Strain/Sprain Injury">Strain/Sprain Injury</option>
    		<option value="Accidental Injury">Accidental Injury</option>
    		<option value="EyeSight Problem">EyeSight Problem</option>
    		<option value="Brain Hamorrhage">Brain Hamorrhage</option>
    		<option value="Feeds Attack">Feeds Attack</option>
    		
  		</select>
	</div>
	<div class="form-group">
  		<label for="sel1" style="color:white;">Emergency Type:</label>
  		<select name="emer_type" class="form-control" id="sel1">
    		<option value="0">Very Urgent</option>
    		<option value="1">Urgent</option>
  		</select>
	</div>
	<div class="form-group">
  		<label for="sel1" style="color:white;">Hospital Grade:</label>
  		<select name="grade" class="form-control" id="sel1">
    		<option value="0">High Grade</option>
    		<option value="1">Average Grade</option>
    		<option value="2">Low Grade</option>
    	</select>
	</div>
	
	<input type="hidden" id="latlong" name="latlong" value="" />
	<button onclick="getLocation()" class="btn btn-default">Find Hospital</button>
   </form>
    <script>
	function getLocation() {
    	if (navigator.geolocation) {
        	navigator.geolocation.getCurrentPosition(showPosition);
    	} else { 
    		document.getElementById("latlong").value = 12;
    	}
	}

	function showPosition(position) {
		document.getElementById("latlong").value= position.coords.latitude + "," + position.coords.longitude;
	}
	</script> 
   
   </div>
   
  
   
   
   <div class="col-sm-2">
   </div>
   
   <div class="col-sm-12">
    <br><br><br>
    <br><br><br>
    <br><br><br> 
   </div>
     
    
    </div>
    
    <div class="col-sm-1">
    </div>
    
  </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
