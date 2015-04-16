<%@page import="Bean.Member"%>
<%@page import="Bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Group"%>
<%@page import="Bean.HomePageBean"%>
<%@page import="Bean.UserBean"%>
<html>
<head>
	<title>Brainstorm</title>
	
        <script type="text/javascript" src="others/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="../others/jquery-ui-1.11.4.css"/> 
        <script type="text/javascript" src="../others/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../others/jquery-ui.1.11.4.js"></script>
	<link rel="shortcut icon" href="../design/Tab Icon.png"/> 
        <script type="text/javascript" src="../others/brainstorm_func.js"></script>

        <script>
            
            
            
	$(document).ready(function(){
                    
                var currGroup = "0";
                var pageShow, pageHide, pageHide1, pageHide2;
                var groupname="#"+currGroup;
                var search;
                var availableTags = [
                "ActionScript",
                "AppleScript",
                "Asp",
                "BASIC",
                "C",
                "C++",
                "Clojure",
                "COBOL",
                "ColdFusion",
                "Erlang",
                "Fortran",
                "Groovy",
                "Haskell",
                "Java",
                "JavaScript",
                "Lisp",
                "Perl",
                "PHP",
                "Python",
                "Ruby",
                "Scala",
                "Scheme"
                ];

 
                $("#search").keyup(function(){
                    search = $("#search").val();
                     console.log("key Up");
                    $.get('please',{keyword:search},function(responseText) { 
                        console.log("BITCH PLS");
                        console.log(responseText);     
                    });       
                });
                
                $( "#search" ).autocomplete({
                source: availableTags
                });
                
                
                
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
               
        
                $('#search2').keyup(function(event) {  
                    var username=$('#search2').val();
                    console.log('hello');
                $.get('../please',{user:username},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
	});
	</script>
</head>
<body>

<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="search2"/>
<input type="button" id="submit" value="Ajax Submit"/>
<br/>
<div id="welcometext">
</div>
</form>
     

       
<!---
<div id="footer">
</div>
-->

</body>
</html>
