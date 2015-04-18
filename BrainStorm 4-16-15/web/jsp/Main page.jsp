<%@page import="Bean.Project"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.Idea"%>
<%@page import="Bean.UserBean"%>
<%@page import="Bean.Topic"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
        <%    
            HttpSession s = request.getSession();
            Project Bean = (Project ) s.getAttribute("project");
            UserBean u = (UserBean) s.getAttribute("user");
            ArrayList<Topic> topics = Bean.getTopics();
            Group g = (Group)s.getAttribute("group");
        %>
        
	<title><%=Bean.getName()%> under <%=g.getGroupName()%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="all" href="../css/Main Style.css"/>
	<link rel="shortcut icon" href="../design/Tab Icon.png"/>
	<script type="text/javascript" src="../others/jquery.min.js"></script>
	<script type="text/javascript" src="../others/brainstorm_func.js"></script>
	   
        <script>
	$(document).ready(function(){
            var Idea = function (firstName, lastName, topic, idea , id, time , agree, disagree,comments) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.topic = topic;
                this.idea = idea;
                this.ideaid = id;
                this.time = time;
                this.agree=agree;
                this.disagree=disagree;
                this.commentnum = comments;

                this.getCommentNum = function () {
                return this.commentnum;
                };

                this.getAgree = function () {
                return this.agree;
                };

                this.getDisagree = function () {
                return this.disagree;
                };

                this.getideaid = function () {
                return this.ideaid;
                };

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
            reloadCollection();
            
            function reloadCollection() {

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
                    "<%=tpc.getName()%>", "<%=ideas.get(cnt).getIdea()%>", <%=ideas.get(cnt).getIdeaID()%>, "<%=ideas.get(cnt).getTime()%>",<%=ideas.get(cnt).getAgreeCount()%> ,<%=ideas.get(cnt).getDisagreeCount()%>,<%=ideas.get(cnt).getComments().size()%>);
                <%
                    }        
                }
                %>
            }
                
            function reloadIdeas(topic) {
                $(".box").remove();
                if(topic === "All Topics"){
                    console.log("* TOPIC SELECT - ALL");
                    for(var cont = 0; cont < icollection.length; cont++)
                        appendIdea(cont);
                }
                else {
                    console.log("* TOPIC SELECT - OTHERS");
                    for(var i = 0; i < icollection.length; i++)
                        if(icollection[i].getTopic() == topic)
                            appendIdea(i);
                }
            } 
            
            function appendIdea(cont) {
                console.log("   append" + cont);
                $("#ideas").append(
                "<div class=\"box\"  id ="+ icollection[cont].getideaid()+">"+
                "<div id=\"b-head\">"+
                "<span id=\"maker\">" + icollection[cont].getfirstName() +" "+ icollection[cont].getlastName()+ "</span>"+
                "<span id=\"date-time\"> "+icollection[cont].getTime() +"</span>" +
                "<span id=\"b-topic\">"+ icollection[cont].getTopic() +"</span>" +
                "</div>" +
                "<div id=\"content\">"+ icollection[cont].getIdea()+"</div>" +
                "<div id=\"b-footer\">"+
                "<span id=\"comments\">"+icollection[cont].getCommentNum()+"</span> Comments"+
                "<span id=\"agree\">"+ icollection[cont].getAgree()+"</span> Agrees"+
                "<span id=\"disagree\">"+icollection[cont].getDisagree()+"</span> Disagrees"+
                "</div>"
                );
            }
            
            function sortIdeas(sortType) {
                if(sortType == "Latest") {
                    icollection.sort(function(a, b) {
                        return (b.getideaid() - a.getideaid());
                    });
                    console.log("   sorted latest");
                }
                else if(sortType == "Most Approves") {
                    icollection.sort(function(a, b) {
                        return ((b.getAgree() - b.getDisagree()) - (a.getAgree() - a.getDisagree()));
                    });
                    console.log("   sorted most agree");
                }
            }
              
            /* JQUERY */
             
            $(document).on("click","#add", function(){
                window.location.href = "Post Page.jsp";
            });
            $(document).on("click","#user", function(){
                window.location.href = "Edit Profile Page.jsp";
            });
            
            $(document).on("click","#logout", function(){
                alert("You will be logged out. Please sign in again.");
                window.location.href = "Log In and Sign Up.html";
            });
            $(document).on("click","#icon", function(){
                window.location.href = "../ToHomePageServlet";
            });
            
            $(document).on("change", ".title-select", function(){
                var topicSelected = $("#topicselector option:selected").text();
                var sortSelected = $("#sortselector option:selected").text();
                console.log("* IN SELECT CHANGE - " + topicSelected + ", " + sortSelected);
                sortIdeas(sortSelected);
                reloadIdeas(topicSelected, sortSelected);
            });
            
            sortIdeas("Latest");
            reloadIdeas("All Topics");
            console.log("* IDEAS RELOADED - ");

            $(document).on("click", ".box", function(){
                var status = $(this).attr('id'); 
                console.log(status);
                window.location.href = "../MainIdeaServlet?id="+status;
            });
	});
	</script>
</head>
<body>

<div id="bg">

<div id="header">
	<span id="left-header">
		<img id="icon" src="../design/Icon.png"/>
		<span id="group"><%=g.getGroupName()%></span>
		<input id="search" type="text" placeholder="Search" style="color: black">
	</span>
	
	<span id="right-header">
		<button id="user"><%=u.getFirstName()%> <%=u.getLastName()%></button>
		<span id="line"></span>
		<button id="logout">Log Out</button>
	</span>
</div>

<div id="title-head">
	<span id="title-project"><%=Bean.getName()%></span>
		
	<span id="view" class="title-right">View 
		<select class="title-select" id="topicselector">
			<option>All Topics</option>
		</select>
	</span>
	<span id="sort" class="title-right">Sort by 
		<select class="title-select" id="sortselector">
			<option>Latest</option>
			<option>Most Approves</option>
		</select>
	</span>
	<span id="add">+</span>
</div>

<div id="ideas" align="center">
	</div>
        
</div>
</body>
</html>
