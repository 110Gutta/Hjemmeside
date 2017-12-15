<%-- 
    Document   : downloadfile
    Created on : 13.des.2017, 15:00:41
    Author     : mats, simen & nils
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DB.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

<body>
  <nav class="navbar navbar-expand-md bg-secondary navbar-dark">
    <div class="container">
      <a class="navbar-brand" href="ProfileStudent.jsp">SLIT</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="ProfileStudent.jsp">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="downloadFileModul.jsp">Modules</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="downloadfile.jsp">My Modules</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="uploadindex.jsp">Deliver Module</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="indexchat.jsp">Chatroom</a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link" href="LogoutServlet">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Log out</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="#"></a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="#"></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="py-5 text-center opaque-overlay" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);">
    <div class="container py-5">
      <div class="row">
        <div class="col-md-12 text-white">
          <h1 class="display-3 mb-4">Welcome ${firstname} </h1>
          <p class="lead mb-5">Du lærer hvordan du kan bidra til å utvikle informasjonssystemer, og hvordan digitalisering påvirker samfunnet, blant annet gjennom å: analysere brukerbehov, designe informasjonssystemer, utvikle databaseløsninger og programmere ha en grunnleggende
            forståelse av og kunnskap om hvordan IT og informasjonssystemer kan utvikles og anvendes bidra til at organisasjoner kan utnytte informasjonssystemer til å nå egne mål forstå rollen teknologi spiller i utvikling av organisasjoner og i samfunnet
            som helhet.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <ul class="list-group"></ul>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

</html>


<table border="1" align="center">
  <tr>
    <th>Module number</th>
    <th>File</th>
    <th>Filetype</th>
    <th>Uploaded</th>
    <th>Feedback</th>
    <th>Score</th>
    <th>Download</th>

  </tr>
<%
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            con = db.getCon();
            st = con.createStatement();


session = request.getSession(false);
                    if(session!=null){
           
                        String userid = (String)session.getAttribute("userid");
                        
                        String query =("select Delivery.moduleid, Delivery.filename, Delivery.typefile, Delivery.uploadtime, Feedback.deliveryfeedback, Feedback.score  from Delivery LEFT JOIN Feedback ON Delivery.userid = Feedback.userid AND Delivery.moduleid = Feedback.moduleid where Delivery.userid =" + userid);
  
                        rs = st.executeQuery(query);

  int count =0;
  while(rs.next())
  {
    out.println("<tr>"
        + "<td>"+rs.getString(1)+"</td>"
        + "<td>"+rs.getString(2)+"</td>"
        + "<td>"+rs.getString(3)+"</td>"
        + "<td>"+rs.getString(4)+"</td>"
        + "<td>"+rs.getString(5)+"</td>"
        + "<td>"+rs.getInt(6)+"</td>"
        + "<td>"
        + "<a href='download.jsp?moduleid="+rs.getInt(1) +"'> Download </a>"
        + "</td>"
        + "</tr>");
    count++;
  }
  rs.close();
  con.close();
  if(count==0)
  {
    out.println("<tr><td colspan='4'> No File Found..!! </td></tr>");
  }
                    } else{
                      out.print("Please login first");
                      request.getRequestDispatcher("login.html").include(request, response);
                    
                    }
%>            
</table>