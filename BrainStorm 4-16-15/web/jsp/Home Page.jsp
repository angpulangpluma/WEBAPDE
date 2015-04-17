<%@page import="Bean.Notification"%>
<%@page import="Bean.Member"%>
<%@page import="Bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.UserBean"%>
<html>
    <head>
        <title>BrainStorm</title>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta content="utf-8" http-equiv="encoding">
        <script type="text/javascript" src="../others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui.1.11.4.css"/>
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
        <link rel="shortcut icon" href="../design/Tab Icon.png"/>
        <link rel="stylesheet" type="text/css" media="all" href="../css/Home Style.css"/>
        <script type="text/javascript" src="../others/brainstorm_func.js"></script>



        <%
            UserBean Bean = (UserBean) session.getAttribute("user");
            HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
            ArrayList<Group> groups = pagebean.getGroups();
            ArrayList<Notification> notifs = pagebean.getNotifs();
            int gnumber = groups.size();

        %>      
        <script>



            $(document).ready(function() {

                var currGroup = "0";
                var pageShow, pageHide, pageHide1, pageHide2;
                var groupname = "#" + currGroup;
                var search;
                var sugg = [];
                var groupids=[];
                
               <% for (int i = 0; i < groups.size(); i++) { %>
                groupids[<%=i%>] = <%=groups.get(i).getID()%> ;
                <%}%>
/*
                $("#search").keyup(function() {
                    search = $("#search").val();
                    console.log("key Up");
                    $.get('../AutoComplete', {keyword: search}, function(responseText) {
                        console.log("BITCH PLS");
                        console.log(responseText);
                        sugg = responseText.split("\n");
                        console.log(sugg);
                    });

                    $("#search").autocomplete({
                        source: sugg
                    });

                });
*/


                $('#selectedgroup').text($(groupname).text());

                for (var cont = 0; cont < <%=gnumber%>; cont++) {
                    $("#grp-projects-page-" + cont).hide();
                    $("#grp-members-page-" + cont).hide();
                }
                if (<%=gnumber%> > 0)
                    $("#grp-projects-page-0").show();


                $("#user").click(function() {
                    window.location.href = "Edit Profile Page.jsp";
                });
                $("#home").click(function() {
                    window.location.href = "Home Page.html";
                });
                $("#logout").click(function() {
                    alert("You will be logged out. Please sign in again.");
                    window.location.href = "../LogOutServlet";
                });
                $("#icon").click(function() {
                    window.location.href = "../ToHomePageServlet";
                });
                $("#grp-name").click(function() {
                    window.location.href = "Main Page.html";
                });

                //	$(".proj-name").click(function(){
                //		window.location.href = "Main Page.html";
                //	});
                $("#grp-projects").click(function() {
                    pageHide = "#grp-members-page-" + currGroup;
                    pageShow = "#grp-projects-page-" + currGroup;
                    $(pageHide).hide();
                    $(pageShow).show();
                });
                $("#grp-members").click(function() {
                    pageHide = "#grp-projects-page-" + currGroup;
                    pageShow = "#grp-members-page-" + currGroup;
                    $(pageHide).hide();
                    $(pageShow).show();
                });
                $(".group").click(function() {
                    pageHide1 = "#grp-projects-page-" + currGroup;
                    pageHide2 = "#grp-members-page-" + currGroup;
                    pageShow = "#grp-projects-page-" + $("#grp-list").val();
                    $(pageHide1).hide();
                    $(pageHide2).hide();
                    $(pageShow).show();
                    currGroup = $("#grp-list").val();
                    console.log("CURR GROUP IS " + currGroup);
                    groupname = "#" + currGroup;


                    $('#selectedgroup').text($(groupname).text());
                    // document.getElementById("selectedgroup").textContent=          
                });


                var numberofgroups = <%=groups.size()%>;
                var addgroupflag = 1;
                //$("#newgroupname").hide();


                $("#addgroup").click(function() {
/*
                    if (addgroupflag === 1) {
                        addgroupflag = 0;
                        $("#addgroup").text("Save Group");
                        $("#newgroupname").show();
                    }

                    else if (addgroupflag === 0) {

*/
                        if ($("#newgroupname").val().length === 0) {
                            alert("Please enter groupname");
                        } else {
                            var newgroupname = $("#newgroupname").val();
                            $("#addgroup").text("Add Group");
                            $("#newgroupname").val("");
                            $("#newgroupname").hide();
                            addgroupflag = 1;
                            $.get('../AddGroupServlet', {name: newgroupname}, function(responseText) {
                                
                                    var num3 = responseText;
                                   groupids [groupids.length] = num3;
                                    console.log("NEW NUM IS "+groupids );
                                $("#grp-list").append(
                                        "<option id=\"" + numberofgroups + "\" class=\"group\" value=\"" + numberofgroups + "\">" + newgroupname +
                                        " </option> "
                                        );

                                $("#grp-page").append(
                                        "<div id=\"grp-projects-page-" + numberofgroups + "\"> " +
                                        "</div>"
                                        );

                                $("#grp-page").append(
                                        "<div id=\"grp-members-page-" + numberofgroups + "\"> " +
                                        "<div class=\"grp-box\">" +
                                        "<a href=\"\" class=\"proj-name\"> <%= Bean.getFirstName()%> <%=Bean.getLastName()%></a>" +
                                        "</div>" +
                                        "</div>"
                                        );

                                pageHide1 = "#grp-projects-page-" + numberofgroups;
                                pageHide2 = "#grp-members-page-" + numberofgroups;
                                $(pageHide1).hide();
                                $(pageHide2).hide();

                                numberofgroups++;
                                $('#grp-list').attr('size', numberofgroups);
                                $(".group").click(function() {
                                    pageHide1 = "#grp-projects-page-" + currGroup;
                                    pageHide2 = "#grp-members-page-" + currGroup;
                                    pageShow = "#grp-projects-page-" + $("#grp-list").val();
                                    $(pageHide1).hide();
                                    $(pageHide2).hide();
                                    $(pageShow).show();
                                    currGroup = $("#grp-list").val();
                                    console.log("CURR GROUP IS " + currGroup);
                                    groupname = "#" + currGroup;
                                    
                                    $('#selectedgroup').text($(groupname).text());
                                    // document.getElementById("selectedgroup").textContent=          
                                });



                            });

                        //}
                    }

                    $(".group").click(function() {
                        pageHide1 = "#grp-projects-page-" + currGroup;
                        pageHide2 = "#grp-members-page-" + currGroup;
                        pageShow = "#grp-projects-page-" + $("#grp-list").val();
                        $(pageHide1).hide();
                        $(pageHide2).hide();
                        $(pageShow).show();
                        currGroup = $("#grp-list").val();
                        console.log("CURR GROUP IS " + currGroup);
                        groupname = "#" + currGroup;

                        $('#selectedgroup').text($(groupname).text());
                        // document.getElementById("selectedgroup").textContent=          
                    });

                });

                
                var sugg2=[];
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
               
                $("#addproject").click(function() {
                    var newproject = $("#newproject").val();
                    if(newproject.length ===0 )
                        alert("Please Entername first");
                    else if( groupids.length ===0  )
                        alert("Create Group First");
                    else {
                        $.get('../AddProjectServlet', { groupid :groupids[currGroup],name:newproject}, function(responseText) {
                           var maxid = responseText;
                           $("#grp-projects-page-"+currGroup).append(" <div class=\"grp-box\"><a href=\"../IdeaPageServlet?id="+maxid+"\"class=\"proj-name\">"+ newproject+"</a></div>");
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
                <span class="adders" id="groupadder">
                    <input id="newgroupname" class="adder-input" type="text">
                    <span class="adder-text" id="addgroup">Add Group</span>
                </span>
                <div id="groups">
                    
                    <select id="grp-list" size="<%=groups.size()%>">

                        <%
                            //System.out.println("<--->" + groups.size());
                            for (int i = 0; i < groups.size(); i++) {
                               
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
                        
                      <!--span id="addproject"> Add Project </span> <input type="text" id="newproject"-->
                        <div id="adder" class="adders">
                            <input id="newproject" class="adder-input" type="text">
                            <span class="adder-text" id="addproject">Add Project</span>
                        </div><br/>
                        
                        <!-- when 'projects' tab is clicked -->

                        <%
                            ArrayList<Member> members;
                            Member m;
                            Group g;
                            ArrayList<Project> proj;
                            for (int c = 0; c < groups.size(); c++) {
                                g = groups.get(c);
                                proj = g.getProjects();


                        %>
                        <div id="grp-projects-page-<%=c%>">

                            <%
                                for (Project p : proj) {
                            %>
                            <div class="grp-box">
                                <a  href="../IdeaPageServlet?projid=<%=p.getID()%>&grpid=<%=g.getID()%>" class="proj-name"><%=p.getName()%></a>
                                <div class="proj-ideas"><%=p.getIdeaCount()%></div>
                            </div>
                            <%
                                }
                            %>
                        </div>                      
                        <!-- when 'members' tab is clicked -->
                        <div id="grp-members-page-<%=c%>">                                                 
                            <%
                                members = g.getMembers();

                                for (int count = 0; count < members.size(); count++) {
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
                    <%for(Notification notif:notifs ){ %>  
                        <div class="box">  
                            <div id="content">
                                <span id="notif-user"><%=notif.getNotifUser().getFirstName()%> <%=notif.getNotifUser().getLastName()%></span>
                                <%=notif.getNotif()%>
                                <span id="notif-proj"></span> 
                                <span id="notif-topic"></span>
                            </div>
                            <div id="date-time"><%=notif.getNotifTime()%></div>
                        </div>
                    <%} %>
                    
                    
                    <!--
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
                    -->
                </div>

            </div>

            <!---
            <div id="footer">
            </div>
            -->

    </body>
</html>
