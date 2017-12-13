<%-- 
    Document   : downloadfile
    Created on : 13.des.2017, 15:00:41
    Author     : mats, simen & nils
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DB.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table border="1">
  <tr>
    <th>File Name</th>
    <th>File Type</th>
    <th>Upload Time</th>
    <th>Action</th>
  </tr>
<%
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
%>            
</table>