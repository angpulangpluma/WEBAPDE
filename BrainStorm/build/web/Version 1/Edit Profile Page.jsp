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
			window.location.href = "Home Page.html";
		});
		$("#grp-name").click(function(){
			window.location.href = "Main Page.html";
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
	<span id="name">Marienne Lopez</span><br/><br/><br/>
	Email<br/><input class="inputs" type="text" placeholder="Email" value="marienne.lopez@gmail.com"><br/><br/>
	First Name</br><input type="text" class="inputs" placeholder="First Name" value="Marienne"><br/><br/>
	Last Name<br/><input type="text" class="inputs" placeholder="Last Name" value="Lopez"><br/><br/>
	Password<br/><input type="password" class="inputs" placeholder="Password should be chuchu" value="1234567890"><br/><br/>
	Re-enter Password<br/><input type="password" class="inputs" placeholder="Re-enter Password" value="1234567890"><br/><br/>
	<button id="save">Save</button>
</div>

<!---
<div id="footer">
</div>
-->

</body>
</html>
