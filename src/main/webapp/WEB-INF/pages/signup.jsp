<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <script>
				  var loadFile = function(event) {
				    var output = document.getElementById('output');
				    output.src = URL.createObjectURL(event.target.files[0]);
				    output.onload = function() {
				      URL.revokeObjectURL(output.src) // free memory
				    }
				  };
</script>
</head>
<body>
<header style="height: 30px;background-color: #2196f3; color: White; text-align:center"> 
	* represents required field</header>
<div class="container"> 
	<br/>   
  	<img src="${pageContext.request.contextPath}/img/signup.png" style="height: 120px;">
  	<h3>User Sign Up</h3>
  	<hr/>	
  	 
  		 <form action="signUp"  method="post" enctype="multipart/form-data">
	  		  Username<b>*</b>
	  		   <input type="text"  name="username"  class="form-control"  required="required" style="width: 50%;">
	  		   
	  		   Password<b>*</b>
	  		   <input type="password"  name="password"  class="form-control"  required="required" style="width: 50%;">
	  		   Name<b>*</b>
	  		   <input type="text"  name="name"  class="form-control"  required="required" style="width: 50%;">
	  		   Email<b>*</b>
	  		   <input type="text"  name="email"  class="form-control"  required="required" style="width: 50%;">
	  		   Salutation<b>*</b>
	  		   <select name="salutation"  class="form-control"  style="width: 50%;">
	  		   	<option>Mr</option>
	  		      <option>Mrs</option>
	  		   </select>
	  		   Photo<b>*</b>
	  		   	<input type="file"  name="photo"  class="form-control" onchange="loadFile(event)"style="width: 50%;background-color: #ecffde;height: 44px">
	  		   	<img id="output" style="height: 100px; width:100px"/><span class="spinner-border spinner-border-sm"></span>
	  		    <br/>
	  		   <button type="submit" class="btn btn-primary" style ="background-color: Red">Sign Up</button>
	  		   <a href="${pageContext.request.contextPath}/login">
	  		   <button type="button" class="btn btn-danger" style ="background-color: Blue">Sign In</button>
	  		   </a>
  		 </form>
</div>
</body>
</html>