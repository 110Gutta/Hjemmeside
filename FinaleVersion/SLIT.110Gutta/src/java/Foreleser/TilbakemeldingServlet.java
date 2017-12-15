/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Foreleser;

import Constants.Constants;
import DB.DataBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author mats
 */
public class TilbakemeldingServlet extends HttpServlet {

        DataBase db = new DataBase();
        Connection con = null;
        String message = null;  // message will be sent back to client

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("linkteacher.html").include(request, response);
            HttpSession session=request.getSession(false);
                    if(session!=null){
            
            
            //String userid="1";
            //String moduleid ="1";
            //String deliveryfeedback ="sdfsdf";
            //String score = "9";
            
            String userid=request.getParameter("userid");
            String moduleid=request.getParameter("moduleid");
            String score=request.getParameter("score");
            String deliveryfeedback=request.getParameter("deliveryfeedback");

            con = db.getCon();
            
            String sql = "INSERT INTO Feedback (userid, moduleid, deliveryfeedback, score) values (?,?,?,?)";

            PreparedStatement psmt = con.prepareStatement(sql);
            
            psmt.setString(1, userid);
            psmt.setString(2, moduleid);
            psmt.setString(3, deliveryfeedback);
            psmt.setString(4, score);
            psmt.executeUpdate();
            
            out.print("tilbakemelding registrert");
            
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
                Logger.getLogger(TilbakemeldingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TilbakemeldingServlet.class.getName()).log(Level.SEVERE, null, ex);
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