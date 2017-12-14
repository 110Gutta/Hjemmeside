package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Constants.Constants;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class studentlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\"/>\n");
      out.write("<title> SLIT-Project </title>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, minimumscale=\n");
      out.write("     1.0, maximum-scale=1.0\" />\n");
      out.write("  \n");
      out.write("<title>Students</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" \n");
      out.write("</body>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("<form method=\"post\">\n");
      out.write(" \n");
      out.write("<table border=\"2\">\n");
      out.write("<tr>\n");
      out.write("<td>UserID</td>\n");
      out.write("<td>Fornavn</td>\n");
      out.write("<td>Etternavn</td>\n");
      out.write("<td>Email</td>\n");
      out.write("<td>Moduler</td>\n");
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write("</tr>\n");

    request.getRequestDispatcher("link.html");
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/prog";
String username="root";
String password="root";
String query= Constants.sqlWriteStudent;
Connection conn=DriverManager.getConnection(url, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);

while(rs.next())
{
    
 
    out.println("<tr>"
        + "<td>"+rs.getString(1)+"</td>"
        + "<td>"+rs.getString(2)+"</td>"
        + "<td>"+rs.getString(3)+"</td>"
        + "<td>"+rs.getString(4)+"</td>"
        + "<td>"
        + "<a href='foreleserinnleveringer.jsp?userid="+rs.getInt(1) +"'> Moduler </a>"
        + "</td>"
        + "</tr>");
 
}

      out.write("\n");
      out.write("</table>\n");

        rs.close();
        stmt.close();
        conn.close();
    }
    catch(Exception e)
    {
e.printStackTrace();
}

      out.write("\n");
      out.write("</form>");
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
