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
        <h1>Module</h1>
        <form method="post" action="upload.jsp" enctype="multipart/form-data">
            <table border="0">
                <tr>
   
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Deliver">
                    </td>
                </tr>
            </table>
        </form>
        <form method="post" action="DownloadServ" enctype="multipart/form-data">
            <table border="0">
                <tr>
   
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Download">
                    </td>
                </tr>
            </table>
        </form>
       
    </center>
</body>
</html>