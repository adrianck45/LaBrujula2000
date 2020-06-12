<%-- 
    Document   : MenuNav
    Created on : 30/01/2018, 01:10:25 PM
    Author     : Adrián Alejandro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="estiloprincipal.css">
	<link rel="icon" href="http://www.topandroide.com/static/3dcompass.jpg">
    </head>
    <body>
	    <div class="banner">
		<div class="titulo">
		    <h1>La Brújula</h1>
		</div>
		<div class="recortar">
		    <img class="imagencentrada" src="imagenes/mundo.jpg" alt=""/>
		</div>
	    </div>
	    <div class="menuNav">
		<ul>
		    <li><a href="Principal.jsp">Principal</a></li>
		    <li><a href="Tecnologia.jsp">Tecnología</a></li>
		    <li><a href="Artes.jsp">Artes</a></li>
		    <li><a href="Politica.jsp">Política</a></li>
		    <li><a href="Naturaleza.jsp">Naturaleza</a></li>
		    <li><a href="Actualidad.jsp">Actualidad</a></li>
		    <li><a href="Contacto.jsp">Contacto</a></li>
                    <li><a href="Principal_1.jsp">Prototipo</a></li>
		    <%	    
		    HttpSession sessions = request.getSession(false);
		    String nick = (String) sessions.getAttribute("nickname");
                    String nivel = (String) sessions.getAttribute("privilegios"); 
		    if(nick == null){
			%>
		    <li class="alignRight"><a><button class="trigger">Iniciar Sesión</button></a></li>
		    <%
		    }else if(nick != null){
		    %>
		    <li>
			<a>${nickname} (${privilegios})</a>
		    </li>
		    <li class="alignRight">
			<a>
			    <form action="LogoutServlet" method="POST">
				<input type="submit" name="LogoutServlet" value="Cerrar Sesión">
			    </form>
			</a>
		    </li>
		    <%
		    }
 %>
		</ul>
	    </div>
	    <br>
	   
	    <div class="modal">
		<div class="modal-content">
		    <span class="close-button">&times;</span>
		    <h1>Iniciar Sesión</h1>
		    <form method="POST" action="LoginServlet">
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
		</div>
	    </div>
	
	    <script>
		var modal = document.querySelector(".modal");
    var trigger = document.querySelector(".trigger");
    var closeButton = document.querySelector(".close-button");

    function toggleModal() {
        modal.classList.toggle("show-modal");
    }

    function windowOnClick(event) {
        if (event.target === modal) {
            toggleModal();
        }
    }

    trigger.addEventListener("click", toggleModal);
    closeButton.addEventListener("click", toggleModal);
    window.addEventListener("click", windowOnClick);
		</script>

    </body>
</html>
