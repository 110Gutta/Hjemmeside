package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import DB.DataBase;
import Moduler.Download;

public final class downloadfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<table border=\"1\">\n");
      out.write("  <tr>\n");
      out.write("    <th>File Name</th>\n");
      out.write("    <th>File Type</th>\n");
      out.write("    <th>Upload Time</th>\n");
      out.write("    <th>Action</th>\n");
      out.write("  </tr>\n");

        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();

        
        
  String query = "select docid,filename,typefile, uploadtime from documents";
  rs = st.executeQuery(query);
  
  
  int count =0;
  while(rs.next())
  {
    out.println("<tr>"
        + "<td>"+rs.getString(2)+"</td>"
        + "<td>"+rs.getString(3)+"</td>"
        + "<td>"+rs.getString(4)+"</td>"
    //    + "<td>"+rs.getString(5)+"</td>"
      //  + "<td>"+rs.getString(3)+"</td>"
     //   + "<td>"+rs.getString(4)+"</td>"
        + "<td>"
        + "<a href='downloadtest.jsp?docid="+rs.getInt(1) +"'> Download </a>"
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

      out.write("            \n");
      out.write("</table>\n");
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
