package User;

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



public class LoginServlet extends HttpServlet {  
        DataBase db = new DataBase();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("link.html").include(request, response);
            
            String email=request.getParameter("email");
            String passord=request.getParameter("pw1");
            
            con = db.getCon();
            st = con.createStatement();
            
            String SQL = "SELECT email,password from User where email='"+email+"'and password='"+passord+"'";
            
            rs = st.executeQuery(SQL);
            
            if (rs.next()) {
                
                out.print("Welcome, "+email);
                HttpSession session=request.getSession();
                session.setAttribute("email",email);
                response.sendRedirect("ProfileServlet");
            }
            else{
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
}  