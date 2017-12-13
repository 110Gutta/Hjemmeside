<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filopplastning</title>
</head>
<body>
    <center>
        <h1>Filopplastning</h1>
        <form method="post" action="FileUploadDBServlet" enctype="multipart/form-data">
            <table border="0">
                 <tr>
                    <td>Modul NR: </td>
                    <td><input type="text" name="moduleid" size="50"/></td>
                </tr>
                <tr>
                    <td>Modul name: </td>
                    <td><input type="text" name="modulName" size="50"/></td>
                </tr>
                <tr>
                    <td>Modul læringsmål: </td>
                    <td><input type="text" name="modulgoals" size="50"/></td>
                </tr>
                 <tr>
                    <td>Modul beskrivelse: </td>
                    <td><input type="text" name="modulText" size="50"/></td>
                </tr>
                <tr>
                    <td>Last opp fil: </td>
                    <td><input type="file" name="file" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
        
       
        
        <a href="Profile.jsp">go to site</a>
    </center>
</body>
</html>