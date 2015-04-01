package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Brainstorm</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Home Style.css\"/>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\r\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\r\n");
      out.write("\t");

        UserBean Bean = (UserBean) session.getAttribute("user");
        HomePageBean pagebean = (HomePageBean) session.getAttribute("homepage");
        ArrayList<Group> groups = pagebean.getGroups();
        int gnumber = groups.size();
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("                    \r\n");
      out.write("                var currGroup = \"0\";\r\n");
      out.write("                var pageShow, pageHide, pageHide1, pageHide2;\r\n");
      out.write("                var groupname=\"#\"+currGroup;\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("          \r\n");
      out.write("                 \r\n");
      out.write("                $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("                \r\n");
      out.write("                 for(var cont=0; cont< 3; cont++ ){\r\n");
      out.write("                $(\"#grp-projects-page-\"+cont).hide();\r\n");
      out.write("              \r\n");
      out.write("                $(\"#grp-members-page-\"+cont).hide();\r\n");
      out.write("\t     \r\n");
      out.write("                } \r\n");
      out.write("            \r\n");
      out.write("                 $(\"#grp-projects-page-0\").show();\r\n");
      out.write("                       \r\n");
      out.write("\t\t$(\"#user\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Edit Profile Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#home\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#logout\").click(function(){\r\n");
      out.write("\t\t\talert(\"You will be logged out. Please sign in again.\");\r\n");
      out.write("\t\t\twindow.location.href = \"../LogOutServlet\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#icon\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#grp-name\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\".proj-name\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#grp-projects\").click(function(){\r\n");
      out.write("                        pageHide = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                        pageShow = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                        $(pageHide).hide();\r\n");
      out.write("                        $(pageShow).show();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#grp-members\").click(function(){\r\n");
      out.write("                        pageHide = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                        pageShow = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                        $(pageHide).hide();\r\n");
      out.write("                        $(pageShow).show();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\".group\").click(function(){\r\n");
      out.write("                        pageHide1 = \"#grp-projects-page-\" + currGroup;\r\n");
      out.write("                        pageHide2 = \"#grp-members-page-\" + currGroup;\r\n");
      out.write("                        pageShow = \"#grp-projects-page-\" + $(\"#grp-list\").val();\r\n");
      out.write("                        $(pageHide1).hide();\r\n");
      out.write("                        $(pageHide2).hide();\r\n");
      out.write("                        $(pageShow).show();\r\n");
      out.write("                        currGroup = $(\"#grp-list\").val();\r\n");
      out.write("                        \r\n");
      out.write("                        groupname=\"#\"+currGroup;\r\n");
      out.write("                    \r\n");
      out.write("                      $('#selectedgroup').text($(groupname).text());\r\n");
      out.write("                       // document.getElementById(\"selectedgroup\").textContent= \r\n");
      out.write("                        \r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("        \r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("        \r\n");
      out.write("\t<span id=\"left-header\">\r\n");
      out.write("\t\t<img id=\"icon\" src=\"Icon.png\"/>\r\n");
      out.write("\t\t<input id=\"search\" type=\"text\" placeholder=\"Search\" style=\"color: black\">\r\n");
      out.write("\t</span>\r\n");
      out.write("\t\r\n");
      out.write("\t<span id=\"right-header\">\r\n");
      out.write("\t\t<button id=\"user\"> ");
      out.print(Bean.getFirstName());
      out.write(' ');
      out.print(Bean.getLastName());
      out.write("</button>\r\n");
      out.write("\t\t<span id=\"line\"></span>\r\n");
      out.write("\t\t<button id=\"home\">Home</button>\r\n");
      out.write("\t\t<span id=\"line\"></span>\r\n");
      out.write("\t\t<button id=\"logout\">Log Out</button>\r\n");
      out.write("\t\t<!---\r\n");
      out.write("\t\t<select id=\"user-select\" class=\"h-select\">\r\n");
      out.write("\t\t\t<option>Settings</option>\r\n");
      out.write("\t\t\t<option>Log Out</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t-->\r\n");
      out.write("\t</span>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"center-content\">\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"groups-whole\">\r\n");
      out.write("\t<span class=\"titles\" id=\"grp-title\">Groups</span>\r\n");
      out.write("\t<div id=\"groups\">\r\n");
      out.write("\t\t<select id=\"grp-list\" size=\"");
      out.print(groups.size());
      out.write("\">\r\n");
      out.write("                    \r\n");
      out.write("                    ");

                    //System.out.println("<--->" + groups.size());
                    for(int i = 0; i < groups.size(); i++){
                    //System.out.println("*--->" + groups.get(i).getGroupName());
                    
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                        <option id=\"");
      out.print(i);
      out.write("\" class=\"group\" value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(groups.get(i).getGroupName());
      out.write("\r\n");
      out.write("\t\t\t</option>          \r\n");
      out.write("                    ");

                    }
                    
      out.write("\r\n");
      out.write("\t\t</select>\r\n");
      out.write("                \r\n");
      out.write("\t\t<div id=\"grp-page\">\r\n");
      out.write("                    <div id=\"grp-header\">\r\n");
      out.write("                        <a id=\"grp-name\">\r\n");
      out.write("               \r\n");
      out.write("                        \r\n");
      out.write("                     <span id=\"selectedgroup\">Team Nerds</span> \r\n");
      out.write("\t\t\t              \r\n");
      out.write("               \r\n");
      out.write("                         </a> <span id=\"grp-line\"></span>\r\n");
      out.write("                        <a id=\"grp-projects\">Projects</a> <span id=\"grp-line\"></span>\r\n");
      out.write("                        <a id=\"grp-members\">Members</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- when 'projects' tab is clicked -->\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        ");

                        ArrayList<Member> members;
                        Member m;
                        Group g;
                        ArrayList<Project> proj;
                        for(int c=0; c< groups.size();c++ ){
                        g = groups.get(c);
                        proj = g.getProjects();
                        
                      
                        
      out.write("\r\n");
      out.write("\t\t\t<div id=\"grp-projects-page-");
      out.print(c);
      out.write("\">\r\n");
      out.write("\t\t\t       \r\n");
      out.write("                        ");

                        for(Project p: proj){    
                        System.out.println(g.getGroupName() + "UR TOPIC IS " +p.getName());
                        
      out.write("\r\n");
      out.write("                            <div class=\"grp-box\">\r\n");
      out.write("\t\t\t\t\t<a class=\"proj-name\">");
      out.print(p.getName());
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"proj-ideas\">10 Ideas</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                        ");

                            }          
                        
      out.write("\r\n");
      out.write("                        </div>                      \r\n");
      out.write("\t\t\t<!-- when 'members' tab is clicked -->\r\n");
      out.write("\t\t\t<div id=\"grp-members-page-");
      out.print(c);
      out.write("\">                                                 \r\n");
      out.write("                            ");

                            members = g.getMembers();
                            
                            for(int count = 0; count < members.size() ; count++ ){
                                m = members.get(count);
                            
      out.write("                      \r\n");
      out.write("\t\t\t\t<div class=\"grp-box\">\r\n");
      out.write("\t\t\t\t\t<a href=\"\" class=\"proj-name\">");
      out.print(m.getFirstName());
      out.write(' ');
      out.print(m.getLastName());
      out.write("</a>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("                              ");
  
                            }
                                
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                    ");
                                                
                        }
                      
      out.write("                                         \t\t                                    \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"notifs-whole\">\r\n");
      out.write("\t<span class=\"titles\">Notifications</span>\r\n");
      out.write("\t<div id=\"notifs\">\r\n");
      out.write("\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t<span id=\"notif-user\">Hannah Sibayan</span>\r\n");
      out.write("\t\t\t\tposted an idea in\r\n");
      out.write("\t\t\t\t<span id=\"notif-proj\">WEBAPP</span> \r\n");
      out.write("\t\t\t\tunder \r\n");
      out.write("\t\t\t\t<span id=\"notif-topic\">HTML</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"date-time\">1:23pm</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"box\">\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t<span id=\"notif-user\">Jet Virtusio</span>\r\n");
      out.write("\t\t\t\tposted an idea in\r\n");
      out.write("\t\t\t\t<span id=\"notif-proj\">SWDESPA</span> \r\n");
      out.write("\t\t\t\tunder \r\n");
      out.write("\t\t\t\t<span id=\"notif-topic\">User Stories</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"date-time\">1:22pm</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!---\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("</div>\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
