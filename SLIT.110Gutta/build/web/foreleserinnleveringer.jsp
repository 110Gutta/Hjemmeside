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
    <th>Modulnummer</th>
    <th>Filnavn</th>
    <th>Filtype</th>
    <th>Opplastet</th>
    <th>Last ned</th>
    <th>Gi tilbakemelding</th>
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
 
        
        String userid = request.getParameter("userid");
  String query = "select moduleid,filename,typefile, uploadtime from Delivery where userid = " + userid;
  rs = st.executeQuery(query);
  

  int count =0;
  while(rs.next())
  {
    out.println("<tr>"
        + "<td>"+rs.getString(1)+"</td>"
        + "<td>"+rs.getString(2)+"</td>"
        + "<td>"+rs.getString(3)+"</td>"
        + "<td>"+rs.getString(4)+"</td>"
        + "<td>"
        + "<a href='download.jsp?moduleid="+rs.getInt(1) +"' > Download </a>"
        + "</td>"
        + "<td>"
        + "<a href='tilbakemeldingForeleser.jsp?moduleid="+rs.getInt(1)+"&userid="+userid+"  ' > Gi tilbakemelding </a>"
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
