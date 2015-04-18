<%@page import="Bean.Project"%>
<%@page import="Connection.SearchConnection"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<html>
    <%    
            HttpSession s = request.getSession();
            UserBean user = (UserBean) session.getAttribute("user");
            String chosen = (String) s.getAttribute("chosen");
            HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
            Project p = (Project)session.getAttribute("project");
            Group g = (Group)session.getAttribute("group");
            SearchConnection sCon = new SearchConnection();
            ArrayList<Group> myGroups = pagebean.getGroups();
            ArrayList<UserBean> users = new ArrayList<>();
            ArrayList<Group> groups = new ArrayList<>();
            
            if(null != chosen) switch (chosen) {
                case "people":
                    users = (ArrayList<UserBean>) s.getAttribute("people");
                    break;
                case "group":
                    groups =(ArrayList<Group>) s.getAttribute("groups");
                    break;
            }
            
            System.out.println("sizes: " + users.size() + " - " + groups.size());
        %>
        
<head>
	<title>BrainStorm - Search Results</title>
	<link rel="stylesheet" type="text/css" media="all" href="../css/Search Style.css"/>
	<link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script src="../others/jquery.js"></script>
        
	<script>
	$(document).ready(function(){
            
            function setStyle (height) {
                var style = {
                    'float': 'right',
                    'border': '0',
                    'background-color': '#EEEEEE',
                    'padding': '5px',
                    'padding-left': '10px',
                    'padding-right': '10px',
                    'height': '30px',
                    'border-left': '1px solid #E0E0E0'
                }
                $(".search-select").css(style);
                $(".search-select:hover").css({'cursor':'pointer'});
                $(".search-box").css({'height':height});
            }
                
            var chosen = "<%=chosen%>";
            chosen = chosen.toLowerCase();
            
            if(chosen === "people")
                reloadPeople();
            else if(chosen === "group")
                reloadGroups();
            
            function reloadPeople() {
                console.log("People: " + "<%= users.size() %>");
                
                var clickables = "<input type=\"button\" value=\"Add Member\" class=\"search-button\" name=\"" + id + "\">\n" +
                    "<select class=\"search-select\" id=\"select" + id + "\">" + 
                    <% for(Group tempGroup : myGroups) { %>
                       "<option name=\"" + <%= tempGroup.getID() %> + "\"><%= tempGroup.getGroupName() %></option>" +   
                    <% } %>
                    "</select>";
                    
                <% for(UserBean tempUser : users) { %>
                    var name = "<%=tempUser.getFirstName()%>" + " " + "<%=tempUser.getLastName()%>";
                    var id = "<%=tempUser.getID()%>";
                    appendBox(name, id, clickables, "");
                    console.log("   " + name);
                <% } %>
                    
                setStyle("30px");
            }
            
            function reloadGroups() {
                console.log("Groups: ");
                <% for(Group tempGroup : groups) { %>
                    var name = "<%=tempGroup.getGroupName()%>";
                    var id = "<%=tempGroup.getID()%>";
                    var lead = "<%=tempGroup.getLeader()%>";
                    var clickables = "<input type=\"button\" value=\"Join Group\" class=\"search-button\" name=\"" + id + "\">\n";
                    var lead = "Leader:   " + lead + "\n";
                
                    appendBox(name, id, clickables, lead);
                    console.log("   " + name);
                <% } %>
                
                setStyle("60px");
            }
            
            function appendBox(name, id, clickables, lead) {
                $("#center-content").append(
                    "    <div class=\"search-box\">\n" +
                    "        <div class=\"search-header\">\n" +
                    "                <div class=\"search-name\">" + name + "</div>\n" + clickables +
                    "        </div>\n" +
                    "        <div class=\"search-info\">\n" + lead +
                    "        </div>\n" +
                    "    </div>");
            
            }
            
            $(document).on("click", ".search-button", function(){
                var text = $(this).val();
                if(text === "Join Group") {
                    var id = $(this).attr("name");  // id hidden by 'name' attr
                    $.get("../SearchAddServlet", {chosen: text, id: id}, function() {
                        window.location.href = "Home Page.jsp";
                    });
                }
                else if(text === "Add Member") {
                    var userID = $(this).attr("name");      // id hidden by 'name' attr
                    var id = $(this).siblings(".search-select").attr("id");
                    var element = "#" + id + " :selected";
                    var groupID = $(element).attr("name");
                    console.log("Add Member:");
                    console.log("   userID: " + userID);
                    console.log("   groupID: " + groupID);
                    
                    var name = $(this).siblings(".search-name").text();
                    var groupChosen = $(element).text();
                    $.get("../SearchAddServlet", {chosen: text, userID: userID, groupID: groupID}, function(isMember) {
                        console.log("isMember: " + isMember);
                        if(isMember == "true")
                            alert(name + " is already a member of " + groupChosen);
                        else
                            alert(name + " was added to your group " + groupChosen);
                    });
                }
            });
            
            $("option#edit").click(function(){
                    alert("edit");
                    window.location.href = "Edit Profile Page.html";
            });
            $("option#logout").click(function(){
                    alert("logout");
                    window.location.href = "Log In and Sign Up.html";
            });

            $("#icon").click(function(){
                    window.location.href = "../ToHomePageServlet";
            });
            
            $(".proj-name").click(function(){
                    window.location.href = "../IdeaPageServlet?projid=<%=p.getID()%>&grpid=<%=g.getID()%>";
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
		<button id="user"><%=user.getFirstName()%><%=user.getLastName()%></button>
		<span id="line"></span>
		<select id="user-select" class="h-select">
			<option id="edit">Edit Profile</option>
			<option id="logout">Log Out</option>
		</select>
	</span>
</div>

<div id="center-content">
</div>
    
</div>
	
</div>

<!---
<div id="footer">
</div>
-->

</body>
</html>
