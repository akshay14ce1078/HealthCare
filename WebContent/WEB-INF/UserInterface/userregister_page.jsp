<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="/lib/w3.css">
  <link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/file1.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  

</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>   

  
<div class="container-fluid" style="margin-top:0px;margin-bottom:0px;">    
  <div class="row" >
  
    <div class="col-sm-1">
    </div>
    
    <div class="col-sm-10" style="background-image:url('${pageContext.request.contextPath}/images/hosp_reg.jpg'); height:100%;" >  
    
    <br><br><br>
    <br>
    
    
    <div class="container">
  <center><h2><u>User Registration</u></h2></center>
  <br>
  <form class="form-horizontal" action="userregister">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">First Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="Fname" id="fname" placeholder="Enter First Name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Last Name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="Lname" id="lname" placeholder="Enter Last Name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" name="Email" id="email" placeholder="Enter Email_id">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">User Id:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" name="User_id" id="fname" placeholder="Enter User Id">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Contact1:</label>
      <div class="col-sm-8">
        <input type="number" class="form-control" name="Contact1" id="Contact1" placeholder="Enter contact">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Contact2:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" name="Contact2" id="Contact2" placeholder="Enter alternate contact">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-5 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>  	
    
    <br><br><br><br>
    <br><br>
    
    
    </div>
    
    <div class="col-sm-1">
    </div>
    
  </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
