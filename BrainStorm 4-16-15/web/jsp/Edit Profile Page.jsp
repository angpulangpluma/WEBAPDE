<%@page import="Bean.Member"%>
<%@page import="Bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.UserBean"%>
<html>
<head>
	<title>Brainstorm</title>
	<link rel="stylesheet" type="text/css" media="all" href="../css/Edit Profile Style.css"/>
	<link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script type="text/javascript" src="../others/jquery.min.js"></script>
        <script type="text/javascript" src="../others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui-1.11.4.css"/>
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
        <script type="text/javascript" src="../others/brainstorm_func.js"></script>
        
        <%
            UserBean Bean = (UserBean) session.getAttribute("user");
        %>
	<script>
	$(document).ready(function(){
		$("#user").click(function(){
			window.location.href = "Edit Profile Page.html";
		});
		$("#home").click(function(){
			window.location.href = "../ToHomePageServlet";
		});
		$("#logout").click(function(){
			alert("You will be logged out. Please sign in again.");
			window.location.href = "../LogOutServlet";
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
		<img id="icon" src="../design/Icon.png"/>
		<input id="search" type="text" placeholder="Search" style="color: black">
	</span>
	
	<span id="right-header">
            <button id="user"><%=Bean.getFirstName()%> <%=Bean.getLastName()%></button>
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
            First Name</br><input name="fname" type="text" class="inputs" placeholder="<%=Bean.getFirstName()%>" id="firstname"><br/><br/>
            Last Name<br/><input name ="lname" type="text" class="inputs" placeholder="<%=Bean.getLastName()%>" id="lastname"><br/><br/>
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
