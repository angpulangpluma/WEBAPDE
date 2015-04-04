package org.apache.jsp.Version_00201;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Edit_0020Profile_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Brainstorm</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"Edit Profile Style.css\"/>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"Tab Icon.png\"/>\r\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"brainstorm_func.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$(\"#user\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Edit Profile Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#home\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Home Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#logout\").click(function(){\r\n");
      out.write("\t\t\talert(\"You will be logged out. Please sign in again.\");\r\n");
      out.write("\t\t\twindow.location.href = \"Log In and Sign Up.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#icon\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"../ToHomePageServlet\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#grp-name\").click(function(){\r\n");
      out.write("\t\t\twindow.location.href = \"Main Page.html\";\r\n");
      out.write("\t\t});\r\n");
      out.write("                \r\n");
      out.write("                $(\"#savename\").click(function(){\r\n");
      out.write("                    console.log(\"HERE\");\r\n");
      out.write("                    console.log($(\"#lastname\").val().length);\r\n");
      out.write("                    if( $(\"#lastname\").val().length===0 || $(\"#firstname\").val().length===0 )\r\n");
      out.write("                           alert(\"Please put details first\");\r\n");
      out.write("                     else $(\"#nameform\").submit()       \r\n");
      out.write("                            \r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                $(\"#savepassword\").click(function(){\r\n");
      out.write("                    \r\n");
      out.write("            \r\n");
      out.write("                     if ( $(\"#pas\").val() !== $(\"#pas2\").val() ){\r\n");
      out.write("                         alert(\"Password does not match\");\r\n");
      out.write("                     } else if( $(\"#pas\").val().length ===0  ){\r\n");
      out.write("                         alert(\"Input password\");\r\n");
      out.write("                     }else if( $(\"#pas\").val() === $(\"#pas2\").val()){\r\n");
      out.write("                         $(\"#passform\").submit()   \r\n");
      out.write("                     }      \r\n");
      out.write("                            \r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\r\n");
      out.write("\t<span id=\"left-header\">\r\n");
      out.write("\t\t<img id=\"icon\" src=\"Icon.png\"/>\r\n");
      out.write("\t\t<input id=\"search\" type=\"text\" placeholder=\"Search\" style=\"color: black\">\r\n");
      out.write("\t</span>\r\n");
      out.write("\t\r\n");
      out.write("\t<span id=\"right-header\">\r\n");
      out.write("\t\t<button id=\"user\">Marienne Lopez</button>\r\n");
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
      out.write("\t\r\n");
      out.write("        <form id=\"nameform\" action=\"../ChangeNameServlet\" metho=\"POST\">\r\n");
      out.write("        First Name</br><input name=\"fname\" type=\"text\" class=\"inputs\" placeholder=\"First Name\" id=\"firstname\"><br/><br/>\r\n");
      out.write("        Last Name<br/><input name =\"lname\" type=\"text\" class=\"inputs\" placeholder=\"Last Name\" id=\"lastname\"><br/><br/>\r\n");
      out.write("        </form>\r\n");
      out.write("        <button id=\"savename\">Save Name</button>\r\n");
      out.write("        <form id=\"passform\" action=\"../ChangePassServlet\" method=\"POST\" >\r\n");
      out.write("        Password<br/><input id=\"pas\" name=\"pass\" type=\"password\" class=\"inputs\" placeholder=\"Password should be chuchu\" value=\"\"><br/><br/>\r\n");
      out.write("        Re-enter Password<br/><input id=\"pas2\" type=\"password\" class=\"inputs\" placeholder=\"Re-enter Password\" value=\"\"><br/><br/>\r\n");
      out.write("        </form>\r\n");
      out.write("        <button id=\"savepassword\" >Save Password</button>\r\n");
      out.write("        \r\n");
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
