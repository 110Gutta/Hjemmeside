/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Java.DataBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nilsf
 */
public class LoginTest extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
           String password = request.getParameter("password");
          
            
            DataBase db = new DataBase();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            
            
     
            String SQL = "SELECT name,pass from user where name='"+username+"'and pass='"+password+"'";
            
            ResultSet rs = st.executeQuery(SQL);
            

            
        if(rs.next()) {
                
                out.println("You are logged in");
            } else {
                out.println("The user does not exist");
            }
            
      
            
            
        } catch (SQLException ex) {
           Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
          
        }
     }
}