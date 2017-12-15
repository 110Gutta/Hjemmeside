package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import DB.DataBase;

public final class downloadFileModul_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/link.html");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<a href=\"index.html\">Login</a> |  \n");
      out.write("<a href=\"LogoutServlet\">Logout</a> |  \n");
      out.write("<a href=\"ProfileServlet\">Profile</a>  |\n");
      out.write("<a href= \"downloadFileModul.jsp\">Modules</a> |\n");
      out.write("<a href= \"downloadfile.jsp\">My Modules</a> |\n");
      out.write("<a href= \"uploadindex.jsp\">Deliver module</a> |\n");
      out.write("<a href= \"indexchat.jsp\">Chatroom</a> |\n");
      out.write("<hr>  ");
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css\" type=\"text/css\"> </head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <nav class=\"navbar navbar-expand-md bg-secondary navbar-dark\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"ProfileStudent.jsp\">SLIT</a>\n");
      out.write("      <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"> <span class=\"navbar-toggler-icon\"></span> </button>\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("        <ul class=\"navbar-nav mr-auto\">\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"StudentProfile.jsp\">Profile</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"downloadFileModul.jsp\">Modules</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"downloadfile.jsp\">My Modules</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"uploadindex.jsp\">Deliver Module</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"indexchat.jsp\">Chatroom</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item mx-3\">\n");
      out.write("            <a class=\"nav-link\" href=\"LogoutServlet\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Log out</a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link text-white\" href=\"#\"></a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link text-white\" href=\"#\"></a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write("  <div class=\"py-5 text-center opaque-overlay\" style=\"background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);\">\n");
      out.write("    <div class=\"container py-5\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12 text-white\">\n");
      out.write("          <h1 class=\"display-3 mb-4\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h1>\n");
      out.write("          <p class=\"lead mb-5\">Du lærer hvordan du kan bidra til å utvikle informasjonssystemer, og hvordan digitalisering påvirker samfunnet, blant annet gjennom å: analysere brukerbehov, designe informasjonssystemer, utvikle databaseløsninger og programmere ha en grunnleggende\n");
      out.write("            forståelse av og kunnskap om hvordan IT og informasjonssystemer kan utvikles og anvendes bidra til at organisasjoner kan utnytte informasjonssystemer til å nå egne mål forstå rollen teknologi spiller i utvikling av organisasjoner og i samfunnet\n");
      out.write("            som helhet.</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"py-5\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("          <ul class=\"list-group\"></ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<table border=\"1\">\n");
      out.write("  <tr>\n");
      out.write("    <th>Module number</th>\n");
      out.write("    <th>Module name</th>\n");
      out.write("    <th>Download</th>\n");
      out.write("  </tr>\n");

        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
       
            con = db.getCon();
            st = con.createStatement();
 
 
session = request.getSession(false);
                    if(session!=null){
           
                       
                        String query = "select moduleid, modulename from module";
                       
 
                        rs = st.executeQuery(query);
 
  int count =0;
  while(rs.next())
  {
    out.println("<tr>"
        + "<td>"+rs.getString(1)+"</td>"
        + "<td>"+rs.getString(2)+"</td>"
 
        + "<td>"
        + "<a href='downloadModul.jsp?moduleid="+rs.getInt(1) +"'> Download </a>"
        + "</td>"
        + "</tr>");
    count++;
  }
  rs.close();
  con.close();
  if(count==0)
  {
    out.println("<tr><td colspan='4'> No File Found..!! </td></tr>");
  }
                    } else{
                      out.print("Please login first");
                      request.getRequestDispatcher("login.html").include(request, response);
                   
                    }

      out.write("            \n");
      out.write("</table>");
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
