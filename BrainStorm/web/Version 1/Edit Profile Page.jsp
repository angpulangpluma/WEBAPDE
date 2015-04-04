<html>
<head>
	<title>Brainstorm</title>
	<link rel="stylesheet" type="text/css" media="all" href="Edit Profile Style.css"/>
	<link rel="shortcut icon" href="Tab Icon.png"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="brainstorm_func.js"></script>
	<script>
	$(document).ready(function(){
		$("#user").click(function(){
			window.location.href = "Edit Profile Page.html";
		});
		$("#home").click(function(){
			window.location.href = "Home Page.html";
		});
		$("#logout").click(function(){
			alert("You will be logged out. Please sign in again.");
			window.location.href = "Log In and Sign Up.html";
		});
		$("#icon").click(function(){
			window.location.href = "../ToHomePageServlet";
		});
		$("#grp-name").click(function(){
			window.location.href = "Main Page.html";
		});
                
                $("#savename").click(function(){
                    console.log("HERE");
                    console.log($("#lastname").val().length);
                    if( $("#lastname").val().length===0 || $("#firstname").val().length===0 )
                           alert("Please put details first");
                     else $("#nameform").submit()       
                            
                });
                
                $("#savepassword").click(function(){
                    
            
                     if ( $("#pas").val() !== $("#pas2").val() ){
                         alert("Password does not match");
                     } else if( $("#pas").val().length ===0  ){
                         alert("Input password");
                     }else if( $("#pas").val() === $("#pas2").val()){
                         $("#passform").submit()   
                     }      
                            
                });
                
                
                
	});
	</script>
</head>
<body>

<div id="header">

	<span id="left-header">
		<img id="icon" src="Icon.png"/>
		<input id="search" type="text" placeholder="Search" style="color: black">
	</span>
	
	<span id="right-header">
		<button id="user">Marienne Lopez</button>
		<span id="line"></span>
		<button id="home">Home</button>
		<span id="line"></span>
		<button id="logout">Log Out</button>
		<!---
		<select id="user-select" class="h-select">
			<option>Settings</option>
			<option>Log Out</option>
		</select>
		-->
	</span>
</div>

<div id="center-content">
	
        <form id="nameform" action="../ChangeNameServlet" method="POST">
        First Name</br><input name="fname" type="text" class="inputs" placeholder="First Name" id="firstname"><br/><br/>
        Last Name<br/><input name ="lname" type="text" class="inputs" placeholder="Last Name" id="lastname"><br/><br/>
        </form>
    
        <button id="savename">Save Name</button>
        <form id="passform" action="../ChangePassServlet" method="POST" >
        Password<br/><input id="pas" name="pass" type="password" class="inputs" placeholder="Password should be chuchu" value=""><br/><br/>
        Re-enter Password<br/><input id="pas2" type="password" class="inputs" placeholder="Re-enter Password" value=""><br/><br/>
        </form>
        <button id="savepassword" >Save Password</button>
        
</div>

<!---
<div id="footer">
</div>
-->

</body>
</html>
