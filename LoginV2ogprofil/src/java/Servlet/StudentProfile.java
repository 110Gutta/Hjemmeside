/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
 
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
public class StudentProfile extends HttpServlet {
 
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param out
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try (PrintWriter out = response.getWriter()) {
               
            DataBase db = new DataBase();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            String LE;
            LE = (String) request.getAttribute("loginEmail");
            String SQL = "SELECT name, email from user where email='"+LE+"'";
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                
               
                // <!-- Sidebar start (navigasjonsbar) -->
               
                out.println("<nav id= \"nav\">");
                out.println("<p><h3>Modul</h3></p>");
                out.format("<a href='delivery.jsp'>Modul 1</a></p>");
                out.format("<a href=''>Modul 2</a></p>");
                out.format("<a href=''>Modul 3</a></p>");
                out.format("<a href=''>Modul 4</a></p>");
                out.format("<a href=''>Modul 5</a></p>");
                out.format("<a href=''>Modul 6</a></p>");
                out.format("<a href=''>Modul 7</a></p>");
                out.format("<a href=''>Modul 8</a></p>");
                out.format("<a href=''>Modul 9</a></p>");
                out.format("<a href=''>Modul 10</a></p>");
               
                out.println("<p><h3>Grade, status & feedback</h3></p>");
                out.format("<a href=''>Tilbakemelding</a></p>");
                out.format("<a href=''>Chat</a></p>");
               
                out.println("</nav>");
                
                out.println("<input type= \"submit\" value=\"submit\" ></br>");
                //<!-- Sidebar Slutt (navigasjonsbar) -->
               
                out.println("<p2><h2> Name: " + name + "</h2></p2>");
                out.println("<p2><h2> Email: " + email + "</h2></p2>");
               
                out.println("<footer class= \"footer\">");
                out.println("C0deNerds");
                out.println("</footer>");
            }
 
                       } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        }
     public void skrivHtmlHeader(PrintWriter out,  String tittel)
    {
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>" +tittel +"</title>");  
       out.println("<meta charset=\"UTF-8\">");    
       out.println("<link rel=\"stylesheet\" href=\"\">");
           
       out.println("</head>");
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