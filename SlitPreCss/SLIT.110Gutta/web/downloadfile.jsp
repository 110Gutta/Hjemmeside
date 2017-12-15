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
<%@include  file="link.html" %>
<!DOCTYPE html>
<table border="1">
  <tr>
    <th>Module number</th>
    <th>File</th>
    <th>Filetype</th>
    <th>Uploaded</th>
    <th>Feedback</th>
    <th>Score</th>
    <th>Download</th>

  </tr>
<%
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();


session = request.getSession(false);
                    if(session!=null){
           
                        String userid = (String)session.getAttribute("userid");
                        
                        String query =("select Delivery.moduleid, Delivery.filename, Delivery.typefile, Delivery.uploadtime, Feedback.deliveryfeedback, Feedback.score  from Delivery LEFT JOIN Feedback ON Delivery.userid = Feedback.userid AND Delivery.moduleid = Feedback.moduleid where Delivery.userid =" + userid);
  
                        rs = st.executeQuery(query);

  int count =0;
  while(rs.next())
  {
    out.println("<tr>"
        + "<td>"+rs.getString(1)+"</td>"
        + "<td>"+rs.getString(2)+"</td>"
        + "<td>"+rs.getString(3)+"</td>"
        + "<td>"+rs.getString(4)+"</td>"
        + "<td>"+rs.getString(5)+"</td>"
        + "<td>"+rs.getInt(6)+"</td>"
        + "<td>"
        + "<a href='download.jsp?moduleid="+rs.getInt(1) +"'> Download </a>"
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
%>            
</table>