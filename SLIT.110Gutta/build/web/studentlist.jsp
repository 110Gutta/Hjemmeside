<%--
    Document   : studentlist
    Created on : 11.des.2017, 13:03:54
    Author     : Simen Fredriksen
--%>
 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
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
<td>Fornavn</td>
<td>Etternavn</td>
<td>Email</td>
<td>Modul 1</td>
<td>Modul 2</td>
<td>Modul 3</td>
<td>Modul 4</td>
<td>Modul 5</td>
<td>Modul 6</td>
<td>Modul 7</td>
<td>Modul 8</td>
<td>Modul 9</td>
<td>Modul 10</td>
<td>Modul 11</td>
<td>Modul 12</td>
 
 
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/prog";
String username="root";
String password="bjerk7412395";
String query="SELECT user.firstname,user.lastname,user.email,delivery.deliveryfile" +
"FROM delivery" +
"INNER JOIN User ON delivery.email = User.email" +
"group by email";
Connection conn=DriverManager.getConnection(url, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
 
%>
<tr>
<td><%=rs.getString("firstname") %></td>
<td><%=rs.getString("lastname") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>
<td><%=rs.getBlob(1) %></td>


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