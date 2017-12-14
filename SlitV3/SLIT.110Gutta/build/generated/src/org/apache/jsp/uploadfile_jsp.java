package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.io.InputStream;
import DB.DataBase;
import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.util.Enumeration;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;

public final class uploadfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        upload file page...!!!\n");
      out.write("        ");

            String rtempfile = File.createTempFile("temp","1").getParent();            
            MultipartRequest multi = new MultipartRequest(request,rtempfile, 15*1024*1024);     // maximum size 15 MB
           
            Enumeration files = multi.getFileNames();
            
            session = request.getSession(false);
                    if(session!=null){
            int userid = (Integer)session.getAttribute("userid");
            
            
            DataBase db = new DataBase();        
            Connection con = null;
            Statement st = null;

            // String em = "nils@nils.no";
            
            
            con = db.getCon();
            st = con.createStatement();

 
            String SQL="insert into Delivery(userid, moduleid, filename, typefile, file) values (?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(SQL);
            String moduleid = multi.getParameter("moduleid");
            out.print(moduleid);

            String name="";
            String fileExtesion="";
            File ff =null;
            FileInputStream fin =null;
            
           
            while (files.hasMoreElements())
            {
                    name=(String)files.nextElement();                                        
                    ff = multi.getFile(name);
                    fileExtesion = ff.getName().substring(ff.getName().lastIndexOf("."));
                   
                    boolean fileAllowed = fileExtesion.equalsIgnoreCase(".txt")||
                                          fileExtesion.equalsIgnoreCase(".pdf")||
                                          fileExtesion.equalsIgnoreCase(".doc")||
                                          fileExtesion.equalsIgnoreCase(".docx")||
                                          fileExtesion.equalsIgnoreCase(".xls")||
                                          fileExtesion.equalsIgnoreCase(".xlsx");
                   
                    if((ff!=null)&&fileAllowed)
                    {
 
                            try
                            {
                                
                                
                                    fin=new FileInputStream(ff);
                                    psmt.setInt(1, userid);
                                    psmt.setString(2, moduleid);
                                    psmt.setString(3, ff.getName());
                                    psmt.setString(4, fileExtesion);
                                    psmt.setBinaryStream(5,(InputStream)fin, (int)(ff.length()));
                                            // pass the user name or id
                                    boolean sss = psmt.execute();
                                   
                                    out.print("uploaded successfully..");
                                    out.print("<br/> Go to <a href='downloadfile.jsp'>Download</a> page");
                            }
 
                            catch(Exception e)
                            {
                                    out.print("Failed due to " + e);
                            }
 
                            finally
                            {
                            // next statement is must otherwise file will not be deleted from the temp as fin using f.
                             // its necessary to put outside otherwise at the time of exception file will not be closed.
                                    fin.close();
                                    ff.delete();
                            }
                    }
                    else
                    {
                           out.print("Please select the correct file...");
                    }// end of if and else
            }// end of while
                                           
            con.close();
                    }
        
      out.write("\n");
      out.write("        <a href=\"uploadhtml.jsp\">Home Page</a>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
