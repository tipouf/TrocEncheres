<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String error = (String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encheres - Inscription</title>

	<h1>Inscription</h1>
	
	<form action="" method="POST">
	
		<input type="text" name="pseudo" required>
		<input type="text" name="nom" required>
		<input type="text" name="prenom" required>
		<input type="email" name="email" required>
		<input type="phone" name="telephone">
		<input type="text" name="rue" required>
		<input type="text" name="codePostal" required>
		<input type="text" name="ville" required>
		<input type="password" name="password" required>
		
		<input type="submit">
		
		<% if(error != null) { %>
			<span class=""><%= error %></span>
		<% } %>
	</form>

</head>
<body>

</body>
</html>