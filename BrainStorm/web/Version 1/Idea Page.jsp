<%@page import="Bean.Member"%>
<%@page import="Bean.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Idea"%>
<%@page import="Bean.IdeaPageBean"%>
<%@page import="Bean.UserBean"%>
<html>
<head>
	<title>Team Nerds</title>
	<link rel="stylesheet" type="text/css" media="all" href="Idea Style.css"/>
	<link rel="shortcut icon" href="Tab Icon.png"/>
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>-->
        <script type="text/javascript" src="jquery.min.js"></script>
	<script>
          <%
              UserBean u = (UserBean) session.getAttribute("user");
              session = request.getSession();
              IdeaPageBean Bean = (IdeaPageBean)session.getAttribute("idea");
              Idea idea = Bean.getIdea();
              Member user = idea.getUser();
              ArrayList<Comment> comments = idea.getComments();
          %>
            
            
	$(document).ready(function(){
		$("#group").click(function(){
			window.location.href = "Main Page.html";
		});
		$("#user").click(function(){
			window.location.href = "Edit Profile Page.jsp";
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
                $("#button-comment").click(function(){
			var commenttext = $("#text-comment").val();
                        $.post('../CommentServlet',{text:commenttext,userid: <%=user.getId()%>, topicid: <%= idea.getIdeaID() %>},function(responseText) { 
                        
                        $("#comments").append(
                          "<div class=\"comment\"> "+
                           " <span id=\"comment-user\"><%=user.getFirstName()%> <%=user.getLastName()%></span> "+
                           " <span id=\"comment-date-time\">"+ responseText+" </span><br/>" +
                           "<span id=\"comment-content\">"+ commenttext+" </span>"+
                            "</div>"
                        );
                       var numberofcomments =  $("#agree-num").text();
                       numberofcomments++;
                       $("#comments-num").text(numberofcomments);
                       $("#text-comment").val("");
                        
                    });       
		});
                
                var flag = <%=Bean.getRating()%> ;
                // flag = 0 dislike flag=1 like flag -1 undecided
               console.log("FLAG IS "+flag);
                $("#agree").text("Agree");
                $("#disagree").text("Disagree");
                
                if(flag === 1){
                     $("#agree").text("Agreed");
                 }
                
                if(flag === 0){
                    $("disagree").text("Disagreed");
                }   
                    
                $("#agree").click(function(){
                 
                 if(flag === 1){
                      $.post('../RatingServlet',{rate: -1, userid: <%=user.getId()%>, topicid: <%= idea.getIdeaID() %>},function(responseText) {     
                            var rat = responseText.split(",");
                            console.log(rat);
                            $("#agree-num").text(rat[0]);
                            $("#disagree-num").text(rat[1]);
                            flag= 1;
                            $("#agree").text("Agree");
                            $("#disagree").text("Disagree");
                        });      
                 }
                else{
                        $.post('../RatingServlet',{rate: 1, userid: <%=user.getId()%>, topicid: <%= idea.getIdeaID() %>},function(responseText) {     
                            var rat = responseText.split(",");
                            console.log(rat);
                            $("#agree-num").text(rat[0]);
                            $("#disagree-num").text(rat[1]);
                            flag= 1;
                            $("#agree").text("Agreed");
                            $("#disagree").text("Disagree");
                        });      
                    } 
                });
                
               
                $("#disagree").click(function(){
                    if(flag ===0 ){
                      $.post('../RatingServlet',{rate: -1, userid: <%=user.getId()%>, topicid: <%= idea.getIdeaID() %>},function(responseText) {     
                            var rat = responseText.split(",");
                            console.log(rat);
                            $("#agree-num").text(rat[0]);
                            $("#disagree-num").text(rat[1]);
                            flag= 1;
                            $("#agree").text("Agree");
                            $("#disagree").text("Disagree");
                        });      
                     
                    }
                     
                    else{
                        $.post('../RatingServlet',{rate: 0, userid: <%=user.getId()%>, topicid: <%= idea.getIdeaID() %>},function(responseText) {     
                            var rat = responseText.split(",");
                            console.log(rat);
                            $("#agree-num").text(rat[0]);
                            $("#disagree-num").text(rat[1]);
                            flag=0;
                            $("#agree").text("Agree");
                            $("#disagree").text("Disagreed");
                        });      
                    } 
               
                });
                
                
                
	});
	</script>
</head>
<body>
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
            <button id="user"><%=user.getFirstName()%> <%=user.getLastName()%></button>
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

<div id="idea" align="center">
	<div class="box">
		<div id="b-head">
			<span id="maker"><%=user.getFirstName()%> <%=user.getLastName()%></span>
			<span id="date-time"> <%=idea.getTime()%></span>
			<span id="b-topic"><%=idea.getTopicname()%></span>
		</div>
		<!--<div id="title">This is an Idea</div>-->
		<div id="content"> <%=idea.getIdea()%> </div>
		<div id="b-footer">
                    
                       
			<span id="comments-num"><%=comments.size()%></span> Comments
			<span id="agree-num"> <%= idea.getAgreeCount() %> </span> Agrees
			<span id="disagree-num"><%=idea.getDisagreeCount()%></span> Disagrees___    <span id="agree"></span>
                        <span id="disagree"</span>
                        
                        
		</div>
		<div id="comments">
			<%for(int crt=0; crt <comments.size(); crt++ ){  %>
                        <div class="comment">
                            <span id="comment-user"><%=comments.get(crt).getCommentUser().getFirstName()%> <%=comments.get(crt).getCommentUser().getLastName()%></span>
                            <span id="comment-date-time"><%= comments.get(crt).getTime()%> </span><br/>
				<span id="comment-content"><%=comments.get(crt).getCommentDesc()%></span>
			</div>
                        <%}%>
                    <!--
			<div class="comment">
				<span id="comment-user">Hannah Sibayan</span>
				<span id="comment-date-time">1:55pm</span><br/>
				<span id="comment-content">Nice nice nice!</span>
			</div>
                    -->
		</div>
		<div id="write">
			<textarea id="text-comment" placeholder="Write your comment here.."></textarea>
			<input id="button-comment" type="button" value="Post"/>
		</div>
	</div>
</div>

<!--
<div id="footer">
</div>
-->
</body>
</html>
