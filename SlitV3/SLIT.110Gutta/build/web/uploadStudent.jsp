<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Image</title>
</head>
<body>
    <center>
        <h1>File Upload to Image</h1>
        <form method="post" action="DeliverModuleStudent" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" size="50"/></td>
                </tr>
                <tr>
                    <td>Modul nummer: </td>
                    <td><input type="text" name="modulID" size="50"/></td>
                </tr>
                <tr>
                    <td>Upload file: </td>
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