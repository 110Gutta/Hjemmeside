<!DOCTYPE html>
<html>

<head></head>

<body>
    <meta page contentType="text/html" pageEncoding="UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="alert alert-danger" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">�</button>
            <h4 class="alert-heading">Modulen finnes ikke!</h4>
            <p class="mb-0" contenteditable="true">Pr�v et annet modul.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <nav class="navbar navbar-expand-md bg-secondary navbar-dark">
    <div class="container">
      <a class="navbar-brand" href="studentlist.jsp">SLIT</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="studentlist.jsp">Overview</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="moduleUploadIndex.jsp">Create Modul</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="deleteModul.jsp">Delete Modul</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="deleteUser.jsp">Delete User</a>
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
          <p class="lead mb-5">Du l�rer hvordan du kan bidra til � utvikle informasjonssystemer, og hvordan digitalisering p�virker samfunnet, blant annet gjennom �: analysere brukerbehov, designe informasjonssystemer, utvikle databasel�sninger og programmere ha en grunnleggende
            forst�else av og kunnskap om hvordan IT og informasjonssystemer kan utvikles og anvendes bidra til at organisasjoner kan utnytte informasjonssystemer til � n� egne m�l forst� rollen teknologi spiller i utvikling av organisasjoner og i samfunnet
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
  <div id="container">
    <header id="header"> </header>
  </div>
  <div id="content" align="center">
    <article class="post">
      <h2>Enter your information</h2>
      <div class="form">
        <form action="DeleteModul" method="POST"> Module number:
          <input type="text" placeholder="module nr" name="id">
          <br>
          <input type="submit" value="Delete">
          <br> </form>
      </div>
    </article>
  </div>
</body>

</html>