<%-- 
    Document   : downloadtest
    Created on : 13.des.2017, 15:33:43
    Author     : mats, simen & nils
--%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DB.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();
  
  String docid = request.getParameter("docid");     
  String query = "select filename, typefile, file from Documents where docid = " + docid;
  rs = st.executeQuery(query);
  
  
  
  
  
  rs.next();
  
  // clear the response header information.
  response.reset();                        
  // check the file type and set the header contentType accordingly..   
  if(rs.getString(2)==".txt")
  {
      response.setContentType("application/octet-stream");
  }
  else if(rs.getString(2)==".pdf")
  {
      response.setContentType("application/pdf");
  }
  else if((rs.getString(2)==".doc")||rs.getString(2)==".docx")
  {
      response.setContentType("application/msword");
  }
  else if((rs.getString(2)==".xls")||(rs.getString(2)==".xlsx"))
  {
      response.setContentType("application/vnd.ms-excel");
  }
  // add header information to response object
  response.addHeader("Content-Disposition","attachment; filename="+rs.getString(1));
  // create the byte array from Blob
  Blob blb = rs.getBlob(3);
  byte[] bdata = blb.getBytes(1, (int) blb.length());
  
  // get the response Output stream object to write the content of the file into header
  OutputStream output =  response.getOutputStream();
  output.write(bdata);
  output.close();
  // close the obejct of ResultSet
  rs.close();
  
  // close the connection object.. 
  con.close();
%>