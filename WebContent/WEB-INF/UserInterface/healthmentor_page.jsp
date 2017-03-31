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
<style>
 #section1 {color: #fff; background-color: #ff9800;}
</style>  

</head>
<body>

<jsp:include page="user_navigation.jsp"></jsp:include>   

  
<div class="container-fluid" style="margin-top:0px;margin-bottom:0px;">    
  <div class="row" >
  
    <div class="col-sm-1">
    </div>
    
    <div class="col-sm-10" style="background-image:url('${pageContext.request.contextPath}/images/plus.jpg'); height:100%;" >  
    
    <br><br><br>
    <br><br><br>
    
    
    <div id="section1" class="container-fluid">
  
  <h1 style="color:black;"><u>Here are 10 tips to keep in mind when responding to emergency situations:</u></h2>

<h3>1.Don't panic.</h3>

<h3>2.Make sure you are in a safe position to offer help. DO NOT attempt to assist victims if you are in danger (for example, the building is on fire, traffic has not been controlled, or guns are being fired etc.).</h3>

<h3>3.Remember the ABCs of Life Support Airways open—Open and maintain victim's airway. Breathing restored—If victim is not breathing, then begin rescue-breathing techniques immediately. Circulation maintained—If no pulse is present, call 911 or your local Emergency Medical Services (EMS) and then get assistance from a person certified in cardiopulmonary resuscitation (CPR) techniques. REMEMBER, to be able to perform CPR effectively, it is essential to be properly trained.</h3>

<h3>4.Check for bleeding.</h3>

<h3>5.Apply direct pressure with a clean cloth and seek medical attention as soon as possible. If possible, wear health care gloves to protect yourself from direct contact with blood.
Look for signs of shock and broken bones or fractures.</h3>

<h3>6.Call 911 or your local emergency services quickly. Know emergency numbers such as 0 or 911. Telephone appropriate authorities (rescue squad, ambulance, police, poison control center [1-800-222-1222] or fire department) and describe the problem. Be sure to give your name, location, and the number of people involved.</h3>

<h3>7.Check for emergency medical identification on the victim.</h3>

<h3>8.Loosen any clothing that may restrict victim's breathing or interfere with circulation.</h3>

<h3>9.Never give an unconscious person anything by mouth.</h3>

<h3>10.DO NOT move injured persons unless situation is life threatening. Keep victim still, quiet, and warm (except for heat exhaustion and heatstroke see Heat Exposure section for specific care instructions).</h3>
  
  
  </div>
    
    <br><br><br>
    <br><br>    
    </div>
    
    <div class="col-sm-1">
    </div>
    
  </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
