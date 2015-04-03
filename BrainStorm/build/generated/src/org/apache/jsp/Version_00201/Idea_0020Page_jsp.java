package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.Member;
import Bean.Comment;
import java.util.ArrayList;
import Bean.Idea;
import Bean.IdeaPageBean;

public final class Idea_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Team Nerds</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Idea Style.css\"/>\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("          ");

              session = request.getSession();
              IdeaPageBean Bean = (IdeaPageBean)session.getAttribute("idea");
              Idea idea = Bean.getIdea();
              Member user = idea.getUser();
              ArrayList<Comment> comments = idea.getComments();
          
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\t$(document).ready(function(){\n");
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
      out.write("\t\t\twindow.location.href = \"Log In and Sign Up.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#icon\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#grp-name\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\n");
      out.write("\t\t});\n");
      out.write("                $(\"#button-comment\").click(function(){\n");
      out.write("\t\t\tvar commenttext = $(\"#text-comment\").val();\n");
      out.write("                        $.post('../CommentServlet',{text:commenttext,userid: ");
      out.print(user.getId());
      out.write(", topicid: ");
      out.print( idea.getIdeaID() );
      out.write("},function(responseText) { \n");
      out.write("                        \n");
      out.write("                        $(\"#comments\").append(\n");
      out.write("                          \"<div class=\\\"comment\\\"> \"+\n");
      out.write("                           \" <span id=\\\"comment-user\\\">");
      out.print(user.getFirstName());
      out.write(' ');
      out.print(user.getLastName());
      out.write("</span> \"+\n");
      out.write("                           \" <span id=\\\"comment-date-time\\\">\"+ responseText+\" </span><br/>\" +\n");
      out.write("                           \"<span id=\\\"comment-content\\\">\"+ commenttext+\" </span>\"+\n");
      out.write("                            \"</div>\"\n");
      out.write("                        );\n");
      out.write("                    });       \n");
      out.write("\t\t});\n");
      out.write("                \n");
      out.write("                var flag = Bean.getRating();\n");
      out.write("                // flag = 0 dislike flag=1 like flag -1 undecided\n");
      out.write("               \n");
      out.write("                $(\"#agree\").text(\"Agree\");\n");
      out.write("                $(\"#disagree\").text(\"Disagree\");\n");
      out.write("                \n");
      out.write("                if(flag ==1 )\n");
      out.write("                     $(\"#agree\").text(\"You agreed!\");\n");
      out.write("                \n");
      out.write("                if(flag == 0)\n");
      out.write("                    $(\"#agree\").text(\"You disagreed!\");\n");
      out.write("                    \n");
      out.write("                $(\"#agree\").click(function(){\n");
      out.write("                   \n");
      out.write("                 \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                $(\"#disagree\").click(function(){\n");
      out.write("                console.log(\"Working it\");\n");
      out.write("               \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("\t});\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
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
      out.write("\t\t<button id=\"user\">Marienne Lopez</button>\n");
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
      out.write("<div id=\"idea\" align=\"center\">\n");
      out.write("\t<div class=\"box\">\n");
      out.write("\t\t<div id=\"b-head\">\n");
      out.write("\t\t\t<span id=\"maker\">");
      out.print(user.getFirstName());
      out.write(' ');
      out.print(user.getLastName());
      out.write("</span>\n");
      out.write("\t\t\t<span id=\"date-time\"> ");
      out.print(idea.getTime());
      out.write("</span>\n");
      out.write("\t\t\t<span id=\"b-topic\">");
      out.print(idea.getTopicname());
      out.write("</span>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--<div id=\"title\">This is an Idea</div>-->\n");
      out.write("\t\t<div id=\"content\"> ");
      out.print(idea.getIdea());
      out.write(" </div>\n");
      out.write("\t\t<div id=\"b-footer\">\n");
      out.write("                    \n");
      out.write("                        <span id=\"agree\"></span>\n");
      out.write("                        <span id=\"disagree\"</span>\n");
      out.write("\t\t\t<span id=\"comments-num\">");
      out.print(comments.size());
      out.write("</span> Comments\n");
      out.write("\t\t\t<span id=\"agree-num\"> ");
      out.print( idea.getAgreeCount() );
      out.write(" </span> Agrees\n");
      out.write("\t\t\t<span id=\"disagree-num\">");
      out.print(idea.getDisagreeCount());
      out.write("</span> Disagrees\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"comments\">\n");
      out.write("\t\t\t");
for(int crt=0; crt <comments.size(); crt++ ){  
      out.write("\n");
      out.write("                        <div class=\"comment\">\n");
      out.write("                            <span id=\"comment-user\">");
      out.print(comments.get(crt).getCommentUser().getFirstName());
      out.write(' ');
      out.print(comments.get(crt).getCommentUser().getLastName());
      out.write("</span>\n");
      out.write("                            <span id=\"comment-date-time\">");
      out.print( comments.get(crt).getTime());
      out.write(" </span><br/>\n");
      out.write("\t\t\t\t<span id=\"comment-content\">");
      out.print(comments.get(crt).getCommentDesc());
      out.write("</span>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    <!--\n");
      out.write("\t\t\t<div class=\"comment\">\n");
      out.write("\t\t\t\t<span id=\"comment-user\">Hannah Sibayan</span>\n");
      out.write("\t\t\t\t<span id=\"comment-date-time\">1:55pm</span><br/>\n");
      out.write("\t\t\t\t<span id=\"comment-content\">Nice nice nice!</span>\n");
      out.write("\t\t\t</div>\n");
      out.write("                    -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"write\">\n");
      out.write("\t\t\t<textarea id=\"text-comment\" placeholder=\"Write your comment here..\"></textarea>\n");
      out.write("\t\t\t<input id=\"button-comment\" type=\"button\" value=\"Post\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<div id=\"footer\">\n");
      out.write("</div>\n");
      out.write("-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
