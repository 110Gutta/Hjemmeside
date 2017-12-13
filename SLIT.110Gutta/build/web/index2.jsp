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
        <h1>Last opp fil!</h1>
                       
        <form enctype="multipart/form-data" action="uploadfile.jsp" method="post" onsubmit="return verify()">      
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
                        <input type="submit" value="Save File" />
                    </td>
                </tr>                
            </table>            
        </form>
        <br/>
        <br/>
        <a href="downloadfile.jsp"> download file</a>
    </body>
</html>