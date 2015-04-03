package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.Idea;
import Bean.UserBean;
import Bean.Topic;
import java.util.ArrayList;
import Bean.ProjectPageBean;

public final class Main_0020page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("\t<title>Team Nerds</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Main Style.css\"/>\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\n");
      out.write("\t\n");
      out.write("        ");
    
            HttpSession s = request.getSession();
            ProjectPageBean Bean = (ProjectPageBean ) s.getAttribute("project");
            UserBean u = (UserBean) s.getAttribute("user");
            ArrayList<Topic> topics = Bean.getTopics();
                     
            
         
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("            \n");
      out.write("                var Idea = function (firstName, lastName, topic, idea , id, time) {\n");
      out.write("                this.firstName = firstName;\n");
      out.write("                this.lastName = lastName;\n");
      out.write("                this.topic = topic;\n");
      out.write("                this.idea = idea;\n");
      out.write("                this.ideaid = id;\n");
      out.write("                this.time = time;\n");
      out.write("                \n");
      out.write("                this.getideaid = function () {\n");
      out.write("                return this.ideaid;\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                this.getTime = function () {\n");
      out.write("                return this.time;\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                this.getfirstName = function () {\n");
      out.write("                return this.firstName;\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("               this.getlastName = function () {\n");
      out.write("                return this.lastName;\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                this.getTopic = function () {\n");
      out.write("                return this.topic;\n");
      out.write("                }; \n");
      out.write("                \n");
      out.write("                this.getIdea = function () {\n");
      out.write("                return this.idea;\n");
      out.write("                }; \n");
      out.write("                \n");
      out.write("                };\n");
      out.write("            var icollection=[];\n");
      out.write("            \n");
      out.write("       //initialize topic collection here         \n");
      out.write("        ");

        ArrayList<Idea> ideas;    
        for(Topic tpc: topics){
         
      out.write("   \n");
      out.write("          $(\"#topicselector\").append(\"<option>");
      out.print(tpc.getName());
      out.write("</option>\");\n");
      out.write("         ");

            ideas = tpc.getIdeas();
           
            for(int cnt=0 ; cnt< ideas.size(); cnt++){
        
      out.write("\n");
      out.write("            \n");
      out.write("            icollection[ icollection.length ] = new Idea( \"");
      out.print(ideas.get(cnt).getUser().getFirstName());
      out.write("\" ,\"");
      out.print(ideas.get(cnt).getUser().getLastName());
      out.write("\" , \n");
      out.write("            \"");
      out.print(tpc.getName());
      out.write("\", \"");
      out.print(ideas.get(cnt).getIdea());
      out.write("\", ");
      out.print(ideas.get(cnt).getIdeaID());
      out.write(", \"");
      out.print(ideas.get(cnt).getTime());
      out.write("\"  );\n");
      out.write("               \n");
      out.write("        ");

            }        
            }
        
      out.write("\n");
      out.write("                \n");
      out.write("            function reloadTopics(topic) {\n");
      out.write("             \n");
      out.write("             if(topic == \"All Topics\"){\n");
      out.write("                 \n");
      out.write("                 for(var cont =0; cont < icollection.length; cont++){\n");
      out.write("                     $(\"#ideas\").append(\n");
      out.write("                        \"<div class=\\\"box\\\"  id =\"+ icollection[cont].getideaid()+\">\"+\n");
      out.write("                        \"<div id=\\\"b-head\\\">\"+\n");
      out.write("\t\t\t\"<span id=\\\"maker\\\">\" + icollection[cont].getfirstName() +\" \"+ icollection[cont].getlastName()+ \"</span>\"+\n");
      out.write("\t\t\t\"<span id=\\\"date-time\\\"> \"+icollection[cont].getTime() +\"</span>\" +\n");
      out.write("\t\t\t\"<span id=\\\"b-topic\\\">\"+ icollection[cont].getTopic() +\"</span>\" +\n");
      out.write("                        \"</div>\" +\n");
      out.write("                        \"<div id=\\\"content\\\">\"+ icollection[cont].getIdea()+\"</div>\" +\n");
      out.write("                        \"<div id=\\\"b-footer\\\">\"+\n");
      out.write("\t\t\t\"<span id=\\\"comments\\\"> 2</span> Comments\"+\n");
      out.write("\t\t\t\"<span id=\\\"agree\\\">5</span> Agrees\"+\n");
      out.write("\t\t\t\"<span id=\\\"disagree\\\">3</span> Disagrees\"+\n");
      out.write("                        \"</div>\"\n");
      out.write("                          );\n");
      out.write("                    }  //end of loop     \n");
      out.write("            } //end of if        \n");
      out.write("        } // end of function    \n");
      out.write("                          \n");
      out.write("\t\t$(\"#add\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Post Page.jsp\";\n");
      out.write("\t\t});\n");
      out.write("\n");
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
      out.write("                \n");
      out.write("                reloadTopics(\"All Topics\");\n");
      out.write("                \n");
      out.write("                $(\".box\").click(function(){\n");
      out.write("                        console.log($(this).attr('id') +\"  VALUE IS\" );\n");
      out.write("\t\t\t//window.location.href = \"Idea Page.html\";\n");
      out.write("\t\t});\n");
      out.write("                \n");
      out.write("                \n");
      out.write("\t});\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
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
      out.write("\t\t<button id=\"user\"> HUHIUH Marienne Lopez</button>\n");
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
      out.write("<div id=\"title-head\">\n");
      out.write("\t<span id=\"title-project\">WEBAPP Project</span>\n");
      out.write("\t<select id=\"proj-select\">\n");
      out.write("\t\t<option>WEBAPP</option>\n");
      out.write("\t\t<option>SWDESPA</option>\n");
      out.write("\t\t<option>OPERSYS</option>\n");
      out.write("\t</select>\n");
      out.write("\t\t\n");
      out.write("\t<span id=\"view\" class=\"title-right\">View \n");
      out.write("\t\t<select class=\"title-select\" id=\"topicselector\">\n");
      out.write("\t\t\t<option>All Topics</option>\n");
      out.write("\t\t</select>\n");
      out.write("\t</span>\n");
      out.write("\t<span id=\"sort\" class=\"title-right\">Sort by \n");
      out.write("\t\t<select class=\"title-select\">\n");
      out.write("\t\t\t<option>Latest</option>\n");
      out.write("\t\t\t<option>Most Approves</option>\n");
      out.write("\t\t</select>\n");
      out.write("\t</span>\n");
      out.write("\t<span id=\"add\">+</span>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"ideas\" align=\"center\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\t<div class=\"box\">\n");
      out.write("\t\t<div id=\"b-head\">\n");
      out.write("\t\t\t<span id=\"maker\">Jet Virtusio</span>\n");
      out.write("\t\t\t<span id=\"date-time\">1:23pm</span>\n");
      out.write("\t\t\t<span id=\"b-topic\">HTML</span>\n");
      out.write("\t\t</div>\n");
      out.write("   \n");
      out.write("    <!--<div id=\"title\">This is an Idea</div>-->\n");
      out.write("    \n");
      out.write("    <div id=\"content\">These sentences are stuffs about the idea. These sentences are stuffs about the idea. \n");
      out.write("\t\t\t\tklsdka askdjskl asdklj ;madmsakdmsadThese sentences are stuffs about the idea. Blablablabla alsjd laksjdkslajdksadk asldn askdnsa laksds</div>\n");
      out.write("                \n");
      out.write("                <div id=\"b-footer\">\n");
      out.write("\t\t\t<span id=\"comments\">2</span> Comments\n");
      out.write("\t\t\t<span id=\"agree\">5</span> Agrees\n");
      out.write("\t\t\t<span id=\"disagree\">3</span> Disagrees\n");
      out.write("\t\t\t\n");
      out.write("       \n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<div id=\"footer\">\n");
      out.write("</div>\n");
      out.write("-->\n");
      out.write("</div>\n");
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
