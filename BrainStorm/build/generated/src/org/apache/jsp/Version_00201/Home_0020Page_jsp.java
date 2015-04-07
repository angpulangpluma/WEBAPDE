package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.Notification;
import Bean.Member;
import Bean.Project;
import java.util.ArrayList;
import Bean.Group;
import Bean.HomePageBean;
import Bean.UserBean;

public final class Home_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Brainstorm</title>\r\n");
      out.write("        <meta content=\"text/html;charset=utf-8\" http-equiv=\"Content-Type\">\r\n");
      out.write("        <meta content=\"utf-8\" http-equiv=\"encoding\">\r\n");
      out.write("        <!--<script src=\"http://code.jquery.com/jquery-latest.js\"></script>-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery-latest.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"jquery-ui-1.11.4.css\"/>\r\n");
      out.write("        \r\n");
      out.write("        <!--<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery-1.10.2.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <!--<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery-ui.1.11.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Home Style.css\"/>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

            UserBean Bean = (UserBean) session.getAttribute("user");
            HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
            ArrayList<Group> groups = pagebean.getGroups();
            ArrayList<Notification> notifs = pagebean.getNotifs();
            int gnumber = groups.size();

        
      out.write("      \r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("                var currGroup = \"0\";\r\n");
      out.write("                var pageShow, pageHide, pageHide1, pageHide2;\r\n");
      out.write("                var groupname = \"#\" + currGroup;\r\n");
      out.write("                var search;\r\n");
      out.write("                var sugg = [];\r\n");
      out.write("                var groupids=[];\r\n");
      out.write("                \r\n");
      out.write("               ");
 for (int i = 0; i < groups.size(); i++) { 
      out.write("\r\n");
      out.write("                groupids[");
      out.print(i);
      out.write("] = ");
      out.print(groups.get(i).getID());
      out.write(" ;\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("/*\r\n");
      out.write("                $(\"#search\").keyup(function() {\r\n");
      out.write("                    search = $(\"#search\").val();\r\n");
      out.write("                    console.log(\"key Up\");\r\n");
      out.write("                    $.get('../AutoComplete', {keyword: search}, function(responseText) {\r\n");
      out.write("                        console.log(\"BITCH PLS\");\r\n");
      out.write("                        console.log(responseText);\r\n");
      out.write("                        sugg = responseText.split(\"\\n\");\r\n");
      out.write("                        console.log(sugg);\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    $(\"#search\").autocomplete({\r\n");
      out.write("                        source: sugg\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("*/\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("\r\n");
      out.write("                for (var cont = 0; cont < ");
      out.print(gnumber);
      out.write("; cont++) {\r\n");
      out.write("                    $(\"#grp-projects-page-\" + cont).hide();\r\n");
      out.write("                    $(\"#grp-members-page-\" + cont).hide();\r\n");
      out.write("                }\r\n");
      out.write("                if (");
      out.print(gnumber);
      out.write(" > 0)\r\n");
      out.write("                    $(\"#grp-projects-page-0\").show();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                $(\"#user\").click(function() {\r\n");
      out.write("                    window.location.href = \"Edit Profile Page.jsp\";\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#home\").click(function() {\r\n");
      out.write("                    window.location.href = \"Home Page.html\";\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#logout\").click(function() {\r\n");
      out.write("                    alert(\"You will be logged out. Please sign in again.\");\r\n");
      out.write("                    window.location.href = \"../LogOutServlet\";\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#icon\").click(function() {\r\n");
      out.write("                    window.location.href = \"../ToHomePageServlet\";\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#grp-name\").click(function() {\r\n");
      out.write("                    window.location.href = \"Main Page.html\";\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                //\t$(\".proj-name\").click(function(){\r\n");
      out.write("                //\t\twindow.location.href = \"Main Page.html\";\r\n");
      out.write("                //\t});\r\n");
      out.write("                $(\"#grp-projects\").click(function() {\r\n");
      out.write("                    pageHide = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                    pageShow = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                    $(pageHide).hide();\r\n");
      out.write("                    $(pageShow).show();\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#grp-members\").click(function() {\r\n");
      out.write("                    pageHide = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                    pageShow = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                    $(pageHide).hide();\r\n");
      out.write("                    $(pageShow).show();\r\n");
      out.write("                });\r\n");
      out.write("                $(\".group\").click(function() {\r\n");
      out.write("                    pageHide1 = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                    pageHide2 = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                    pageShow = \"#grp-projects-page-\" + $(\"#grp-list\").val();\r\n");
      out.write("                    $(pageHide1).hide();\r\n");
      out.write("                    $(pageHide2).hide();\r\n");
      out.write("                    $(pageShow).show();\r\n");
      out.write("                    currGroup = $(\"#grp-list\").val();\r\n");
      out.write("                    console.log(\"CURR GROUP IS \" + currGroup);\r\n");
      out.write("                    groupname = \"#\" + currGroup;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("                    // document.getElementById(\"selectedgroup\").textContent=          \r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                var numberofgroups = ");
      out.print(groups.size());
      out.write(";\r\n");
      out.write("                var addgroupflag = 1;\r\n");
      out.write("                $(\"#newgroupname\").hide();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                $(\"#addgroup\").click(function() {\r\n");
      out.write("\r\n");
      out.write("                    if (addgroupflag === 1) {\r\n");
      out.write("                        addgroupflag = 0;\r\n");
      out.write("                        $(\"#addgroup\").text(\"Save Group\");\r\n");
      out.write("                        $(\"#newgroupname\").show();\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    else if (addgroupflag === 0) {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        if ($(\"#newgroupname\").val().length === 0) {\r\n");
      out.write("                            alert(\"Please enter groupname\");\r\n");
      out.write("                        } else {\r\n");
      out.write("                            var newgroupname = $(\"#newgroupname\").val();\r\n");
      out.write("                            $(\"#addgroup\").text(\"Add Group\");\r\n");
      out.write("                            $(\"#newgroupname\").val(\"\");\r\n");
      out.write("                            $(\"#newgroupname\").hide();\r\n");
      out.write("                            addgroupflag = 1;\r\n");
      out.write("                            $.get('../AddGroupServlet', {name: newgroupname}, function(responseText) {\r\n");
      out.write("                                \r\n");
      out.write("                                    var num3 = responseText;\r\n");
      out.write("                                   groupids [groupids.length] = num3;\r\n");
      out.write("                                    console.log(\"NEW NUM IS \"+groupids );\r\n");
      out.write("                                $(\"#grp-list\").append(\r\n");
      out.write("                                        \"<option id=\\\"\" + numberofgroups + \"\\\" class=\\\"group\\\" value=\\\"\" + numberofgroups + \"\\\">\" + newgroupname +\r\n");
      out.write("                                        \" </option> \"\r\n");
      out.write("                                        );\r\n");
      out.write("\r\n");
      out.write("                                $(\"#grp-page\").append(\r\n");
      out.write("                                        \"<div id=\\\"grp-projects-page-\" + numberofgroups + \"\\\"> \" +\r\n");
      out.write("                                        \"</div>\"\r\n");
      out.write("                                        );\r\n");
      out.write("\r\n");
      out.write("                                $(\"#grp-page\").append(\r\n");
      out.write("                                        \"<div id=\\\"grp-members-page-\" + numberofgroups + \"\\\"> \" +\r\n");
      out.write("                                        \"<div class=\\\"grp-box\\\">\" +\r\n");
      out.write("                                        \"<a href=\\\"\\\" class=\\\"proj-name\\\"> ");
      out.print( Bean.getFirstName());
      out.write(' ');
      out.print(Bean.getLastName());
      out.write("</a>\" +\r\n");
      out.write("                                        \"</div>\" +\r\n");
      out.write("                                        \"</div>\"\r\n");
      out.write("                                        );\r\n");
      out.write("\r\n");
      out.write("                                pageHide1 = \"#grp-projects-page-\" + numberofgroups;\r\n");
      out.write("                                pageHide2 = \"#grp-members-page-\" + numberofgroups;\r\n");
      out.write("                                $(pageHide1).hide();\r\n");
      out.write("                                $(pageHide2).hide();\r\n");
      out.write("\r\n");
      out.write("                                numberofgroups++;\r\n");
      out.write("                                $('#grp-list').attr('size', numberofgroups);\r\n");
      out.write("                                $(\".group\").click(function() {\r\n");
      out.write("                                    pageHide1 = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                                    pageHide2 = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                                    pageShow = \"#grp-projects-page-\" + $(\"#grp-list\").val();\r\n");
      out.write("                                    $(pageHide1).hide();\r\n");
      out.write("                                    $(pageHide2).hide();\r\n");
      out.write("                                    $(pageShow).show();\r\n");
      out.write("                                    currGroup = $(\"#grp-list\").val();\r\n");
      out.write("                                    console.log(\"CURR GROUP IS \" + currGroup);\r\n");
      out.write("                                    groupname = \"#\" + currGroup;\r\n");
      out.write("                                    \r\n");
      out.write("                                    $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("                                    // document.getElementById(\"selectedgroup\").textContent=          \r\n");
      out.write("                                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            });\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    $(\".group\").click(function() {\r\n");
      out.write("                        pageHide1 = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                        pageHide2 = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                        pageShow = \"#grp-projects-page-\" + $(\"#grp-list\").val();\r\n");
      out.write("                        $(pageHide1).hide();\r\n");
      out.write("                        $(pageHide2).hide();\r\n");
      out.write("                        $(pageShow).show();\r\n");
      out.write("                        currGroup = $(\"#grp-list\").val();\r\n");
      out.write("                        console.log(\"CURR GROUP IS \" + currGroup);\r\n");
      out.write("                        groupname = \"#\" + currGroup;\r\n");
      out.write("\r\n");
      out.write("                        $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("                        // document.getElementById(\"selectedgroup\").textContent=          \r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                var sugg2=[];\r\n");
      out.write("                $(\"#search\").keyup(function() {\r\n");
      out.write("                    var clickedradio = $(\"input:radio[name ='t']:checked\").val();\r\n");
      out.write("                    search = $(\"#search\").val();\r\n");
      out.write("                    \r\n");
      out.write("                    if(clickedradio===\"people\"){\r\n");
      out.write("                      \r\n");
      out.write("                    $.get('../AutoComplete', {keyword: search}, function(responseText) {\r\n");
      out.write("                        console.log(\"BITCH PLS\");\r\n");
      out.write("                        console.log(responseText);\r\n");
      out.write("                        sugg = responseText.split(\"\\n\");\r\n");
      out.write("                        console.log(sugg);\r\n");
      out.write("                       $(\"#search\").autocomplete({\r\n");
      out.write("                        source: sugg\r\n");
      out.write("                    });\r\n");
      out.write("                    });\r\n");
      out.write("                    \r\n");
      out.write("                        \r\n");
      out.write("                    }else{\r\n");
      out.write("                    $.get('../AutoCompleteGroup', {keyword: search,userid:");
      out.print(Bean.getID());
      out.write("}, function(responseText) {\r\n");
      out.write("                        console.log(\"BITCH PLS\");\r\n");
      out.write("                        console.log(responseText);\r\n");
      out.write("                        sugg2 = responseText.split(\"\\n\");\r\n");
      out.write("                        console.log(sugg);\r\n");
      out.write("                        $(\"#search\").autocomplete({\r\n");
      out.write("                        source: sugg2\r\n");
      out.write("                    });\r\n");
      out.write("                    });\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                    }\r\n");
      out.write("                \r\n");
      out.write("                });\r\n");
      out.write("               \r\n");
      out.write("                \r\n");
      out.write("                 $(\"#addproject\").click(function() {\r\n");
      out.write("                        var newproject = $(\"#newproject\").val();\r\n");
      out.write("                        \r\n");
      out.write("                        if(newproject.length ===0 ){\r\n");
      out.write("                        alert(\"Please Entername first\");\r\n");
      out.write("                        }\r\n");
      out.write("                        else if( groupids.length ===0  ){\r\n");
      out.write("                        alert(\"Create Group First\");\r\n");
      out.write("                        }\r\n");
      out.write("                        else{\r\n");
      out.write("                       $.get('../AddProjectServlet', { groupid :groupids[currGroup],name:newproject}, function(responseText) {\r\n");
      out.write("                           var maxid = responseText;\r\n");
      out.write("                \r\n");
      out.write("                           $(\"#grp-projects-page-\"+currGroup).append(\" <div class=\\\"grp-box\\\"><a href=\\\"../IdeaPageServlet?id=\"+maxid+\"\\\"class=\\\"proj-name\\\">\"+ newproject+\"</a></div>\");\r\n");
      out.write("                        });\r\n");
      out.write("        \r\n");
      out.write("                        }\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                    });\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("               <form id=\"myradio\" action=\"../SearchServlet\" method=\"GET\">\r\n");
      out.write("            <span id=\"left-header\">\r\n");
      out.write("                <img id=\"icon\" src=\"Icon.png\"/>\r\n");
      out.write("                <input id=\"search\" type=\"text\" placeholder=\"Search People\" style=\"color: black\">     \r\n");
      out.write("                \r\n");
      out.write("                <input type=\"radio\" name=\"t\" value=\"people\" checked=\"checked\">People\r\n");
      out.write("                <input type=\"radio\" name=\"t\" value=\"group\">Group\r\n");
      out.write("            </span>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            <span id=\"right-header\">\r\n");
      out.write("                <button id=\"user\"> ");
      out.print(Bean.getFirstName());
      out.write(' ');
      out.print(Bean.getLastName());
      out.write("</button>\r\n");
      out.write("                <span id=\"line\"></span>\r\n");
      out.write("                <button id=\"home\">Home</button>\r\n");
      out.write("                <span id=\"line\"></span>\r\n");
      out.write("                <button id=\"logout\">Log Out</button>\r\n");
      out.write("                <!---\r\n");
      out.write("                <select id=\"user-select\" class=\"h-select\">\r\n");
      out.write("                        <option>Settings</option>\r\n");
      out.write("                        <option>Log Out</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                -->\r\n");
      out.write("            </span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"center-content\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div id=\"groups-whole\">\r\n");
      out.write("\r\n");
      out.write("                <span class=\"titles\" id=\"grp-title\">Groups</span>\r\n");
      out.write("                <br/>\r\n");
      out.write("                <span class =\"titles\" id=\"addgroup\" >Add Group</span> <input id=\"newgroupname\" type=\"text\" >\r\n");
      out.write("                <div id=\"groups\">\r\n");
      out.write("                    \r\n");
      out.write("                    <select id=\"grp-list\" size=\"");
      out.print(groups.size());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                        ");

                            //System.out.println("<--->" + groups.size());
                            for (int i = 0; i < groups.size(); i++) {
                               
                        
      out.write("                  \r\n");
      out.write("                        <option id=\"");
      out.print(i);
      out.write("\" class=\"group\" value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(groups.get(i).getGroupName());
      out.write("\r\n");
      out.write("                        </option>          \r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("\r\n");
      out.write("                    <div id=\"grp-page\">\r\n");
      out.write("                        <div id=\"grp-header\">\r\n");
      out.write("                            <a id=\"grp-name\">\r\n");
      out.write("                                <span id=\"selectedgroup\">Team Nerds</span> \r\n");
      out.write("                            </a> <span id=\"grp-line\"></span>\r\n");
      out.write("                            <a id=\"grp-projects\">Projects</a> <span id=\"grp-line\"></span>\r\n");
      out.write("                            <a id=\"grp-members\">Members</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                      <span id=\"addproject\"> Add Project </span> <input type=\"text\" id=\"newproject\">\r\n");
      out.write("                        \r\n");
      out.write("                        <!-- when 'projects' tab is clicked -->\r\n");
      out.write("\r\n");
      out.write("                        ");

                            ArrayList<Member> members;
                            Member m;
                            Group g;
                            ArrayList<Project> proj;
                            for (int c = 0; c < groups.size(); c++) {
                                g = groups.get(c);
                                proj = g.getProjects();


                        
      out.write("\r\n");
      out.write("                        <div id=\"grp-projects-page-");
      out.print(c);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                            ");

                                for (Project p : proj) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"grp-box\">\r\n");
      out.write("                                <a  href=\"../IdeaPageServlet?id=");
      out.print(p.getID());
      out.write("\" class=\"proj-name\">");
      out.print(p.getName());
      out.write("</a>\r\n");
      out.write("                                <div class=\"proj-ideas\">10 Ideas</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                        </div>                      \r\n");
      out.write("                        <!-- when 'members' tab is clicked -->\r\n");
      out.write("                        <div id=\"grp-members-page-");
      out.print(c);
      out.write("\">                                                 \r\n");
      out.write("                            ");

                                members = g.getMembers();

                                for (int count = 0; count < members.size(); count++) {
                                    m = members.get(count);
                            
      out.write("                      \r\n");
      out.write("                            <div class=\"grp-box\">\r\n");
      out.write("                                <a href=\"\" class=\"proj-name\">");
      out.print(m.getFirstName());
      out.write(' ');
      out.print(m.getLastName());
      out.write("</a>\r\n");
      out.write("                            </div>\t\t\t\t\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                        </div>            \r\n");
      out.write("                        ");

                            }
                        
      out.write("                                         \t\t                                    \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"notifs-whole\">\r\n");
      out.write("                <span class=\"titles\">Notifications</span>\r\n");
      out.write("                <div id=\"notifs\">\r\n");
      out.write("                    <div class=\"box\">\r\n");
      out.write("                    ");
for(Notification notif:notifs ){ 
      out.write("    \r\n");
      out.write("                        <div id=\"content\">\r\n");
      out.write("                            <span id=\"notif-user\">");
      out.print(notif.getNotifUser().getFirstName());
      out.write(' ');
      out.print(notif.getNotifUser().getLastName());
      out.write("</span>\r\n");
      out.write("                            ");
      out.print(notif.getNotif());
      out.write("\r\n");
      out.write("                            <span id=\"notif-proj\"></span> \r\n");
      out.write("                            <span id=\"notif-topic\"></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"date-time\">");
      out.print(notif.getNotifTime());
      out.write("</div>\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <!--\r\n");
      out.write("                    <div class=\"box\">\r\n");
      out.write("                        <div id=\"content\">\r\n");
      out.write("                            <span id=\"notif-user\">Jet Virtusio</span>\r\n");
      out.write("                            posted an idea in\r\n");
      out.write("                            <span id=\"notif-proj\">SWDESPA</span> \r\n");
      out.write("                            under \r\n");
      out.write("                            <span id=\"notif-topic\">User Stories</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"date-time\">1:22pm</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    -->\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!---\r\n");
      out.write("            <div id=\"footer\">\r\n");
      out.write("            </div>\r\n");
      out.write("            -->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
