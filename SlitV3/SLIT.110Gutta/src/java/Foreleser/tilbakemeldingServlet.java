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
 * @author hallvardlauvrak
 */
public class tilbakemeldingServlet extends HttpServlet {
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
       
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws java.sql.SQLException
     */

    protected void ProsessRequest(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException, SQLException {  
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    con = db.getCon();
                    st = con.createStatement();
                   
                    String SQL = Constants.sqlSelectFeedback;
                   
                    rs = st.executeQuery(SQL);
                   
                    if(rs.next()){
                        String moduleid = rs.getString("moduleid");
                        String score = rs.getString("score");
                        String userid = rs.getString("userid");
                        st.executeUpdate("insert into module (moduleid, score, userid) values('"+moduleid+"','"+score+"','"+userid+"')");
                out.println("Feedback given");

                    } else{
                        out.print("Please login first");
                        request.getRequestDispatcher("login.html").include(request, response);
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
