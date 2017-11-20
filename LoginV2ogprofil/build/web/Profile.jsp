<!DOCTYPE html>


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="Hjemmeside.css" type="text/css"> 
</head>


<body>
    <% String id = request.getParameter("username"); %>
  <nav class="navbar navbar-expand-md bg-secondary navbar-dark text-center fixed-top">
    <div class="container text-center">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
        <ul class="navbar-nav mx-2">
          <li class="nav-item">
            <a class="nav-link" href="#">Str�m</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Studenter
              <br> </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Info</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="py-5 text-center opaque-overlay" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);">
    <div class="container py-5">
      <div class="row">
        <div class="col-md-12 text-white">
          <h1 class="display-3 mb-4">IS-200</h1>
          <p class="lead mb-5">Du l�rer hvordan du kan bidra til � utvikle informasjonssystemer, og hvordan digitalisering p�virker samfunnet,</p>
          
          <a href="#" class="btn btn-lg btn-primary mx-1"><i class="fa fa-user fa-fw"></i> username </a>
          
        </div>
      </div>
    </div>
  </div>
  <div class="modal">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Philip</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-header m-0">
          <h6 class="modal-title">7.september</h6>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <p>Modal body text goes here.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">Save changes</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

