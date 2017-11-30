<%-- 
    Document   : Register
    Created on : Nov 18, 2017, 2:51:08 AM
    Author     : nilsf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
    <head>
        <meta charset="utf-8"/>
	<title> SLIT-Project </title>
	<meta name="viewport" content="width=device-width, minimumscale=
	1.0, maximum-scale=1.0" />
    </head>
    
    <body>
        
        
                  
        <div id="container">
            <header id="header">
                <hgroup>
                    <h1><a href="index.html" style="text-decoration:none">SLIT</a></h1>
                     
                </hgroup>
            </header>
            </div>
        
            <div id="content">
		<article class="post">
			<h2>Enter your information</h2>
            <div class="form">
                <form action="RegisterServlet" method="post" >
                First name: <input type="text" placeholder="first name" name="firstName" ></br>
                Last name: <input type="text" placeholder="last name" name="lastName" ></br>
                Email: <input type="text" placeholder="email" name="email"></br>
                Password: <input type="password" placeholder="password" name="password" ></br>
                <input type="submit" value="register" ></br>
                
               
            </div>
	
      
        </div>
    
            <div>
                <footer id="footer">
	Made by: C0deNerds
	</footer>
            </div>
    </body>
          

</html>

