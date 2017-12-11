<%--
    Document   : studentlist
    Created on : 11.des.2017, 13:03:54
    Author     : Simen Fredriksen
--%>
 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
 
</body>
 
 
<form method="post">
 
<table border="2">
<tr>
<td>Fornavn</td>
<td>Etternavn</td>
<td>Email</td>
<td>Modul</td>
 
 
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/slit";
String username="root";
String password="root";
String query="SELECT * FROM bruker";
Connection conn=DriverManager.getConnection(url, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
 
%>
<tr>
<td><%=rs.getString("forNavn") %></td>
<td><%=rs.getString("etterNavn") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getBlob("modul") %></td>
</tr>
 <%
 
}
%>
</table>
<%
rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</form>