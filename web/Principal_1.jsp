<%-- 
    Document   : principal
    Created on : 29/01/2018, 09:01:16 AM
    Author     : Adrián Alejandro
--%>
<%@page import="modelo.ConexionDB"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="principal.css">
<jsp:include page="MenuNav.jsp" />
<!DOCTYPE html>
<html>
    <head>
	<title>La Brújula</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="js/abreviador.js"></script>
    </head>
    <body>	
	<div class="contenidoP">
	    <h1>Últimas Publicaciones</h1>  
	    <table>
		<tr class="barraUNO">
		    <td>Título</td>
		    <td>Categoría</td>
		</tr>
<%
    Statement statement = null;
    ResultSet resultSet = null;

    ConexionDB conexion = new ConexionDB();
    conexion.abrirConexion();

    try{
    statement = conexion.obtenerConexion().createStatement();
    String sql = "SELECT * FROM ARTICULOS";

    resultSet = statement.executeQuery(sql);
    while (resultSet.next()) {
    %>
		    
		    <tr class="snippet">
			<td>
			    <a href="<%=request.getContextPath()%>/GeneradorArticulo?idArticulo=<%=resultSet.getString("ID_ARTICULO")%>"><%=resultSet.getString("TITULO")%></a>
			    <p class="ellipsis"><%=resultSet.getString("CONTENIDO")%></p>
			</td>
			<td><%=resultSet.getString("CATEGORIA")%></td>
			<td class="fondoImagen">
			    <img src="<%=resultSet.getString("IMAGEN")%>">
			</td>
		    </tr>
		<%
    }
    } catch (SQLException e) {
    System.out.println("Ha ocurrido un error");
    e.printStackTrace();
    }
    %>
		<tr class="snippet">
			<td>
			    <a href="articulo1.jsp">YouTube Is Serving Covert Cryptocurrency Mining Ads</a>
			    <p class="ellipsis">Stealth cryptocurrency mining in one’s browser, without the user’s permission, is one of our least-favorite trends of the past six months. While there were always questions about whether cryptocurrency mining in-browser could serve as an alternate revenue stream for websites, there was at least an idea that some kind of alternate funding system might emerge — hopefully putting an end to the eternal cycle of invasive ads driving users to deploy ad blockers, which then drives websites to adopt more invasive ads.</p>
			</td>
			<td>Artes</td>
			<td class="fondoImagen">
			    <img src="https://www.extremetech.com/wp-content/uploads/2017/12/555358-cryptocurrency-bitcoin-chip-640x360.jpg" alt=""/>
			</td>
		    </tr>
	    </table>
	    <br>
	</div>
	<br>
    </body>
</html>
