/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduler;

import DB.DataBase;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
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
 * @author mats
 */
public class Download extends HttpServlet {

        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
  String docid = request.getParameter("docid");     
  String query = "select filename, type, file from Documents where docid = " + docid;
  con = db.getCon();
  st = con.createStatement();
  rs = st.executeQuery(query);
  rs.next();
  
  // clear the response header information.
  response.reset();                        
  // check the file type and set the header contentType accordingly..   
  if(rs.getString(2)==".txt")
  {
      response.setContentType("application/octet-stream");
  }
  else if(rs.getString(2)==".pdf")
  {
      response.setContentType("application/pdf");
  }
  else if((rs.getString(2)==".doc")||rs.getString(2)==".docx")
  {
      response.setContentType("application/msword");
  }
  else if((rs.getString(2)==".xls")||(rs.getString(2)==".xlsx"))
  {
      response.setContentType("application/vnd.ms-excel");
  }
  // add header information to response object
  response.addHeader("Content-Disposition","attachment; filename="+rs.getString(1));
  // create the byte array from Blob
  Blob blb = rs.getBlob(3);
  byte[] bdata = blb.getBytes(1, (int) blb.length());
  
            try ( // get the response Output stream object to write the content of the file into header
                    OutputStream output = response.getOutputStream()) {
                output.write(bdata);
            }
  // close the obejct of ResultSet
  rs.close();
  
  // close the connection object.. 
  con.close();
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
                Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
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
