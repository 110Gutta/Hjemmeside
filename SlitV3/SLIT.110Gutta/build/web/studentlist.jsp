<%--
    Document   : studentlist
    Created on : 11.des.2017, 13:03:54
    Author     : Simen Fredriksen
--%>
 
<%@page import="DB.DataBase"%>
<%@page import="Constants.Constants"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html
<html>
<head>
<meta charset="utf-8"/>
<title> SLIT-Project </title>
<meta name="viewport" content="width=device-width, minimumscale=
     1.0, maximum-scale=1.0" />
  
<title>Students</title>
</head>
<body>
 
</body>
 
<form method="post">
 
<table border="2">
<tr>
<td>UserID</td>
<td>Fornavn</td>
<td>Etternavn</td>
<td>Email</td>
<td>Moduler</td>

 
 
</tr>
<%
    
try
{
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();
            String query= Constants.sqlWriteStudent;

            rs = st.executeQuery(query);

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
%>
</table>
<%
        rs.close();
        st.close();
        con.close();
    }
    catch(Exception e)
    {
e.printStackTrace();
}
%>
</form>