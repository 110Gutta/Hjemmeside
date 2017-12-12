package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deleteUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("\t<title> SLIT-Project </title>\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, minimumscale=\n");
      out.write("\t1.0, maximum-scale=1.0\" />\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("                  \n");
      out.write("        <div id=\"container\">\n");
      out.write("            <header id=\"header\">\n");
      out.write("                <hgroup>\n");
      out.write("                    <h1><a href=\"index.html\" style=\"text-decoration:none\">SLIT</a></h1>\n");
      out.write("                     \n");
      out.write("                </hgroup>\n");
      out.write("            </header>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("            <div id=\"content\">\n");
      out.write("\t\t<article class=\"post\">\n");
      out.write("\t\t\t<h2>Enter your information</h2>\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <form action=\"DeleteUser\" method=\"POST\" >\n");
      out.write("                Fornavn: <input type=\"text\" placeholder=\"Fornavn\" name=\"fornavn\" ></br>\n");
      out.write("                Etternavn <input type=\"text\" placeholder=\"Etternavn\" name=\"etternavn\" ></br>\n");
      out.write("           \n");
      out.write("                <input type=\"submit\" value=\"Slett\" ></br>\n");
      out.write("                \n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("\t\n");
      out.write("      \n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("          \n");
      out.write("    </body>\n");
      out.write("          \n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    \n");
      out.write("         \n");
      out.write("    </body>\n");
      out.write("          \n");
      out.write("\n");
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
