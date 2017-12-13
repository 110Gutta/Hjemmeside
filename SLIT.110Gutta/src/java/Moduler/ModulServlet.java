package Moduler;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Constants.Constants;

/**
 *
 * @author mats
 */
@WebServlet(urlPatterns = {"/ModulServlet"})
public class ModulServlet extends HttpServlet {

        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
            try {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                request.getRequestDispatcher("link.html").include(request, response);

                HttpSession session=request.getSession(false);
                if(session!=null){
                //String email=(String)session.getAttribute("email");
                    
                
            con = db.getCon();
            st = con.createStatement();
            
            String SQL = Constants.sqlSelectModule;
            
            rs = st.executeQuery(SQL);
            
            if(rs.next()){
                String moduleName = rs.getString("modulename");
                String learningGoals = rs.getString("learninggoals");
                String moduleText = rs.getString("moduletext");
            
                out.println(moduleName + "\n");
                out.println(learningGoals);
                out.println(moduleText);
                    } else{
                    out.print("Please login first");
                    request.getRequestDispatcher("login.html").include(request, response);
                }  
        out.close();
    }
   }        catch (SQLException ex) {
                Logger.getLogger(ModulServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */