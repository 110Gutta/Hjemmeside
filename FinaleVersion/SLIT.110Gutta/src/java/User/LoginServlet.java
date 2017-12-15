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
            
            
          String SQL =("SELECT user.userid, user.email,user.password,permission.adminid,permission.type, user.firstname from User INNER JOIN permission ON user.adminid = permission.adminid where user.email='"+email+"'and user.password='"+passord+"' order by user.email");
//   String SQL = "SELECT email,password,firstname,lastname from User where email='"+email+"'and password='"+passord+"'";
            rs = st.executeQuery(SQL);
                
            if(rs.next()) {
                HttpSession session=request.getSession();
                String userid = rs.getString("userid");
            
             
                String userType = rs.getString("type");
             
                session.setAttribute("email",email);
                session.setAttribute("userid",userid);
                session.setAttribute("type", userType); 
                
                    String firstname = rs.getString("firstname");
                    session.setAttribute("firstname",firstname);
                              
                
                if ("Student".equals(userType)) {
                    response.sendRedirect("ProfileStudent.jsp");
                    
                
                              
                  // out.print("hey student");
                    
                }
                
                else if ("Foreleser".equals(userType)) {
                   response.sendRedirect("studentlist.jsp");
                   //out.print("hey teacher");
                   
                }
           
                else {
             
                request.getRequestDispatcher("LoginFeilInfo.jsp").include(request, response);
            }
            }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
