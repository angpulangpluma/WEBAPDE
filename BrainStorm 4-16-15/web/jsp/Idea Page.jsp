<%@page import="Bean.Group"%>
<%@page import="Bean.Member"%>
<%@page import="Bean.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Idea"%>
<%@page import="Bean.IdeaPageBean"%>
<%@page import="Bean.UserBean"%>
<html>
<head>
	<title>Team Nerds</title>
	<link rel="stylesheet" type="text/css" media="all" href="../css/Idea Style.css"/>
	<script type="text/javascript" src="../others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui.1.11.4.css"/>
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
        <link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script>
          <%
              UserBean u = (UserBean) session.getAttribute("user");
              session = request.getSession();
              IdeaPageBean Bean = (IdeaPageBean)session.getAttribute("idea");
              Idea idea = Bean.getIdea();
              Member user = idea.getUser();
              ArrayList<Comment> comments = idea.getComments();
              Group g = (Group)session.getAttribute("group");
          %>
            
            
	$(document).ready(function(){

		$("#user").click(function(){
			window.location.href = "Edit Profile Page.jsp";
		});
		$("#logout").click(function(){
			alert("You will be logged out. Please sign in again.");
                        window.location.href = "../LogOutServlet";
		});
		$("#icon").click(function(){
			window.location.href = "../ToHomePageServlet";
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
                
                var sugg2=[];
            var sugg=[];
                $("#search").keyup(function() {
                    var clickedradio = $("input:radio[name ='t']:checked").val();
                    search = $("#search").val();
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
                        $.get('../AutoCompleteGroup', {keyword: search,userid:<%=u.getID()%>}, function(responseText) {
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
                     <span id="group"><%=g.getGroupName()%></span>
                     <input id="search" name="searchInput" type="text" placeholder="Search" style="color: black">     

                     <span id="radios">
                         <input type="radio" name="t" value="people" checked="checked" class="radio">People
                         <input type="radio" name="t" value="group" class="radio">Group
                     </span>
                 </span>
             </form>

            <span id="right-header">
                <button id="user"> <%=u.getFirstName()%> <%=u.getLastName()%></button>
                <span id="line"></span>
                
                <button id="logout">Log Out</button>
                
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
                    
		</div>
		<div id="write">
			<textarea id="text-comment" placeholder="Write your comment here.."></textarea>
			<input id="button-comment" type="button" value="Post"/>
		</div>
	</div>
</div>


</body>
</html>
