/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Foreleser;

import DB.DataBase;
import javax.servlet.http.HttpSession; 
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



public class tilbakemeldingServlet extends HttpServlet {  
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("tilbakemeldingForeleser.jsp").include(request, response);
            
            HttpSession session=request.getSession(false);
                    if(session!=null){            
            String score=request.getParameter("score");
            String userid=request.getParameter("userid");
            String moduleid=request.getParameter("moduleid");
            String deliveryfeedback=request.getParameter("deliveryfeedback");
            
            con = db.getCon();
            st = con.createStatement();
            String SQL = "INSERT INTO Feedback (userid, moduleid, deliveryfeedback, score) values ('"+userid+"','"+moduleid+"','"+deliveryfeedback+"','"+score+"')";
            
 
            
            if (rs.next()) {
                           rs = st.executeQuery(SQL);
                out.print("Feedback given to student");
                response.sendRedirect("tilbakemeldingServlet");

            }
            else{
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        }  
    }       catch (SQLException ex) {  
                Logger.getLogger(tilbakemeldingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
}
