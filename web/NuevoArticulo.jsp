<%-- 
    Document   : NuevoArticulo
    Created on : May 28, 2018, 3:37:34 PM
    Author     : aapb9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="principal.css">
<jsp:include page="MenuNav.jsp" />
<!DOCTYPE html>
<html>
    <head>
	<title>La Brújula - Nuevo Artículo</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="contenidoP">
	    <h1>Crear Nuevo Artículo</h1>  
	    <form method="POST" action="CrearArticulo" id="edicionArticulo">
                Título: 
                <input type="text" name="titulo" placeholder="Título del artículo...">
                <br>
                <br>
                Imagen del artículo:
                <input type="text" name="imagen" placeholder="URL de la imagen...">
                <br>
                <br>
                Contenido:
                <br>
                <textarea rows="20" cols="70" name="contenido" form="edicionArticulo" placeholder="Escriba aquí el contenido..."></textarea>
                <br>
                <br>
                Categoría:
                <select name="categoria">
                    <option value="Tecnologia">Tecnología</option>
                    <option value="Artes">Artes</option>
                    <option value="Politica">Política</option>
                    <option value="Naturaleza">Naturaleza</option>
                    <option value="Actualidad">Actualidad</option>
                </select>
                <br>
                <br>
                <input type="submit" value="Enviar">
            </form>
	</div>
    </body>
</html>
