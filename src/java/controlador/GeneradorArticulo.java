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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aapb9
 */
public class GeneradorArticulo extends HttpServlet {

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
        /*Aquí obtenemos las credenciales del usuario que fueron ingresadas en el formulario de inicio de sesión*/
            String articuloID = request.getParameter("idArticulo");

            String imagenURL =  null;
            String tituloArticulo = null;
            String contenidoArticulo = null;
            String categoriaArticulo = null;
            int idArticulo = 0;
            String idArt = null;

            /*Credenciales para la base de datos*/
            String urlDB = "jdbc:derby://localhost:1527/BaseDeCultura";
            String userDB = "Josue";
            String passDB = "josue";

            /*Aquí creamos una conexión a la base de datos, buscamos los datos de la cuenta que ingresamos*/
            try{
                Connection conexion = DriverManager.getConnection(urlDB, userDB, passDB);
                Statement stmt = conexion.createStatement();
                String sql = "select * from ARTICULOS where ID_ARTICULO = "+ articuloID + "";	    
                ResultSet resultados = stmt.executeQuery(sql);
                while(resultados.next()){
                    tituloArticulo = resultados.getString("TITULO");
                    contenidoArticulo = resultados.getString("CONTENIDO");
                    imagenURL = resultados.getString("IMAGEN");
                    categoriaArticulo = resultados.getString("CATEGORIA");
                    idArticulo = resultados.getInt("ID_ARTICULO"); 
                    idArt = resultados.getString("ID_ART");
                }	    
            }catch(SQLException e){
                System.out.println("Recuperación Fallida");
            }
            
            /*ASIGNAMOS TODO*/
            HttpSession session = request.getSession();
            
            session.setAttribute("TITULO", tituloArticulo);
            session.setAttribute("IMAGEN", imagenURL);
            session.setAttribute("CONTENIDO", contenidoArticulo);
            session.setAttribute("CATEGORIA", categoriaArticulo);
            session.setAttribute("ID_ARTICULO", idArt);
            response.sendRedirect("articuloEnBlanco.jsp");
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
