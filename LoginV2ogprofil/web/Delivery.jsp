<%-- 
    Document   : Delivery
    Created on : 30.nov.2017, 13:41:43
    Author     : mats
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Image</title>
</head>
<body>
    <center>
        <h1>File Upload to Image</h1>
        <form method="post" action="deliveryServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Modul name: </td>
                    <td><input type="text" name="modulName" size="50"/></td>
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
    </center>
</body>
</html>

