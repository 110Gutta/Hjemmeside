package User;
 
 
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import DB.DataBase;
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
import Constants.Constants;

 
/**
 *
 * @author Mats
 */
public class RegisterServletDAO extends HttpServlet {
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
       
        String adminpw = Constants.adminPWD;
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fornavn = request.getParameter("fornavn");
            String etternavn = request.getParameter("etternavn").trim();
            String email = request.getParameter("email").trim();
            String pw1 = request.getParameter("pw1");
            String pw2 = request.getParameter("pw2");
            String adminkode = request.getParameter("adminkode");
         
           
            
            con = db.getCon();
            st = con.createStatement();
            
            
            
            String SQL = "SELECT email from User where email='"+email+"'";
           
            rs = st.executeQuery(SQL);
           
            if(pw1.equals(pw2) && !rs.next()) {
                if(adminkode.equals(adminpw)){
                st.executeUpdate("insert into User (firstname, lastname, email, password, adminid) values('"+fornavn+"','"+etternavn+"','"+email+"','"+pw1+"', 1)");
                out.println("You have sucsessfully been registered as a teacher in the system");
                }else if(!(adminkode.equals(adminpw))){
                    st.executeUpdate("insert into User (firstname, lastname, email, password, adminid) values('"+fornavn+"','"+etternavn+"','"+email+"','"+pw1+"', 2)");
                    out.println("You have sucsessfully been registered as a student in the system");
                }
            } else {
                out.println("The email is already registered or passwords not matching");
            }
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
         } catch (SQLException ex) {
             Logger.getLogger(RegisterServletDAO.class.getName()).log(Level.SEVERE, null, ex);
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
         } catch (SQLException ex) {
             Logger.getLogger(RegisterServletDAO.class.getName()).log(Level.SEVERE, null, ex);
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