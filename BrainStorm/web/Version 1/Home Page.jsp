<%@page import="Bean.Member"%>
<%@page import="Bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.UserBean"%>
<html>
<head>
	<title>Brainstorm</title>
	<link rel="stylesheet" type="text/css" media="all" href="Home Style.css"/>
	<link rel="shortcut icon" href="Tab Icon.png"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="brainstorm_func.js"></script>
	<%
        UserBean Bean = (UserBean) session.getAttribute("user");
        HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
        ArrayList<Group> groups = pagebean.getGroups();
        int gnumber = groups.size();
        %>
        
        <script>
            
            
	$(document).ready(function(){
                    
                var currGroup = "0";
                var pageShow, pageHide, pageHide1, pageHide2;
                var groupname="#"+currGroup;
                
                $('#selectedgroup').text($(groupname).text());     
                 for(var cont=0; cont< 3; cont++ ){
                $("#grp-projects-page-"+cont).hide();
              
                $("#grp-members-page-"+cont).hide();
	     
                } 
            
                 $("#grp-projects-page-0").show();
                       
		$("#user").click(function(){
			window.location.href = "Edit Profile Page.html";
		});
		$("#home").click(function(){
			window.location.href = "Home Page.html";
		});
		$("#logout").click(function(){
			alert("You will be logged out. Please sign in again.");
			window.location.href = "../LogOutServlet";
		});
		$("#icon").click(function(){
			window.location.href = "Home Page.html";
		});
		$("#grp-name").click(function(){
			window.location.href = "Main Page.html";
		});
		$(".proj-name").click(function(){
			window.location.href = "Main Page.html";
		});
		$("#grp-projects").click(function(){
                        pageHide = "#grp-members-page-" + currGroup;
                        pageShow = "#grp-projects-page-" + currGroup;
                        $(pageHide).hide();
                        $(pageShow).show();
		});
		$("#grp-members").click(function(){
                        pageHide = "#grp-projects-page-" + currGroup;
                        pageShow = "#grp-members-page-" + currGroup;
                        $(pageHide).hide();
                        $(pageShow).show();
		});
		$(".group").click(function(){
                        pageHide1 = "#grp-projects-page-" + currGroup;
                        pageHide2 = "#grp-members-page-" + currGroup;
                        pageShow = "#grp-projects-page-" + $("#grp-list").val();
                        $(pageHide1).hide();
                        $(pageHide2).hide();
                        $(pageShow).show();
                        currGroup = $("#grp-list").val();
                        
                        groupname="#"+currGroup;
                    
                      $('#selectedgroup').text($(groupname).text());
                       // document.getElementById("selectedgroup").textContent= 
                        
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
		<button id="user"> <%=Bean.getFirstName()%> <%=Bean.getLastName()%></button>
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

	<div id="groups-whole">
	<span class="titles" id="grp-title">Groups</span>
	<div id="groups">
		<select id="grp-list" size="<%=groups.size()%>">
                    
                    <%
                    //System.out.println("<--->" + groups.size());
                    for(int i = 0; i < groups.size(); i++){
                    //System.out.println("*--->" + groups.get(i).getGroupName());
                    %>
                    
                        <option id="<%=i%>" class="group" value="<%=i%>"><%=groups.get(i).getGroupName()%>
			</option>          
                    <%
                    }
                    %>
		</select>
                
		<div id="grp-page">
                    <div id="grp-header">
                        <a id="grp-name">
               
                        
                     <span id="selectedgroup">Team Nerds</span> 
			              
               
                         </a> <span id="grp-line"></span>
                        <a id="grp-projects">Projects</a> <span id="grp-line"></span>
                        <a id="grp-members">Members</a>
			</div>
			
			<!-- when 'projects' tab is clicked -->
                        
                        
                        <%
                        ArrayList<Member> members;
                        Member m;
                        Group g;
                        ArrayList<Project> proj;
                        for(int c=0; c< groups.size();c++ ){
                        g = groups.get(c);
                        proj = g.getProjects();
                        
                      
                        %>
			<div id="grp-projects-page-<%=c%>">
			       
                        <%
                        for(Project p: proj){    
                        System.out.println(g.getGroupName() + "UR TOPIC IS " +p.getName());
                        %>
                            <div class="grp-box">
					<a class="proj-name"><%=p.getName()%></a>
					<div class="proj-ideas">10 Ideas</div>
				</div>
                        <%
                            }          
                        %>
                        </div>                      
			<!-- when 'members' tab is clicked -->
			<div id="grp-members-page-<%=c%>">                                                 
                            <%
                            members = g.getMembers();
                            
                            for(int count = 0; count < members.size() ; count++ ){
                                m = members.get(count);
                            %>                      
				<div class="grp-box">
					<a href="" class="proj-name"><%=m.getFirstName()%> <%=m.getLastName()%></a>
				</div>				
                              <%  
                            }
                                %>
			</div>
                    <%                                                
                        }
                      %>                                         		                                    
		</div>
	</div>
	</div>
	
	<div id="notifs-whole">
	<span class="titles">Notifications</span>
	<div id="notifs">
		<div class="box">
			<div id="content">
				<span id="notif-user">Hannah Sibayan</span>
				posted an idea in
				<span id="notif-proj">WEBAPP</span> 
				under 
				<span id="notif-topic">HTML</span>
			</div>
			<div id="date-time">1:23pm</div>
		</div>
		<div class="box">
			<div id="content">
				<span id="notif-user">Jet Virtusio</span>
				posted an idea in
				<span id="notif-proj">SWDESPA</span> 
				under 
				<span id="notif-topic">User Stories</span>
			</div>
			<div id="date-time">1:22pm</div>
		</div>
	</div>

</div>

<!---
<div id="footer">
</div>
-->

</body>
</html>
