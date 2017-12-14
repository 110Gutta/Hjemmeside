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
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
            try {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    con = db.getCon();
                    st = con.createStatement();
                   
                    String SQL = Constants.sqlSelectFeedback;
                   
                    rs = st.executeQuery(SQL);
                   
                    if(rs.next()){
                        String moduleid = rs.getString("moduleid");
                        String score = rs.getString("score");
                        String email = rs.getString("email");
                        st.executeUpdate("insert into module (moduleid, score, email) values('"+moduleid+"','"+score+"','"+email+"')");
                out.println("Feedback given");
                        out.println(moduleid + "\n");
                        out.println(score);
                        out.println(email);
                    } else{
                        out.print("Please login first");
                        request.getRequestDispatcher("login.html").include(request, response);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(tilbakemeldingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}