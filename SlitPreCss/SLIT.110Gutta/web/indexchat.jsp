<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String WsUrl = getServletContext().getInitParameter("WsUrl"); %>
<html>
<head>
<script type="text/javascript" src="chat.js"></script>
<script type="text/javascript">
var wsUri = '<%=WsUrl%>';
var operator = Create(wsUri);

document.addEventListener("DOMContentLoaded", function(event) {
	console.log(document.getElementById('loginPanel'));
	operator.initiate({
		loginPanel: document.getElementById('loginPanel'),
		msgPanel: document.getElementById('msgPanel'),
		txtMsg: document.getElementById('txtMsg'),
		firstname: document.getElementById('firstname'),
		msgContainer: document.getElementById('msgContainer')
	});
});

</script>
</head>
<body>
    <style>
textarea {
  border: 1px solid black;
  background: blue;
  color: white;
  padding: 10px;
  width: 800px;
  height: 400px;
}



</style>
 

<div id="container">
	<div id="loginPanel">
		<div id="infoLabel">Click the button to join the chatroom</div>
		<div style="padding: 10px;">
			<input id="firstname" value="<%= session.getAttribute("firstname") %>" type="text" class="loginInput"
				onkeyup="operator.login_keyup(event)" />
			<button type="button" class="loginInput" onclick="operator.login()">Join the room</button>
		</div>
	</div>
                                
                                
	<div id="msgPanel" style="display: none">
		<div id="msgContainer" style="overflow: auto"></div>
		<div id="msgController"> 
                
			<textarea id="txtMsg"  
				title="Enter to send message"
				onkeyup="operator.sendMessage_keyup(event)"
				style="height: 20px; width: 100%"></textarea>
			<button style="height: 30px; width: 100px" type="button"
				onclick="operator.logout()">Logout</button>
		</div>
	</div>
</div>
</body>
</html>