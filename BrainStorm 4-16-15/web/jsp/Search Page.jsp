<%@page import="Connection.SearchConnection"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<title>Brainstorm</title>
	<link rel="stylesheet" type="text/css" media="all" href="../css/Search Style.css"/>
	<script type="text/javascript" src="../others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui.1.11.4.css"/>
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
        <link rel="shortcut icon" href="../design/Tab Icon.png"/>
        
        <%    
            HttpSession s = request.getSession();
            UserBean Bean = (UserBean)session.getAttribute("user");
            String chosen = (String) s.getAttribute("chosen");
            HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
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
            
                for(UserBean u: users){
                System.out.println("HEREE>>> " + u.getFirstName()  +" " +u.getID());
            
                }
            
            
            System.out.println("sizes: " + users.size() + " - " + groups.size());
        %>
        
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
<<<<<<< HEAD
                   
                <% for(UserBean tempUser : users) { %>
                    var name = "<%=tempUser.getFirstName()%>" + " " + "<%=tempUser.getLastName()%>";
                    var id = "<%=tempUser.getID()%>";  
                   
=======
                var id;
                var name;
>>>>>>> origin/4-10-Branch
                var clickables = "<input type=\"button\" value=\"Add Member\" class=\"search-button\" name=\"" + id + "\">\n" +
                    "<select class=\"search-select\" id=\"select" + id + "\">" + 
                    <% for(Group tempGroup : myGroups) { %>
                       "<option name=\"" + <%= tempGroup.getID() %> + "\"><%= tempGroup.getGroupName() %></option>" +   
                    <% } %>
                    "</select>";
                    
<<<<<<< HEAD

=======
                <% for(UserBean tempUser : users) { %>
                    name = "<%=tempUser.getFirstName()%>" + " " + "<%=tempUser.getLastName()%>";
                    id = "<%=tempUser.getID()%>";
>>>>>>> origin/4-10-Branch
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
                    window.location.href = "Edit Profile Page.html";
            });
            $("option#logout").click(function(){
                    alert("You will be logged out. Please sign in again.");
                        window.location.href = "../LogOutServlet";
            });
            $("#icon").click(function(){
                    window.location.href = "../ToHomePageServlet";
            });
            
            var sugg2=[];
            var sugg=[];
                $("#search").keyup(function() {
                    var clickedradio = $("input:radio[name ='t']:checked").val();
                    search = $("#search").val();
                    console.log("Entered: " + search);
                    if(clickedradio==="people") {
                        $.get('../AutoComplete', {keyword: search}, function(responseText) {
                            console.log("BITCH PLS");
                            console.log(responseText);
                            sugg = responseText.split("\n");
                            console.log(sugg);
                            $("#search").autocomplete({
                                source: sugg
                            });
                        });
                    }
                    else {
                        $.get('../AutoCompleteGroup', {keyword: search,userid:<%=Bean.getID()%>}, function(responseText) {
                            console.log("BITCH PLS");
                            console.log(responseText);
                            sugg2 = responseText.split("\n");
                            console.log(sugg);
                            $("#search").autocomplete({
                                source: sugg2
                            });
                        });
                    }
                });
            
	});
	</script>
</head>
<body>

<div id="header">
            <form id="myradio" action="../SearchServlet" method="GET">
                 <span id="left-header">
                     <img id="icon" src="../design/Icon.png"/>
                     <input id="search" name="searchInput" type="text" placeholder="Search" style="color: black">     

                     <span id="radios">
                         <input type="radio" name="t" value="people" checked="checked" class="radio">People
                         <input type="radio" name="t" value="group" class="radio">Group
                     </span>
                 </span>
             </form>

            <span id="right-header">
                <button id="user"> <%=Bean.getFirstName()%> <%=Bean.getLastName()%></button>
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
</div>
    
</div>
	
</div>

<!---
<div id="footer">
</div>
-->

</body>
</html>
