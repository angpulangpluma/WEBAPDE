<%@page import="Bean.Idea"%>
<%@page import="Bean.UserBean"%>
<%@page import="Bean.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.ProjectPageBean"%>
<html>
<head>
        
	<title>Team Nerds</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="all" href="Main Style.css"/>
	<link rel="shortcut icon" href="Tab Icon.png"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="brainstorm_func.js"></script>
	
        <%    
            HttpSession s = request.getSession();
            ProjectPageBean Bean = (ProjectPageBean ) s.getAttribute("project");
            UserBean u = (UserBean) s.getAttribute("user");
            ArrayList<Topic> topics = Bean.getTopics();
                     
            
         %>
        
        
        <script>
	$(document).ready(function(){
            
                var Idea = function (firstName, lastName, topic, idea , id, time) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.topic = topic;
                this.idea = idea;
                this.ideaid = id;
                this.time = time;
                
                this.getTime = function () {
                return this.time;
                };
                
                this.getfirstName = function () {
                return this.firstName;
                };
                
               this.getlastName = function () {
                return this.lastName;
                };
                
                this.getTopic = function () {
                return this.topic;
                }; 
                
                this.getIdea = function () {
                return this.idea;
                }; 
                
                };
            var icollection=[];
            
       //initialize topic collection here         
        <%
        ArrayList<Idea> ideas;    
        for(Topic tpc: topics){
         %>   
          $("#topicselector").append("<option><%=tpc.getName()%></option>");
         <%
            ideas = tpc.getIdeas();
           
            for(int cnt=0 ; cnt< ideas.size(); cnt++){
        %>
            
            icollection[ icollection.length ] = new Idea( "<%=ideas.get(cnt).getUser().getFirstName()%>" ,"<%=ideas.get(cnt).getUser().getLastName()%>" , 
            "<%=tpc.getName()%>", "<%=ideas.get(cnt).getIdea()%>", <%=ideas.get(cnt).getIdeaID()%>, "<%=ideas.get(cnt).getTime()%>"  );
               
        <%
            }        
            }
        %>
                
            function reloadTopics(topic) {
             
             if(topic == "All Topics"){
                 
                 for(var cont =0; cont < icollection.length; cont++){
                     $("#ideas").append(
                        "<div class=\"box\"> "+
                        "<div id=\"b-head\">"+
			"<span id=\"maker\">" + icollection[cont].getfirstName() +" "+ icollection[cont].getlastName()+ "</span>"+
			"<span id=\"date-time\"> "+icollection[cont].getTime() +"</span>" +
			"<span id=\"b-topic\">"+ icollection[cont].getTopic() +"</span>" +
                        "</div>" +
                        "<div id=\"content\">"+ icollection[cont].getIdea()+"</div>" +
                        "<div id=\"b-footer\">"+
			"<span id=\"comments\"> 2</span> Comments"+
			"<span id=\"agree\">5</span> Agrees"+
			"<span id=\"disagree\">3</span> Disagrees"+
                        "</div>"
                          );
                    }  //end of loop     
            } //end of if        
        } // end of function    
                          
		$("#add").click(function(){
			window.location.href = "Post Page.jsp";
		});
		$(".box").click(function(){
			window.location.href = "Idea Page.html";
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
                
                reloadTopics("All Topics");
                
	});
	</script>
</head>
<body>

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

<div id="title-head">
	<span id="title-project">WEBAPP Project</span>
	<select id="proj-select">
		<option>WEBAPP</option>
		<option>SWDESPA</option>
		<option>OPERSYS</option>
	</select>
		
	<span id="view" class="title-right">View 
		<select class="title-select" id="topicselector">
			<option>All Topics</option>
		</select>
	</span>
	<span id="sort" class="title-right">Sort by 
		<select class="title-select">
			<option>Latest</option>
			<option>Most Approves</option>
		</select>
	</span>
	<span id="add">+</span>
</div>

<div id="ideas" align="center">
    
    <!--
	<div class="box">
		<div id="b-head">
			<span id="maker">Jet Virtusio</span>
			<span id="date-time">1:23pm</span>
			<span id="b-topic">HTML</span>
		</div>
    -->
    <!--<div id="title">This is an Idea</div>-->
    <!--
    <div id="content">These sentences are stuffs about the idea. These sentences are stuffs about the idea. 
				klsdka askdjskl asdklj ;madmsakdmsadThese sentences are stuffs about the idea. Blablablabla alsjd laksjdkslajdksadk asldn askdnsa laksds</div>
                
                <div id="b-footer">
			<span id="comments">2</span> Comments
			<span id="agree">5</span> Agrees
			<span id="disagree">3</span> Disagrees
			
       
		</div>
	</div>
    -->
    
	
	</div>



<!--
<div id="footer">
</div>
-->
</div>
</body>
</html>
