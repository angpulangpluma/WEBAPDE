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

public final class HomeTest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Brainstorm</title>\n");
      out.write("\t\n");
      out.write("       <script src=\"http://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\"> \n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\n");
      out.write("        <script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\n");
      out.write("        <!--\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Home Style.css\"/>\n");
      out.write("        -->\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("\t$(document).ready(function(){\n");
      out.write("                    \n");
      out.write("                var currGroup = \"0\";\n");
      out.write("                var pageShow, pageHide, pageHide1, pageHide2;\n");
      out.write("                var groupname=\"#\"+currGroup;\n");
      out.write("                var search;\n");
      out.write("                var availableTags = [\n");
      out.write("                \"ActionScript\",\n");
      out.write("                \"AppleScript\",\n");
      out.write("                \"Asp\",\n");
      out.write("                \"BASIC\",\n");
      out.write("                \"C\",\n");
      out.write("                \"C++\",\n");
      out.write("                \"Clojure\",\n");
      out.write("                \"COBOL\",\n");
      out.write("                \"ColdFusion\",\n");
      out.write("                \"Erlang\",\n");
      out.write("                \"Fortran\",\n");
      out.write("                \"Groovy\",\n");
      out.write("                \"Haskell\",\n");
      out.write("                \"Java\",\n");
      out.write("                \"JavaScript\",\n");
      out.write("                \"Lisp\",\n");
      out.write("                \"Perl\",\n");
      out.write("                \"PHP\",\n");
      out.write("                \"Python\",\n");
      out.write("                \"Ruby\",\n");
      out.write("                \"Scala\",\n");
      out.write("                \"Scheme\"\n");
      out.write("                ];\n");
      out.write("\n");
      out.write(" \n");
      out.write("                $(\"#search\").keyup(function(){\n");
      out.write("                    search = $(\"#search\").val();\n");
      out.write("                     console.log(\"key Up\");\n");
      out.write("                    $.get('please',{keyword:search},function(responseText) { \n");
      out.write("                        console.log(\"BITCH PLS\");\n");
      out.write("                        console.log(responseText);     \n");
      out.write("                    });       \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $( \"#search\" ).autocomplete({\n");
      out.write("                source: availableTags\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                $('#selectedgroup').text($(groupname).text());     \n");
      out.write("                 for(var cont=0; cont< 3; cont++ ){\n");
      out.write("                $(\"#grp-projects-page-\"+cont).hide();\n");
      out.write("              \n");
      out.write("                $(\"#grp-members-page-\"+cont).hide();\n");
      out.write("\t     \n");
      out.write("                } \n");
      out.write("            \n");
      out.write("                 $(\"#grp-projects-page-0\").show();\n");
      out.write("                       \n");
      out.write("\t\t$(\"#user\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Edit Profile Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#home\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#logout\").click(function(){\n");
      out.write("\t\t\talert(\"You will be logged out. Please sign in again.\");\n");
      out.write("\t\t\twindow.location.href = \"../LogOutServlet\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#icon\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#grp-name\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\".proj-name\").click(function(){\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#grp-projects\").click(function(){\n");
      out.write("                        pageHide = \"#grp-members-page-\" + currGroup;\n");
      out.write("                        pageShow = \"#grp-projects-page-\" + currGroup;\n");
      out.write("                        $(pageHide).hide();\n");
      out.write("                        $(pageShow).show();\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\"#grp-members\").click(function(){\n");
      out.write("                        pageHide = \"#grp-projects-page-\" + currGroup;\n");
      out.write("                        pageShow = \"#grp-members-page-\" + currGroup;\n");
      out.write("                        $(pageHide).hide();\n");
      out.write("                        $(pageShow).show();\n");
      out.write("\t\t});\n");
      out.write("\t\t$(\".group\").click(function(){\n");
      out.write("                        pageHide1 = \"#grp-projects-page-\" + currGroup;\n");
      out.write("                        pageHide2 = \"#grp-members-page-\" + currGroup;\n");
      out.write("                        pageShow = \"#grp-projects-page-\" + $(\"#grp-list\").val();\n");
      out.write("                        $(pageHide1).hide();\n");
      out.write("                        $(pageHide2).hide();\n");
      out.write("                        $(pageShow).show();\n");
      out.write("                        currGroup = $(\"#grp-list\").val();\n");
      out.write("                        \n");
      out.write("                        groupname=\"#\"+currGroup;\n");
      out.write("                    \n");
      out.write("                      $('#selectedgroup').text($(groupname).text());\n");
      out.write("                       // document.getElementById(\"selectedgroup\").textContent=          \n");
      out.write("\t\t});\n");
      out.write("               \n");
      out.write("        \n");
      out.write("                $('#search2').keyup(function(event) {  \n");
      out.write("                    var username=$('#search2').val();\n");
      out.write("                    console.log('hello');\n");
      out.write("                $.get('../please',{user:username},function(responseText) { \n");
      out.write("                        $('#welcometext').text(responseText);         \n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("\t});\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form id=\"form1\">\n");
      out.write("<h1>AJAX Demo using Jquery in JSP and Servlet</h1>\n");
      out.write("Enter your Name:\n");
      out.write("<input type=\"text\" id=\"search2\"/>\n");
      out.write("<input type=\"button\" id=\"submit\" value=\"Ajax Submit\"/>\n");
      out.write("<br/>\n");
      out.write("<div id=\"welcometext\">\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("     \n");
      out.write("\n");
      out.write("       \n");
      out.write("<!---\n");
      out.write("<div id=\"footer\">\n");
      out.write("</div>\n");
      out.write("-->\n");
      out.write("\n");
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
