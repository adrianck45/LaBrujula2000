<%-- 
    Document   : Login
    Created on : 21/04/2018, 08:36:54 AM
    Author     : Adrián Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="principal.css">
<jsp:include page="MenuNav.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <title>La Brújula - Registro</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
	<div class="contenidoP">
	    <h1>Formulario de Registro</h1>  

	    <form method="POST" action="SignUpServlet">
		Usuario:
		<input type="text" name="usuario">
		<br>
		<br>
		Contraseña:
		<input type="password" name="clave">
		<br>
		<br>
		<input type="submit" value="Enviar">
	    </form>
	    ${mensaje}
	</div>
    </body>
</html>
