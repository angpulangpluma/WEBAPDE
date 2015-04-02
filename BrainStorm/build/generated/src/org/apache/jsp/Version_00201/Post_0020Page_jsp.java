package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.UserBean;
import java.util.ArrayList;
import Bean.Topic;
import Bean.ProjectPageBean;

public final class Post_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Team Nerds</title>\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Post Style.css\"/>\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("            \n");
      out.write("         ");

             HttpSession s = request.getSession();
             ProjectPageBean Bean = (ProjectPageBean ) s.getAttribute("project");
             ArrayList<Topic> topics = Bean.getTopics();
             UserBean ub = (UserBean)s.getAttribute("user");
             
             
             
         
      out.write("\n");
      out.write("            \n");
      out.write("\t $(document).ready(function(){\n");
      out.write("\t\t$(\"#newtopic\").hide();\n");
      out.write("\t\t$(\"#select-popup\").change(function(){\n");
      out.write("\t\t\tif($(\"#select-popup\").find(\":selected\").val() === \"new\")\n");
      out.write("\t\t\t\t$(\"#newtopic\").show();\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t\t$(\"#newtopic\").hide();\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#group\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#user\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Edit Profile Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#home\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#logout\").click(function(){\n");
      out.write("\t\t\talert(\"You will be logged out. Please sign in again.\");\n");
      out.write("\t\t\twindow.location.href = \"Log In and Sign Up.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#icon\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#grp-name\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t/*\n");
      out.write("\t\t$(\"input:button[name=post]\").click(function(){\n");
      out.write("\t\t    var selected = $(\"#select-popup option:selected\").text();\n");
      out.write("\t\t\tvar desc = $(\"textarea#text-popup\").val();\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tif(selected==\"new\"){\n");
      out.write("\t\t\t  selected=$(\"input:text[name=topictitle]\").val();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tif(desc== \"\"){\n");
      out.write("\t\t\t  alert(\"Please enter the idea description.\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tif(selected== \"\"){\n");
      out.write("\t\t\t  alert(\"Please enter the idea topic.\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t//if(selected!= \"\" && desc!= \"\"){\n");
      out.write("\t\t\t//  alert(\"Congratulations! A new idea has been created!\");\n");
      out.write("\t\t\t//  window.location.href=\"Main Page.html\";\n");
      out.write("\t\t//\t}\n");
      out.write("\t\t});\n");
      out.write("                */\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div id=\"add-popup\">\n");
      out.write("\t<div id=\"content-popup\">\n");
      out.write("                <form method=\"POST\" action=\"../PostIdeaServlet\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<span id=\"topic-popup\">Topic</span>\n");
      out.write("\t\t\t<select id=\"select-popup\" name=\"selected\">\n");
      out.write("                            ");
 for(Topic tpc: topics){ 
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(tpc.gettopicid());
      out.write("\"> ");
      out.print(tpc.getName());
      out.write("\n");
      out.write("                              ");
  } 
      out.write("\n");
      out.write("\t\t\t\t<option value=\"new\">Add new topic</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t<input type=\"text\" id=\"newtopic\" name=\"topictitle\" placeholder=\"New Topic\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<textarea id=\"text-popup\" rows=\"10\" cols=\"65\" name=\"ideadesc\" placeholder=\"Write your awesome idea here..\"></textarea>\n");
      out.write("\t\t<input type=\"hidden\" value=\"");
      out.print( ub.getID());
      out.write("\" name=\"userid\" >\n");
      out.write("                <input id=\"button-popup\" type=\"submit\" value=\"Post\" name=\"post\"/>\n");
      out.write("                \n");
      out.write("                </form>\n");
      out.write("\t</div>\n");
      out.write("            \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"bg\">\n");
      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("\t<span id=\"left-header\">\n");
      out.write("\t\t<img id=\"icon\" src=\"Icon.png\"/>\n");
      out.write("\t\t<span id=\"group\">Team Nerds</span>\n");
      out.write("\t\t<select id=\"group-select\" class=\"h-select\">\n");
      out.write("\t\t\t<option>Members</option>\n");
      out.write("\t\t\t<option>Switch Group</option>\n");
      out.write("\t\t\t<option>Edit Group</option>\n");
      out.write("\t\t</select>\n");
      out.write("\t\t<input id=\"search\" type=\"text\" placeholder=\"Search\" style=\"color: black\">\n");
      out.write("\t</span>\n");
      out.write("\t\n");
      out.write("\t<span id=\"right-header\">\n");
      out.write("\t\t<button id=\"user\">");
      out.print( ub.getFirstName());
      out.write(' ');
      out.print(ub.getLastName());
      out.write("</button>\n");
      out.write("\t\t<span id=\"line\"></span>\n");
      out.write("\t\t<button id=\"home\">Home</button>\n");
      out.write("\t\t<span id=\"line\"></span>\n");
      out.write("\t\t<button id=\"logout\">Log Out</button>\n");
      out.write("\t\t<!---\n");
      out.write("\t\t<select id=\"user-select\" class=\"h-select\">\n");
      out.write("\t\t\t<option>Settings</option>\n");
      out.write("\t\t\t<option>Log Out</option>\n");
      out.write("\t\t</select>\n");
      out.write("\t\t-->\n");
      out.write("\t</span>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<div id=\"footer\">\n");
      out.write("</div>\n");
      out.write("-->\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
