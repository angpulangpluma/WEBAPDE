<%@page import="Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Topic"%>
<%@page import="Bean.ProjectPageBean"%>
<html>
<head>
	<title>Team Nerds</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="all" href="Post Style.css"/>
	<link rel="shortcut icon" href="Tab Icon.png"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="brainstorm_func.js"></script>
	<script>
            
         <%
             HttpSession s = request.getSession();
             ProjectPageBean Bean = (ProjectPageBean ) s.getAttribute("project");
             ArrayList<Topic> topics = Bean.getTopics();
             UserBean ub = (UserBean)s.getAttribute("user");
             
             
             
         %>
            
	 $(document).ready(function(){
		$("#newtopic").hide();
                
                if($("#select-popup").find(":selected").val() === "new")
                    $("#newtopic").show();
                
                
		$("#select-popup").change(function(){
			if($("#select-popup").find(":selected").val() === "new")
				$("#newtopic").show();
			else
				$("#newtopic").hide();
		});
		$("#group").click(function(){
			window.location.href = "Main Page.html";
		});
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
		/*
		$("input:button[name=post]").click(function(){
		    var selected = $("#select-popup option:selected").text();
			var desc = $("textarea#text-popup").val();
			
			if(selected=="new"){
			  selected=$("input:text[name=topictitle]").val();
			}
			
			if(desc== ""){
			  alert("Please enter the idea description.");
			}
			
			if(selected== ""){
			  alert("Please enter the idea topic.");
			}
			
			//if(selected!= "" && desc!= ""){
			//  alert("Congratulations! A new idea has been created!");
			//  window.location.href="Main Page.html";
		//	}
		});
                */
		
	});
	
	</script>
</head>
<body>

<div id="add-popup">
	<div id="content-popup">
                <form method="POST" action="../PostIdeaServlet">
		<div>
			<span id="topic-popup">Topic</span>
			<select id="select-popup" name="selected">
                            <% for(Topic tpc: topics){ %>
                            <option value="<%=tpc.gettopicid()%>"> <%=tpc.getName()%>
                              <%  } %>
				<option value="new">Add new topic</option>
			</select>
			<input type="text" id="newtopic" name="topictitle" placeholder="New Topic">
		</div>
		<textarea id="text-popup" rows="10" cols="65" name="ideadesc" placeholder="Write your awesome idea here.."></textarea>
		<input type="hidden" value="<%= ub.getID()%>" name="userid" >
                <input type ="hidden" value="<%=Bean.getID()%>" name="projid">
                
                <input id="button-popup" type="submit" value="Post" name="post"/>
                
                </form>
	</div>
            
</div>

<div id="bg">

<div id="header">
	<span id="left-header">
		<img id="icon" src="Icon.png"/>
		<span id="group">Team Nerds</span>
		<select id="group-select" class="h-select">
			<option>Members</option>
			<option>Switch Group</option>
			<option>Edit Group</option>
		</select>
		<input id="search" type="text" placeholder="Search" style="color: black">
	</span>
	
	<span id="right-header">
		<button id="user"><%= ub.getFirstName()%> <%=ub.getLastName()%></button>
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

<!--
<div id="footer">
</div>
-->
</div>
</body>
</html>

