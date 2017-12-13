<%--
    Document   : uploadfile2
    Created on : Dec 13, 2017, 3:42:00 PM
    Author     : nilsf
--%>
 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page import="DB.DataBase"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        upload file page...!!!
        <%
            String rtempfile = File.createTempFile("temp","1").getParent();            
            MultipartRequest multi = new MultipartRequest(request,rtempfile, 15*1024*1024);     // maximum size 15 MB
           
            Enumeration files = multi.getFileNames();
                    DataBase db = new DataBase();
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();
           
 
            String SQL="insert into documents(filename, typefile, file) values (?,?,?)";
            PreparedStatement psmt = con.prepareStatement(SQL);
           
                       
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
                                    psmt.setString(1, ff.getName());
                                    psmt.setString(2, fileExtesion);
                                    psmt.setBinaryStream(3,(InputStream)fin, (int)(ff.length()));
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
        %>
        <a href="index2.jsp">Home Page</a>
    </body>
</html>