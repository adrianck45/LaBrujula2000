/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aapb9
 */
public class CrearArticulo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
        /*Aquí obtenemos los nuevos datos que vamos a actualizar en los artículos*/
        String titulo = request.getParameter("titulo");
	String imagen = request.getParameter("imagen");
        String contenido = request.getParameter("contenido");
        String categoria = request.getParameter("categoria");
        int id = 0;
        
        /*Abrimos conexión a la base de datos y hacemos los cálculos para agregar un número de ID*/
        try{
	    Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/BaseDeCultura", "Josue", "josue");
            Statement statement = connection.createStatement();
            String sql = "select MAX(ID_ART) as Ultimo_ID from ARTICULOS";
            ResultSet resultados = statement.executeQuery(sql);
	    while(resultados.next()){
		id = resultados.getInt("Ultimo_ID");
                System.out.println("Check2");
	    }
	}catch(SQLException e){
	    System.out.println("Conexión Fallida");
	}
        
        id = id + 1;
        String Sid = Integer.toString(id);
        
      
         /*Aquí creamos una conexión a la base de datos e ingresamos los datos*/
	try{
	    Connection conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/BaseDeCultura", "Josue", "josue");	    
            String sql = "insert into ARTICULOS values ('"+ titulo +"','"+ imagen +"','"+ categoria +"','"+ contenido +"',"+ id +",'"+ Sid +"')";
            System.out.println(sql);
	    PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.executeUpdate();
	}catch(SQLException e){
	    System.out.println("Creación Fallida");
            e.printStackTrace();
	}
               
        response.sendRedirect("Principal.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
