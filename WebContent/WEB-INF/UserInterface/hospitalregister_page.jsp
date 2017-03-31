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

<jsp:include page="hosp_navigation.jsp"></jsp:include>   

  
<div class="container-fluid" style="margin-top:0px;margin-bottom:0px;">    
  <div class="row" >
  
    <div class="col-sm-1">
    </div>
    
    <div class="col-sm-10" style="background-image:url('${pageContext.request.contextPath}/images/hosp_reg.jpg'); height:100%;" >  
    
    <br><br><br>
    <br><br><br>
    
    
    
    <div class="container">
    <div class="form-group">        
      <div class="col-sm-offset-4 col-sm-10">
   <h2><u>Hospital Details</u></h2>
  </div>
  </div>
  <br>
  <form class="form-horizontal" action="hospitalspecial" method="POST">
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
     <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Chest Pain"><b>Chest Pain</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d1">
    </label> 
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Abdominal Pain"><b>Abdominal Pain</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d2">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Back Pain"><b>Back Pain</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d3">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
    <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Strain/Sprain Injury"><b>Strain/Sprain Injury</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d4">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Accidental Injury"><b>Accidental Injury</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d5">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="EyeSight Problem"><b>EyeSight Problem</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d6">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Brain Hamorrhage"><b>Brain Hamorrhage</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d7">
    </label>
    </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-3 col-sm-10">
      <label class="checkbox-inline">
      <input type="checkbox" name="emergency" value="Feeds Attack"><b>Feeds Attack</b>
    </label>
    <label class="checkbox-inline">
      <b>Enter Doctor Name</b>: <input type="text" name="d8">
    </label>
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
    
    
    
    </div>
    
    <div class="col-sm-1">
    </div>
    
  </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>

  
</body>
</html>
