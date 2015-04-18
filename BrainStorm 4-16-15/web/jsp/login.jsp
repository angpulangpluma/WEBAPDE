<html>
<head>
	<title>Welcome to Brainstorm</title>
	<link rel="stylesheet" type="text/css" media="all" href="../css/LS Style.css"/>
	<link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script type="text/javascript" src="../others/brainstorm_func.js"></script>
	<script type="text/javascript" src="../others/jquery-2.1.3.min.js"></script>
	<script>
	$(document).ready(function(){
		
		$('button[name=login]').click(function(){
		     var email = $.trim($('input:text[name=emaillogin]').val());
			 console.log('Email: ' + email);
			 var password = $.trim($('input:password[name=passwordlogin]').val());
			 console.log('Password: ' + password);
                         
			 if(password == ''){
			   alert('Please enter your password.');
			 }
			 
			 //if(email!='' && email.indexOf('@')==email.lastIndexOf('@') && password!='' && email.indexOf('@')!=-1){
                         if(email!='' && password!=''){
			     window.location.href='Home Page.html';
			 }
			 
		});
		
		
		$('button[name=signup]').click(function(){
		   var firstname = $.trim($('input:text[name=firstname]').val());
		   var lastname = $.trim($('input:text[name=lastname]').val());
		   var password1 = $.trim($('input:password[name=passwordsignup]').val());
		   var password2 = $.trim($('input:password[name=anotherpass]').val());
		   var email2 = $.trim($('input:text[name=user]').val());
		   
		   
                   if(email2==''){
			    alert('Please enter your username.');
			 }
			 
		  if(firstname == ''){
		        alert('Please enter your first name.');
		  }
		  
		  if (lastname = ''){
		       alert('Please enter your last name.');
		  }
		  
		  if(password1!=password2 || password2==''){
		      alert('Please enter your password again correctly.');
		  }
		  
		  if(password1==''){
		     alert('Please enter your desired password.');
		  }
		
		});
	});
	</script>
</head>
<body>

<div id="header">
	<span id="welcome">Hello!<br/>Welcome to  </span>
	<span id="name">BrainStorm</span>
</div>

<br/><br/><br/>

<div align="center">
<div id="forms" align="center">

	<div id="login" >
            
            <form action ="../LoginServlet" method="POST">
		<input class="login-inputs" type="text" name="emaillogin" placeholder="Username"><br/><br/>
		<input class="login-inputs" type="password" name="passwordlogin" placeholder="Password"><br/><br/>		
                <button class="buttons" name="login">Log In</button>
            </form>            
        </div>
	
    
	<div id="signup">
            <form method="POST" action="../SignUp2">
		<span id="signup-header">No account yet? Sign Up</span><br/><br/>
		<input type="text" class="signup-inputs" name="user" placeholder="Username" style="margin-top: -8px"><br/><br/>
		<input type="text" class="signup-inputs" name="firstname" placeholder="First Name"><br/><br/>
		<input type="text" class="signup-inputs" name="lastname" placeholder="Last Name"><br/><br/>
		<input type="password" class="signup-inputs" name="passwordsignup" placeholder="Password"><br/><br/>
		<input type="password" class="signup-inputs" name="anotherpass" placeholder="Re-enter Password"><br/><br/>
		<button class="buttons" name="signup">Sign Up</button>
            </form>    
	</div>
	
</div>
</div>

</body>
</html>
