package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>Welcome to Brainstorm</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"../css/LS Style.css\"/>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"../design/Tab Icon.png\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../others/brainstorm_func.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../others/jquery-2.1.3.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('button[name=login]').click(function(){\r\n");
      out.write("\t\t     var email = $.trim($('input:text[name=emaillogin]').val());\r\n");
      out.write("\t\t\t console.log('Email: ' + email);\r\n");
      out.write("\t\t\t var password = $.trim($('input:password[name=passwordlogin]').val());\r\n");
      out.write("\t\t\t console.log('Password: ' + password);\r\n");
      out.write("                         \r\n");
      out.write("\t\t\t if(password == ''){\r\n");
      out.write("\t\t\t   alert('Please enter your password.');\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t //if(email!='' && email.indexOf('@')==email.lastIndexOf('@') && password!='' && email.indexOf('@')!=-1){\r\n");
      out.write("                         if(email!='' && password!=''){\r\n");
      out.write("\t\t\t     window.location.href='Home Page.html';\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('button[name=signup]').click(function(){\r\n");
      out.write("\t\t   var firstname = $.trim($('input:text[name=firstname]').val());\r\n");
      out.write("\t\t   var lastname = $.trim($('input:text[name=lastname]').val());\r\n");
      out.write("\t\t   var password1 = $.trim($('input:password[name=passwordsignup]').val());\r\n");
      out.write("\t\t   var password2 = $.trim($('input:password[name=anotherpass]').val());\r\n");
      out.write("\t\t   var email2 = $.trim($('input:text[name=user]').val());\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t   \r\n");
      out.write("                   if(email2==''){\r\n");
      out.write("\t\t\t    alert('Please enter your username.');\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t  if(firstname == ''){\r\n");
      out.write("\t\t        alert('Please enter your first name.');\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if (lastname = ''){\r\n");
      out.write("\t\t       alert('Please enter your last name.');\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if(password1!=password2 || password2==''){\r\n");
      out.write("\t\t      alert('Please enter your password again correctly.');\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if(password1==''){\r\n");
      out.write("\t\t     alert('Please enter your desired password.');\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<span id=\"welcome\">Hello!<br/>Welcome to  </span>\r\n");
      out.write("\t<span id=\"name\">BrainStorm</span>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<br/><br/><br/>\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<div id=\"forms\" align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"login\" >\r\n");
      out.write("            \r\n");
      out.write("            <form action =\"../LoginServlet\" method=\"POST\">\r\n");
      out.write("\t\t<input class=\"login-inputs\" type=\"text\" name=\"emaillogin\" placeholder=\"Username\"><br/><br/>\r\n");
      out.write("\t\t<input class=\"login-inputs\" type=\"password\" name=\"passwordlogin\" placeholder=\"Password\"><br/><br/>\t\t\r\n");
      out.write("                <button class=\"buttons\" name=\"login\">Log In</button>\r\n");
      out.write("            </form>            \r\n");
      out.write("        </div>\r\n");
      out.write("\t\r\n");
      out.write("    \r\n");
      out.write("\t<div id=\"signup\">\r\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("            <form method=\"POST\" action=\"../SignUp2\">\r\n");
      out.write("\t\t<span id=\"signup-header\">No account yet? Sign Up</span><br/><br/>\r\n");
      out.write("\t\t<input type=\"text\" class=\"signup-inputs\" name=\"user\" placeholder=\"Username\" style=\"margin-top: -8px\"><br/><br/>\r\n");
      out.write("\t\t<input type=\"text\" class=\"signup-inputs\" name=\"firstname\" placeholder=\"First Name\"><br/><br/>\r\n");
      out.write("\t\t<input type=\"text\" class=\"signup-inputs\" name=\"lastname\" placeholder=\"Last Name\"><br/><br/>\r\n");
      out.write("\t\t<input type=\"password\" class=\"signup-inputs\" name=\"passwordsignup\" placeholder=\"Password\"><br/><br/>\r\n");
      out.write("\t\t<input type=\"password\" class=\"signup-inputs\" name=\"anotherpass\" placeholder=\"Re-enter Password\"><br/><br/>\r\n");
      out.write("\t\t<button class=\"buttons\" name=\"signup\">Sign Up</button>\r\n");
      out.write("            </form>    \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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
