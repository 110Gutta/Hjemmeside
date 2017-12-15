<%--
    Document   : moduleUploadIndex
    Created on : 14.des.2017, 21:27:46
    Author     : Simen Fredriksen
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="linkteacher.html" %>
<!DOCTYPE html>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function verify()
            {
                if(document.getElementById('filename').value=="")
                {
                    alert('Please select the file');
                    return false;                
                }
                else
                {
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <h1>Upload module</h1>
                       
        <form enctype="multipart/form-data" action="uploadModule.jsp" method="post" onsubmit="return verify()">      
            <table border='1'>
                <tr>
                    <td>
                        <br/>
                        Remember you can upload only MS-word, MS-Excel, txt and PDF files. max size = 15mb
                        <br/>
                        <br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="file" name="filename" id="filename" accept=".txt, application/pdf, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/msword"  />                                                            
                    </td>
 
                </tr>
                <tr>
                    <td>
                      Module number:  <input type="text" name="moduleid" />
                    </td>
                </tr>
                <tr>
                    <td>
                      Module name:  <input type="text" name="modulename" />
                    </td>
                </tr>
 
                <tr>
                    <td>
                        <input type="submit" value="Save File" />
                    </td>
                </tr>                
            </table>            
        </form>
        <br/>
        <br/>
 
    </body>
</html>