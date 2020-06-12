<%-- 
    Document   : articuloEnBlanco
    Created on : 29/01/2018, 09:45:23 AM
    Author     : Adrián Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="principal.css">
<jsp:include page="MenuNav.jsp" />
<!DOCTYPE html>
<html>
    <head>
	<title>${TITULO} - La Brújula</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%	    
        HttpSession sessions = request.getSession();
        String nivel = (String) request.getSession().getAttribute("privilegios");
			%>
        <div class="contenidoP">
	    <h1>${TITULO}</h1>
            <b value="${ID_ARTICULO}"></b>
            <%
            if("administrador".equals(nivel)){          
            %>
            <button class="trigger2">Editar</button>
            <%
            }
            %>

            <h5>${CATEGORIA}</h5>
	    <br>
	</div>
	<div class="contenidoP">
	    <img src="${IMAGEN}" alt=""/>
	    <br>
	</div>
	<div class="contenidoP">
	    <p>${CONTENIDO}</p>
            <br>
	</div>
        <br>
            
         <div class="modal2">
		<div class="modal-content2">
		    <span class="close-button2">&times;</span>
		    <h1>Editar Artículo</h1>
		    <form method="POST" action="EditarArticulo" id="edicionArticulo">
			Título anterior: ${TITULO} 
                        <br>
                        Nuevo título: 
			<input type="text" name="nuevoTitulo" placeholder="${TITULO}">
                        <br>
                        <br>
                        URL Imagen anterior: ${IMAGEN}
                        <br>
                        Nueva imagen:
                        <input type="text" name="nuevaImagen" placeholder="${IMAGEN}">
			<br>
                        <br>
			Contenido:
                        <textarea rows="20" cols="70" name="nuevoContenido" form="edicionArticulo">${CONTENIDO}</textarea>
			<br>
                        <br>
                        Categoría:
                        <input type="text" name="nuevaCategoria" placeholder="${CATEGORIA}">
			<br>
			<input type="submit" value="Enviar">
                        <input type="hidden" name="id_articulo" value="${ID_ARTICULO}">
		    </form>
		    <a href="<%=request.getContextPath()%>/EliminarArticulo?idArticulo=${ID_ART}">Eliminar Artículo</a>
		</div>
	    </div>
	
	    <script>
		var modal2 = document.querySelector(".modal2");
    var trigger2 = document.querySelector(".trigger2");
    var closeButton2 = document.querySelector(".close-button2");

    function toggleModal2() {
        modal2.classList.toggle("show-modal2");
    }

    function windowOnClick2(event) {
        if (event.target === modal2) {
            toggleModal2();
        }
    }

    trigger2.addEventListener("click", toggleModal2);
    closeButton2.addEventListener("click", toggleModal2);
    window.addEventListener("click", windowOnClick);
		</script>   
    </body>
</html>
