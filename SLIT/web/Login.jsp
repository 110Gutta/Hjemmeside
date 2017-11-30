<%-- 
    Document   : login
    Created on : Nov 2, 2017, 6:43:14 PM
    Author     : nilsf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/custom-theme.css" rel="stylesheet" media="screen">
    </head>
    <body class="dark-bg">
        <div class="container">
   	  <div class="row">
   	 	<div class="col-md-offset-4 col-md-4">
   	        <div class="alert alert-danger" id="top-alert-box" style="display: none;"></div> 
   	  	</div>	
   	  </div>
      <div class="row">
        <div class="col-md-offset-4 col-md-4 white-box">
	 	    <div class="white-box-title text-center">
            	<img src="${pageContext.request.contextPath}/images/logo/logo.png" alt="Logo">
            	<h1 class="text-center">Sign in to account</h1>
                <p class="text-center">One Account For all Users</p>
            </div>
			<br>
			<form role="form" method="post" id="loginForm">
                <div class="form-group ">
                    <label for="first-name" class="control-label">Email</label>				
                    <input type="text" class="form-control" id="username" name="username" value="${param.username}" placeholder="Email" maxlength="250">
                    <span class="input-error" id="unameErrorMsg">Required field</span>
                </div>
                <div class="form-group">
                    <label for="pwd" class="control-label">Password</label>
                    <input type="password" class="form-control" id="pwd" name="password" placeholder="Password" maxlength="30">
                    <span class="input-error" id="pwdErrorMsg">Required field</span>    
                </div>
                <div class="form-group">
                	<div class="row">
                        <div class="col-md-6 hidden-xs">
                            <a href="${pageContext.request.contextPath}/forget-password" class="btn btn-danger btn-md btn-block">Forgot Password?</a>
                        </div>
                        <div class="col-md-6">
                        	<input type="hidden" name="action" value="login">
                            <button type="submit" class="btn btn-success btn-md btn-block" id="btnLogin">Sign In</button>
                        </div>
                        <div class="col-md-6 visible-xs">
                            <a href="${pageContext.request.contextPath}/forget-password" class="btn btn-danger btn-md btn-block">Forgot Password?</a>
                        </div>
                    </div>
                </div>
		      </form>
		      <p align="center">Don't have an account? </p>
		     <a href="${pageContext.request.contextPath}/register" class="sign-up-link"> <button class="btn btn-success btn-md btn-block">Create Account</button></a><br/>
		
		   </div>
       	</div>
    </div>
    <br><br><br><br>
        
        <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
        
         <script>
    	alertTimer = null;
    	$('#top-alert-box').width($('.col-md-4').width());
		$(document).ready(function(){
			$("#username").focus();
			
			$('#loginForm').submit(function(e){
				e.preventDefault();
				clearTimeout(alertTimer);
				$('#top-alert-box').hide();
				$('.input-error').hide();
    			$('.has-error').removeClass('has-error');
    			
				var username = $("#username").val();
				var pwd = $("#pwd").val();
                                
				var error = false;
				
				if(username=='' || username==null){
					$('#username').parent().addClass('has-error');
					$('#unameErrorMsg').text('Required field');
					$('#unameErrorMsg').show();
					error = true;
				}
				
				if(pwd=='' || pwd==null){
					$('#pwd').parent().addClass('has-error');
					$('#pwdErrorMsg').text('Required field');
					$('#pwdErrorMsg').show();
					error = true;
				}
				
				if(error){
					$('#top-alert-box').removeClass('alert-success').addClass('alert alert-danger');
					$('#top-alert-box').html('<p>:( Please correct following errors</p>');
					$('#top-alert-box').fadeIn();
					$("html, body").animate({ scrollTop: "0px" });
					alertTimer = setTimeout(function(){
						$('#top-alert-box').fadeOut();
					},20*1000);
				}else{
					$('input').prop('readonly','readonly');
					$('#btnLogin').prop('disabled','disabled');
					$('#btnLogin').html('<b>Please wait...</b>');
					$('#top-alert-box').removeAttr('class').addClass('alert alert-info');
					$('#top-alert-box').html('<p><b>:p Please wait...</b></p>');
					$('#top-alert-box').show();
					$.post('${pageContext.request.contextPath}/login',$(this).serialize(),function(data){
						if(data.success){
							$('#btnLogin').text('Login Success :)');
							if(data.isVerified){
								$('#top-alert-box').removeAttr('class').addClass('alert alert-success');
								$('#top-alert-box').html('<p><b>:) '+data.message+'. Redirecting...</b></p>');
							}else{
								$('#top-alert-box').removeAttr('class').addClass('alert alert-warning');
								$('#top-alert-box').html('<p><b>'+data.message+'. Redirecting...</b></p>');
							}
							$('#top-alert-box').fadeIn();
							alertTimer = setTimeout(function(){
								location.href= data.redirect;
							},1.5*1000);
						}else{
							$('input').removeAttr('readonly');
							$('#btnLogin').removeAttr('disabled');
							$('#btnLogin').text('Sign In');
							$('#top-alert-box').removeAttr('class').addClass('alert alert-danger');
							$('#top-alert-box').html('<p>'+data.message+'</p>');
							$('#top-alert-box').fadeIn();
							$("html, body").animate({ scrollTop: "0px" });
							alertTimer = setTimeout(function(){
								$('#top-alert-box').fadeOut();
							},20*1000);
						}
					});
				}
			});
		});
    </script>
    </body>
</html>
