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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aapb9
 */
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");      
        /*Aquí obtenemos las credenciales del usuario que fueron ingresadas en el formulario de inicio de sesión*/
        String nickname = request.getParameter("usuario");
	String password = request.getParameter("clave");
	
	/*Valor vacío donde guardamos la verdadera contraseña perteneciente al usuario*/
	String password2 = null;
	
	/*Valor vacío donde guardamos el nivel de privilegios del usuario*/
	String nivel = null;
			
	/*Aquí creamos una conexión a la base de datos, buscamos los datos de la cuenta que ingresamos*/
        
        String driverName = "org.apache.derby.jdbc.ClientDriver";
        String connectionUrl = "jdbc:derby://localhost:1527/BaseDeCultura";
        String userName = "Josue";
        String pass = "josue";
        
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        System.out.println("Check1");
        try{
            Connection connection = DriverManager.getConnection(connectionUrl, userName, pass);
            Statement statement = connection.createStatement();
            String sql = "select * from USUARIOS where USUARIO = '"+ nickname +"' and CLAVE = '"+ password +"'";
            ResultSet resultados = statement.executeQuery(sql);
	    while(resultados.next()){
		password2 = resultados.getString("CLAVE");
		nivel = resultados.getString("PRIVILEGIOS");
                System.out.println("Check2");
	    }	    
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
        password2 = password2.replaceAll("\\s+","");
        nivel = nivel.replaceAll("\\s+","");
        System.out.println("Check3");
        System.out.println("1 " + password);
        System.out.println("2 " + password2);
        
	/*Comparamos la contraseña que ingresamos con la contraseña en la base de datos. Si son iguales, iniciamos sesión, si no, no.*/
	HttpSession superusuario = request.getSession();
        if(password.equals(password2)){
            System.out.println("Son iguales");
        }
        
        
	try{
	    if(password.equals(password2)){
			superusuario.setAttribute("nickname",nickname);
			superusuario.setAttribute("privilegios",nivel);
			response.sendRedirect("Principal.jsp");
                        System.out.println(nickname);
	    } else {
			response.sendRedirect("Principal.jsp");
                        System.out.println(nickname);
	    }
	}catch(IOException e){
	    System.out.println("Redirección fallida");
	}
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
