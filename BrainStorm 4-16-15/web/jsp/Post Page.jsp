<%@page import="Bean.Group"%>
<%@page import="Bean.Project"%>
<%@page import="Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Topic"%>
<html>
<head>
    <%
             HttpSession s = request.getSession();
             Project Bean = (Project ) s.getAttribute("project");
             ArrayList<Topic> topics = Bean.getTopics();
             UserBean ub = (UserBean)s.getAttribute("user");
             Group g = (Group) session.getAttribute("group");
              Project p = (Project) session.getAttribute("project");
         %>
	<title>Idea of <%=p.getName()%> under <%=g.getGroupName()%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="all" href="../css/Post Style.css"/>
	<script type="text/javascript" src="../others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui.1.11.4.css"/>
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
        <link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script type="text/javascript" src="../others/brainstorm_func.js"></script>
	<script>
            
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
		
		$("#user").click(function(){
			window.location.href = "Edit Profile Page.html";
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
                        $.get('../AutoCompleteGroup', {keyword: search,userid:<%=ub.getID()%>}, function(responseText) {
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
            <form id="myradio" action="../SearchServlet" method="GET">
                 <span id="left-header">
                     <img id="icon" src="../design/Icon.png"/>
                     <span id="group"><%=g.getGroupName()%></span>
                     <input id="search" name="searchInput" type="text" placeholder="Search" style="color: black">     

                     <span id="radios">
                         <input type="radio" name="t" value="people" checked="checked" class="radio">People
                         <input type="radio" name="t" value="group" class="radio">Group
                     </span>
                 </span>
             </form>

            <span id="right-header">
                <button id="user"> <%=ub.getFirstName()%> <%=ub.getLastName()%></button>
                <span id="line"></span>
                <button id="home">Home</button>
                <span id="line"></span>
                <button id="logout">Log Out</button>
   
            </span>
        </div>


</div>
</body>
</html>

