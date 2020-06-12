<%-- 
    Document   : principal
    Created on : 29/01/2018, 09:01:16 AM
    Author     : Adrián Alejandro
--%>
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
	    <h1>Actualidad</h1>  
	    <table>
		<tr class="barraUNO">
		    <td>Título</td>
		    <td>Categoría</td>
		</tr>
<%
String driverName = "org.apache.derby.jdbc.ClientDriver";
String connectionUrl = "jdbc:derby://localhost:1527/BaseDeCultura";
String userName = "Josue";
String password = "josue";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
		<%
    try{
    connection = DriverManager.getConnection(connectionUrl, userName, password);
    statement = connection.createStatement();
    String sql = "SELECT * FROM ARTICULOS WHERE CATEGORIA = 'Actualidad'";

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
	    </table>
	    <br>
	</div>
	<br>
    </body>
</html>
