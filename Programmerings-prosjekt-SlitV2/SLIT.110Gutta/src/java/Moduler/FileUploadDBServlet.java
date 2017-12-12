/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduler;
 
import DB.DataBase;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Constants.Constants;
 
/**
 *
 * @author nilsf
 */
@WebServlet("/FileUploadDBServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
 
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
        PreparedStatement pst = null;
        String message = null;  // message will be sent back to client
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String modulName = request.getParameter("modulName");
        String modulGoals = request.getParameter("modulgoals");
        String modulText = request.getParameter("modulText");
        String moduleid = request.getParameter("moduleid");
       
        InputStream inputStream = null; // input stream of the upload file
       
         // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
         
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        try (PrintWriter out = response.getWriter()) {
         
            con = db.getCon();
            
            // constructs SQL statement
            String sql = Constants.sqlInsertIntoModule;
            pst = con.prepareStatement(sql);
            pst.setString(1, modulName);
            pst.setString(2, modulGoals);
            pst.setString(3, modulText);
            pst.setString(4, moduleid);
            
           
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                pst.setBlob(5, inputStream);
            }
 
           
            // sends the statement to the database server
            int row = pst.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
                out.println(message);
            }
           
           
         } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
         } finally {
            if (con != null) {
                // closes the database connection
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
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
 
}