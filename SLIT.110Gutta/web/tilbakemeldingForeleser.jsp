<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DB.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
 <%
            //String userid=request.getParameter("userid");
            //String moduleid=request.getParameter("moduleid");
%>
<html>

<form action="Tilbakemelding" method="post"> 

Score:<input type="text" name="score"><br>
Feedback:<input type="text" name="deliveryfeedback"><br>
<input type="hidden" name="userid" value="<%= request.getParameter("userid")%>">
<input type="hidden" name="moduleid" value="<%= request.getParameter("moduleid")%>">

<input type="submit" value="Give feedback">





<p><a href="studentlist.jsp">Back to students</a></p>

</form>  
</html>